package ru.promakh.cjsx;

import com.intellij.openapi.fileTypes.LanguageFileType;
import com.intellij.openapi.util.IconLoader;
//import icons.CoffeescriptIcons;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import javax.swing.*;

public class CjsxFileType extends LanguageFileType{
    public static final Icon Coffeescript_filetype = IconLoader.getIcon("/ru/promakh/cjsx/icons/coffeescript_filetype.png");

    public static final CjsxFileType INSTANCE = new CjsxFileType();

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
        return "cjsx";
    }

    @Nullable
    @Override
    public Icon getIcon() {
        return Coffeescript_filetype;
    }
}
