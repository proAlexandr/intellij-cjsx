package ru.promakh.cjsx.highlighter;

import com.intellij.lang.annotation.AnnotationHolder;
import com.intellij.lang.annotation.Annotator;
import com.intellij.psi.PsiElement;
import ru.promakh.cjsx.psi.impl.CjsxElementImpl;
import ru.promakh.cjsx.psi.impl.CjsxNameValueAttributeImpl;
import ru.promakh.cjsx.psi.impl.CjsxTagImpl;

public class CjsxHighlightAnnotator implements Annotator {

    @Override
    public void annotate(PsiElement psiElement, AnnotationHolder annotationHolder) {
        if (psiElement instanceof CjsxElementImpl) {
            if (psiElement instanceof CjsxTagImpl) {
                highlightTagIdentifier(((CjsxTagImpl) psiElement), annotationHolder);
            } else if (psiElement instanceof CjsxNameValueAttributeImpl) {
                highlightAttributeName(((CjsxNameValueAttributeImpl) psiElement), annotationHolder);
            }
        }
    }

    private void highlightTagIdentifier(CjsxTagImpl psiElement, AnnotationHolder annotationHolder) {
        annotationHolder.createInfoAnnotation(psiElement.nameElement(), null)
                .setTextAttributes(CjsxSyntaxHighlighter.TAG_NAME);
    }

    private void highlightAttributeName(CjsxNameValueAttributeImpl psiElement, AnnotationHolder annotationHolder) {
        annotationHolder.createInfoAnnotation(psiElement.nameElement(), null)
                .setTextAttributes(CjsxSyntaxHighlighter.ATTRIBUTE_NAME);
    }
}
