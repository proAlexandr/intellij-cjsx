package ru.promakh.cjsx.highlighter;

import com.intellij.lang.annotation.AnnotationHolder;
import com.intellij.psi.PsiElement;
import org.coffeescript.highlighter.CoffeeScriptAnnotatingVisitor;
import org.jetbrains.annotations.NotNull;
import ru.promakh.cjsx.psi.ICjsxElementVisitor;
import ru.promakh.cjsx.psi.impl.CjsxTagImpl;

public class CjsxAnnotatingVisitor extends CoffeeScriptAnnotatingVisitor implements ICjsxElementVisitor {

    public CjsxAnnotatingVisitor(@NotNull PsiElement psiElement, @NotNull AnnotationHolder holder) {
        super(psiElement, holder);
    }

    @Override
    public void visitTagElement(CjsxTagImpl element) {
        myHolder.createInfoAnnotation(element.nameIdentifier, null)
                .setTextAttributes(CjsxSyntaxHighlighter.TAG_NAME);
    }
}