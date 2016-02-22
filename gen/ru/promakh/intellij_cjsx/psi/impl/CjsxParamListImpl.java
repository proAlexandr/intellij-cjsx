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

public class CjsxParamListImpl extends ASTWrapperPsiElement implements CjsxParamList {

  public CjsxParamListImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof CjsxVisitor) ((CjsxVisitor)visitor).visitParamList(this);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public CjsxOptComma getOptComma() {
    return findChildByClass(CjsxOptComma.class);
  }

  @Override
  @Nullable
  public CjsxParam getParam() {
    return findChildByClass(CjsxParam.class);
  }

  @Override
  @Nullable
  public CjsxParamList getParamList() {
    return findChildByClass(CjsxParamList.class);
  }

  @Override
  @Nullable
  public PsiElement getIndent() {
    return findChildByType(INDENT);
  }

  @Override
  @Nullable
  public PsiElement getTerminator() {
    return findChildByType(TERMINATOR);
  }

}
