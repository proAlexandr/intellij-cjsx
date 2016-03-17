import com.intellij.lexer.FlexAdapter;
import com.intellij.psi.tree.IElementType;
import org.coffeescript.lang.lexer.CoffeeScriptTokenTypes;
import org.junit.Assert;
import org.junit.Test;
import ru.promakh.cjsx.CjsxLexerAdapter;
import ru.promakh.cjsx.psi.CjsxTokenType;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CjsxLexer_Test {

    @Test
    public void should_parse_asssignation() throws IOException {
        AssertParsing("a=123", new IElementType[]{
                CoffeeScriptTokenTypes.IDENTIFIER,
                CoffeeScriptTokenTypes.EQ,
                CoffeeScriptTokenTypes.NUMBER,
        });
    }

    @Test
    public void should_parse_single_tag() throws IOException {
        AssertParsing("<img/>", new IElementType[]{
                CoffeeScriptTokenTypes.LT,
                CoffeeScriptTokenTypes.IDENTIFIER,
                CjsxTokenType.DIV_GT
        });
    }

    @Test
    public void should_parse_single_tag_with_attribute() throws IOException {
        AssertParsing("<img src=\"name.jpeg\"/>", new IElementType[]{
                CoffeeScriptTokenTypes.LT,                  // <
                CoffeeScriptTokenTypes.IDENTIFIER,          // img
                CoffeeScriptTokenTypes.IDENTIFIER,          // src
                CoffeeScriptTokenTypes.EQ,                  // =
                CoffeeScriptTokenTypes.STRING_LITERAL,      // "
                CoffeeScriptTokenTypes.STRING_LITERAL,      // name.jpeg
                CoffeeScriptTokenTypes.STRING_LITERAL,      // "
                CjsxTokenType.DIV_GT                        // />
        });
    }

    @Test
    public void should_parse_single_tag_with_attribute_of_code() throws IOException {
        AssertParsing("<img src={ url }/>", new IElementType[]{
                CoffeeScriptTokenTypes.LT,                  // <
                CoffeeScriptTokenTypes.IDENTIFIER,          // img
                CoffeeScriptTokenTypes.IDENTIFIER,          // src
                CoffeeScriptTokenTypes.EQ,                  // =
                CoffeeScriptTokenTypes.BRACE_START,         // {
                CoffeeScriptTokenTypes.IDENTIFIER,          // url
                CoffeeScriptTokenTypes.BRACE_END,           // }
                CjsxTokenType.DIV_GT                        // />
        });
    }

    private static final IElementType[] DIV_TOKENS = new IElementType[]{
            CoffeeScriptTokenTypes.LT,                  // <
            CoffeeScriptTokenTypes.IDENTIFIER,          // div
            CoffeeScriptTokenTypes.GT,                  // >
            CjsxTokenType.LT_DIV,                       // </
            CoffeeScriptTokenTypes.IDENTIFIER,          // div
            CoffeeScriptTokenTypes.GT,                  // >
    };

    @Test
    public void should_parse_tag() {
        AssertParsing("<div> </div>", DIV_TOKENS);
    }

    @Test
    public void should_parse_tag_without_whitespace() {
        AssertParsing("<div></div>", DIV_TOKENS);
    }

    @Test
    public void should_parse_tag_with_interpolation_body() {
        AssertParsing("<div> { class_impl.method_call() } </div>", new IElementType[]{
                CoffeeScriptTokenTypes.LT,                  // <
                CoffeeScriptTokenTypes.IDENTIFIER,          // div
                CoffeeScriptTokenTypes.GT,                  // >
                CoffeeScriptTokenTypes.BRACE_START,
                CoffeeScriptTokenTypes.IDENTIFIER,
                CoffeeScriptTokenTypes.DOT,
                CoffeeScriptTokenTypes.IDENTIFIER,
                CoffeeScriptTokenTypes.PARENTHESIS_START,
                CoffeeScriptTokenTypes.PARENTHESIS_END,
                CoffeeScriptTokenTypes.BRACE_END,
                CjsxTokenType.LT_DIV,                       // </
                CoffeeScriptTokenTypes.IDENTIFIER,          // div
                CoffeeScriptTokenTypes.GT,                  // >
        });
    }

    public static void AssertParsing(String input, IElementType[] expectedTokens) {
        IElementType[] actualTokens = parseToTokens(input);
        Assert.assertArrayEquals(expectedTokens, actualTokens);
    }

    public static IElementType[] parseToTokens(String input) {
        FlexAdapter lexerAdapter = getFlexAdapter(input);
        List<IElementType> list = getAllTokens(lexerAdapter);
        IElementType[] array = new IElementType[list.size()];
        return list.toArray(array);
    }

    public static FlexAdapter getFlexAdapter(String input) {
        FlexAdapter lexerAdapter = new CjsxLexerAdapter();
        lexerAdapter.start(input);
        return lexerAdapter;
    }

    public static List<IElementType> getAllTokens(FlexAdapter lexer) {
        List<IElementType> list = new ArrayList<>();
        IElementType a;
        do {
            a = lexer.getTokenType();
            if (a != CoffeeScriptTokenTypes.WHITE_SPACE && a != null) {
                String text = lexer.getBufferSequence().toString().substring(lexer.getTokenStart(), lexer.getTokenEnd());
                System.out.println("Found token. Type=" + a + " Text='" + text + "'");
                list.add(a);
            }
            lexer.advance();
        } while (a != null);
        return list;
    }
}
