// This is a generated file. Not intended for manual editing.
package ru.promakh.intellij_cjsx.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface CjsxOperation extends PsiElement {

  @Nullable
  CjsxExpression getExpression();

  @Nullable
  CjsxSimpleAssignable getSimpleAssignable();

  @Nullable
  CjsxStatement getStatement();

  @Nullable
  PsiElement getIndent();

  @Nullable
  PsiElement getMath();

  @Nullable
  PsiElement getTerminator();

}
