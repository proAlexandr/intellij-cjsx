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

public class CjsxWhileImpl extends ASTWrapperPsiElement implements CjsxWhile {

  public CjsxWhileImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof CjsxVisitor) ((CjsxVisitor)visitor).visitWhile(this);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public CjsxBlock getBlock() {
    return findChildByClass(CjsxBlock.class);
  }

  @Override
  @Nullable
  public CjsxExpression getExpression() {
    return findChildByClass(CjsxExpression.class);
  }

  @Override
  @Nullable
  public CjsxLoop getLoop() {
    return findChildByClass(CjsxLoop.class);
  }

  @Override
  @Nullable
  public CjsxStatement getStatement() {
    return findChildByClass(CjsxStatement.class);
  }

  @Override
  @Nullable
  public CjsxWhileSource getWhileSource() {
    return findChildByClass(CjsxWhileSource.class);
  }

}
