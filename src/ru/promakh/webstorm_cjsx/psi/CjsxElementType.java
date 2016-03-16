package ru.promakh.webstorm_cjsx.psi;

import com.intellij.psi.tree.IElementType;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;
import ru.promakh.webstorm_cjsx.CjsxLanguage;

public class CjsxElementType extends IElementType {
    static public final IElementType TAG_CONTAINER = new CjsxElementType("TagContainer");
    static public final IElementType TAG_SINGLE = new CjsxElementType("TagSingle");
    static public final IElementType TAG_OPEN = new CjsxElementType("TagOpen");
    static public final IElementType TAG_BODY = new CjsxElementType("TagBody");
    static public final IElementType TAG_CLOSE = new CjsxElementType("TagClose");
    static public final IElementType ATTRIBUTES = new CjsxElementType("Attributes");
    static public final IElementType ATTRIBUTE = new CjsxElementType("Attribute");
    static public final IElementType TAG_INTERPOLATION = new CjsxElementType("TagInterpolation");

    public CjsxElementType(@NotNull @NonNls String debugName) {
        super(debugName, CjsxLanguage.INSTANCE);
    }
}
