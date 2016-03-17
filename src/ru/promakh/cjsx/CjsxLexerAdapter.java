package ru.promakh.cjsx;

import com.intellij.lexer.FlexAdapter;
import ru.promakh.cjsx.lang.CjsxLexer;

public class CjsxLexerAdapter extends FlexAdapter {

    public CjsxLexerAdapter() {
        super(new CjsxLexer(null));
    }
}
