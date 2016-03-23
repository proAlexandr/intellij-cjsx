package ru.promakh.cjsx.psi.impl;

import com.intellij.lang.ASTNode;
import com.intellij.lang.javascript.psi.JSElementVisitor;
import com.intellij.psi.PsiElementVisitor;
import org.coffeescript.lang.lexer.CoffeeScriptTokenTypes;
import org.jetbrains.annotations.NotNull;
import ru.promakh.cjsx.psi.ICjsxElementVisitor;

public class CjsxTagImpl extends CjsxElementImpl {

    public CjsxTagImpl(@NotNull ASTNode astNode) {
        super(astNode);
    }

    public void accept(@NotNull PsiElementVisitor visitor) {
        if(visitor instanceof ICjsxElementVisitor) {
            ((ICjsxElementVisitor)visitor).visitTagElement(this);
        } else {
            visitor.visitElement(this);
        }
    }

    public ASTNode nameElement(){
        return findChildByType(CoffeeScriptTokenTypes.IDENTIFIER);
    }
}