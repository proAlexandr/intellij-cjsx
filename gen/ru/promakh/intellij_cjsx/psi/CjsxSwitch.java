// This is a generated file. Not intended for manual editing.
package ru.promakh.intellij_cjsx.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface CjsxSwitch extends PsiElement {

  @Nullable
  CjsxBlock getBlock();

  @Nullable
  CjsxExpression getExpression();

  @NotNull
  CjsxWhens getWhens();

  @NotNull
  PsiElement getIndent();

}
