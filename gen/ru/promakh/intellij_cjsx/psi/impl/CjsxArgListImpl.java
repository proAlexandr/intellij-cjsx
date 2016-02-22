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

public class CjsxArgListImpl extends ASTWrapperPsiElement implements CjsxArgList {

  public CjsxArgListImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof CjsxVisitor) ((CjsxVisitor)visitor).visitArgList(this);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public CjsxArg getArg() {
    return findChildByClass(CjsxArg.class);
  }

  @Override
  @Nullable
  public CjsxArgList getArgList() {
    return findChildByClass(CjsxArgList.class);
  }

  @Override
  @Nullable
  public CjsxOptComma getOptComma() {
    return findChildByClass(CjsxOptComma.class);
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
