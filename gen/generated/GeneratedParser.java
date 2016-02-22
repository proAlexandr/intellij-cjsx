// This is a generated file. Not intended for manual editing.
package generated;

import com.intellij.lang.PsiBuilder;
import com.intellij.lang.PsiBuilder.Marker;
import static generated.GeneratedTypes.*;
import static com.intellij.lang.parser.GeneratedParserUtilBase.*;
import com.intellij.psi.tree.IElementType;
import com.intellij.lang.ASTNode;
import com.intellij.psi.tree.TokenSet;
import com.intellij.lang.PsiParser;
import com.intellij.lang.LightPsiParser;

@SuppressWarnings({"SimplifiableIfStatement", "UnusedAssignment"})
public class GeneratedParser implements PsiParser, LightPsiParser {

  public ASTNode parse(IElementType t, PsiBuilder b) {
    parseLight(t, b);
    return b.getTreeBuilt();
  }

  public void parseLight(IElementType t, PsiBuilder b) {
    boolean r;
    b = adapt_builder_(t, b, this, null);
    Marker m = enter_section_(b, 0, _COLLAPSE_, null);
    if (t == EXPRESSION) {
      r = Expression(b, 0);
    }
    else {
      r = parse_root_(t, b, 0);
    }
    exit_section_(b, 0, m, t, r, true, TRUE_CONDITION);
  }

  protected boolean parse_root_(IElementType t, PsiBuilder b, int l) {
    return Root(b, l + 1);
  }

  /* ********************************************************** */
  // NUMBER '=' NUMBER
  //              | NUMBER
  public static boolean Expression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Expression")) return false;
    if (!nextTokenIs(b, NUMBER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = Expression_0(b, l + 1);
    if (!r) r = consumeToken(b, NUMBER);
    exit_section_(b, m, EXPRESSION, r);
    return r;
  }

  // NUMBER '=' NUMBER
  private static boolean Expression_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Expression_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, NUMBER);
    r = r && consumeToken(b, "=");
    r = r && consumeToken(b, NUMBER);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // Expression
  static boolean Root(PsiBuilder b, int l) {
    return Expression(b, l + 1);
  }

}
