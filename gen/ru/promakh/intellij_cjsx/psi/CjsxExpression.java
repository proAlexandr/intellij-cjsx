// This is a generated file. Not intended for manual editing.
package ru.promakh.intellij_cjsx.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface CjsxExpression extends PsiElement {

  @Nullable
  CjsxAssign getAssign();

  @Nullable
  CjsxClassDeclaration getClassDeclaration();

  @Nullable
  CjsxCode getCode();

  @Nullable
  CjsxFor getFor();

  @Nullable
  CjsxIf getIf();

  @Nullable
  CjsxInvocation getInvocation();

  @Nullable
  CjsxOperation getOperation();

  @Nullable
  CjsxSwitch getSwitch();

  @Nullable
  CjsxThrow getThrow();

  @Nullable
  CjsxTry getTry();

  @Nullable
  CjsxValue getValue();

  @Nullable
  CjsxWhile getWhile();

}
