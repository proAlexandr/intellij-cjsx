package ru.promakh.cjsx.highlighter;

import com.intellij.lang.annotation.AnnotationHolder;
import com.intellij.lang.annotation.Annotator;
import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.NotNull;
import ru.promakh.cjsx.psi.impl.CjsxElementImpl;
import ru.promakh.cjsx.psi.impl.CjsxTagImpl;

public class CjsxHighlightAnnotator implements Annotator {
    @Override
    public void annotate(@NotNull PsiElement psiElement, @NotNull AnnotationHolder annotationHolder) {
        if (psiElement instanceof CjsxElementImpl) {
            if (psiElement instanceof CjsxTagImpl) {
                highlightTagIdentifier(((CjsxTagImpl) psiElement), annotationHolder);
            }
        }
    }

    private void highlightTagIdentifier(CjsxTagImpl psiElement, AnnotationHolder annotationHolder) {
        annotationHolder.createInfoAnnotation(psiElement.nameIdentifier, null)
                .setTextAttributes(CjsxSyntaxHighlighter.TAG_NAME);
    }
}
