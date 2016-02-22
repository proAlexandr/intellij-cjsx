package token_regexp;

import org.junit.Test;
import org.junit.Assert;

public class String_Test {
    public String ESCAPED_QUARTER_REGEXP = "\\\\\\\"" ;
    public String STRING_REGEXP = "\"([^\"]|" + ESCAPED_QUARTER_REGEXP + ")*\"";

    public String QUOTE = "\"";
    public String E_QUOTE = "\\\"";

    @Test
    public void should_accept_simple_string() {
        AssertMatch("\"hello\"");
    }

    @Test
    public void should_accept_string_with_escaped_quote() {
        AssertMatch(QUOTE + "he" + E_QUOTE + "llo" + QUOTE);
    }

    private void AssertMatch(String input) {
        Assert.assertTrue(input.matches(STRING_REGEXP));
    }
}
