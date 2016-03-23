package ru.promakh.cjsx.psi.impl;

import com.intellij.lang.ASTNode;
import com.intellij.lang.javascript.psi.JSElementVisitor;
import com.intellij.psi.PsiElementVisitor;
import org.coffeescript.lang.lexer.CoffeeScriptTokenTypes;
import org.jetbrains.annotations.NotNull;
import ru.promakh.cjsx.psi.ICjsxElementVisitor;

public class CjsxTagImpl extends CjsxElementImpl {
    public final ASTNode nameIdentifier;

    public CjsxTagImpl(@NotNull ASTNode astNode) {
        super(astNode);
        nameIdentifier = astNode.findChildByType(CoffeeScriptTokenTypes.IDENTIFIER);
    }

    public void accept(@NotNull PsiElementVisitor visitor) {
        if(visitor instanceof ICjsxElementVisitor) {
            ((ICjsxElementVisitor)visitor).visitTagElement(this);
        } else {
            visitor.visitElement(this);
        }
    }
}