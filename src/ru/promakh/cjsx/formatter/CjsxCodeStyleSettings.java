package ru.promakh.cjsx.formatter;

import com.intellij.psi.codeStyle.CodeStyleSettings;
import com.intellij.psi.codeStyle.CustomCodeStyleSettings;

public class CjsxCodeStyleSettings extends CustomCodeStyleSettings {
    public CjsxCodeStyleSettings(CodeStyleSettings settings) {
        super("CjsxCodeStyleSettings", settings);
    }
}