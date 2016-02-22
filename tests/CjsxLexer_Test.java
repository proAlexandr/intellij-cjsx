import com.intellij.psi.tree.IElementType;
import org.junit.Test;
import ru.promakh.intellij_cjsx._CjsxLexer;

import java.io.IOException;
import java.io.StringReader;

public class CjsxLexer_Test {
    @Test
    public void test() throws IOException {

        CharSequence text = "return 2 + 4";
        _CjsxLexer lexer = new _CjsxLexer();
        lexer.reset(text, 0, text.length(), 0);

        IElementType token;
        do {

         token = lexer.advance();

        } while (token != null)      ;

    }

}
