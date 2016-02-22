// This is a generated file. Not intended for manual editing.
package ru.promakh.intellij_cjsx.psi;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import ru.promakh.intellij_cjsx.psi.impl.*;

public interface CjsxTypes {

  IElementType ACCESSOR = new CjsxElementType("ACCESSOR");
  IElementType ALPHA_NUMERIC = new CjsxElementType("ALPHA_NUMERIC");
  IElementType ARG = new CjsxElementType("ARG");
  IElementType ARGUMENTS = new CjsxElementType("ARGUMENTS");
  IElementType ARG_LIST = new CjsxElementType("ARG_LIST");
  IElementType ARRAY = new CjsxElementType("ARRAY");
  IElementType ASSIGN = new CjsxElementType("ASSIGN");
  IElementType ASSIGNABLE = new CjsxElementType("ASSIGNABLE");
  IElementType ASSIGN_LIST = new CjsxElementType("ASSIGN_LIST");
  IElementType ASSIGN_OBJ = new CjsxElementType("ASSIGN_OBJ");
  IElementType BLOCK = new CjsxElementType("BLOCK");
  IElementType BODY = new CjsxElementType("BODY");
  IElementType CATCH = new CjsxElementType("CATCH");
  IElementType CLASS_DECLARATION = new CjsxElementType("CLASS_DECLARATION");
  IElementType CODE = new CjsxElementType("CODE");
  IElementType COMMENT = new CjsxElementType("COMMENT");
  IElementType EXPRESSION = new CjsxElementType("EXPRESSION");
  IElementType FOR = new CjsxElementType("FOR");
  IElementType FOR_BODY = new CjsxElementType("FOR_BODY");
  IElementType FOR_SOURCE = new CjsxElementType("FOR_SOURCE");
  IElementType FOR_START = new CjsxElementType("FOR_START");
  IElementType FOR_VALUE = new CjsxElementType("FOR_VALUE");
  IElementType FOR_VARIABLES = new CjsxElementType("FOR_VARIABLES");
  IElementType FUNC_GLYPH = new CjsxElementType("FUNC_GLYPH");
  IElementType IDENTIFIER = new CjsxElementType("IDENTIFIER");
  IElementType IF = new CjsxElementType("IF");
  IElementType IF_BLOCK = new CjsxElementType("IF_BLOCK");
  IElementType INDEX = new CjsxElementType("INDEX");
  IElementType INDEX_VALUE = new CjsxElementType("INDEX_VALUE");
  IElementType INVOCATION = new CjsxElementType("INVOCATION");
  IElementType LINE = new CjsxElementType("LINE");
  IElementType LITERAL = new CjsxElementType("LITERAL");
  IElementType LOOP = new CjsxElementType("LOOP");
  IElementType OBJECT = new CjsxElementType("OBJECT");
  IElementType OBJ_ASSIGNABLE = new CjsxElementType("OBJ_ASSIGNABLE");
  IElementType OPERATION = new CjsxElementType("OPERATION");
  IElementType OPT_COMMA = new CjsxElementType("OPT_COMMA");
  IElementType OPT_FUNC_EXIST = new CjsxElementType("OPT_FUNC_EXIST");
  IElementType PARAM = new CjsxElementType("PARAM");
  IElementType PARAM_LIST = new CjsxElementType("PARAM_LIST");
  IElementType PARAM_VAR = new CjsxElementType("PARAM_VAR");
  IElementType PARENTHETICAL = new CjsxElementType("PARENTHETICAL");
  IElementType RANGE = new CjsxElementType("RANGE");
  IElementType RANGE_DOTS = new CjsxElementType("RANGE_DOTS");
  IElementType REGEX = new CjsxElementType("REGEX");
  IElementType RETURN = new CjsxElementType("RETURN");
  IElementType SIMPLE_ARGS = new CjsxElementType("SIMPLE_ARGS");
  IElementType SIMPLE_ASSIGNABLE = new CjsxElementType("SIMPLE_ASSIGNABLE");
  IElementType SIMPLE_OBJECT_ASSIGNABLE = new CjsxElementType("SIMPLE_OBJECT_ASSIGNABLE");
  IElementType SLICE = new CjsxElementType("SLICE");
  IElementType SPLAT = new CjsxElementType("SPLAT");
  IElementType STATEMENT = new CjsxElementType("STATEMENT");
  IElementType STRING = new CjsxElementType("STRING");
  IElementType SWITCH = new CjsxElementType("SWITCH");
  IElementType THIS = new CjsxElementType("THIS");
  IElementType THIS_PROPERTY = new CjsxElementType("THIS_PROPERTY");
  IElementType THROW = new CjsxElementType("THROW");
  IElementType TRY = new CjsxElementType("TRY");
  IElementType VALUE = new CjsxElementType("VALUE");
  IElementType WHEN = new CjsxElementType("WHEN");
  IElementType WHENS = new CjsxElementType("WHENS");
  IElementType WHILE = new CjsxElementType("WHILE");
  IElementType WHILE_SOURCE = new CjsxElementType("WHILE_SOURCE");

