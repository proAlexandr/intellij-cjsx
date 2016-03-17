package ru.promakh.cjsx.psi.impl;

import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import org.jetbrains.annotations.NotNull;

public class CjsxElementImpl extends ASTWrapperPsiElement {

    public CjsxElementImpl(@NotNull ASTNode astNode) {
        super(astNode);
    }
}


