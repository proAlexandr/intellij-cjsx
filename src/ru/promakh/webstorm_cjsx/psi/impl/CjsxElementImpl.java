package ru.promakh.webstorm_cjsx.psi.impl;

import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import com.intellij.lang.javascript.psi.impl.JSExpressionImpl;
import org.jetbrains.annotations.NotNull;

public class CjsxElementImpl extends ASTWrapperPsiElement {

    public CjsxElementImpl(@NotNull ASTNode astNode) {
        super(astNode);
    }
}


