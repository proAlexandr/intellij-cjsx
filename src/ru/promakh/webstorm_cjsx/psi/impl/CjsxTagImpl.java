package ru.promakh.webstorm_cjsx.psi.impl;

import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.impl.PsiElementBase;
import org.coffeescript.lang.lexer.CoffeeScriptElementType;
import org.coffeescript.lang.lexer.CoffeeScriptTokenTypes;
import org.jetbrains.annotations.NotNull;
import ru.promakh.webstorm_cjsx.psi.CjsxTokenType;

public class CjsxTagImpl extends CjsxElementImpl {
    public final ASTNode nameIdentifier;

    public CjsxTagImpl(@NotNull ASTNode astNode) {
        super(astNode);
        nameIdentifier = astNode.findChildByType(CoffeeScriptTokenTypes.IDENTIFIER);
    }
}