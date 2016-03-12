package ru.promakh.webstorm_cjsx;

import com.intellij.lexer.FlexAdapter;
import org.coffeescript.lang.lexer.CoffeeScriptLexer;
import ru.promakh.webstorm_cjsx.lang.CjsxLexer;

import java.io.Reader;

public class CjsxLexerAdapter extends FlexAdapter {

    public CjsxLexerAdapter() {
        super(new CjsxLexer(null));
    }
}
