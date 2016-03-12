import com.intellij.lang.*;
import com.intellij.lang.impl.PsiBuilderImpl;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.util.Key;
import com.intellij.psi.impl.file.PsiBinaryFileImpl;
import com.intellij.psi.tree.IElementType;
import com.intellij.psi.tree.TokenSet;
import com.intellij.util.diff.FlyweightCapableTreeStructure;
import org.coffeescript.lang.lexer.CoffeeScriptTokenTypes;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.junit.Test;
import ru.promakh.webstorm_cjsx.lang.CjsxParser;
import ru.promakh.webstorm_cjsx.psi.CjsxElementType;

import java.io.IOException;

public class CjsxParser_Test{

    @Test
    public void test() throws IOException {
//        Language language = CjsxLanguage.INSTANCE;
//        LightVirtualFile virtualFile = new LightVirtualFile(name, language, text);

        PsiBuilder builder = new PsiBuilderFromArray(new IElementType[]{
                CoffeeScriptTokenTypes.IDENTIFIER,
                CoffeeScriptTokenTypes.EQ,
                CoffeeScriptTokenTypes.STRING_LITERAL
        });

        PsiParser parser = new CjsxParser();
        IElementType type = new CjsxElementType("FILE");


        ASTNode tree = parser.parse(type, builder);
    }

    public class PsiBuilderFromArray implements PsiBuilder {

        private IElementType[] tokens;
        private int currentIndex;
        private IElementType currentToken;

        ITokenTypeRemapper tokenTypeRemapper;

        public final RuntimeException FAIL_EXCEPTION = new RuntimeException("fail");

        public PsiBuilderFromArray(IElementType[] elements) {
            this.tokens = elements;
            this.currentIndex = 0;
            this.currentToken = elements[currentIndex];
        }

        @Override
        public Project getProject() {
            throw FAIL_EXCEPTION;
        }

        @Override
        public CharSequence getOriginalText() {
            throw FAIL_EXCEPTION;
        }

        @Override
        public void advanceLexer() {
            currentIndex += 1;
            currentToken = tokens[currentIndex];
        }

        @Nullable
        @Override
        public IElementType getTokenType() {
            return currentToken;
        }

        @Override
        public void setTokenTypeRemapper(@Nullable ITokenTypeRemapper iTokenTypeRemapper) {
            tokenTypeRemapper = iTokenTypeRemapper;
        }

        @Override
        public void remapCurrentToken(IElementType iElementType) {
            throw FAIL_EXCEPTION;
        }

        @Override
        public void setWhitespaceSkippedCallback(@Nullable WhitespaceSkippedCallback whitespaceSkippedCallback) {
        }

        @Nullable
        @Override
        public IElementType lookAhead(int i) {
            return tokens[currentIndex + i];
        }

        @Nullable
        @Override
        public IElementType rawLookup(int i) {
            return tokens[currentIndex + i];
        }

        @Override
        public int rawTokenTypeStart(int i) {
            throw FAIL_EXCEPTION;
        }

        @Override
        public int rawTokenIndex() {
            return currentIndex;
        }

        @Nullable
        @Override
        public String getTokenText() {
            return "token_text";
        }

        @Override
        public int getCurrentOffset() {
            return currentIndex;
        }

        @NotNull
        @Override
        public Marker mark() {
            return null;
        }

        @Override
        public void error(String s) {

        }

        @Override
        public boolean eof() {
            return currentIndex == tokens.length;
        }

        @NotNull
        @Override
        public ASTNode getTreeBuilt() {
            return null;
        }

        @NotNull
        @Override
        public FlyweightCapableTreeStructure<LighterASTNode> getLightTree() {
            return null;
        }

        @Override
        public void setDebugMode(boolean b) {

        }

        @Override
        public void enforceCommentTokens(@NotNull TokenSet tokenSet) {

        }

        @Nullable
        @Override
        public LighterASTNode getLatestDoneMarker() {
            return null;
        }

        @Nullable
        @Override
        public <T> T getUserData(@NotNull Key<T> key) {
            return null;
        }

        @Override
        public <T> void putUserData(@NotNull Key<T> key, @Nullable T t) {

        }

        @Nullable
        @Override
        public <T> T getUserDataUnprotected(@NotNull Key<T> key) {
            return null;
        }

        @Override
        public <T> void putUserDataUnprotected(@NotNull Key<T> key, @Nullable T t) {

        }
    }

}
