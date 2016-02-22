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

public class CjsxExpressionImpl extends ASTWrapperPsiElement implements CjsxExpression {

  public CjsxExpressionImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof CjsxVisitor) ((CjsxVisitor)visitor).visitExpression(this);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public CjsxAssign getAssign() {
    return findChildByClass(CjsxAssign.class);
  }

  @Override
  @Nullable
  public CjsxClassDeclaration getClassDeclaration() {
    return findChildByClass(CjsxClassDeclaration.class);
  }

  @Override
  @Nullable
  public CjsxCode getCode() {
    return findChildByClass(CjsxCode.class);
  }

  @Override
  @Nullable
  public CjsxFor getFor() {
    return findChildByClass(CjsxFor.class);
  }

  @Override
  @Nullable
  public CjsxIf getIf() {
    return findChildByClass(CjsxIf.class);
  }

  @Override
  @Nullable
  public CjsxInvocation getInvocation() {
    return findChildByClass(CjsxInvocation.class);
  }

  @Override
  @Nullable
  public CjsxOperation getOperation() {
    return findChildByClass(CjsxOperation.class);
  }

  @Override
  @Nullable
  public CjsxSwitch getSwitch() {
    return findChildByClass(CjsxSwitch.class);
  }

  @Override
  @Nullable
  public CjsxThrow getThrow() {
    return findChildByClass(CjsxThrow.class);
  }

  @Override
  @Nullable
  public CjsxTry getTry() {
    return findChildByClass(CjsxTry.class);
  }

  @Override
  @Nullable
  public CjsxValue getValue() {
    return findChildByClass(CjsxValue.class);
  }

  @Override
  @Nullable
  public CjsxWhile getWhile() {
    return findChildByClass(CjsxWhile.class);
  }

}
