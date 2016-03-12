package ru.promakh.webstorm_cjsx;

import com.intellij.lang.ASTNode;
import com.intellij.lang.Language;
import com.intellij.lang.ParserDefinition;
import com.intellij.lang.PsiParser;
import com.intellij.lexer.Lexer;
import com.intellij.openapi.project.Project;
import com.intellij.psi.FileViewProvider;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.tree.IFileElementType;
import com.intellij.psi.tree.TokenSet;
import org.coffeescript.lang.lexer.CoffeeScriptTokenSets;
import org.coffeescript.lang.parser.CoffeeScriptParserDefinition;
import org.jetbrains.annotations.NotNull;
import ru.promakh.webstorm_cjsx.lang.CjsxParser;
import ru.promakh.webstorm_cjsx.psi.CjsxFile;

public class CjsxParserDefinition implements ParserDefinition {
//    public static final TokenSet WHITE_SPACES = TokenSet.create(TokenType.WHITE_SPACE);
//    public static final TokenSet COMMENTS = TokenSet.create(CjsxTokenType.COMMENT);


    private CoffeeScriptParserDefinition cpd = new CoffeeScriptParserDefinition();
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
        return cpd.createElement(node);
    }

    @Override
    public PsiFile createFile(FileViewProvider viewProvider) {
        PsiFile  file = new CjsxFile(viewProvider);
        return file;
    }

    @Override
    public SpaceRequirements spaceExistanceTypeBetweenTokens(ASTNode left, ASTNode right) {
        return SpaceRequirements.MAY;
    }
}
