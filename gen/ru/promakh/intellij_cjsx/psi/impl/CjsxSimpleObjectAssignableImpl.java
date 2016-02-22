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

public class CjsxSimpleObjectAssignableImpl extends ASTWrapperPsiElement implements CjsxSimpleObjectAssignable {

  public CjsxSimpleObjectAssignableImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof CjsxVisitor) ((CjsxVisitor)visitor).visitSimpleObjectAssignable(this);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public CjsxIdentifier getIdentifier() {
    return findChildByClass(CjsxIdentifier.class);
  }

  @Override
  @Nullable
  public CjsxThisProperty getThisProperty() {
    return findChildByClass(CjsxThisProperty.class);
  }

}
