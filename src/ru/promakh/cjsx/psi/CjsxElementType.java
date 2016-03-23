package ru.promakh.cjsx.psi;

import com.intellij.psi.tree.IElementType;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;
import ru.promakh.cjsx.CjsxLanguage;

public class CjsxElementType extends IElementType {
    public static final IElementType TAG_CONTAINER = new CjsxElementType("TagContainer");
    public static final IElementType TAG_SINGLE = new CjsxElementType("TagSingle");
    public static final IElementType TAG_OPEN = new CjsxElementType("TagOpen");
    public static final IElementType TAG_BODY = new CjsxElementType("TagBody");
    public static final IElementType TAG_CLOSE = new CjsxElementType("TagClose");
    public static final IElementType ATTRIBUTES = new CjsxElementType("Attributes");
    public static final IElementType ATTRIBUTE = new CjsxElementType("Attribute");
    public static final IElementType TAG_INTERPOLATION = new CjsxElementType("TagInterpolation");
    public static final IElementType TAG_TEXT = new CjsxElementType("TagText");

    public CjsxElementType(@NotNull @NonNls String debugName) {
        super(debugName, CjsxLanguage.INSTANCE);
    }
}
