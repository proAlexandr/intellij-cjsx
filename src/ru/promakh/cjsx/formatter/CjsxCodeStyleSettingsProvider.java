package ru.promakh.cjsx.formatter;

import com.intellij.application.options.CodeStyleAbstractConfigurable;
import com.intellij.application.options.CodeStyleAbstractPanel;
import com.intellij.application.options.TabbedLanguageCodeStylePanel;
import com.intellij.openapi.options.Configurable;
import com.intellij.psi.codeStyle.CodeStyleSettings;
import com.intellij.psi.codeStyle.CodeStyleSettingsProvider;
import com.intellij.psi.codeStyle.CustomCodeStyleSettings;
import com.intellij.psi.codeStyle.LanguageCodeStyleSettingsProvider;
import com.sun.istack.internal.NotNull;
import com.sun.istack.internal.Nullable;
import org.coffeescript.formatter.CoffeeScriptCodeStylePanel;
import ru.promakh.cjsx.CjsxLanguage;

public class CjsxCodeStyleSettingsProvider extends CodeStyleSettingsProvider {

    @Override
    public CustomCodeStyleSettings createCustomSettings(CodeStyleSettings settings) {
        return new CjsxCodeStyleSettings(settings);
    }

    @Nullable
    @Override
    public String getConfigurableDisplayName() {
        return "CJSX";
    }

    @NotNull
    @Override
    public Configurable createSettingsPage(CodeStyleSettings settings, CodeStyleSettings originalSettings) {
        return new CodeStyleAbstractConfigurable(settings, originalSettings, "CJSX") {
            @Override
            protected CodeStyleAbstractPanel createPanel(CodeStyleSettings settings) {
                return new CjsxCodeStyleMainPanel(getCurrentSettings(), settings);
            }

            @Nullable
            @Override
            public String getHelpTopic() {
                return null;
            }
        };
    }

    private static class CjsxCodeStyleMainPanel extends TabbedLanguageCodeStylePanel {
        public CjsxCodeStyleMainPanel(CodeStyleSettings currentSettings, CodeStyleSettings settings) {
            super(CjsxLanguage.INSTANCE, currentSettings, settings);
        }

        protected void initTabs(CodeStyleSettings settings) {
            LanguageCodeStyleSettingsProvider provider = LanguageCodeStyleSettingsProvider.forLanguage(this.getDefaultLanguage());
            this.addIndentOptionsTab(settings);
            if(provider != null) {
                this.addSpacesTab(settings);
                this.addWrappingAndBracesTab(settings);
                this.addBlankLinesTab(settings);
                this.addTab(new CoffeeScriptCodeStylePanel(settings));
            }

        }
    }
}