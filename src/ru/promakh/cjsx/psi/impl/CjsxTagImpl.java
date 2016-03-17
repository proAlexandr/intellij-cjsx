package ru.promakh.cjsx.psi.impl;

import com.intellij.lang.ASTNode;
import org.coffeescript.lang.lexer.CoffeeScriptTokenTypes;
import org.jetbrains.annotations.NotNull;

public class CjsxTagImpl extends CjsxElementImpl {
    public final ASTNode nameIdentifier;

    public CjsxTagImpl(@NotNull ASTNode astNode) {
        super(astNode);
        nameIdentifier = astNode.findChildByType(CoffeeScriptTokenTypes.IDENTIFIER);
    }
}