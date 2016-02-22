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

public class CjsxAssignObjImpl extends ASTWrapperPsiElement implements CjsxAssignObj {

  public CjsxAssignObjImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof CjsxVisitor) ((CjsxVisitor)visitor).visitAssignObj(this);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public CjsxComment getComment() {
    return findChildByClass(CjsxComment.class);
  }

  @Override
  @Nullable
  public CjsxExpression getExpression() {
    return findChildByClass(CjsxExpression.class);
  }

  @Override
  @Nullable
  public CjsxObjAssignable getObjAssignable() {
    return findChildByClass(CjsxObjAssignable.class);
  }

  @Override
  @Nullable
  public CjsxSimpleObjectAssignable getSimpleObjectAssignable() {
    return findChildByClass(CjsxSimpleObjectAssignable.class);
  }

  @Override
  @Nullable
  public PsiElement getIndent() {
    return findChildByType(INDENT);
  }

}
