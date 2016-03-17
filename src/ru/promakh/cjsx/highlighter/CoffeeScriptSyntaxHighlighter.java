//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package ru.promakh.cjsx.highlighter;

import com.intellij.lang.javascript.highlighting.JSHighlighter;
import com.intellij.lexer.Lexer;
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors;
import com.intellij.openapi.editor.HighlighterColors;
import com.intellij.openapi.editor.colors.EditorColors;
import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.psi.tree.IElementType;
import com.intellij.psi.tree.TokenSet;
import java.util.HashMap;
import java.util.Map;
import org.coffeescript.CoffeeScriptLanguage;
import org.coffeescript.lang.lexer.CoffeeScriptFlexLexer;
import org.coffeescript.lang.lexer.CoffeeScriptTokenTypes;
import org.jetbrains.annotations.NotNull;

public class CoffeeScriptSyntaxHighlighter extends JSHighlighter {
    protected static final Map<IElementType, TextAttributesKey> TOKENS_TO_STYLES;

    static final TextAttributesKey BAD_CHARACTER;
    static final TextAttributesKey SEMICOLON;
    static final TextAttributesKey COMMA;
    static final TextAttributesKey DOT;
    public static final TextAttributesKey CLASS_NAME;
    static final TextAttributesKey IDENTIFIER;
    public static final TextAttributesKey FUNCTION_NAME;
    public static final TextAttributesKey OBJECT_KEY;
    public static final TextAttributesKey PARAMETER;
    public static final TextAttributesKey LOCAL_VARIABLE;
    public static final TextAttributesKey GLOBAL_VARIABLE;
    static final TextAttributesKey NUMBER;
    static final TextAttributesKey BOOLEAN;
    static final TextAttributesKey STRING_LITERAL;
    static final TextAttributesKey HEREDOC_ID;
    static final TextAttributesKey HEREDOC_CONTENT;
    static final TextAttributesKey HEREGEX_ID;
    static final TextAttributesKey HEREGEX_CONTENT;
    static final TextAttributesKey JAVASCRIPT_INJECTION_QUOTE;
    static final TextAttributesKey JAVASCRIPT_INJECTION;
    static final TextAttributesKey EXPRESSIONS_SUBSTITUTION_MARK;
    static final TextAttributesKey LINE_COMMENT;
    static final TextAttributesKey BLOCK_COMMENT;
    static final TextAttributesKey PARENTHESIS;
    static final TextAttributesKey BRACKETS;
    static final TextAttributesKey BRACES;
    static final TextAttributesKey OPERATIONS;
    static final TextAttributesKey EXISTENTIAL;
    public static final TextAttributesKey KEYWORD;
    static final TextAttributesKey RANGE;
    static final TextAttributesKey SPLAT;
    static final TextAttributesKey THIS;
    static final TextAttributesKey COLON;
    static final TextAttributesKey PROTOTYPE;
    static final TextAttributesKey FUNCTION_ARROW;
    static final TextAttributesKey FUNCTION_BINDING_ARROW;
    static final TextAttributesKey REGULAR_EXPRESSION_ID;
    static final TextAttributesKey REGULAR_EXPRESSION_CONTENT;
    static final TextAttributesKey REGULAR_EXPRESSION_FLAG;
    static final TextAttributesKey ESCAPE_SEQUENCE;

    public CoffeeScriptSyntaxHighlighter() {
        super(CoffeeScriptLanguage.INSTANCE.getOptionHolder());
    }

    @NotNull
    public Lexer getHighlightingLexer() {
        return new CoffeeScriptFlexLexer();
    }

    @NotNull
    public TextAttributesKey[] getTokenHighlights(IElementType tokenType) {
        return pack((TextAttributesKey)TOKENS_TO_STYLES.get(tokenType));
    }

