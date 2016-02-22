package ru.promakh.intellij_cjsx.psi;

import com.intellij.lang.Language;
import com.intellij.psi.tree.IElementType;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;
import ru.promakh.intellij_cjsx.CjsxLanguage;

public class CjsxTokenType extends IElementType {
    static public IElementType COMMENT = new CjsxElementType("COMMENT");

    public CjsxTokenType(@NotNull @NonNls String debugName) {
        super(debugName, CjsxLanguage.INSTANCE);
    }

    @Override
    public String toString() {
        return "CJSXTokenType." + super.toString();
    }
}
