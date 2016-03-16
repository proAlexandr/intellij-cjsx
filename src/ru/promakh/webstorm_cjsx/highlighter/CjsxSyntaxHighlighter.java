package ru.promakh.webstorm_cjsx.highlighter;

import com.intellij.lexer.Lexer;
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors;
import com.intellij.openapi.editor.XmlHighlighterColors;
import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.psi.tree.IElementType;
import org.jetbrains.annotations.NotNull;
import ru.promakh.webstorm_cjsx.CjsxLexerAdapter;

public class CjsxSyntaxHighlighter extends CoffeeScriptSyntaxHighlighter {
    public static final TextAttributesKey TAG_NAME =
            TextAttributesKey.createTextAttributesKey("CJSX.TAG_NAME", XmlHighlighterColors.XML_TAG_NAME);

    @NotNull
    @Override
    public Lexer getHighlightingLexer() {
        return new CjsxLexerAdapter();
    }

    static {
//        TOKENS_TO_STYLES.put()
    }
}