  IElementType BOOL = new CjsxTokenType("BOOL");
  IElementType BY = new CjsxTokenType("by");
  IElementType CALL_END = new CjsxTokenType("CALL_END");
  IElementType CALL_START = new CjsxTokenType("CALL_START");
  IElementType CATCH_T = new CjsxTokenType("catch");
  IElementType CLASS_T = new CjsxTokenType("class");
  IElementType COMPARE = new CjsxTokenType("COMPARE");
  IElementType COMPOUND_ASSIGN = new CjsxTokenType("COMPOUND_ASSIGN");
  IElementType DEBUGGER = new CjsxTokenType("DEBUGGER");
  IElementType ELSE = new CjsxTokenType("else");
  IElementType EXTENDS = new CjsxTokenType("extends");
  IElementType FINALLY = new CjsxTokenType("FINALLY");
  IElementType FORIN = new CjsxTokenType("in");
  IElementType FOROF = new CjsxTokenType("of");
  IElementType FOR_T = new CjsxTokenType("for");
  IElementType FROM = new CjsxTokenType("from");
  IElementType FUNC_EXIST = new CjsxTokenType("?");
  IElementType HERECOMMENT = new CjsxTokenType("HERECOMMENT");
  IElementType IDENTIFIER_T = new CjsxTokenType("\\w+");
  IElementType IF_T = new CjsxTokenType("IF_T");
  IElementType INDENT = new CjsxTokenType("INDENT");
  IElementType INDEX_END = new CjsxTokenType("INDEX_END");
  IElementType INDEX_SOAK = new CjsxTokenType("INDEX_SOAK");
  IElementType INDEX_START = new CjsxTokenType("INDEX_START");
  IElementType JS = new CjsxTokenType("JS");
  IElementType LEADING_WHEN = new CjsxTokenType("LEADING_WHEN");
  IElementType LOGIC = new CjsxTokenType("LOGIC");
  IElementType LOOP_T = new CjsxTokenType("loop");
  IElementType MATH = new CjsxTokenType("MATH");
  IElementType NULL = new CjsxTokenType("null");
  IElementType NUMBER = new CjsxTokenType("\\d+(\\.\\d+)*");
  IElementType OUTDENT = new CjsxTokenType("OUTDENT");
  IElementType OWN = new CjsxTokenType("own");
  IElementType PARAM_END = new CjsxTokenType(")");
  IElementType PARAM_START = new CjsxTokenType("(");
  IElementType POST_IF = new CjsxTokenType("POST_IF");
  IElementType REGEX_END = new CjsxTokenType("///");
  IElementType REGEX_START = new CjsxTokenType("REGEX_START");
  IElementType REGEX_T = new CjsxTokenType("//");
  IElementType RELATION = new CjsxTokenType("RELATION");
  IElementType RETURN_T = new CjsxTokenType("return");
  IElementType SHIFT = new CjsxTokenType("SHIFT");
  IElementType STATEMENT_T = new CjsxTokenType("STATEMENT_T");
  IElementType STRING_END = new CjsxTokenType("\"\"\"");
  IElementType STRING_START = new CjsxTokenType("STRING_START");
  IElementType STRING_T = new CjsxTokenType("\"([^\"]|\\\")*\"");
  IElementType SUPER = new CjsxTokenType("super");
  IElementType SWITCH_T = new CjsxTokenType("switch");
  IElementType TERMINATOR = new CjsxTokenType("TERMINATOR");
  IElementType THIS_T = new CjsxTokenType("this");
  IElementType THROW_T = new CjsxTokenType("throw");
  IElementType TRY_T = new CjsxTokenType("try");
  IElementType UNARY = new CjsxTokenType("UNARY");
  IElementType UNARY_MATH = new CjsxTokenType("UNARY_MATH");
  IElementType UNDEFINED = new CjsxTokenType("undefined");
  IElementType UNTIL = new CjsxTokenType("until");
  IElementType WHEN_T = new CjsxTokenType("when");
  IElementType WHILE_T = new CjsxTokenType("while");
  IElementType YIELD = new CjsxTokenType("yield");

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
       if (type == ACCESSOR) {
        return new CjsxAccessorImpl(node);
      }
      else if (type == ALPHA_NUMERIC) {
        return new CjsxAlphaNumericImpl(node);
      }
      else if (type == ARG) {
        return new CjsxArgImpl(node);
      }
      else if (type == ARGUMENTS) {
        return new CjsxArgumentsImpl(node);
      }
      else if (type == ARG_LIST) {
        return new CjsxArgListImpl(node);
      }
      else if (type == ARRAY) {
        return new CjsxArrayImpl(node);
      }
      else if (type == ASSIGN) {
        return new CjsxAssignImpl(node);
      }
      else if (type == ASSIGNABLE) {
        return new CjsxAssignableImpl(node);
      }
      else if (type == ASSIGN_LIST) {
        return new CjsxAssignListImpl(node);
      }
      else if (type == ASSIGN_OBJ) {
        return new CjsxAssignObjImpl(node);
      }
      else if (type == BLOCK) {
        return new CjsxBlockImpl(node);
      }
      else if (type == BODY) {
        return new CjsxBodyImpl(node);
      }
      else if (type == CATCH) {
        return new CjsxCatchImpl(node);
      }
      else if (type == CLASS_DECLARATION) {
        return new CjsxClassDeclarationImpl(node);
      }
      else if (type == CODE) {
        return new CjsxCodeImpl(node);
      }
      else if (type == COMMENT) {
        return new CjsxCommentImpl(node);
      }
      else if (type == EXPRESSION) {
        return new CjsxExpressionImpl(node);
      }
      else if (type == FOR) {
        return new CjsxForImpl(node);
      }
      else if (type == FOR_BODY) {
        return new CjsxForBodyImpl(node);
      }
      else if (type == FOR_SOURCE) {
        return new CjsxForSourceImpl(node);
      }
      else if (type == FOR_START) {
        return new CjsxForStartImpl(node);
      }
      else if (type == FOR_VALUE) {
        return new CjsxForValueImpl(node);
      }
      else if (type == FOR_VARIABLES) {
        return new CjsxForVariablesImpl(node);
      }
      else if (type == FUNC_GLYPH) {
        return new CjsxFuncGlyphImpl(node);
      }
      else if (type == IDENTIFIER) {
        return new CjsxIdentifierImpl(node);
      }
      else if (type == IF) {
        return new CjsxIfImpl(node);
      }
      else if (type == IF_BLOCK) {
        return new CjsxIfBlockImpl(node);
      }
      else if (type == INDEX) {
        return new CjsxIndexImpl(node);
      }
      else if (type == INDEX_VALUE) {
        return new CjsxIndexValueImpl(node);
      }
      else if (type == INVOCATION) {
        return new CjsxInvocationImpl(node);
      }
      else if (type == LINE) {
        return new CjsxLineImpl(node);
      }
      else if (type == LITERAL) {
        return new CjsxLiteralImpl(node);
      }
      else if (type == LOOP) {
        return new CjsxLoopImpl(node);
      }
      else if (type == OBJECT) {
        return new CjsxObjectImpl(node);
      }
      else if (type == OBJ_ASSIGNABLE) {
        return new CjsxObjAssignableImpl(node);
      }
      else if (type == OPERATION) {
        return new CjsxOperationImpl(node);
      }
      else if (type == OPT_COMMA) {
        return new CjsxOptCommaImpl(node);
      }
      else if (type == OPT_FUNC_EXIST) {
        return new CjsxOptFuncExistImpl(node);
      }
      else if (type == PARAM) {
        return new CjsxParamImpl(node);
      }
      else if (type == PARAM_LIST) {
        return new CjsxParamListImpl(node);
      }
      else if (type == PARAM_VAR) {
        return new CjsxParamVarImpl(node);
      }
      else if (type == PARENTHETICAL) {
        return new CjsxParentheticalImpl(node);
      }
      else if (type == RANGE) {
        return new CjsxRangeImpl(node);
      }
      else if (type == RANGE_DOTS) {
        return new CjsxRangeDotsImpl(node);
      }
      else if (type == REGEX) {
        return new CjsxRegexImpl(node);
      }
      else if (type == RETURN) {
        return new CjsxReturnImpl(node);
      }
      else if (type == SIMPLE_ARGS) {
        return new CjsxSimpleArgsImpl(node);
      }
      else if (type == SIMPLE_ASSIGNABLE) {
        return new CjsxSimpleAssignableImpl(node);
      }
      else if (type == SIMPLE_OBJECT_ASSIGNABLE) {
        return new CjsxSimpleObjectAssignableImpl(node);
      }
      else if (type == SLICE) {
        return new CjsxSliceImpl(node);
      }
      else if (type == SPLAT) {
        return new CjsxSplatImpl(node);
      }
      else if (type == STATEMENT) {
        return new CjsxStatementImpl(node);
      }
      else if (type == STRING) {
        return new CjsxStringImpl(node);
      }
      else if (type == SWITCH) {
        return new CjsxSwitchImpl(node);
      }
      else if (type == THIS) {
        return new CjsxThisImpl(node);
      }
      else if (type == THIS_PROPERTY) {
        return new CjsxThisPropertyImpl(node);
      }
      else if (type == THROW) {
        return new CjsxThrowImpl(node);
      }
      else if (type == TRY) {
        return new CjsxTryImpl(node);
      }
      else if (type == VALUE) {
        return new CjsxValueImpl(node);
      }
      else if (type == WHEN) {
        return new CjsxWhenImpl(node);
      }
      else if (type == WHENS) {
        return new CjsxWhensImpl(node);
      }
      else if (type == WHILE) {
        return new CjsxWhileImpl(node);
      }
      else if (type == WHILE_SOURCE) {
        return new CjsxWhileSourceImpl(node);
      }
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}
