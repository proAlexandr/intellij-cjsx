package ru.promakh.webstorm_cjsx.lang;

//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

import com.intellij.indentation.OperationParserHelper;
import com.intellij.lang.LighterASTNode;
import com.intellij.lang.PsiBuilder;
import com.intellij.lang.javascript.JSElementTypes;
import com.intellij.lang.javascript.JSStubElementTypes;
import com.intellij.psi.tree.IElementType;
import com.intellij.psi.tree.TokenSet;
import com.intellij.util.ArrayUtil;
import com.intellij.util.containers.HashMap;
import com.intellij.util.containers.Stack;
import org.coffeescript.CsBundle;
import org.coffeescript.lang.lexer.CoffeeScriptTokenTypes;
import org.coffeescript.lang.parser.BaseCoffeeScriptParser;
import org.coffeescript.lang.parser.CoffeeScriptElementTypes;
import org.coffeescript.lang.parser.CoffeeScriptParserMetaData;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class CoffeeScriptParser extends BaseCoffeeScriptParser {
    public static final String ERROR_MULTIPLE_SPLATS_EXPANSIONS_ARE_DISALLOWED_IN_AN_ASSIGNMENT = "Multiple splats/expansions are disallowed in an assignment";
    private final CoffeeScriptParser.StatementInvoker myStatementInvoker = new CoffeeScriptParser.StatementInvoker();
    protected final CoffeeScriptParser.ExpressionInvoker myExpressionInvoker = new CoffeeScriptParser.ExpressionInvoker();
    private Stack<Boolean> oneLineState = new Stack();
    private int parenthesisLevel = 0;
    private int argumentListLevel = 0;
    private int invocationIndent = -1;
    private boolean myMultilineArgumentListAllowed = true;
    private List<String> CS_RESERVED = Arrays.asList(new String[]{"case", "default", "function", "var", "void", "with", "const", "let", "enum", "export", "import", "native", "__hasProp", "__extends", "__slice", "__bind", "__indexOf", "implements", "interface", "let", "package", "private", "protected", "public", "static", "yield"});
    private Map<Integer, CoffeeScriptParserMetaData> metaData = new HashMap();
    private Stack<Integer> wantedElseAtIndent = new Stack();

    public CoffeeScriptParser() {
    }

    public void parseRoot(boolean wrapWithBlock) {
        while(!this.eof()) {
            int offset = this.getCurrentOffset();
            if(wrapWithBlock) {
                PsiBuilder.Marker marker = this.myBuilder.mark();
                this.parseBlock(0, false);
                this.done(marker, CoffeeScriptElementTypes.INDENT_BLOCK);
            } else {
                this.parseBlock(-1, false);
            }

            if(offset == this.getCurrentOffset()) {
                this.error("Unexpected token");
                this.advance();
            }
        }

    }

    protected void parseBlock(int blockIndent, boolean withMark) {
        this.parseBlock(blockIndent, withMark, true);
    }

    private void parseBlock(int blockIndent, boolean withMark, boolean withScope) {
        if(!this.isTerminator()) {
            this.oneLineState.push(Boolean.valueOf(false));
            this.invocationIndent = -1;
            if(withScope) {
                this.startScope();
            }

            int firstIndent = -1;
            PsiBuilder.Marker marker = this.mark();

            while(!this.eof()) {
                if(firstIndent < 0) {
                    firstIndent = this.getCurrentIndent();
                    if(firstIndent <= blockIndent) {
                        break;
                    }
                }

                if(this.getCurrentIndent() < firstIndent) {
                    break;
                }

                int offset = this.getCurrentOffset();
                if(!this.isCurrentTokenIn(new IElementType[]{CoffeeScriptTokenTypes.PARENTHESIS_END})) {
                    if(this.getCurrentIndent() > firstIndent) {
                        this.error("Unexpected indent");
                        this.parseBlock(blockIndent + 1, false);
                    } else {
                        this.parseLine(true);
                        if(!this.isNewLine() && !this.eof() && !this.isCurrentTokenIn(new IElementType[]{CoffeeScriptTokenTypes.PARENTHESIS_END})) {
                            this.error("Expected end of line");
                        }
                    }
                }

                if(offset == this.getCurrentOffset()) {
                    if(this.parenthesisLevel != 0 && this.isCurrentTokenIn(new IElementType[]{CoffeeScriptTokenTypes.PARENTHESIS_END})) {
                        break;
                    }

                    this.error("unexpected element");
                    this.advance();
                }

                if(this.eof()) {
                    break;
                }
            }

            if(withMark) {
                this.done(marker, CoffeeScriptElementTypes.INDENT_BLOCK);
            } else {
                marker.drop();
            }

            if(withScope) {
                this.endScope();
            }

            this.oneLineState.pop();
        }
    }

    protected void parseLineWithNewScope(boolean withScope) {
        if(!this.isTerminator()) {
            this.oneLineState.push(Boolean.valueOf(true));
            if(withScope) {
                this.startScope();
            }

            this.parseLine(withScope);
            if(withScope) {
                this.endScope();
            }

            this.oneLineState.pop();
        }
    }

    private void parseLine(boolean finalizationAllowed) {
        while(true) {
            if(!this.eof()) {
                int offset = this.getCurrentOffset();
                if(this.isStatement()) {
                    this.parseWithPossibleWhileOrForOrIf(this.myStatementInvoker);
                } else {
                    PsiBuilder.Marker message = this.mark();
                    boolean success = this.parseWithPossibleWhileOrForOrIf(this.myExpressionInvoker);
                    LighterASTNode lastMarker = this.myBuilder.getLatestDoneMarker();
                    IElementType lastTokenType = lastMarker != null?lastMarker.getTokenType():null;
                    if(success && finalizationAllowed && !CoffeeScriptElementTypes.STATEMENTS.contains(lastTokenType)) {
                        this.done(message, CoffeeScriptElementTypes.EXPRESSION_STATEMENT);
                    } else {
                        message.drop();
                    }
                }

                if(offset == this.getCurrentOffset()) {
                    String message1 = "Unexpected token";
                    if(this.isCurrentTokenIn(new IElementType[]{CoffeeScriptTokenTypes.IF})) {
                        message1 = "UNEXPECTED \'POST_IF\'";
                    }

                    this.error(message1);
                } else if(this.isCurrentTokenIn(new IElementType[]{CoffeeScriptTokenTypes.SEMICOLON})) {
                    this.advance();
                    if(!this.isNewLine()) {
                        continue;
                    }
                }
            }

            if(this.currentTokenIn(new IElementType[]{CoffeeScriptTokenTypes.SEMICOLON})) {
                this.advance();
            }

            return;
        }
    }

    protected void parseFor() {
        this.startScope();
        int forIndent = this.getCurrentIndent();
        PsiBuilder.Marker marker = this.mark();
        this.parseForBody();
        this.parseBlockOrThen(forIndent);
        this.done(marker, CoffeeScriptElementTypes.FOR_STATEMENT);
        this.endScope();
    }

    private void parseForBody() {
        this.expect(CoffeeScriptTokenTypes.FOR);
        boolean oldMultilineArgumentListAllowed = this.myMultilineArgumentListAllowed;
        this.myMultilineArgumentListAllowed = false;
        if(this.isRange()) {
            this.parseRange();
        } else {
            if(this.isCurrentTokenIn(new IElementType[]{CoffeeScriptTokenTypes.OWN})) {
                this.advance();
            }

            if(this.isForVariables()) {
                this.parseForVariables();
            } else {
                this.error("expected for variables");
            }

            this.parseForSource();
        }

        this.myMultilineArgumentListAllowed = oldMultilineArgumentListAllowed;
    }

    private void parseForSource() {
        if(this.isCurrentTokenIn(new IElementType[]{CoffeeScriptTokenTypes.IN_KEYWORD, CoffeeScriptTokenTypes.OF})) {
            this.advance();
            this.parseOperation();
            if(this.parseTokenCondition(new IElementType[]{CoffeeScriptTokenTypes.WHEN})) {
                this.parseTokenCondition(new IElementType[]{CoffeeScriptTokenTypes.BY});
            } else if(this.parseTokenCondition(new IElementType[]{CoffeeScriptTokenTypes.BY})) {
                this.parseTokenCondition(new IElementType[]{CoffeeScriptTokenTypes.WHEN});
            }

        } else {
            this.error("Expected IN_KEYWORD or OF tokens");
        }
    }

    private void parseForVariables() {
        this.parseForVariable();
        if(this.isCurrentTokenIn(new IElementType[]{CoffeeScriptTokenTypes.COMMA})) {
            this.advance();
            this.parseForVariable();
        }

    }

    private void parseForVariable() {
        PsiBuilder.Marker varStatementMarker;
        PsiBuilder.Marker marker;
        if(this.isThis()) {
            varStatementMarker = this.mark();
            marker = this.mark();
            this.parseThis();
            this.done(marker, CoffeeScriptElementTypes.REFERENCED_EXPRESSION);
            this.done(varStatementMarker, CoffeeScriptElementTypes.DEFINITION_EXPRESSION);
        } else if(this.isIdentifier() && this.isInScope(this.getTokenText())) {
            varStatementMarker = this.mark();
            this.parseIdentifier(false);
            this.done(varStatementMarker, CoffeeScriptElementTypes.REFERENCED_EXPRESSION);
        } else {
            varStatementMarker = this.mark();
            marker = this.mark();
            if(this.isArray()) {
                this.parseDestructuringArray();
            } else if(this.isIdentifier()) {
                this.addVariableInCurrentScope(this.getTokenText());
                this.parseIdentifier(false);
            } else if(this.isObject()) {
                this.parseObject();
            } else {
                this.error("Unexpected token for FOR_VARIABLE");
            }

            this.done(marker, CoffeeScriptElementTypes.VARIABLE);
            this.done(varStatementMarker, CoffeeScriptElementTypes.VAR_STATEMENT);
        }

    }

    private boolean isForVariables() {
        return this.isArray() || this.isIdentifier() || this.isObject() || this.isThis();
    }

    private void parseWhileExpression() {
        boolean oldMultilineArgumentListAllowed = this.myMultilineArgumentListAllowed;
        this.myMultilineArgumentListAllowed = false;
        this.advance();
        this.parseOperation();
        this.parseTokenCondition(new IElementType[]{CoffeeScriptTokenTypes.WHEN});
        this.myMultilineArgumentListAllowed = oldMultilineArgumentListAllowed;
    }

    private boolean parseTokenCondition(@NotNull IElementType... types) {
        if(this.isCurrentTokenIn(types)) {
            this.advance();
            boolean marker = this.parseOperation();
            if(!marker) {
                this.error("\'WHEN\' condition expected");
            }

            return true;
        } else {
            return false;
        }
    }

    protected void parseWhile() {
        PsiBuilder.Marker marker = this.mark();
        int whileIndent = this.getCurrentIndent();
        this.parseWhileExpression();
        this.parseBlockOrThen(whileIndent);
        this.done(marker, CoffeeScriptElementTypes.WHILE_STATEMENT);
    }

    protected void parseTry() {
        int indent = this.getCurrentIndent();
        PsiBuilder.Marker marker = this.mark();
        this.advance();
        this.parseBlockOrLine(indent);

        while(this.isCurrentTokenIn(new IElementType[]{CoffeeScriptTokenTypes.CATCH}) && this.getCurrentIndent() >= indent) {
            this.parseCatch();
        }

        if(this.isCurrentTokenIn(new IElementType[]{CoffeeScriptTokenTypes.FINALLY})) {
            this.advance();
            this.parseBlockOrLine(indent);
        }

        this.done(marker, CoffeeScriptElementTypes.TRY_STATEMENT);
    }

    protected void parseLoop() {
        int indent = this.getCurrentIndent();
        PsiBuilder.Marker loopMarker = this.mark();
        this.advance();
        this.parseBlockOrLine(indent);
        this.done(loopMarker, JSElementTypes.WHILE_STATEMENT);
    }

    private void parseCatch() {
        int indent = this.getCurrentIndent();
        if(this.currentTokenIn(new IElementType[]{CoffeeScriptTokenTypes.CATCH})) {
            PsiBuilder.Marker marker = this.mark();
            this.advance();
            if(!this.isNewLine()) {
                if(this.isIdentifier()) {
                    this.parseParam();
                } else if(this.isObject()) {
                    this.parseDestructuringObject(CoffeeScriptElementTypes.VARIABLE, true, true);
                }
            }

            this.parseBlockOrThen(indent);
            this.done(marker, CoffeeScriptElementTypes.CATCH_BLOCK);
        }

    }

    private void parseBlockOrThen(int indent) {
        if(this.isNewLine()) {
            this.parseBlock(indent, true);
        } else if(this.isCurrentTokenIn(new IElementType[]{CoffeeScriptTokenTypes.THEN})) {
            this.advance();
            this.parseLineWithNewScope(true);
        }

    }

    private void parseBlockOrLine(int indent) {
        if(this.isNewLine()) {
            this.parseBlock(indent, true);
        } else {
            this.parseLineWithNewScope(true);
        }

    }

    private boolean parseIfCondition() {
        this.advance();
        boolean oldMultilineArgumentListAllowed = this.myMultilineArgumentListAllowed;
        this.myMultilineArgumentListAllowed = false;
        boolean parsed = this.parseOperation();
        this.myMultilineArgumentListAllowed = oldMultilineArgumentListAllowed;
        if(!parsed) {
            this.error("If condition expected");
        }

        return parsed;
    }

    private boolean isPostSuffix(CoffeeScriptParser.ParseInvoker parseInvoker) {
        if((this.rawLookup(-1) != CoffeeScriptTokenTypes.WHITE_SPACE || this.rawLookup(-2) != null) && this.rawLookup(-1) != null && !this.isNewLine()) {
            int indent = this.getCurrentIndent();
            PsiBuilder.Marker marker = this.mark(true);

            boolean var4;
            try {
                parseInvoker.parse();
                if(this.eof()) {
                    var4 = true;
                    return var4;
                }

                if(!this.isNewLine()) {
                    if(!this.isCurrentTokenIn(new IElementType[]{CoffeeScriptTokenTypes.PARENTHESIS_END, CoffeeScriptTokenTypes.INTERPOLATION_END, CoffeeScriptTokenTypes.BRACE_END, CoffeeScriptTokenTypes.BRACKET_END, CoffeeScriptTokenTypes.PARENTHESIS_END, CoffeeScriptTokenTypes.IF, CoffeeScriptTokenTypes.FOR, CoffeeScriptTokenTypes.WHILE, CoffeeScriptTokenTypes.UNLESS})) {
                        return false;
                    }

                    var4 = true;
                    return var4;
                }

                if(this.getCurrentIndent() <= indent && (this.getCurrentIndent() != indent || !this.isCurrentTokenIn(new IElementType[]{CoffeeScriptTokenTypes.THEN, CoffeeScriptTokenTypes.ELSE}))) {
                    var4 = true;
                    return var4;
                }

                var4 = false;
            } finally {
                this.rollbackTo(marker);
            }

            return var4;
        } else {
            return false;
        }
    }

    protected void parseIf() {
        int indent = this.getCurrentIndent();
        PsiBuilder.Marker marker = this.mark();
        if(this.parseIfCondition()) {
            boolean positiveStatement = false;
            boolean positiveBlock = false;
            boolean thenKeyword = false;
            int wantedElseAtNewLine;
            if(this.isCurrentTokenIn(new IElementType[]{CoffeeScriptTokenTypes.THEN})) {
                positiveStatement = true;
                thenKeyword = true;
                this.advance();
                if(!this.isNewLine()) {
                    this.parseLineWithNewScope(false);
                }
            } else if(!this.isCurrentTokenIn(new IElementType[]{CoffeeScriptTokenTypes.ELSE})) {
                positiveStatement = true;
                positiveBlock = true;
                wantedElseAtNewLine = this.getCurrentOffset();
                this.parseBlock(indent, true, false);
                if(wantedElseAtNewLine == this.getCurrentOffset()) {
                    this.error("UNEXPECTED \'POST_IF\'");
                }
            }

            wantedElseAtNewLine = this.wantedElseAtIndent.size() > 0?((Integer)this.wantedElseAtIndent.peek()).intValue():-1;
            if((!thenKeyword || !this.isNewLine() || this.isNewLine() && indent == this.getCurrentIndent() && wantedElseAtNewLine != this.getCurrentIndent()) && this.isCurrentTokenIn(new IElementType[]{CoffeeScriptTokenTypes.ELSE})) {
                if(this.getCurrentIndent() == indent || positiveBlock && this.getCurrentIndent() > indent) {
                    this.advance();
                    if(!this.isTerminator() || this.isNewLine()) {
                        this.parseBlockOrLine(indent);
                    }
                }
            } else if(!positiveStatement && !this.eof()) {
                this.error("UNEXPECTED \'POST_IF\'");
            }
        }

        this.done(marker, CoffeeScriptElementTypes.IF_STATEMENT);
    }

    private boolean isTerminator() {
        return this.currentTokenIn(new IElementType[]{CoffeeScriptTokenTypes.BRACE_END, CoffeeScriptTokenTypes.PARENTHESIS_END, CoffeeScriptTokenTypes.INTERPOLATION_END, CoffeeScriptTokenTypes.CATCH, CoffeeScriptTokenTypes.FINALLY});
    }

    protected void parseClass() {
        PsiBuilder.Marker marker = this.mark();
        if(this.isCurrentTokenIn(new IElementType[]{CoffeeScriptTokenTypes.CLASS})) {
            int indent = this.getCurrentIndent();
            this.advance();
            if(!this.isNewLine() && this.isSimpleAssignable()) {
                this.parseValuesAndInvocations(false, false, false, false);
            }

            if(!this.isNewLine() && this.isCurrentTokenIn(new IElementType[]{CoffeeScriptTokenTypes.EXTENDS})) {
                PsiBuilder.Marker extendsListMarker = this.mark();
                this.advance();
                if(!this.isSimpleAssignable() && (!this.isExpression() || this.isNewLine())) {
                    this.error("Class name expected");
                } else {
                    this.parseValuesAndInvocations(false, true, false, false);
                }

                this.done(extendsListMarker, CoffeeScriptElementTypes.EXTENDS_LIST);
            }

            if(!this.isNewLine() && !this.eof()) {
                if(this.currentTokenIn(new IElementType[]{CoffeeScriptTokenTypes.THEN})) {
                    this.advance();
                    if(!this.isNewLine()) {
                        this.parseLine(false);
                    }
                } else {
                    this.error("End of line expected");
                }
            } else if(this.isNewLine()) {
                this.parseBlock(indent, true);
            }
        }

        this.done(marker, CoffeeScriptElementTypes.CLASS);
    }

    private void parseSimpleAssignable() {
        if(this.isIdentifier()) {
            this.parseIdentifier(false);
        } else if(this.isThisProperty()) {
            this.parseThisProperty();
        } else {
            this.error("Expected assignable token");
        }

    }

    public void     parseIdentifier(boolean reservedWordsAllowed) {
        if(!reservedWordsAllowed && !tokenIn(this.rawLookup(-1), new IElementType[]{CoffeeScriptTokenTypes.DOT}) && this.CS_RESERVED.contains(this.getTokenText())) {
            this.error("Reserved word");
        }

        this.advance();
    }

    private boolean parseContinue() {
        if(this.currentTokenIn(new IElementType[]{CoffeeScriptTokenTypes.CONTINUE})) {
            PsiBuilder.Marker marker = this.mark();
            this.advance();
            this.done(marker, JSElementTypes.CONTINUE_STATEMENT);
            return true;
        } else {
            return false;
        }
    }

    private boolean parseStatement() {
        if(this.isReturn()) {
            this.parseReturn();
        } else if(this.isString()) {
            this.parseString();
        } else if(!this.parseContinue()) {
            this.advance();
        }

        return true;
    }

    private void parseThisProperty() {
        PsiBuilder.Marker marker = this.mark();
        this.advance();
        this.advance();
        this.done(marker, CoffeeScriptElementTypes.THIS_PROPERTY);
    }

    private CoffeeScriptParser.ValueTypes parseAccessor(@Nullable PsiBuilder.Marker referenceMarker, @Nullable PsiBuilder.Marker invocationMarker, boolean invocationWithoutParenthesisAllowed, boolean argumentsOnNewLineAllowed) {
        CoffeeScriptParser.ValueTypes result = CoffeeScriptParser.ValueTypes.VALUE;
        if(this.isCurrentTokenIn(new IElementType[]{CoffeeScriptTokenTypes.DOT})) {
            this.advance();
            result = this.parseValueOrInvocation(referenceMarker, invocationMarker, invocationWithoutParenthesisAllowed, true, argumentsOnNewLineAllowed);
        } else if(this.isPrototype()) {
            this.advance();
            if(this.getTokenType() == CoffeeScriptTokenTypes.IDENTIFIER) {
                this.advance();
            }

            if(referenceMarker != null) {
                this.done(referenceMarker, CoffeeScriptElementTypes.REFERENCED_EXPRESSION);
            }
        } else if(this.isIndex()) {
            this.parseIndex();
            if(referenceMarker != null) {
                this.done(referenceMarker, CoffeeScriptElementTypes.INDEXED_PROPERTY_ACCESS_EXPRESSION);
            }
        } else if(this.isExist()) {
            this.advance();
            if(referenceMarker != null) {
                this.done(referenceMarker, CoffeeScriptElementTypes.REFERENCED_EXPRESSION);
            }
        } else {
            referenceMarker.drop();
            this.error("Unexpected token type");
        }

        return result;
    }

    private void parseIndex() {
        this.advance();
        if(this.isRangeSymbol()) {
            this.advance();
            if(!this.isCurrentTokenIn(new IElementType[]{CoffeeScriptTokenTypes.BRACKET_END})) {
                this.parseOperation();
            }
        } else {
            this.parseOperation();
            if(this.isRangeSymbol()) {
                this.advance();
            }

            if(!this.isCurrentTokenIn(new IElementType[]{CoffeeScriptTokenTypes.BRACKET_END}) && !this.isNewLine() && !this.eof()) {
                this.parseOperation();
            }
        }

        this.expect(CoffeeScriptTokenTypes.BRACKET_END);
    }

    protected boolean isValue() {
        return this.isAssignable() || this.isLiteral() || this.isParenthetical() || this.isRange() || this.isThis() || this.isSuper() || this.currentTokenIn(new IElementType[]{CoffeeScriptTokenTypes.NEW_KEYWORD});
    }

    private boolean isAssignable() {
        return this.isSimpleAssignable() || this.isArray() || this.isObject();
    }

    private boolean isStringObjectKey() {
        boolean result = false;
        if(this.isString()) {
            PsiBuilder.Marker marker = this.mark(true);
            this.parseString();
            result = this.isCurrentTokenIn(new IElementType[]{CoffeeScriptTokenTypes.COLON});
            this.rollbackTo(marker);
        }

        return result;
    }

    private boolean isObject() {
        return this.isCurrentTokenIn(new IElementType[]{CoffeeScriptTokenTypes.BRACE_START}) || this.isStringObjectKey() || this.isIdentifier() && isTokenIn(this.lookAhead(1), new IElementType[]{CoffeeScriptTokenTypes.COLON}) || this.isThisProperty() && isTokenIn(this.lookAhead(2), new IElementType[]{CoffeeScriptTokenTypes.COLON});
    }

    private void parseDestructuringObject(@NotNull IElementType propertyType, boolean wrapWithVarStatement, boolean checkForBraces) {
        PsiBuilder.Marker varStatementMarker = this.mark();
        PsiBuilder.Marker destructuringElementMarker = this.mark();
        PsiBuilder.Marker destructuringObjectMarker = this.mark();
        boolean withBraces = false;
        if(this.currentTokenIn(new IElementType[]{CoffeeScriptTokenTypes.BRACE_START})) {
            this.advance();
            withBraces = true;
        } else if(checkForBraces) {
//            this.error(CsBundle.message("parser.destructuring.object.without.braces", new Object[0]));
            this.error("parser.destructuring.object.without.braces");
        }

        while(this.isIdentifier() || this.isShortThis() || this.isString()) {
            PsiBuilder.Marker propertyMarker = this.mark();
            PsiBuilder.Marker definitionMarker = this.mark();
            PsiBuilder.Marker propertyNameMarker = this.mark();
            String variableName = null;
            if(this.isString()) {
                this.parseString();
            } else {
                variableName = this.getTokenText();
                this.advance();
            }

            if(this.isCurrentTokenIn(new IElementType[]{CoffeeScriptTokenTypes.EQ})) {
                this.done(propertyNameMarker, propertyType);
                drop(definitionMarker);
                this.advance();
                this.myExpressionInvoker.parse();
            } else if(this.isCurrentTokenIn(new IElementType[]{CoffeeScriptTokenTypes.COLON})) {
                this.done(propertyNameMarker, CoffeeScriptElementTypes.REFERENCED_EXPRESSION);
                drop(definitionMarker);
                this.advance();
                if(this.isObject()) {
                    this.parseDestructuringObject(CoffeeScriptElementTypes.VARIABLE, false, false);
                } else if(this.currentTokenIn(new IElementType[]{CoffeeScriptTokenTypes.BRACKET_START})) {
                    this.parseDestructuringArray();
                } else if(this.shouldDeclareVariable(this.getTokenText())) {
                    this.parseDestructuringVariable(propertyType);
                } else {
                    definitionMarker = this.mark();
                    PsiBuilder.Marker referenceMarker = this.mark();
                    if(this.isShortThis()) {
                        PsiBuilder.Marker referenceMarkerForThis = this.mark();
                        this.advance();
                        this.done(referenceMarkerForThis, JSElementTypes.REFERENCE_EXPRESSION);
                    }

                    this.advance();
                    this.done(referenceMarker, JSElementTypes.REFERENCE_EXPRESSION);
                    this.done(definitionMarker, JSStubElementTypes.DEFINITION_EXPRESSION);
                }
            } else if(this.shouldDeclareVariable(variableName)) {
                this.addVariableInCurrentScope(variableName);
                drop(propertyNameMarker);
                this.done(definitionMarker, propertyType);
            } else {
                this.done(propertyNameMarker, JSElementTypes.REFERENCE_EXPRESSION);
                this.done(definitionMarker, JSStubElementTypes.DEFINITION_EXPRESSION);
            }

            this.done(propertyMarker, JSStubElementTypes.DESTRUCTURING_PROPERTY);
            if(this.isCurrentTokenIn(new IElementType[]{CoffeeScriptTokenTypes.COMMA})) {
                this.advance();
            }
        }

        if(withBraces) {
            this.expectAndAdvance(CoffeeScriptTokenTypes.BRACE_END);
        }

        if(this.currentTokenIn(new IElementType[]{CoffeeScriptTokenTypes.EQ})) {
            this.advance();
            this.parseWithPossibleWhileOrForOrIf(this.myExpressionInvoker);
        }

        this.done(destructuringObjectMarker, JSStubElementTypes.DESTRUCTURING_OBJECT);
        this.done(destructuringElementMarker, JSStubElementTypes.DESTRUCTURING_ELEMENT);
        if(wrapWithVarStatement) {
            this.done(varStatementMarker, CoffeeScriptElementTypes.VAR_STATEMENT);
        } else {
            drop(varStatementMarker);
        }

    }

    private void parseDestructuringVariable(@NotNull IElementType propertyType) {
        this.addVariableInCurrentScope(this.getTokenText());
        PsiBuilder.Marker variableMarker = this.mark();
        this.advance();
        this.done(variableMarker, propertyType);
    }

    private boolean shouldDeclareVariable(String text) {
        return text != null && !this.isShortThis() && !this.isInScope(text);
    }

    private void parseObject() {
        PsiBuilder.Marker marker = this.mark(true);
        boolean startedOnNewLine = this.isNewLine();
        boolean withBraces = false;
        this.invocationIndent = -1;
        if(this.isCurrentTokenIn(new IElementType[]{CoffeeScriptTokenTypes.BRACE_START})) {
            this.advance();
            withBraces = true;
        }

        boolean firstObjectValue = true;
        int indent = this.getCurrentIndent();
        PsiBuilder.Marker lastCommaMarker = null;

        while(!withBraces || !this.isCurrentTokenIn(new IElementType[]{CoffeeScriptTokenTypes.BRACE_END})) {
            int offset = this.getCurrentOffset();
            if(this.isNewLine()) {
                int newIndent = this.getCurrentIndent();
                if(indent >= 0 && newIndent > indent && !withBraces || newIndent < indent && !withBraces || !startedOnNewLine && newIndent == indent && !withBraces) {
                    break;
                }

                indent = newIndent;
            } else if(!firstObjectValue && this.isNewLine() && 0 < indent && !withBraces) {
                break;
            }

            if(this.isComma() && lastCommaMarker == null) {
                lastCommaMarker = this.mark(true);
                this.advance();
            } else {
                if(!withBraces && (!this.isThisProperty() || !isTokenIn(this.lookAhead(2), new IElementType[]{CoffeeScriptTokenTypes.COLON})) && !this.isStringObjectKey() && (!this.isCurrentTokenIn(new IElementType[]{CoffeeScriptTokenTypes.IDENTIFIER}) || !isTokenIn(this.lookAhead(1), new IElementType[]{CoffeeScriptTokenTypes.COLON}))) {
                    break;
                }

                if(!withBraces || !this.isCurrentTokenIn(new IElementType[]{CoffeeScriptTokenTypes.BRACE_END})) {
                    this.parseAssignObj();
                }

                if(lastCommaMarker != null) {
                    drop(lastCommaMarker);
                    lastCommaMarker = null;
                }

                if(this.getCurrentOffset() == offset) {
                    this.error("AssignObj expected");
                    break;
                }

                firstObjectValue = false;
            }
        }

        if(withBraces) {
            this.expect(CoffeeScriptTokenTypes.BRACE_END);
        }

        if(withBraces && this.isCurrentTokenIn(new IElementType[]{CoffeeScriptTokenTypes.EQ})) {
            this.rollbackTo(marker);
            this.parseDestructuringObject(CoffeeScriptElementTypes.VARIABLE, true, true);
        } else {
            if(lastCommaMarker != null) {
                if(!withBraces && !this.isNewLine()) {
                    this.rollbackTo(lastCommaMarker);
                } else {
                    drop(lastCommaMarker);
                }
            }

            this.done(marker, CoffeeScriptElementTypes.OBJECT);
        }

    }

    private void parseAssignObj() {
        PsiBuilder.Marker marker = this.mark(true);
        if(this.isObjAssignable()) {
            PsiBuilder.Marker referenceMarker = this.mark();
            boolean couldBeReference = this.parseObjAssignable();
            if(this.isCurrentTokenIn(new IElementType[]{CoffeeScriptTokenTypes.COLON})) {
                this.advance();
                if(!this.isExpressionTerminator()) {
                    this.parseWithPossibleWhileOrForOrIf(this.myExpressionInvoker);
                }

                couldBeReference = false;
            }

            if(couldBeReference) {
                this.done(referenceMarker, CoffeeScriptElementTypes.REFERENCED_EXPRESSION);
            } else {
                referenceMarker.drop();
            }
        }

        this.done(marker, CoffeeScriptElementTypes.PROPERTY);
    }

    private boolean parseObjAssignable() {
        boolean couldBeReference = true;
        if(this.isIdentifier()) {
            this.parseIdentifier(true);
        } else if(this.isAlphaNumeric()) {
            this.parseLiteral(false);
            couldBeReference = false;
        } else if(this.isThisProperty()) {
            this.advance();
            this.parseIdentifier(true);
        } else {
            couldBeReference = false;
            this.error("unexpected token");
        }

        return couldBeReference;
    }

    private void parseParenthetical() {
        ++this.parenthesisLevel;
        this.startScope();
        PsiBuilder.Marker marker = this.mark();
        this.advance();

        while(!this.isCurrentTokenIn(new IElementType[]{CoffeeScriptTokenTypes.PARENTHESIS_END})) {
            int offset = this.getCurrentOffset();
            this.parseLine(false);
            if(offset == this.getCurrentOffset()) {
                this.error("Unexpected element: " + this.getTokenType());
                break;
            }
        }

        this.expect(CoffeeScriptTokenTypes.PARENTHESIS_END);
        this.done(marker, CoffeeScriptElementTypes.PARENTHESIZED_EXPRESSION);
        --this.parenthesisLevel;
        this.endScope();
    }

    private boolean isRange() {
        if(this.isCurrentTokenIn(new IElementType[]{CoffeeScriptTokenTypes.BRACKET_START})) {
            int offset = this.getCurrentOffset();
            CoffeeScriptParserMetaData md = (CoffeeScriptParserMetaData)this.metaData.get(Integer.valueOf(offset));
            if(md != null) {
                if(md.isRange != null) {
                    return md.isRange.booleanValue();
                }
            } else {
                md = new CoffeeScriptParserMetaData();
                this.metaData.put(Integer.valueOf(offset), md);
            }

            PsiBuilder.Marker marker = this.mark(true);
            this.advance();
            this.parseOperation();
            if(this.isRangeSymbol() && this.lookAhead(1) != CoffeeScriptTokenTypes.COMMA) {
                this.advance();
                if(!this.isNewLine()) {
                    this.rollbackTo(marker);
                    md.isRange = Boolean.valueOf(true);
                    return true;
                }
            }

            md.isRange = Boolean.valueOf(false);
            this.rollbackTo(marker);
        }

        return false;
    }

    private boolean parseParameterList() {
        this.startScope();
        PsiBuilder.Marker marker = this.mark();
        this.advance();

        while(!this.eof() && !this.isCurrentTokenIn(new IElementType[]{CoffeeScriptTokenTypes.PARENTHESIS_END})) {
            int offset = this.getCurrentOffset();
            this.parseParam();
            if(offset == this.getCurrentOffset()) {
                return false;
            }

            if(this.isCurrentTokenIn(new IElementType[]{CoffeeScriptTokenTypes.COMMA})) {
                this.advance();
            }
        }

        if(!this.isCurrentTokenIn(new IElementType[]{CoffeeScriptTokenTypes.PARENTHESIS_END})) {
            this.endScope();
            this.error("Expected )");
            return false;
        } else {
            this.advance();
            this.done(marker, JSStubElementTypes.PARAMETER_LIST);
            return true;
        }
    }

    private void parseSplat() {
        this.advance();
    }

    private void parseParam() {
        String result;
        PsiBuilder.Marker marker;
        if(this.isIdentifier() && this.isInScope(this.getTokenText())) {
            result = this.getTokenText();
            marker = this.mark();
            this.parseValuesAndInvocations(true, false, false, false);
            this.done(marker, CoffeeScriptElementTypes.PARAMETER);
        } else if(this.isObject()) {
            this.parseDestructuringObject(CoffeeScriptElementTypes.PARAMETER, false, true);
            if(this.isCurrentTokenIn(new IElementType[]{CoffeeScriptTokenTypes.EQ})) {
                this.advance();
                this.parseOperation();
            }

            result = null;
        } else if(this.isArray()) {
            this.parseDestructuringArrayInParameters();
            if(this.isSplatSymbol()) {
                this.parseSplat();
            }

            result = null;
        } else {
            marker = this.mark();
            result = this.parseParamVar();
            if(this.isSplatSymbol()) {
                this.parseSplat();
            } else if(this.isCurrentTokenIn(new IElementType[]{CoffeeScriptTokenTypes.EQ})) {
                this.advance();
                this.parseOperation();
            }

            this.done(marker, CoffeeScriptElementTypes.PARAMETER);
        }

        if(result != null) {
            this.addVariableInCurrentScope(result);
        }

    }

    private void parseDestructuringArrayInParameters() {
        PsiBuilder.Marker destructuringArrayMarker = this.mark();
        this.advance();
        int offset = this.getCurrentOffset();
        int splatCount = 0;
        int bracketsDeep = 1;

        do {
            PsiBuilder.Marker parameterMarker = this.mark();
            if(this.isSplatSymbol()) {
                this.parseSplat();
                ++splatCount;
                if(splatCount > 1) {
                    this.error("Multiple splats/expansions are disallowed in an assignment");
                }
            } else {
                this.addVariableInCurrentScope(this.getTokenText());
                this.advance();
            }

            if(this.isSplatSymbol()) {
                if(splatCount > 0) {
                    this.error("Multiple splats/expansions are disallowed in an assignment");
                }

                this.parseSplat();
                ++splatCount;
            }

            this.done(parameterMarker, CoffeeScriptElementTypes.PARAMETER);
            if(this.isComma()) {
                this.advance();
            }

            if(offset == this.getCurrentOffset()) {
                break;
            }

            offset = this.getCurrentOffset();
            if(this.currentTokenIn(new IElementType[]{CoffeeScriptTokenTypes.BRACKET_START})) {
                ++bracketsDeep;
            }

            if(this.currentTokenIn(new IElementType[]{CoffeeScriptTokenTypes.BRACKET_END})) {
                --bracketsDeep;
            }
        } while(bracketsDeep > 0 && !this.eof());

        this.expect(CoffeeScriptTokenTypes.BRACKET_END);
        this.done(destructuringArrayMarker, JSElementTypes.DESTRUCTURING_ARRAY);
    }

    private void parseDestructuringArray() {
        PsiBuilder.Marker destructuringElementMarker = this.mark();
        PsiBuilder.Marker destructuringArrayMarker = this.mark();
        this.expectAndAdvance(CoffeeScriptTokenTypes.BRACKET_START);

        while(!this.currentTokenIn(new IElementType[]{CoffeeScriptTokenTypes.BRACKET_END})) {
            PsiBuilder.Marker definitionMarker = this.mark();
            if(this.isSplatSymbol()) {
                this.parseSplat();
            } else {
                this.parseValuesAndInvocations(true, false, false, false);
            }

            if(this.isSplatSymbol()) {
                this.parseSplat();
            }

            this.done(definitionMarker, CoffeeScriptElementTypes.DEFINITION_EXPRESSION);
            if(!this.isComma()) {
                break;
            }

            this.advance();
        }

        this.expectAndAdvance(CoffeeScriptTokenTypes.BRACKET_END);
        if(this.currentTokenIn(new IElementType[]{CoffeeScriptTokenTypes.EQ})) {
            this.advance();
            this.parseExpression();
        }

        this.done(destructuringArrayMarker, JSElementTypes.DESTRUCTURING_ARRAY);
        this.done(destructuringElementMarker, JSStubElementTypes.DESTRUCTURING_ELEMENT);
    }

    @Nullable
    private String parseParamVar() {
        String result = null;
        if(this.isCurrentTokenIn(new IElementType[]{CoffeeScriptTokenTypes.THIS})) {
            if(this.getTokenText().equals("this")) {
                this.error("Unexpected \'this\'");
                this.advance();
                this.expectAndAdvance(CoffeeScriptTokenTypes.DOT);
            } else {
                this.advance();
            }

            this.expectAndAdvance(CoffeeScriptTokenTypes.IDENTIFIER);
        } else if(this.isIdentifier()) {
            result = this.getTokenText();
            this.advance();
        } else if(this.isArray()) {
            this.parseArray(false);
        }

        return result;
    }

    private void parseArray(boolean assigned) {
        int indent = this.getCurrentIndent();
        PsiBuilder.Marker arrayAssignmentMarker = this.mark(true);
        PsiBuilder.Marker arrayMarker = this.mark();
        this.advance();
        int splatCount = 0;

        while(!this.eof() && !this.isCurrentTokenIn(new IElementType[]{CoffeeScriptTokenTypes.BRACKET_END})) {
            int eqFound = this.getCurrentOffset();
            if(assigned) {
                if(this.isIdentifier() && !isTokenIn(this.lookAhead(1), new IElementType[]{CoffeeScriptTokenTypes.DOT, CoffeeScriptTokenTypes.BRACKET_START}) && !this.isInScope(this.getTokenText())) {
                    this.addVariableInCurrentScope(this.getTokenText());
                    PsiBuilder.Marker marker = this.mark();
                    this.advance();
                    this.done(marker, CoffeeScriptElementTypes.VARIABLE);
                } else if(!this.isSplatSymbol()) {
                    this.parseWithPossibleWhileOrForOrIf(this.myExpressionInvoker);
                }
            } else if(!this.isSplatSymbol()) {
                this.parseWithPossibleWhileOrForOrIf(this.myExpressionInvoker);
            }

            if(this.isSplatSymbol()) {
                if(splatCount > 0 && assigned) {
                    this.error("Multiple splats/expansions are disallowed in an assignment");
                }

                this.parseSplat();
                ++splatCount;
            }

            if(eqFound == this.getCurrentOffset()) {
                this.error("Unexpected token");
                break;
            }

            if(!this.isComma() && !this.isExpressionTerminator()) {
                if(!this.isNewLine() && !this.isCurrentTokenIn(new IElementType[]{CoffeeScriptTokenTypes.BRACKET_END})) {
                    this.error("Expected \"comma\"");
                }
            } else {
                this.advance();

                while(this.isComma()) {
                    this.error("Unexpected ,");
                    this.advance();
                }
            }
        }

        this.expect(CoffeeScriptTokenTypes.BRACKET_END);
        this.done(arrayMarker, (IElementType)(assigned?JSElementTypes.DESTRUCTURING_ARRAY:CoffeeScriptElementTypes.ARRAY_LITERAL_EXPRESSION));
        boolean var8 = this.isCurrentTokenIn(new IElementType[]{CoffeeScriptTokenTypes.EQ}) && this.getCurrentIndent() >= indent;
        if(!assigned && var8) {
            this.rollbackTo(arrayAssignmentMarker);
            this.parseDestructuringArray();
        } else {
            if(var8) {
                arrayAssignmentMarker.drop();
                this.advance();
                this.parseOperation();
            } else {
                arrayAssignmentMarker.drop();
            }

        }
    }

    protected boolean parseWithPossibleWhileOrForOrIf(@NotNull CoffeeScriptParser.ParseInvoker invoker) {
        PsiBuilder.Marker labelMarker = this.mark();
        boolean result = invoker.parse();

        while(!this.isNewLine() && (this.isForBody() || this.isIf() || this.isWhile())) {
            PsiBuilder.Marker marker = labelMarker;
            labelMarker = labelMarker.precede();
            if(this.isWhile()) {
                this.parseWhileExpression();
                this.done(marker, CoffeeScriptElementTypes.WHILE_STATEMENT);
            } else if(this.isForBody()) {
                this.parseForBody();
                this.done(marker, CoffeeScriptElementTypes.FOR_STATEMENT);
            } else if(this.isIf()) {
                this.parseIfCondition();
                this.done(marker, CoffeeScriptElementTypes.IF_STATEMENT);
            }
        }

        labelMarker.drop();
        return result;
    }

    private void parseSimpleArgs() {
        while(true) {
            this.parseOperation();
            if(!this.isCurrentTokenIn(new IElementType[]{CoffeeScriptTokenTypes.COMMA})) {
                return;
            }

            this.advance();
        }
    }

    protected void parseSwitch() {
        int switchIndent = this.getCurrentIndent();
        PsiBuilder.Marker marker = this.mark();
        this.advance();
        if(!this.isNewLine()) {
            this.parseOperation();
            if(!this.isNewLine()) {
                this.error("Unexpected " + this.getTokenText());
            }
        }

        int indent = this.getCurrentIndent();
        if(indent <= switchIndent) {
            this.error("When block must be inside switch block");
        } else {
            this.parseWhens(indent);
        }

        this.done(marker, CoffeeScriptElementTypes.SWITCH_STATEMENT);
    }

    private void parseWhens(int indent) {
        this.wantedElseAtIndent.push(Integer.valueOf(indent));

        while(true) {
            if(this.isNewLine()) {
                if(this.getCurrentIndent() != indent) {
                    break;
                }

                if(this.isCurrentTokenIn(new IElementType[]{CoffeeScriptTokenTypes.WHEN})) {
                    this.parseWhen();
                    continue;
                }

                if(this.isCurrentTokenIn(new IElementType[]{CoffeeScriptTokenTypes.ELSE})) {
                    this.parseElse(CoffeeScriptElementTypes.CASE_CLAUSE);
                    continue;
                }

                this.error("WHEN expected");
                break;
            }

            if(!this.eof()) {
                this.error("Indent expected");
            }
            break;
        }

        this.wantedElseAtIndent.pop();
    }

    private void parseElse(@NotNull IElementType elementType) {
        int indent = this.getCurrentIndent();
        PsiBuilder.Marker marker = this.mark();
        this.advance();
        this.parseBlockOrLine(indent);
        this.done(marker, elementType);
    }

    private void parseWhen() {
        int indent = this.getCurrentIndent();
        PsiBuilder.Marker marker = this.mark();
        this.advance();
        this.parseSimpleArgs();
        this.parseBlockOrThen(indent);
        this.done(marker, CoffeeScriptElementTypes.CASE_CLAUSE);
    }

    private boolean parseAssignment() {
        PsiBuilder.Marker assignmentMarker = this.mark();
        PsiBuilder.Marker definitionMarker = this.mark();
        boolean result = OperationParserHelper.callParsingBinaryOperation(this, CoffeeScriptTokenTypes.BINARY_OPERATION_PRIORITY.length - 1);
        if(CoffeeScriptTokenTypes.ASSIGNMENT_OPERATIONS.contains(this.getTokenType())) {
            this.done(definitionMarker, CoffeeScriptElementTypes.DEFINITION_EXPRESSION);
            this.advance();
            result = this.parseAssignment();
            this.done(assignmentMarker, CoffeeScriptElementTypes.ASSIGN_EXPRESSION);
        } else {
            definitionMarker.drop();
            assignmentMarker.drop();
        }

        return result;
    }

    private boolean parseOperation() {
        return this.parseAssignment();
    }

    protected void parseVariable() {
        int variableIndent = this.getCurrentIndent();
        PsiBuilder.Marker varMarker = this.mark();
        PsiBuilder.Marker marker = this.mark();
        String variableName = this.getTokenText();
        this.addVariableInCurrentScope(variableName);
        this.parseIdentifier(false);
        this.advance();
        if(this.isNewLine()) {
            int indent = this.getCurrentIndent();
            if(indent < variableIndent) {
                this.error("UNEXPECTED \'OUTDENT\'");
            }

            this.parseWithPossibleWhileOrForOrIf(this.myExpressionInvoker);
        } else {
            this.parseOperation();
        }

        this.done(marker, CoffeeScriptElementTypes.VARIABLE);
        this.done(varMarker, CoffeeScriptElementTypes.VAR_STATEMENT);
    }

    private CoffeeScriptParser.ValueTypes parseValueOrInvocation(@Nullable PsiBuilder.Marker referenceMarker, @Nullable PsiBuilder.Marker invocationMarker, boolean invocationWithoutParenthesisAllowed, boolean objectAllowed, boolean argumentsOnNewLineAllowed) {
        int indent = this.getCurrentIndent();
        boolean referenced = this.parseValue(objectAllowed);
        if(referenceMarker != null) {
            if(referenced) {
                this.done(referenceMarker, CoffeeScriptElementTypes.REFERENCED_EXPRESSION);
            } else {
                referenceMarker.drop();
            }
        }

        if(!this.currentTokenIn(new IElementType[]{CoffeeScriptTokenTypes.PARENTHESIS_START}) && (!invocationWithoutParenthesisAllowed || !argumentsOnNewLineAllowed && this.isNewLine())) {
            return CoffeeScriptParser.ValueTypes.VALUE;
        } else if(this.isInvocationWithBraces()) {
            this.parseArgumentList(indent);
            if(invocationMarker != null) {
                this.done(invocationMarker, CoffeeScriptElementTypes.CALL_EXPRESSION);
            }

            return CoffeeScriptParser.ValueTypes.INVOCATION_WITH_BRACES;
        } else if(!referenced || !this.isExpression() || (this.isNewLine() || !this.hasSpaceBefore()) && (!this.isNewLine() || !this.isObject() || indent >= this.getCurrentIndent() || this.isCurrentTokenIn(new IElementType[]{CoffeeScriptTokenTypes.BRACE_START}))) {
            return CoffeeScriptParser.ValueTypes.VALUE;
        } else {
            this.parseArgumentList(indent);
            if(invocationMarker != null) {
                this.done(invocationMarker, CoffeeScriptElementTypes.CALL_EXPRESSION);
            }

            return CoffeeScriptParser.ValueTypes.INVOCATION_WITHOUT_BRACES;
        }
    }

    private boolean startsExpression() {
        int i = -1;
        if(CoffeeScriptTokenTypes.WHITESPACES.contains(this.rawLookup(i))) {
            --i;
        }

        return this.isNewLine() || tokenIn(this.rawLookup(i), new IElementType[]{CoffeeScriptTokenTypes.SEMICOLON, CoffeeScriptTokenTypes.EQ, CoffeeScriptTokenTypes.PARENTHESIS_START, CoffeeScriptTokenTypes.RETURN, CoffeeScriptTokenTypes.EXIST, CoffeeScriptTokenTypes.DO_KEYWORD, CoffeeScriptTokenTypes.YIELD_KEYWORD});
    }

    protected boolean parseValuesAndInvocations(boolean finishInvocation, boolean invocationWithoutParenthesisAllowed, boolean objectAllowed, boolean argumentsOnNewLineAllowed) {
        boolean isCallable = !this.isCurrentTokenIn(new IElementType[]{CoffeeScriptTokenTypes.NUMBER, CoffeeScriptTokenTypes.STRING_LITERAL, CoffeeScriptTokenTypes.BOOL}) && !this.isObject();
        int indent = this.getCurrentIndent();
        boolean startsNewExpression = this.startsExpression();
        PsiBuilder.Marker implicitInvocationMarker = this.mark();
        boolean lastValueInvocation = false;
        PsiBuilder.Marker leftMarker = this.mark();
        PsiBuilder.Marker rightMarker = this.mark();
        CoffeeScriptParser.ValueTypes valueType = this.parseValueOrInvocation(rightMarker, leftMarker, invocationWithoutParenthesisAllowed, objectAllowed, argumentsOnNewLineAllowed);
        if(valueType != CoffeeScriptParser.ValueTypes.VALUE) {
            leftMarker = leftMarker.precede();
            lastValueInvocation = true;
        }

        rightMarker = leftMarker;
        leftMarker = leftMarker.precede();

        while(this.isAccessor(indent) && (!this.isNewLine() || startsNewExpression) || this.isInvocationWithBraces()) {
            int offset = this.getCurrentOffset();
            lastValueInvocation = false;
            if(this.isAccessor(indent)) {
                valueType = this.parseAccessor(rightMarker, leftMarker, invocationWithoutParenthesisAllowed, argumentsOnNewLineAllowed);
                if(valueType != CoffeeScriptParser.ValueTypes.VALUE) {
                    leftMarker = leftMarker.precede();
                    lastValueInvocation = true;
                }

                rightMarker = leftMarker;
                leftMarker = leftMarker.precede();
            }

            if(this.isInvocationWithBraces()) {
                this.parseArgumentList(indent);
                this.done(rightMarker, CoffeeScriptElementTypes.CALL_EXPRESSION);
                rightMarker = leftMarker;
                leftMarker = leftMarker.precede();
            }

            if(offset == this.getCurrentOffset()) {
                break;
            }
        }

        rightMarker.drop();
        leftMarker.drop();
        if(valueType != CoffeeScriptParser.ValueTypes.INVOCATION_WITHOUT_BRACES && (this.isNewLine() && this.isArgumentObject(indent) && this.myMultilineArgumentListAllowed || !this.isNewLine() && this.isExpression()) && finishInvocation && isCallable) {
            lastValueInvocation = true;
            this.parseArgumentList(indent);
            this.done(implicitInvocationMarker, CoffeeScriptElementTypes.CALL_EXPRESSION);
        } else {
            implicitInvocationMarker.drop();
        }

        return !lastValueInvocation;
    }

    protected boolean parseExpression() {
        boolean skip = false;
        if(this.isCode()) {
            skip = this.parseFunction();
        }

        if(!skip) {
            if(this.isCurrentTokenIn(new IElementType[]{CoffeeScriptTokenTypes.DO_KEYWORD})) {
                this.parseDoExpression();
            } else if(this.isCurrentTokenIn(new IElementType[]{CoffeeScriptTokenTypes.CLASS})) {
                this.parseClass();
            } else if(this.isIf() && !this.isPostIf()) {
                this.parseIf();
            } else if(this.isWhile() && !this.isPostWhile()) {
                this.parseWhile();
            } else if(this.isLoop()) {
                this.parseLoop();
            } else if(this.isVariable()) {
                this.parseVariable();
            } else if(this.isValue()) {
                this.parseValuesAndInvocations(true, true, true, true);
            } else if(this.isForBody() && !this.isPostFor()) {
                this.parseFor();
            } else if(this.isSwitch()) {
                this.parseSwitch();
            } else if(this.isCurrentTokenIn(new IElementType[]{CoffeeScriptTokenTypes.TRY})) {
                this.parseTry();
            } else if(this.isThrow()) {
                this.parseThrow();
            } else if(!this.parseYield()) {
                if(!this.isIf() && !this.isWhile() && !this.isForBody() || this.isNewLine()) {
                    this.error("Unexpected token");
                }

                return false;
            }
        }

        return true;
    }

    protected boolean parseYield() {
        if(this.currentTokenIn(new IElementType[]{CoffeeScriptTokenTypes.YIELD_KEYWORD})) {
            PsiBuilder.Marker marker = this.mark();
            this.advance();
            if(this.isReturn()) {
                this.parseReturn();
            } else {
                this.myExpressionInvoker.parse();
            }

            this.done(marker, JSElementTypes.YIELD_EXPRESSION);
            return true;
        } else {
            return false;
        }
    }

    protected void parseDoExpression() {
        PsiBuilder.Marker marker = this.mark();
        this.advance();
        if(!this.myExpressionInvoker.parse()) {
            this.error("Expression expected");
        }

        this.done(marker, CoffeeScriptElementTypes.DO_EXPRESSION);
    }

    protected boolean isPostIf() {
        return this.isIf() && this.isPostSuffix(new CoffeeScriptParser.ParseInvoker() {
            public boolean parse() {
                CoffeeScriptParser.this.parseIfCondition();
                return false;
            }
        });
    }

    protected boolean isPostWhile() {
        return this.isWhile() && this.isPostSuffix(new CoffeeScriptParser.ParseInvoker() {
            public boolean parse() {
                CoffeeScriptParser.this.parseWhileExpression();
                return false;
            }
        });
    }

    protected boolean isPostFor() {
        return this.isForBody() && this.isPostSuffix(new CoffeeScriptParser.ParseInvoker() {
            public boolean parse() {
                CoffeeScriptParser.this.parseForBody();
                return false;
            }
        });
    }

    private boolean endOfOneLineFunctionScope() {
        return this.isNewLine() || this.eof() || this.isCurrentTokenIn(new IElementType[]{CoffeeScriptTokenTypes.PARENTHESIS_END, CoffeeScriptTokenTypes.BRACE_END, CoffeeScriptTokenTypes.BRACKET_END});
    }

    protected boolean parseFunction() {
        int codeIndent = this.getCurrentIndent();
        PsiBuilder.Marker marker = this.mark(true);
        boolean parameterListParsed = true;
        boolean parametersScopeCreated = false;
        if(this.isCurrentTokenIn(new IElementType[]{CoffeeScriptTokenTypes.PARENTHESIS_START})) {
            parameterListParsed = this.parseParameterList();
            parametersScopeCreated = true;
        }

        if(parameterListParsed && this.isCurrentTokenIn(new IElementType[]{CoffeeScriptTokenTypes.FUNCTION, CoffeeScriptTokenTypes.FUNCTION_BIND})) {
            if(this.invocationIndent >= 0) {
                codeIndent = this.invocationIndent;
            }

            this.advance();
            boolean newLine = this.isNewLine();
            if(newLine) {
                this.parseBlock(codeIndent, true);
            } else {
                if(this.isExpression() || this.isStatement()) {
                    this.parseLineWithNewScope(true);
                }

                if(!((Boolean)this.oneLineState.peek()).booleanValue() && !this.endOfOneLineFunctionScope() && !this.currentTokenIn(new IElementType[]{CoffeeScriptTokenTypes.INTERPOLATION_END}) && (!this.currentTokenIn(new IElementType[]{CoffeeScriptTokenTypes.COMMA}) || !this.nextTokenOnNewLine())) {
                    this.error("Unexpected " + this.getTokenText());
                }
            }

            this.done(marker, CoffeeScriptElementTypes.FUNCTION_EXPRESSION);
            if(parametersScopeCreated) {
                this.endScope();
            }

            return true;
        } else {
            this.rollbackTo(marker);
            return false;
        }
    }

    private void parseReturn() {
        PsiBuilder.Marker marker = this.mark();
        this.advance();
        if(!this.isNewLine() && this.isExpression()) {
            this.parseOperation();
        }

        this.done(marker, CoffeeScriptElementTypes.RETURN_STATEMENT);
    }

    protected void parseThrow() {
        PsiBuilder.Marker marker = this.mark();
        this.advance();
        this.parseOperation();
        this.done(marker, CoffeeScriptElementTypes.THROW_STATEMENT);
    }

    private boolean parseNewStatement() {
        if(this.currentTokenIn(new IElementType[]{CoffeeScriptTokenTypes.NEW_KEYWORD})) {
            PsiBuilder.Marker newMarker = this.mark(false);
            this.advance();
            PsiBuilder.Marker invocationMarker = this.mark();
            PsiBuilder.Marker referenceMarker = this.mark();
            CoffeeScriptParser.ValueTypes valueType = this.parseValueOrInvocation(referenceMarker, invocationMarker, true, true, false);
            if(valueType == CoffeeScriptParser.ValueTypes.VALUE) {
                drop(invocationMarker);
            }

            this.done(newMarker, CoffeeScriptElementTypes.NEW_EXPRESSION);
            return true;
        } else {
            return false;
        }
    }

    private boolean parseValue(boolean objectAllowed) {
        boolean referenced = false;
        if(this.currentTokenIn(new IElementType[]{CoffeeScriptTokenTypes.NEW_KEYWORD})) {
            this.parseNewStatement();
        } else if(this.isParenthetical()) {
            this.parseParenthetical();
        } else if(objectAllowed && this.isObject()) {
            this.parseObject();
        } else if(this.isCurrentTokenIn(new IElementType[]{CoffeeScriptTokenTypes.THIS})) {
            referenced = true;
            this.parseThis();
        } else if(this.isRange()) {
            this.parseRange();
        } else if(this.isAssignable()) {
            referenced = this.parseAssignable();
        } else if(this.isLiteral()) {
            this.parseLiteral(true);
        } else if(this.isSuper()) {
            this.advance();
        } else if(this.isCurrentTokenIn(new IElementType[]{CoffeeScriptTokenTypes.CLASS})) {
            this.parseClass();
        } else {
            this.error("Unexpected token: " + this.getTokenType() + " (" + this.getTokenText() + ") ");
        }

        return referenced;
    }

    private boolean expectAndAdvance(IElementType tokenType) {
        if(this.getTokenType() != tokenType) {
            this.error("Expect tokenType: " + tokenType + ", but got: " + this.getTokenType());
            return false;
        } else {
            this.advance();
            return true;
        }
    }

    private boolean parseAssignable() {
        boolean referenced = false;
        if(this.isArray()) {
            this.parseArray(false);
        } else if(this.isSimpleAssignable()) {
            referenced = true;
            this.parseSimpleAssignable();
        } else if(this.isObject()) {
            this.parseDestructuringObject(CoffeeScriptElementTypes.VARIABLE, true, true);
        } else {
            this.error("Unexpected token in assignable element");
        }

        return referenced;
    }

    private void parseLiteral(boolean withExpression) {
        PsiBuilder.Marker marker = withExpression?this.mark():null;
        if(this.isString()) {
            this.parseString();
            if(withExpression) {
                this.done(marker, JSElementTypes.LITERAL_EXPRESSION);
            }
        } else if(this.isCurrentTokenIn(new IElementType[]{CoffeeScriptTokenTypes.NUMBER, CoffeeScriptTokenTypes.BOOL})) {
            this.advance();
            if(withExpression) {
                this.done(marker, CoffeeScriptElementTypes.LITERAL_EXPRESSION);
            }
        } else if(this.isRegexp()) {
            IElementType elementType = this.parseRegexp();
            if(withExpression) {
                this.done(marker, elementType);
            }
        } else if(this.isCurrentTokenIn(new IElementType[]{CoffeeScriptTokenTypes.JAVASCRIPT_LITERAL})) {
            this.advance();
            this.advance();
            this.advance();
            if(withExpression) {
                this.done(marker, CoffeeScriptElementTypes.LITERAL_EXPRESSION);
            }
        } else {
            if(withExpression) {
                marker.drop();
            }

            this.error("Unexpected token");
        }

    }

    private void parseRange() {
        if(this.currentTokenIn(new IElementType[]{CoffeeScriptTokenTypes.BRACKET_START})) {
            PsiBuilder.Marker marker = this.mark();
            this.advance();
            if(!this.isSplatOrRange()) {
                this.parseOperation();
            }

            if(this.isSplatOrRange()) {
                if(this.isSplatSymbol()) {
                    this.parseSplat();
                } else {
                    this.advance();
                }

                if(!this.isCurrentTokenIn(new IElementType[]{CoffeeScriptTokenTypes.BRACKET_END})) {
                    this.parseOperation();
                }

                if(this.isCurrentTokenIn(new IElementType[]{CoffeeScriptTokenTypes.BRACKET_END})) {
                    this.advance();
                } else {
                    this.error("] expected");
                }
            } else {
                this.error("... expected");
            }

            this.done(marker, CoffeeScriptElementTypes.RANGE);
        }

    }

    private void parseThis() {
        PsiBuilder.Marker marker;
        if(this.isShortThis()) {
            marker = this.mark();
            PsiBuilder.Marker marker1 = this.mark();
            int offset = this.getCurrentOffset();
            this.advance();
            this.done(marker1, CoffeeScriptElementTypes.THIS_PROPERTY);
            if(offset + 1 != this.getCurrentOffset() || !this.isIdentifier() && !this.isPrototype()) {
                marker.drop();
            } else {
                this.done(marker, CoffeeScriptElementTypes.REFERENCED_EXPRESSION);
                this.advance();
            }
        } else {
            marker = this.mark();
            this.advance();
            this.done(marker, CoffeeScriptElementTypes.THIS_PROPERTY);
        }

    }

    private void parseInterpolation() {
        if(this.currentTokenIn(new IElementType[]{CoffeeScriptTokenTypes.INTERPOLATION_START})) {
            this.advance();

            while(!this.isCurrentTokenIn(new IElementType[]{CoffeeScriptTokenTypes.INTERPOLATION_END})) {
                this.parseWithPossibleWhileOrForOrIf(this.myExpressionInvoker);
                if(!this.isCurrentTokenIn(new IElementType[]{CoffeeScriptTokenTypes.SEMICOLON})) {
                    break;
                }

                this.advance();
            }

            this.expectAndAdvance(CoffeeScriptTokenTypes.INTERPOLATION_END);
        }

    }

    private void parseGeneralString(@NotNull IElementType end, boolean interpolationAllowed, @NotNull IElementType... body) {
        this.advance();

        while(!this.eof() && !this.isCurrentTokenIn(new IElementType[]{end})) {
            if(this.isCurrentTokenIn(new IElementType[]{CoffeeScriptTokenTypes.INTERPOLATION_START})) {
                if(!interpolationAllowed) {
                    this.error("Interpolation is not allowed here");
                }

                this.parseInterpolation();
            } else {
                if(!ArrayUtil.contains(this.getTokenType(), body)) {
                    this.error("Unexpected element: " + this.getTokenType());
                }

                this.advance();
            }
        }

        if(this.isCurrentTokenIn(new IElementType[]{end})) {
            this.advance();
            if(this.isCurrentTokenIn(new IElementType[]{CoffeeScriptTokenTypes.REGEX_FLAG})) {
                this.advance();
            }
        } else {
            this.error("Expected end of type" + end);
        }

    }

    private IElementType parseRegexp() {
        if(this.isCurrentTokenIn(new IElementType[]{CoffeeScriptTokenTypes.HEREGEX_START})) {
            this.parseGeneralString(CoffeeScriptTokenTypes.HEREGEX_END, true, new IElementType[]{null, CoffeeScriptTokenTypes.TERMINATOR, CoffeeScriptTokenTypes.HEREGEX_TOKEN, CoffeeScriptTokenTypes.REGEX_BRACE_START, CoffeeScriptTokenTypes.REGEX_BRACE_END, CoffeeScriptTokenTypes.REGEX_BRACKET_START, CoffeeScriptTokenTypes.REGEX_BRACKET_END, CoffeeScriptTokenTypes.REGEX_PARENTHESIS_START, CoffeeScriptTokenTypes.REGEX_PARENTHESIS_END, CoffeeScriptTokenTypes.REGEX_FLAG, CoffeeScriptTokenTypes.ESCAPE_SEQUENCE, CoffeeScriptTokenTypes.INTERPOLATION_START, CoffeeScriptTokenTypes.INTERPOLATION_END, CoffeeScriptTokenTypes.BRACKET_START, CoffeeScriptTokenTypes.BRACKET_END, CoffeeScriptTokenTypes.PARENTHESIS_START, CoffeeScriptTokenTypes.PARENTHESIS_END, CoffeeScriptTokenTypes.INDENT});
            return CoffeeScriptElementTypes.HEREGEX;
        } else {
            this.parseGeneralString(CoffeeScriptTokenTypes.REGEX_END, true, new IElementType[]{null, CoffeeScriptTokenTypes.REGEX});
            return CoffeeScriptElementTypes.LITERAL_EXPRESSION;
        }
    }

    private void pargeSimpleString() {
        TokenSet stringBody = TokenSet.create(new IElementType[]{CoffeeScriptTokenTypes.STRING_LITERAL, CoffeeScriptTokenTypes.INTERPOLATION_START, CoffeeScriptTokenTypes.ESCAPE_SEQUENCE});
        boolean firstToken = true;

        while(this.currentTokenIn(stringBody) && (firstToken || this.rawLookup(-1) != CoffeeScriptTokenTypes.WHITE_SPACE && !this.isNewLine())) {
            firstToken = false;
            if(this.getTokenType() == CoffeeScriptTokenTypes.INTERPOLATION_START) {
                this.parseInterpolation();
            } else {
                this.advance();
            }
        }

    }

    protected void parseString() {
        if(this.isCurrentTokenIn(new IElementType[]{CoffeeScriptTokenTypes.STRING_LITERAL})) {
            this.pargeSimpleString();
        } else {
            this.parseGeneralString(CoffeeScriptTokenTypes.HEREDOC_END, true, new IElementType[]{null, CoffeeScriptTokenTypes.HEREDOC, CoffeeScriptTokenTypes.TERMINATOR, CoffeeScriptTokenTypes.INTERPOLATION_START, CoffeeScriptTokenTypes.INTERPOLATION_END, CoffeeScriptTokenTypes.ESCAPE_SEQUENCE});
        }

    }

    private void parseArgument(boolean invocationWithBraces) {
        if(invocationWithBraces) {
            this.parseWithPossibleWhileOrForOrIf(this.myExpressionInvoker);
        } else {
            this.parseOperation();
        }

        if(this.isSplatSymbol()) {
            this.parseSplat();
        }

    }

    private boolean isArgumentObject(int indent) {
        PsiBuilder.Marker marker = this.mark(true);

        boolean var3;
        try {
            if(!this.isNewLine() || !this.myMultilineArgumentListAllowed || this.getCurrentIndent() <= indent || !this.isObject()) {
                var3 = false;
                return var3;
            }

            var3 = true;
        } finally {
            this.rollbackTo(marker);
        }

        return var3;
    }

    protected boolean isExpression() {
        return !this.eof() && !this.isExpressionTerminator() && (!this.isStatement() || this.isVariable()) && !this.isCurrentTokenIn(new IElementType[]{CoffeeScriptTokenTypes.BAD_CHARACTER, CoffeeScriptTokenTypes.PARENTHESIS_END, CoffeeScriptTokenTypes.BRACKET_END, CoffeeScriptTokenTypes.DOT, CoffeeScriptTokenTypes.ELSE, CoffeeScriptTokenTypes.THEN, CoffeeScriptTokenTypes.COMMA, CoffeeScriptTokenTypes.WHEN, CoffeeScriptTokenTypes.BRACE_END, CoffeeScriptTokenTypes.BY, CoffeeScriptTokenTypes.COLON, CoffeeScriptTokenTypes.EQ, CoffeeScriptTokenTypes.EXTENDS, CoffeeScriptTokenTypes.EXIST, CoffeeScriptTokenTypes.RANGE, CoffeeScriptTokenTypes.INTERPOLATION_END}) && !this.isOperationSymbol() && !this.isPostIf() && !this.isRelationSymbol() && !this.isSwitchEnd() && !this.isPostFor() && !this.isPostWhile() && !this.isSplatSymbol() && (!this.isPostfixOperator() || this.rawLookup(-1) == CoffeeScriptTokenTypes.WHITE_SPACE);
    }

    private void parseArgumentList(int callIndent) {
        ++this.argumentListLevel;
        int oldInvocationIndent = this.invocationIndent;
        this.invocationIndent = callIndent;
        PsiBuilder.Marker argumentListMarker = this.mark();
        boolean invocationWithBraces = this.isInvocationWithBraces();
        if(invocationWithBraces) {
            ++this.parenthesisLevel;
            this.advance();

            while(!this.eof() && !this.isCurrentTokenIn(new IElementType[]{CoffeeScriptTokenTypes.PARENTHESIS_END})) {
                int comma = this.getCurrentOffset();
                if(this.currentTokenIn(new IElementType[]{CoffeeScriptTokenTypes.COMMA})) {
                    this.advance();

                    while(this.currentTokenIn(new IElementType[]{CoffeeScriptTokenTypes.COMMA})) {
                        this.error("Unexpected ,");
                        this.advance();
                    }
                }

                if(this.isCurrentTokenIn(new IElementType[]{CoffeeScriptTokenTypes.PARENTHESIS_END})) {
                    break;
                }

                this.parseArgument(true);
                if(comma == this.getCurrentOffset()) {
                    this.error("Unexpected token");
                    break;
                }
            }

            this.expect(CoffeeScriptTokenTypes.PARENTHESIS_END);
            --this.parenthesisLevel;
        } else if(this.getTokenType() == CoffeeScriptTokenTypes.COMMA) {
            this.error("Unexpected ,");
        } else {
            boolean var9 = true;
            boolean argumentObject = false;
            boolean firstArgument = true;
            var9 = false;

            int offset;
            while(!this.eof() && this.isExpression() && (this.myMultilineArgumentListAllowed || !this.isNewLine())) {
                offset = this.getCurrentOffset();
                if(!firstArgument && !var9 && (!this.isNewLine() || this.getCurrentIndent() <= callIndent) || !this.isExpression()) {
                    break;
                }

                firstArgument = false;
                if(this.isObject()) {
                    argumentObject = true;
                }

                this.parseArgument(false);
                var9 = false;

                while(this.isCurrentTokenIn(new IElementType[]{CoffeeScriptTokenTypes.COMMA}) && (this.getCurrentIndent() >= callIndent || this.argumentListLevel == 1)) {
                    if(var9) {
                        this.error("Unexpected ,");
                    }

                    var9 = true;
                    this.advance();
                }

                if(offset == this.getCurrentOffset()) {
                    this.error("unexpected token");
                    break;
                }
            }

            if(this.isArgumentObject(callIndent)) {
                argumentObject = true;
                this.parseArgument(false);
                var9 = false;
            }

            if(this.isComma() && (!this.isNewLine() || this.getCurrentIndent() == callIndent)) {
                this.advance();
                var9 = true;
            }

            if(argumentObject || var9) {
                while(this.getCurrentIndent() > callIndent && !this.eof() && !this.isStatement() && (!this.isNewLine() || this.getCurrentIndent() > callIndent)) {
                    offset = this.getCurrentOffset();
                    if(this.isExpression()) {
                        var9 = false;
                        this.parseArgument(false);
                    }

                    if(offset == this.getCurrentOffset()) {
                        break;
                    }
                }
            }

            if(this.isComma() && (this.getCurrentIndent() >= callIndent || !this.isNewLine())) {
                this.advance();
            } else if(var9) {
                this.error("Unexpected: " + this.getTokenText());
            }
        }

        this.done(argumentListMarker, CoffeeScriptElementTypes.ARGUMENT_LIST);
        --this.argumentListLevel;
        this.invocationIndent = oldInvocationIndent;
    }

    private class ExpressionInvoker implements CoffeeScriptParser.ParseInvoker {
        private ExpressionInvoker() {
        }

        public final boolean parse() {
            return CoffeeScriptParser.this.parseOperation();
        }
    }

    private class StatementInvoker implements CoffeeScriptParser.ParseInvoker {
        private StatementInvoker() {
        }

        public final boolean parse() {
            return CoffeeScriptParser.this.parseStatement();
        }
    }

    private interface ParseInvoker {
        boolean parse();
    }

    static enum ValueTypes {
        VALUE,
        INVOCATION_WITH_BRACES,
        INVOCATION_WITHOUT_BRACES;

        private ValueTypes() {
        }
    }
}

