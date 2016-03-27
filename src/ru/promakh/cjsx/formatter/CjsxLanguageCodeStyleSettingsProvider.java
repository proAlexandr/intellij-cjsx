package ru.promakh.cjsx.formatter;

import com.intellij.lang.Language;
import com.intellij.psi.codeStyle.CommonCodeStyleSettings;
import com.intellij.psi.codeStyle.LanguageCodeStyleSettingsProvider;
import org.jetbrains.annotations.NotNull;
import ru.promakh.cjsx.CjsxLanguage;

public class CjsxLanguageCodeStyleSettingsProvider extends LanguageCodeStyleSettingsProvider {
    private static final String GENERAL_CODE_SAMPLE = "# Assignment:\nnumber = 42\nopposite = true\n\n# Conditions:\nnumber = -42 if opposite\n\n# Functions:\nsquare = (x) ->\n  x * x\n\n\n\n\n# Arrays:\nlist = [1, 2, 3, 4, 5]\n\n\n\n\n# Objects:\nmath =\n  root: Math.sqrt\n  square: square\n  cube: (x) ->\n    x * square x\n\n\n# Splats:\nrace = (winner, runners...) ->\n  print winner, runners\n\n\n# Existence:\nalert \"I knew it!\" if elvis?\n\n\n# Array comprehensions:\ncubes = (math.cube num for num in list)";
    private static final String CJSX_GENERAL_CODE_SAMPLE = "#Cjsx Tag\n<div>\n<span> Hello world </span>\n<img src='./index.jpg'/>\n</div>\n\n" + GENERAL_CODE_SAMPLE;

    @NotNull
    @Override
    public Language getLanguage() {
        return CjsxLanguage.INSTANCE;
    }

    @Override
    public String getCodeSample(@NotNull SettingsType settingsType) {
        return CJSX_GENERAL_CODE_SAMPLE;
    }

    public CommonCodeStyleSettings getDefaultCommonSettings() {
        CommonCodeStyleSettings commonCodeStyleSettings = new CommonCodeStyleSettings(this.getLanguage());
        CommonCodeStyleSettings.IndentOptions indentOptions = commonCodeStyleSettings.initIndentOptions();

        indentOptions.INDENT_SIZE = 2;
        indentOptions.TAB_SIZE = 2;
        indentOptions.CONTINUATION_INDENT_SIZE = 2;
//        commonCodeStyleSettings.ARRAY_INITIALIZER_WRAP = 1;
//        commonCodeStyleSettings.ALIGN_MULTILINE_ARRAY_INITIALIZER_EXPRESSION = true;
//        commonCodeStyleSettings.CATCH_ON_NEW_LINE = true;
//        commonCodeStyleSettings.FINALLY_ON_NEW_LINE = true;
//        commonCodeStyleSettings.ELSE_ON_NEW_LINE = true;
//        commonCodeStyleSettings.CALL_PARAMETERS_WRAP = 1;
//        commonCodeStyleSettings.ALIGN_MULTILINE_PARAMETERS_IN_CALLS = false;
//        commonCodeStyleSettings.CALL_PARAMETERS_LPAREN_ON_NEXT_LINE = false;
//        commonCodeStyleSettings.CALL_PARAMETERS_RPAREN_ON_NEXT_LINE = false;
        return commonCodeStyleSettings;
    }
}
