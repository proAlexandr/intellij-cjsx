package ru.promakh.webstorm_cjsx.lang;

import com.intellij.lang.PsiBuilder;
import com.intellij.psi.tree.IElementType;
import org.coffeescript.lang.lexer.CoffeeScriptTokenTypes;
import ru.promakh.webstorm_cjsx.psi.CjsxElementType;
import ru.promakh.webstorm_cjsx.psi.CjsxTokenType;

public class CjsxParser extends CoffeeScriptParser {
    @Override
    protected boolean parseExpression() {
        boolean skip = false;
        if (this.isCode()) {
            skip = this.parseFunction();
        }

        if (!skip) {
            if (this.isCurrentTokenIn(CoffeeScriptTokenTypes.LT)) {
                this.parseTag();
            } else if (this.isCurrentTokenIn(new IElementType[]{CoffeeScriptTokenTypes.DO_KEYWORD})) {
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
        PsiBuilder.Marker tagMarker = this.mark();

        if (this.isCurrentTokenIn(CoffeeScriptTokenTypes.LT)) {
            PsiBuilder.Marker tagHeaderMarker = this.mark();
            int indent = this.getCurrentIndent();
            advance();
            parseTagName();

            if (this.isIdentifier()) {
                this.parseTagAttributes();
            }

            if (this.isCurrentTokenIn(CoffeeScriptTokenTypes.GT)) {
                this.advance();
                this.done(tagHeaderMarker, CjsxElementType.TAG_OPEN);

                PsiBuilder.Marker bodyTagMarker = mark();
                if (this.isNewLine()) {
                    this.parseBlock(indent, false);
                } else {
                    if (!isCurrentTokenIn(CjsxTokenType.LT_DIV) && (this.isExpression() || this.isStatement())) {
                        this.parseLineWithNewScope(true);
                    }
                }
                done(bodyTagMarker, CjsxElementType.TAG_BODY);

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
                done(tagHeaderMarker, CjsxElementType.TAG_SINGLE);
            } else {
                drop(tagHeaderMarker);
                unexpectedTokenError("expected '>' or '/>'");
            }
        }

        this.done(tagMarker, CjsxElementType.TAG_CONTAINER);
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

        while (isIdentifier()) {
            PsiBuilder.Marker attributeMarker = this.mark();
            parseIdentifier(true);
            if (isCurrentTokenIn(CoffeeScriptTokenTypes.EQ)) {
                advance();

                if (isString()){
                    parseString();
                } else if (isCurrentTokenIn(CoffeeScriptTokenTypes.BRACE_START)){
                    advance();
                    parseWithPossibleWhileOrForOrIf(myExpressionInvoker);

                    if (!isCurrentTokenIn(CoffeeScriptTokenTypes.BRACE_END)){
                        unexpectedTokenError("expected '}'");
                    }
                    advance();
                } else {
                    unexpectedTokenError();
                }

                done(attributeMarker, CjsxElementType.ATTRIBUTE);
            } else {
                drop(attributeMarker);
                unexpectedTokenError("expected '='");
            }
        }

        this.done(marker, CjsxElementType.ATTRIBUTES);
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
