package ru.promakh.cjsx.editor;

import com.intellij.lang.Commenter;
import com.intellij.lang.Language;
import com.intellij.openapi.editor.Editor;
import com.intellij.psi.FileViewProvider;
import com.intellij.psi.PsiFile;
import com.intellij.psi.templateLanguages.MultipleLangCommentProvider;
import org.jetbrains.annotations.Nullable;
import ru.promakh.cjsx.CjsxLanguage;

public class CjsxCommentProvider implements MultipleLangCommentProvider {
    @Nullable
    public Commenter getLineCommenter(PsiFile file, Editor editor, Language lineStartLanguage, Language lineEndLanguage) {
        return new CjsxCommenter();
    }

    public boolean canProcess(PsiFile file, FileViewProvider viewProvider) {
        return viewProvider.getLanguages().contains(CjsxLanguage.INSTANCE);
    }
}
