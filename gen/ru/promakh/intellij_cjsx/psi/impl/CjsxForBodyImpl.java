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

public class CjsxForBodyImpl extends ASTWrapperPsiElement implements CjsxForBody {

  public CjsxForBodyImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof CjsxVisitor) ((CjsxVisitor)visitor).visitForBody(this);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public CjsxExpression getExpression() {
    return findChildByClass(CjsxExpression.class);
  }

  @Override
  @Nullable
  public CjsxForSource getForSource() {
    return findChildByClass(CjsxForSource.class);
  }

  @Override
  @Nullable
  public CjsxForStart getForStart() {
    return findChildByClass(CjsxForStart.class);
  }

  @Override
  @Nullable
  public CjsxRange getRange() {
    return findChildByClass(CjsxRange.class);
  }

}
