package ru.promakh.cjsx.psi.impl;

import com.intellij.lang.ASTNode;
import org.coffeescript.lang.lexer.CoffeeScriptTokenTypes;
import org.jetbrains.annotations.NotNull;

public class CjsxNameValueAttributeImpl extends CjsxElementImpl {

    public CjsxNameValueAttributeImpl(@NotNull ASTNode astNode) {
        super(astNode);
    }

    public ASTNode nameElement(){
        return findChildByType(CoffeeScriptTokenTypes.IDENTIFIER);
    }
}
