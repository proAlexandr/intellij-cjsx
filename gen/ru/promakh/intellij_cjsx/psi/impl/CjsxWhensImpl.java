// This is a generated file. Not intended for manual editing.
package ru.promakh.intellij_cjsx.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static ru.promakh.intellij_cjsx.psi.CjsxTypes.*;
import com.intellij.extapi.psi.ASTWrapperPsiElement;
import ru.promakh.intellij_cjsx.psi.*;

public class CjsxWhensImpl extends ASTWrapperPsiElement implements CjsxWhens {

  public CjsxWhensImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof CjsxVisitor) ((CjsxVisitor)visitor).visitWhens(this);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public CjsxWhen getWhen() {
    return findNotNullChildByClass(CjsxWhen.class);
  }

  @Override
  @Nullable
  public CjsxWhens getWhens() {
    return findChildByClass(CjsxWhens.class);
  }

}
