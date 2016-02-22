package ru.promakh.intellij_cjsx;

import com.intellij.lexer.FlexAdapter;

public class CjsxLexerAdapter extends FlexAdapter {

    public CjsxLexerAdapter() {
        super(new _CjsxLexer(null));
    }
}
