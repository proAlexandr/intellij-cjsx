package ru.promakh.cjsx.lang;

import com.intellij.lang.PsiBuilder;
import com.intellij.psi.tree.IElementType;
import com.intellij.util.containers.Stack;
import org.coffeescript.lang.lexer.CoffeeScriptTokenTypes;
import ru.promakh.cjsx.psi.CjsxElementType;
import ru.promakh.cjsx.psi.CjsxTokenType;

public class CjsxParser extends CoffeeScriptParser {
    private final Stack<Object> tagsNesting = new Stack<>();

    @Override
    protected boolean parseExpression() {
        boolean skip = false;
        if (this.isCode()) {
            skip = this.parseFunction();
        }

        if (!skip) {
            if (isCurrentTokenIn(CoffeeScriptTokenTypes.LT)) {
                parseTag();
            } else if (isInTagBody() && isCurrentTokenIn(CoffeeScriptTokenTypes.BRACE_START)) {
                parseTagInterpolation();
            }else if (this.isCurrentTokenIn(new IElementType[]{CoffeeScriptTokenTypes.DO_KEYWORD})) {
                this.parseDoExpression();
            } else if (this.isCurrentTokenIn(new IElementType[]{CoffeeScriptTokenTypes.CLASS})) {
                this.parseClass();
            } else if (this.isIf() && !this.isPostIf()) {
                this.parseIf();
            } else if (this.isWhile() && !this.isPostWhile()) {
                this.parseWhile();
            } else if (this.isLoop()) {
                this.parseLoop();
            } else if (this.isVariable()) {
                this.parseVariable();
            } else if (this.isValue()) {
                this.parseValuesAndInvocations(true, true, true, true);
            } else if (this.isForBody() && !this.isPostFor()) {
                this.parseFor();
            } else if (this.isSwitch()) {
                this.parseSwitch();
            } else if (this.isCurrentTokenIn(new IElementType[]{CoffeeScriptTokenTypes.TRY})) {
                this.parseTry();
            } else if (this.isThrow()) {
                this.parseThrow();
            } else if (!this.parseYield()) {
                if (!this.isIf() && !this.isWhile() && !this.isForBody() || this.isNewLine()) {
                    this.error("Unexpected token");
                }

                return false;
            }
        }
        return true;
    }

    private void parseTag() {
        PsiBuilder.Marker tagContainerMarker = this.mark();

        if (this.isCurrentTokenIn(CoffeeScriptTokenTypes.LT)) {
            PsiBuilder.Marker tagOpenOrTagSingleMarker = this.mark();
            int indent = this.getCurrentIndent();

            advance();
            parseTagName();

            if (isIdentifier()) {
                parseTagAttributes();
            }

            if (isCurrentTokenIn(CoffeeScriptTokenTypes.GT)) {
                advance();
                done(tagOpenOrTagSingleMarker, CjsxElementType.TAG_OPEN);

                parseTagBody(indent);

                PsiBuilder.Marker closeTagMarker = mark();
                if (isCurrentTokenIn(CjsxTokenType.LT_DIV)) {
                    advance();
                    parseTagName();

                    if (isCurrentTokenIn(CoffeeScriptTokenTypes.GT)) {
                        advance();
                        done(closeTagMarker, CjsxElementType.TAG_CLOSE);
                    } else {
                        drop(closeTagMarker);
                        unexpectedTokenError("expected '>'");
                    }

                } else {
                    drop(closeTagMarker);
                    this.unexpectedTokenError("expected '</'");
                }

            } else if (this.isCurrentTokenIn(CjsxTokenType.DIV_GT)) {
                advance();
                done(tagOpenOrTagSingleMarker, CjsxElementType.TAG_SINGLE);
            } else {
                drop(tagOpenOrTagSingleMarker);
                unexpectedTokenError("expected '>' or '/>'");
            }
        }

        this.done(tagContainerMarker, CjsxElementType.TAG_CONTAINER);
    }

    private void parseTagBody(int indent) {
        tagsNesting.push(new Object());
        PsiBuilder.Marker bodyTagMarker = mark();
        if (this.isNewLine()) {
            this.parseBlock(indent, false);
        } else {
            if (!isCurrentTokenIn(CjsxTokenType.LT_DIV) && (this.isExpression() || this.isStatement())) {
                this.parseLineWithNewScope(true);
            }
        }
        done(bodyTagMarker, CjsxElementType.TAG_BODY);
        tagsNesting.pop();
    }

    private void parseTagName() {
        if (!isNewLine() && isIdentifier()) {
            parseIdentifier(false);
        } else {
            unexpectedTokenError("expected identifier");
        }
    }

    private void parseTagAttributes() {
        PsiBuilder.Marker marker = this.mark();

        while (isTagAttribute()) {
            parseTagAttribute();
        }

        this.done(marker, CjsxElementType.ATTRIBUTES);
    }

    private boolean isTagAttribute() {
        return isIdentifier();
    }

    private void parseTagAttribute() {
        PsiBuilder.Marker marker = mark();

        parseIdentifier(true);

        if (isCurrentTokenIn(CoffeeScriptTokenTypes.EQ)) {
            advance();
            parseTagAttributeValue();
        } else {
            unexpectedTokenError("expected '='");
        }

        done(marker, CjsxElementType.ATTRIBUTE);
    }

    private void parseTagAttributeValue() {
        int intent = getCurrentIndent();

        if (isString()) {
            // String value
            parseString();
        } else if (isCurrentTokenIn(CoffeeScriptTokenTypes.BRACE_START)) {
            // Script interpolation
            advance();
            parseWithPossibleWhileOrForOrIf(myExpressionInvoker);

            if (!isCurrentTokenIn(CoffeeScriptTokenTypes.BRACE_END)) {
                unexpectedTokenError("expected '}'");
            }
            advance();
        } else if (isIdentifier() || isThis()) {
            // variable accessor
            parseValuesAndInvocations(false, false, false, false);
        } else {
            unexpectedTokenError();
        }
    }

    private boolean isInTagBody(){
        return !tagsNesting.isEmpty();
    }

    private void parseTagInterpolation() {
        PsiBuilder.Marker marker = mark();

        if (this.isCurrentTokenIn(CoffeeScriptTokenTypes.BRACE_START)) {
            int indent = this.getCurrentIndent();
            advance();

            if(isNewLine()){
                parseBlock(indent, false);
            } else {
                parseWithPossibleWhileOrForOrIf(myExpressionInvoker);
            }

            if (isCurrentTokenIn(CoffeeScriptTokenTypes.BRACE_END)) {
                advance();
            } else {
                unexpectedTokenError("expected '}'");
            }
        }

        done(marker, CjsxElementType.TAG_INTERPOLATION);
    }

    private void unexpectedTokenError() {
        this.unexpectedTokenError(null);
    }

    private void unexpectedTokenError(String message) {
        String msg = "Unexpected token";
        if (message != null && !message.equals("")) {
            msg += ": " + message;
        }
        this.error(msg);
    }
}
