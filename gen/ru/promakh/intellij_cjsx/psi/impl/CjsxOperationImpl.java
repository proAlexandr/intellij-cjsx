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

public class CjsxOperationImpl extends ASTWrapperPsiElement implements CjsxOperation {

  public CjsxOperationImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof CjsxVisitor) ((CjsxVisitor)visitor).visitOperation(this);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public CjsxExpression getExpression() {
    return findChildByClass(CjsxExpression.class);
  }

  @Override
  @Nullable
  public CjsxSimpleAssignable getSimpleAssignable() {
    return findChildByClass(CjsxSimpleAssignable.class);
  }

  @Override
  @Nullable
  public CjsxStatement getStatement() {
    return findChildByClass(CjsxStatement.class);
  }

  @Override
  @Nullable
  public PsiElement getIndent() {
    return findChildByType(INDENT);
  }

  @Override
  @Nullable
  public PsiElement getMath() {
    return findChildByType(MATH);
  }

  @Override
  @Nullable
  public PsiElement getTerminator() {
    return findChildByType(TERMINATOR);
  }

}
