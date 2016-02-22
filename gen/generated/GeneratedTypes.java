// This is a generated file. Not intended for manual editing.
package generated;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import generated.psi.impl.*;

public interface GeneratedTypes {

  IElementType EXPRESSION = new IElementType("EXPRESSION", null);

  IElementType NUMBER = new IElementType("123", null);

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
       if (type == EXPRESSION) {
        return new ExpressionImpl(node);
      }
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}
