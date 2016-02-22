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

public class CjsxValueImpl extends ASTWrapperPsiElement implements CjsxValue {

  public CjsxValueImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof CjsxVisitor) ((CjsxVisitor)visitor).visitValue(this);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public CjsxAssignable getAssignable() {
    return findChildByClass(CjsxAssignable.class);
  }

  @Override
  @Nullable
  public CjsxLiteral getLiteral() {
    return findChildByClass(CjsxLiteral.class);
  }

  @Override
  @Nullable
  public CjsxParenthetical getParenthetical() {
    return findChildByClass(CjsxParenthetical.class);
  }

  @Override
  @Nullable
  public CjsxRange getRange() {
    return findChildByClass(CjsxRange.class);
  }

  @Override
  @Nullable
  public CjsxThis getThis() {
    return findChildByClass(CjsxThis.class);
  }

}
