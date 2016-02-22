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

public class CjsxInvocationImpl extends ASTWrapperPsiElement implements CjsxInvocation {

  public CjsxInvocationImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof CjsxVisitor) ((CjsxVisitor)visitor).visitInvocation(this);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public CjsxArguments getArguments() {
    return findChildByClass(CjsxArguments.class);
  }

  @Override
  @Nullable
  public CjsxInvocation getInvocation() {
    return findChildByClass(CjsxInvocation.class);
  }

  @Override
  @Nullable
  public CjsxOptFuncExist getOptFuncExist() {
    return findChildByClass(CjsxOptFuncExist.class);
  }

  @Override
  @Nullable
  public CjsxValue getValue() {
    return findChildByClass(CjsxValue.class);
  }

}
