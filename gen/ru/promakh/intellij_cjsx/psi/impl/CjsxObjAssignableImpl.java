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

public class CjsxObjAssignableImpl extends ASTWrapperPsiElement implements CjsxObjAssignable {

  public CjsxObjAssignableImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof CjsxVisitor) ((CjsxVisitor)visitor).visitObjAssignable(this);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public CjsxAlphaNumeric getAlphaNumeric() {
    return findChildByClass(CjsxAlphaNumeric.class);
  }

  @Override
  @Nullable
  public CjsxSimpleObjectAssignable getSimpleObjectAssignable() {
    return findChildByClass(CjsxSimpleObjectAssignable.class);
  }

}
