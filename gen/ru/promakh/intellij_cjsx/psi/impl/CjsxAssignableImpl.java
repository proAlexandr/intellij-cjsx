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

public class CjsxAssignableImpl extends ASTWrapperPsiElement implements CjsxAssignable {

  public CjsxAssignableImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof CjsxVisitor) ((CjsxVisitor)visitor).visitAssignable(this);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public CjsxArray getArray() {
    return findChildByClass(CjsxArray.class);
  }

  @Override
  @Nullable
  public CjsxObject getObject() {
    return findChildByClass(CjsxObject.class);
  }

  @Override
  @Nullable
  public CjsxSimpleAssignable getSimpleAssignable() {
    return findChildByClass(CjsxSimpleAssignable.class);
  }

}
