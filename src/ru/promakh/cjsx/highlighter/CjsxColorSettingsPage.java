package ru.promakh.cjsx.highlighter;

import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.fileTypes.SyntaxHighlighter;
import com.intellij.openapi.options.colors.AttributesDescriptor;
import com.intellij.openapi.options.colors.ColorDescriptor;
import com.intellij.openapi.options.colors.ColorSettingsPage;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.promakh.cjsx.CjsxFileType;

import javax.swing.*;
import java.util.Map;

public class CjsxColorSettingsPage implements ColorSettingsPage {
    private static final AttributesDescriptor[] DESCRIPTORS = new AttributesDescriptor[]{
            new AttributesDescriptor("Tag name", CjsxSyntaxHighlighter.TAG_NAME),
            new AttributesDescriptor("Attribute name", CjsxSyntaxHighlighter.ATTRIBUTE_NAME),
    };

    @Nullable
    @Override
    public Icon getIcon() {
        return CjsxFileType.CoffeescriptFiletypeIcon;
    }

    @NotNull
    @Override
    public SyntaxHighlighter getHighlighter() {
        return new CjsxSyntaxHighlighter();
    }

    @NotNull
    @Override
    public String getDemoText() {
        return "config = \n" +
                "  value: \"sample-value\"\n" +
                "\n" +
                "<Component attr=\"val\" value=config.value >\n" +
                "    <div value=\"string\">\n" +
                "    </div>\n" +
                "    {\n" +
                "        if config.key1\n" +
                "            <input value=\"123\"/>\n" +
                "    }\n" +
                "</Component>";
    }

    @Nullable
    @Override
    public Map<String, TextAttributesKey> getAdditionalHighlightingTagToDescriptorMap() {
        return null;
    }

    @NotNull
    @Override
    public AttributesDescriptor[] getAttributeDescriptors() {
        return DESCRIPTORS;
    }

    @NotNull
    @Override
    public ColorDescriptor[] getColorDescriptors() {
        return ColorDescriptor.EMPTY_ARRAY;
    }

    @NotNull
    @Override
    public String getDisplayName() {
        return "CJSX";
    }
}
