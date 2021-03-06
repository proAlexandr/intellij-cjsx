package ru.promakh.cjsx.psi;

import com.intellij.extapi.psi.PsiFileBase;
import com.intellij.openapi.fileTypes.FileType;
import com.intellij.psi.FileViewProvider;
import org.jetbrains.annotations.NotNull;
import ru.promakh.cjsx.CjsxFileType;
import ru.promakh.cjsx.CjsxLanguage;

public class CjsxFile extends PsiFileBase {
    public CjsxFile(@NotNull FileViewProvider viewProvider) {
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
