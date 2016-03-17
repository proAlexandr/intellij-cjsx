package ru.promakh.cjsx.highlighter;

import com.intellij.lang.annotation.AnnotationHolder;
import com.intellij.psi.PsiElement;
//import org.coffeescript.highlighter.CoffeeScriptAnnotatingVisitor;
import org.coffeescript.highlighter.CoffeeScriptAnnotatingVisitor;
import org.jetbrains.annotations.NotNull;
import ru.promakh.cjsx.psi.impl.CjsxElementImpl;
import ru.promakh.cjsx.psi.impl.CjsxTagImpl;

public class CjsxAnnotatingVisitor extends CoffeeScriptAnnotatingVisitor {

    @Override
    public void annotate(@NotNull PsiElement psiElement, @NotNull AnnotationHolder holder) {
        if (psiElement instanceof CjsxElementImpl) {

            if (psiElement instanceof CjsxTagImpl){
                holder.createInfoAnnotation(((CjsxTagImpl) psiElement).nameIdentifier, null)
                        .setTextAttributes(CjsxSyntaxHighlighter.TAG_NAME);
            }

        } else {
            super.annotate(psiElement, holder);
        }
    }
}
