package ru.promakh.intellij_cjsx;

import com.intellij.extapi.psi.PsiFileBase;
import com.intellij.openapi.fileTypes.FileType;
import com.intellij.psi.FileViewProvider;
import org.jetbrains.annotations.NotNull;

public class CjsxFile extends PsiFileBase {
    protected CjsxFile(@NotNull FileViewProvider viewProvider) {
        super(viewProvider, CjsxLanguage.INSTANCE);
    }

    @NotNull
    @Override
    public FileType getFileType() {
        return CjsxFileType.INSTANCE;
    }

    @Override
    public String toString() {
        return "CJSX file";
    }
}
