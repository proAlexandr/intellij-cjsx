package ru.promakh.cjsx.highlighter;

import com.intellij.ide.highlighter.HtmlHighlighterFactory;
import com.intellij.lexer.Lexer;
import com.intellij.openapi.editor.XmlHighlighterColors;
import com.intellij.openapi.editor.colors.TextAttributesKey;
import org.jetbrains.annotations.NotNull;
import ru.promakh.cjsx.CjsxLexerAdapter;

public class CjsxSyntaxHighlighter extends CoffeeScriptSyntaxHighlighter {
    public static final TextAttributesKey TAG_NAME =
            TextAttributesKey.createTextAttributesKey("CJSX.TAG_NAME", XmlHighlighterColors.HTML_TAG_NAME);
    public static final TextAttributesKey ATTRIBUTE_NAME =
            TextAttributesKey.createTextAttributesKey("CJSX.ATTRIBUTE_NAME", XmlHighlighterColors.HTML_ATTRIBUTE_NAME);

    @NotNull
    @Override
    public Lexer getHighlightingLexer() {
        return new CjsxLexerAdapter();
    }
}
