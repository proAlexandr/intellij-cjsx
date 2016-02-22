// This is a generated file. Not intended for manual editing.
package ru.promakh.intellij_cjsx.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface CjsxParamList extends PsiElement {

  @Nullable
  CjsxOptComma getOptComma();

  @Nullable
  CjsxParam getParam();

  @Nullable
  CjsxParamList getParamList();

  @Nullable
  PsiElement getIndent();

  @Nullable
  PsiElement getTerminator();

}
