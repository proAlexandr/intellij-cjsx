package ru.promakh.intellij_cjsx.psi;

import com.intellij.psi.tree.IElementType;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;
import ru.promakh.intellij_cjsx.CjsxLanguage;

public class CjsxElementType extends IElementType {
    public CjsxElementType(@NotNull @NonNls String debugName) {
        super(debugName, CjsxLanguage.INSTANCE);
    }
}