    static {
        BAD_CHARACTER = TextAttributesKey.createTextAttributesKey("COFFEESCRIPT.BAD_CHARACTER", HighlighterColors.BAD_CHARACTER);
        SEMICOLON = TextAttributesKey.createTextAttributesKey("COFFEESCRIPT.SEMICOLON", DefaultLanguageHighlighterColors.SEMICOLON);
        COMMA = TextAttributesKey.createTextAttributesKey("COFFEESCRIPT.COMMA", DefaultLanguageHighlighterColors.COMMA);
        DOT = TextAttributesKey.createTextAttributesKey("COFFEESCRIPT.DOT", DefaultLanguageHighlighterColors.DOT);
        CLASS_NAME = TextAttributesKey.createTextAttributesKey("COFFEESCRIPT.CLASS_NAME", DefaultLanguageHighlighterColors.IDENTIFIER);
        IDENTIFIER = TextAttributesKey.createTextAttributesKey("COFFEESCRIPT.IDENTIFIER", DefaultLanguageHighlighterColors.IDENTIFIER);
        FUNCTION_NAME = TextAttributesKey.createTextAttributesKey("COFFEESCRIPT.FUNCTION_NAME", DefaultLanguageHighlighterColors.FUNCTION_DECLARATION);
        OBJECT_KEY = TextAttributesKey.createTextAttributesKey("COFFEESCRIPT.OBJECT_KEY", DefaultLanguageHighlighterColors.INSTANCE_FIELD);
        PARAMETER = TextAttributesKey.createTextAttributesKey("COFFEESCRIPT.PARAMETER", DefaultLanguageHighlighterColors.PARAMETER);
        LOCAL_VARIABLE = TextAttributesKey.createTextAttributesKey("COFFEESCRIPT.LOCAL_VARIABLE", JSHighlighter.JS_LOCAL_VARIABLE);
        GLOBAL_VARIABLE = TextAttributesKey.createTextAttributesKey("COFFEESCRIPT.GLOBAL_VARIABLE", JSHighlighter.JS_GLOBAL_VARIABLE);
        NUMBER = TextAttributesKey.createTextAttributesKey("COFFEESCRIPT.NUMBER", DefaultLanguageHighlighterColors.NUMBER);
        BOOLEAN = TextAttributesKey.createTextAttributesKey("COFFEESCRIPT.BOOLEAN", DefaultLanguageHighlighterColors.KEYWORD);
        STRING_LITERAL = TextAttributesKey.createTextAttributesKey("COFFEESCRIPT.STRING_LITERAL", DefaultLanguageHighlighterColors.STRING);
        HEREDOC_ID = TextAttributesKey.createTextAttributesKey("COFFEESCRIPT.HEREDOC_ID", DefaultLanguageHighlighterColors.STRING);
        HEREDOC_CONTENT = TextAttributesKey.createTextAttributesKey("COFFEESCRIPT.HEREDOC_CONTENT", DefaultLanguageHighlighterColors.STRING);
        HEREGEX_ID = TextAttributesKey.createTextAttributesKey("COFFEESCRIPT.HEREGEX_ID", DefaultLanguageHighlighterColors.STRING);
        HEREGEX_CONTENT = TextAttributesKey.createTextAttributesKey("COFFEESCRIPT.HEREGEX_CONTENT", DefaultLanguageHighlighterColors.STRING);
        JAVASCRIPT_INJECTION_QUOTE = TextAttributesKey.createTextAttributesKey("COFFEESCRIPT.JAVASCRIPT_ID", DefaultLanguageHighlighterColors.STRING);
        JAVASCRIPT_INJECTION = TextAttributesKey.createTextAttributesKey("COFFEESCRIPT.JAVASCRIPT_CONTENT", EditorColors.INJECTED_LANGUAGE_FRAGMENT);
        EXPRESSIONS_SUBSTITUTION_MARK = TextAttributesKey.createTextAttributesKey("COFFEESCRIPT.EXPRESSIONS_SUBSTITUTION_MARK", DefaultLanguageHighlighterColors.BRACES);
        LINE_COMMENT = TextAttributesKey.createTextAttributesKey("COFFEESCRIPT.LINE_COMMENT", DefaultLanguageHighlighterColors.LINE_COMMENT);
        BLOCK_COMMENT = TextAttributesKey.createTextAttributesKey("COFFEESCRIPT.BLOCK_COMMENT", DefaultLanguageHighlighterColors.BLOCK_COMMENT);
        PARENTHESIS = TextAttributesKey.createTextAttributesKey("COFFEESCRIPT.PARENTHESIS", DefaultLanguageHighlighterColors.PARENTHESES);
        BRACKETS = TextAttributesKey.createTextAttributesKey("COFFEESCRIPT.BRACKET", DefaultLanguageHighlighterColors.BRACKETS);
        BRACES = TextAttributesKey.createTextAttributesKey("COFFEESCRIPT.BRACE", DefaultLanguageHighlighterColors.BRACES);
        OPERATIONS = TextAttributesKey.createTextAttributesKey("COFFEESCRIPT.OPERATIONS", DefaultLanguageHighlighterColors.OPERATION_SIGN);
        EXISTENTIAL = TextAttributesKey.createTextAttributesKey("COFFEESCRIPT.EXISTENTIAL", DefaultLanguageHighlighterColors.OPERATION_SIGN);
        KEYWORD = TextAttributesKey.createTextAttributesKey("COFFEESCRIPT.KEYWORD", DefaultLanguageHighlighterColors.KEYWORD);
        RANGE = TextAttributesKey.createTextAttributesKey("COFFEESCRIPT.RANGE", DefaultLanguageHighlighterColors.OPERATION_SIGN);
        SPLAT = TextAttributesKey.createTextAttributesKey("COFFEESCRIPT.SPLAT", DefaultLanguageHighlighterColors.OPERATION_SIGN);
        THIS = TextAttributesKey.createTextAttributesKey("COFFEESCRIPT.THIS", DefaultLanguageHighlighterColors.KEYWORD);
        COLON = TextAttributesKey.createTextAttributesKey("COFFEESCRIPT.COLON", DefaultLanguageHighlighterColors.OPERATION_SIGN);
        PROTOTYPE = TextAttributesKey.createTextAttributesKey("COFFEESCRIPT.PROTOTYPE", DefaultLanguageHighlighterColors.OPERATION_SIGN);
        FUNCTION_ARROW = TextAttributesKey.createTextAttributesKey("COFFEESCRIPT.FUNCTION", DefaultLanguageHighlighterColors.OPERATION_SIGN);
        FUNCTION_BINDING_ARROW = TextAttributesKey.createTextAttributesKey("COFFEESCRIPT.FUNCTION_BINDING", DefaultLanguageHighlighterColors.KEYWORD);
        REGULAR_EXPRESSION_ID = TextAttributesKey.createTextAttributesKey("COFFEESCRIPT.REGULAR_EXPRESSION_ID", DefaultLanguageHighlighterColors.STRING);
        REGULAR_EXPRESSION_CONTENT = TextAttributesKey.createTextAttributesKey("COFFEESCRIPT.REGULAR_EXPRESSION_CONTENT", DefaultLanguageHighlighterColors.STRING);
        REGULAR_EXPRESSION_FLAG = TextAttributesKey.createTextAttributesKey("COFFEESCRIPT.REGULAR_EXPRESSION_FLAG", DefaultLanguageHighlighterColors.KEYWORD);
        ESCAPE_SEQUENCE = TextAttributesKey.createTextAttributesKey("COFFEESCRIPT.ESCAPE_SEQUENCE", DefaultLanguageHighlighterColors.VALID_STRING_ESCAPE);
        TOKENS_TO_STYLES = new HashMap();
        TOKENS_TO_STYLES.put(CoffeeScriptTokenTypes.BAD_CHARACTER, BAD_CHARACTER);
        TOKENS_TO_STYLES.put(CoffeeScriptTokenTypes.ERROR_ELEMENT, BAD_CHARACTER);
        TOKENS_TO_STYLES.put(CoffeeScriptTokenTypes.WHITE_SPACE, HighlighterColors.TEXT);
        TOKENS_TO_STYLES.put(CoffeeScriptTokenTypes.TERMINATOR, HighlighterColors.TEXT);
        TOKENS_TO_STYLES.put(CoffeeScriptTokenTypes.DOT, DOT);
        TOKENS_TO_STYLES.put(CoffeeScriptTokenTypes.COMMA, COMMA);
        TOKENS_TO_STYLES.put(CoffeeScriptTokenTypes.COLON, COLON);
        TOKENS_TO_STYLES.put(CoffeeScriptTokenTypes.SEMICOLON, SEMICOLON);
        TOKENS_TO_STYLES.put(CoffeeScriptTokenTypes.IDENTIFIER, IDENTIFIER);
        TOKENS_TO_STYLES.put(CoffeeScriptTokenTypes.NUMBER, NUMBER);
        TOKENS_TO_STYLES.put(CoffeeScriptTokenTypes.BOOL, BOOLEAN);
        TOKENS_TO_STYLES.put(CoffeeScriptTokenTypes.ESCAPE_SEQUENCE, ESCAPE_SEQUENCE);
        TOKENS_TO_STYLES.put(CoffeeScriptTokenTypes.STRING_LITERAL, STRING_LITERAL);
        TOKENS_TO_STYLES.put(CoffeeScriptTokenTypes.HEREDOC_START, HEREDOC_ID);
        TOKENS_TO_STYLES.put(CoffeeScriptTokenTypes.HEREDOC, HEREDOC_CONTENT);
        TOKENS_TO_STYLES.put(CoffeeScriptTokenTypes.HEREDOC_END, HEREDOC_ID);
        TOKENS_TO_STYLES.put(CoffeeScriptTokenTypes.REGEX_START, REGULAR_EXPRESSION_ID);
        TOKENS_TO_STYLES.put(CoffeeScriptTokenTypes.REGEX, REGULAR_EXPRESSION_CONTENT);
        TOKENS_TO_STYLES.put(CoffeeScriptTokenTypes.REGEX_BRACKET_START, REGULAR_EXPRESSION_CONTENT);
        TOKENS_TO_STYLES.put(CoffeeScriptTokenTypes.REGEX_BRACKET_END, REGULAR_EXPRESSION_CONTENT);
        TOKENS_TO_STYLES.put(CoffeeScriptTokenTypes.REGEX_PARENTHESIS_START, REGULAR_EXPRESSION_CONTENT);
        TOKENS_TO_STYLES.put(CoffeeScriptTokenTypes.REGEX_PARENTHESIS_END, REGULAR_EXPRESSION_CONTENT);
        TOKENS_TO_STYLES.put(CoffeeScriptTokenTypes.REGEX_BRACE_START, REGULAR_EXPRESSION_CONTENT);
        TOKENS_TO_STYLES.put(CoffeeScriptTokenTypes.REGEX_BRACE_END, REGULAR_EXPRESSION_CONTENT);
        TOKENS_TO_STYLES.put(CoffeeScriptTokenTypes.REGEX_END, REGULAR_EXPRESSION_ID);
        TOKENS_TO_STYLES.put(CoffeeScriptTokenTypes.REGEX_FLAG, REGULAR_EXPRESSION_FLAG);
        TOKENS_TO_STYLES.put(CoffeeScriptTokenTypes.HEREGEX_START, HEREGEX_ID);
        TOKENS_TO_STYLES.put(CoffeeScriptTokenTypes.HEREGEX_TOKEN, HEREGEX_CONTENT);
        TOKENS_TO_STYLES.put(CoffeeScriptTokenTypes.HEREGEX_END, HEREGEX_ID);
        TOKENS_TO_STYLES.put(CoffeeScriptTokenTypes.INTERPOLATION_START, EXPRESSIONS_SUBSTITUTION_MARK);
        TOKENS_TO_STYLES.put(CoffeeScriptTokenTypes.INTERPOLATION_END, EXPRESSIONS_SUBSTITUTION_MARK);
        TOKENS_TO_STYLES.put(CoffeeScriptTokenTypes.JAVASCRIPT_LITERAL, JAVASCRIPT_INJECTION_QUOTE);
        TOKENS_TO_STYLES.put(CoffeeScriptTokenTypes.JAVASCRIPT, JAVASCRIPT_INJECTION);
        TOKENS_TO_STYLES.put(CoffeeScriptTokenTypes.LINE_COMMENT, LINE_COMMENT);
        TOKENS_TO_STYLES.put(CoffeeScriptTokenTypes.BLOCK_COMMENT, BLOCK_COMMENT);
        TOKENS_TO_STYLES.put(CoffeeScriptTokenTypes.PARENTHESIS_START, PARENTHESIS);
        TOKENS_TO_STYLES.put(CoffeeScriptTokenTypes.PARENTHESIS_END, PARENTHESIS);
        TOKENS_TO_STYLES.put(CoffeeScriptTokenTypes.BRACKET_START, BRACKETS);
        TOKENS_TO_STYLES.put(CoffeeScriptTokenTypes.BRACKET_END, BRACKETS);
        TOKENS_TO_STYLES.put(CoffeeScriptTokenTypes.BRACE_START, BRACES);
        TOKENS_TO_STYLES.put(CoffeeScriptTokenTypes.BRACE_END, BRACES);
        TokenSet[] var0 = CoffeeScriptTokenTypes.BINARY_OPERATION_PRIORITY;
        int var1 = var0.length;

        for(int var2 = 0; var2 < var1; ++var2) {
            TokenSet tokenSet = var0[var2];
            IElementType[] var4 = tokenSet.getTypes();
            int var5 = var4.length;

            for(int var6 = 0; var6 < var5; ++var6) {
                IElementType type = var4[var6];
                TOKENS_TO_STYLES.put(type, OPERATIONS);
            }
        }

        TOKENS_TO_STYLES.put(CoffeeScriptTokenTypes.EXIST, EXISTENTIAL);
        TOKENS_TO_STYLES.put(CoffeeScriptTokenTypes.RANGE, RANGE);
        TOKENS_TO_STYLES.put(CoffeeScriptTokenTypes.SPLAT, SPLAT);
        TOKENS_TO_STYLES.put(CoffeeScriptTokenTypes.THIS, THIS);
        TOKENS_TO_STYLES.put(CoffeeScriptTokenTypes.PROTOTYPE, PROTOTYPE);
        TOKENS_TO_STYLES.put(CoffeeScriptTokenTypes.FUNCTION, FUNCTION_ARROW);
        TOKENS_TO_STYLES.put(CoffeeScriptTokenTypes.FUNCTION_BIND, FUNCTION_BINDING_ARROW);
        TOKENS_TO_STYLES.put(CoffeeScriptTokenTypes.TYPEOF_KEYWORD, KEYWORD);
        TOKENS_TO_STYLES.put(CoffeeScriptTokenTypes.CLASS, KEYWORD);
        TOKENS_TO_STYLES.put(CoffeeScriptTokenTypes.EXTENDS, KEYWORD);
        TOKENS_TO_STYLES.put(CoffeeScriptTokenTypes.IF, KEYWORD);
        TOKENS_TO_STYLES.put(CoffeeScriptTokenTypes.ELSE, KEYWORD);
        TOKENS_TO_STYLES.put(CoffeeScriptTokenTypes.THEN, KEYWORD);
        TOKENS_TO_STYLES.put(CoffeeScriptTokenTypes.UNLESS, KEYWORD);
        TOKENS_TO_STYLES.put(CoffeeScriptTokenTypes.FOR, KEYWORD);
        TOKENS_TO_STYLES.put(CoffeeScriptTokenTypes.IN_KEYWORD, KEYWORD);
        TOKENS_TO_STYLES.put(CoffeeScriptTokenTypes.OF, KEYWORD);
        TOKENS_TO_STYLES.put(CoffeeScriptTokenTypes.BY, KEYWORD);
        TOKENS_TO_STYLES.put(CoffeeScriptTokenTypes.LOOP, KEYWORD);
        TOKENS_TO_STYLES.put(CoffeeScriptTokenTypes.WHILE, KEYWORD);
        TOKENS_TO_STYLES.put(CoffeeScriptTokenTypes.UNTIL, KEYWORD);
        TOKENS_TO_STYLES.put(CoffeeScriptTokenTypes.SWITCH, KEYWORD);
        TOKENS_TO_STYLES.put(CoffeeScriptTokenTypes.WHEN, KEYWORD);
        TOKENS_TO_STYLES.put(CoffeeScriptTokenTypes.TRY, KEYWORD);
        TOKENS_TO_STYLES.put(CoffeeScriptTokenTypes.CATCH, KEYWORD);
        TOKENS_TO_STYLES.put(CoffeeScriptTokenTypes.THROW, KEYWORD);
        TOKENS_TO_STYLES.put(CoffeeScriptTokenTypes.FINALLY, KEYWORD);
        TOKENS_TO_STYLES.put(CoffeeScriptTokenTypes.BREAK, KEYWORD);
        TOKENS_TO_STYLES.put(CoffeeScriptTokenTypes.CONTINUE, KEYWORD);
        TOKENS_TO_STYLES.put(CoffeeScriptTokenTypes.RETURN, KEYWORD);
        TOKENS_TO_STYLES.put(CoffeeScriptTokenTypes.INSTANCEOF_KEYWORD, KEYWORD);
        TOKENS_TO_STYLES.put(CoffeeScriptTokenTypes.OWN, KEYWORD);
        TOKENS_TO_STYLES.put(CoffeeScriptTokenTypes.SUPER, KEYWORD);
        TOKENS_TO_STYLES.put(CoffeeScriptTokenTypes.NEW_KEYWORD, KEYWORD);
        TOKENS_TO_STYLES.put(CoffeeScriptTokenTypes.DO_KEYWORD, KEYWORD);
        TOKENS_TO_STYLES.put(CoffeeScriptTokenTypes.DELETE_KEYWORD, KEYWORD);
        TOKENS_TO_STYLES.put(CoffeeScriptTokenTypes.YIELD_KEYWORD, KEYWORD);
        TOKENS_TO_STYLES.put(CoffeeScriptTokenTypes.LITERATE_BLOCK_COMMENT, BLOCK_COMMENT);
    }
}
