package ru.promakh.cjsx.psi;

import ru.promakh.cjsx.psi.impl.CjsxTagImpl;

public interface ICjsxElementVisitor {
    void visitTagElement(CjsxTagImpl element);
}
