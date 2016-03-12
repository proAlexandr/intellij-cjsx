package ru.promakh.webstorm_cjsx.psi;

import com.intellij.psi.tree.IElementType;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;
import ru.promakh.webstorm_cjsx.CjsxLanguage;

public class CjsxTokenType extends IElementType {
    static public final IElementType COMMENT = new CjsxTokenType("COMMENT");
    static public final IElementType DIV_GT = new CjsxTokenType("DIV_GT");
    static public final IElementType LT_DIV = new CjsxTokenType("LT_DIV");

    public CjsxTokenType(@NotNull @NonNls String debugName) {
        super(debugName, CjsxLanguage.INSTANCE);
    }

    @Override
    public String toString() {
        return "CJSX:" + super.toString();
    }
}
