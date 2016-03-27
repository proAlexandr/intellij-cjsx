package ru.promakh.cjsx.editor;

import org.coffeescript.editor.CoffeeScriptCommenter;

public class CjsxCommenter extends CoffeeScriptCommenter {
    public String getLineCommentPrefix() {
        return "#";
    }
}
