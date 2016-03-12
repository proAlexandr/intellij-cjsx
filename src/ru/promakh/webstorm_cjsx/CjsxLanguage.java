package ru.promakh.webstorm_cjsx;

import com.intellij.lang.Language;

public class CjsxLanguage extends Language {

    public static final CjsxLanguage INSTANCE = new CjsxLanguage();

    private CjsxLanguage() {
        super("CJSX");
    }
}
