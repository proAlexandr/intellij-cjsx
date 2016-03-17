package ru.promakh.cjsx;

import com.intellij.lang.ASTNode;
import com.intellij.lang.Language;
import com.intellij.lang.ParserDefinition;
import com.intellij.lang.PsiParser;
import com.intellij.lexer.Lexer;
import com.intellij.openapi.project.Project;
import com.intellij.psi.FileViewProvider;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.tree.IElementType;
import com.intellij.psi.tree.IFileElementType;
import com.intellij.psi.tree.TokenSet;
import org.coffeescript.lang.lexer.CoffeeScriptTokenSets;
import org.jetbrains.annotations.NotNull;
import ru.promakh.cjsx.lang.CjsxParser;
import ru.promakh.cjsx.psi.CjsxElementType;
import ru.promakh.cjsx.psi.CjsxFile;
import ru.promakh.cjsx.psi.impl.CjsxElementImpl;
import ru.promakh.cjsx.psi.impl.CjsxTagCloseImpl;
import ru.promakh.cjsx.psi.impl.CjsxTagOpenImpl;
import ru.promakh.cjsx.psi.impl.CjsxTagSingleImpl;

public class CjsxParserDefinition implements ParserDefinition {
    public static final IFileElementType FILE;

    static {
        Language languageInstance = Language.findInstance(CjsxLanguage.class);
        FILE = new IFileElementType(languageInstance);
    }

    @NotNull
    @Override
    public Lexer createLexer(Project project) {
        return new CjsxLexerAdapter();
    }

    @Override
    public PsiParser createParser(Project project) {
        return new CjsxParser();
    }

    @Override
    public IFileElementType getFileNodeType() {
        return FILE;
    }

    @NotNull
    @Override
    public TokenSet getWhitespaceTokens() {
        return CoffeeScriptTokenSets.WHITESPACE_TOKEN_SET;
    }

    @NotNull
    @Override
    public TokenSet getCommentTokens() {
        return CoffeeScriptTokenSets.COMMENTS_TOKEN_SET;
    }

    @NotNull
    @Override
    public TokenSet getStringLiteralElements() {
        return CoffeeScriptTokenSets.STRING_TOKEN_SET;
    }


    @NotNull
    @Override
    public PsiElement createElement(ASTNode node) {
        IElementType nodeType = node.getElementType();
        if (nodeType == CjsxElementType.TAG_OPEN) {
            return new CjsxTagOpenImpl(node);
        } else if (nodeType == CjsxElementType.TAG_CLOSE) {
            return new CjsxTagCloseImpl(node);
        } else if (nodeType == CjsxElementType.TAG_SINGLE) {
            return new CjsxTagSingleImpl(node);
        } else {
            return new CjsxElementImpl(node);
        }
    }

    @Override
    public PsiFile createFile(FileViewProvider viewProvider) {
        return new CjsxFile(viewProvider);
    }

    @Override
    public SpaceRequirements spaceExistanceTypeBetweenTokens(ASTNode left, ASTNode right) {
        return SpaceRequirements.MAY;
    }
}
