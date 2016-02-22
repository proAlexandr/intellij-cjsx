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

public class CjsxIfBlockImpl extends ASTWrapperPsiElement implements CjsxIfBlock {

  public CjsxIfBlockImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof CjsxVisitor) ((CjsxVisitor)visitor).visitIfBlock(this);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public CjsxBlock getBlock() {
    return findNotNullChildByClass(CjsxBlock.class);
  }

  @Override
  @NotNull
  public CjsxExpression getExpression() {
    return findNotNullChildByClass(CjsxExpression.class);
  }

  @Override
  @Nullable
  public CjsxIfBlock getIfBlock() {
    return findChildByClass(CjsxIfBlock.class);
  }

  @Override
  @NotNull
  public PsiElement getIfT() {
    return findNotNullChildByType(IF_T);
  }

}
