// This is a generated file. Not intended for manual editing.
package ru.promakh.intellij_cjsx.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface CjsxArgList extends PsiElement {

  @Nullable
  CjsxArg getArg();

  @Nullable
  CjsxArgList getArgList();

  @Nullable
  CjsxOptComma getOptComma();

  @Nullable
  PsiElement getIndent();

  @Nullable
  PsiElement getTerminator();

}
