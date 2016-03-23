package ru.promakh.cjsx.highlighter;

import com.intellij.lang.annotation.AnnotationHolder;
import com.intellij.lang.javascript.JSAnalysisHandlersFactory;
import com.intellij.lang.javascript.validation.JSAnnotatingVisitor;
import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.NotNull;

public class CjsxAnalysisHandlersFactory extends JSAnalysisHandlersFactory {
    public CjsxAnalysisHandlersFactory(){

    }

    public JSAnnotatingVisitor createAnnotatingVisitor(@NotNull PsiElement psiElement, @NotNull AnnotationHolder holder) {
        return new CjsxAnnotatingVisitor(psiElement, holder);
    }
}
