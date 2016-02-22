package ru.promakh.intellij_cjsx;

import com.intellij.openapi.fileTypes.LanguageFileType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import javax.swing.*;

public class CjsxFileType extends LanguageFileType{
    public static CjsxFileType INSTANCE = new CjsxFileType();

    private CjsxFileType() {
        super(CjsxLanguage.INSTANCE);
    }

    @NotNull
    @Override
    public String getName() {
        return "CJSX";
    }

    @NotNull
    @Override
    public String getDescription() {
        return "Coffescript JSX File";
    }

    @NotNull
    @Override
    public String getDefaultExtension() {
        return "csjx";
    }

    @Nullable
    @Override
    public Icon getIcon() {
        return CjsxIcons.ICON;
    }
}
