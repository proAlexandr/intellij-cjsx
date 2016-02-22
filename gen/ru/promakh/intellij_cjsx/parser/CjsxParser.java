// This is a generated file. Not intended for manual editing.
package ru.promakh.intellij_cjsx.parser;

import com.intellij.lang.PsiBuilder;
import com.intellij.lang.PsiBuilder.Marker;
import static ru.promakh.intellij_cjsx.psi.CjsxTypes.*;
import static com.intellij.lang.parser.GeneratedParserUtilBase.*;
import com.intellij.psi.tree.IElementType;
import com.intellij.lang.ASTNode;
import com.intellij.psi.tree.TokenSet;
import com.intellij.lang.PsiParser;
import com.intellij.lang.LightPsiParser;

@SuppressWarnings({"SimplifiableIfStatement", "UnusedAssignment"})
public class CjsxParser implements PsiParser, LightPsiParser {

  public ASTNode parse(IElementType t, PsiBuilder b) {
    parseLight(t, b);
    return b.getTreeBuilt();
  }

  public void parseLight(IElementType t, PsiBuilder b) {
    boolean r;
    b = adapt_builder_(t, b, this, null);
    Marker m = enter_section_(b, 0, _COLLAPSE_, null);
    if (t == ACCESSOR) {
      r = Accessor(b, 0);
    }
    else if (t == ALPHA_NUMERIC) {
      r = AlphaNumeric(b, 0);
    }
    else if (t == ARG) {
      r = Arg(b, 0);
    }
    else if (t == ARG_LIST) {
      r = ArgList(b, 0);
    }
    else if (t == ARGUMENTS) {
      r = Arguments(b, 0);
    }
    else if (t == ARRAY) {
      r = Array(b, 0);
    }
    else if (t == ASSIGN) {
      r = Assign(b, 0);
    }
    else if (t == ASSIGN_LIST) {
      r = AssignList(b, 0);
    }
    else if (t == ASSIGN_OBJ) {
      r = AssignObj(b, 0);
    }
    else if (t == ASSIGNABLE) {
      r = Assignable(b, 0);
    }
    else if (t == BLOCK) {
      r = Block(b, 0);
    }
    else if (t == BODY) {
      r = Body(b, 0);
    }
    else if (t == CATCH) {
      r = Catch(b, 0);
    }
    else if (t == CLASS_DECLARATION) {
      r = ClassDeclaration(b, 0);
    }
    else if (t == CODE) {
      r = Code(b, 0);
    }
    else if (t == COMMENT) {
      r = Comment(b, 0);
    }
    else if (t == EXPRESSION) {
      r = Expression(b, 0);
    }
    else if (t == FOR) {
      r = For(b, 0);
    }
    else if (t == FOR_BODY) {
      r = ForBody(b, 0);
    }
    else if (t == FOR_SOURCE) {
      r = ForSource(b, 0);
    }
    else if (t == FOR_START) {
      r = ForStart(b, 0);
    }
    else if (t == FOR_VALUE) {
      r = ForValue(b, 0);
    }
    else if (t == FOR_VARIABLES) {
      r = ForVariables(b, 0);
    }
    else if (t == FUNC_GLYPH) {
      r = FuncGlyph(b, 0);
    }
    else if (t == IDENTIFIER) {
      r = Identifier(b, 0);
    }
    else if (t == IF) {
      r = If(b, 0);
    }
    else if (t == IF_BLOCK) {
      r = IfBlock(b, 0);
    }
    else if (t == INDEX) {
      r = Index(b, 0);
    }
    else if (t == INDEX_VALUE) {
      r = IndexValue(b, 0);
    }
    else if (t == INVOCATION) {
      r = Invocation(b, 0);
    }
    else if (t == LINE) {
      r = Line(b, 0);
    }
    else if (t == LITERAL) {
      r = Literal(b, 0);
    }
    else if (t == LOOP) {
      r = Loop(b, 0);
    }
    else if (t == OBJ_ASSIGNABLE) {
      r = ObjAssignable(b, 0);
    }
    else if (t == OBJECT) {
      r = Object(b, 0);
    }
    else if (t == OPERATION) {
      r = Operation(b, 0);
    }
    else if (t == OPT_COMMA) {
      r = OptComma(b, 0);
    }
    else if (t == OPT_FUNC_EXIST) {
      r = OptFuncExist(b, 0);
    }
    else if (t == PARAM) {
      r = Param(b, 0);
    }
    else if (t == PARAM_LIST) {
      r = ParamList(b, 0);
    }
    else if (t == PARAM_VAR) {
      r = ParamVar(b, 0);
    }
    else if (t == PARENTHETICAL) {
      r = Parenthetical(b, 0);
    }
    else if (t == RANGE) {
      r = Range(b, 0);
    }
    else if (t == RANGE_DOTS) {
      r = RangeDots(b, 0);
    }
    else if (t == REGEX) {
      r = Regex(b, 0);
    }
    else if (t == RETURN) {
      r = Return(b, 0);
    }
    else if (t == SIMPLE_ARGS) {
      r = SimpleArgs(b, 0);
    }
    else if (t == SIMPLE_ASSIGNABLE) {
      r = SimpleAssignable(b, 0);
    }
    else if (t == SIMPLE_OBJECT_ASSIGNABLE) {
      r = SimpleObjectAssignable(b, 0);
    }
    else if (t == SLICE) {
      r = Slice(b, 0);
    }
    else if (t == SPLAT) {
      r = Splat(b, 0);
    }
    else if (t == STATEMENT) {
      r = Statement(b, 0);
    }
    else if (t == STRING) {
      r = String(b, 0);
    }
    else if (t == SWITCH) {
      r = Switch(b, 0);
    }
    else if (t == THIS) {
      r = This(b, 0);
    }
    else if (t == THIS_PROPERTY) {
      r = ThisProperty(b, 0);
    }
    else if (t == THROW) {
      r = Throw(b, 0);
    }
    else if (t == TRY) {
      r = Try(b, 0);
    }
    else if (t == VALUE) {
      r = Value(b, 0);
    }
    else if (t == WHEN) {
      r = When(b, 0);
    }
    else if (t == WHENS) {
      r = Whens(b, 0);
    }
    else if (t == WHILE) {
      r = While(b, 0);
    }
    else if (t == WHILE_SOURCE) {
      r = WhileSource(b, 0);
    }
    else {
      r = parse_root_(t, b, 0);
    }
    exit_section_(b, 0, m, t, r, true, TRUE_CONDITION);
  }

  protected boolean parse_root_(IElementType t, PsiBuilder b, int l) {
    return Root(b, l + 1);
  }

  /* ********************************************************** */
  // '.' Identifier
  //            | '?.' Identifier
  //            | '::' Identifier
  //            | '?::' Identifier
  //            | '::'
  //            | Index
  public static boolean Accessor(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Accessor")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, "<accessor>");
    r = Accessor_0(b, l + 1);
    if (!r) r = Accessor_1(b, l + 1);
    if (!r) r = Accessor_2(b, l + 1);
    if (!r) r = Accessor_3(b, l + 1);
    if (!r) r = consumeToken(b, "::");
    if (!r) r = Index(b, l + 1);
    exit_section_(b, l, m, ACCESSOR, r, false, null);
    return r;
  }

  // '.' Identifier
  private static boolean Accessor_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Accessor_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ".");
    r = r && Identifier(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // '?.' Identifier
  private static boolean Accessor_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Accessor_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "?.");
    r = r && Identifier(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // '::' Identifier
  private static boolean Accessor_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Accessor_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "::");
    r = r && Identifier(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // '?::' Identifier
  private static boolean Accessor_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Accessor_3")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "?::");
    r = r && Identifier(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // NUMBER | String
  public static boolean AlphaNumeric(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "AlphaNumeric")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, "<alpha numeric>");
    r = consumeToken(b, NUMBER);
    if (!r) r = String(b, l + 1);
    exit_section_(b, l, m, ALPHA_NUMERIC, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // Expression
  //            | Splat
  //            | '...'
  public static boolean Arg(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Arg")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, "<arg>");
    r = Expression(b, l + 1);
    if (!r) r = Splat(b, l + 1);
    if (!r) r = consumeToken(b, "...");
    exit_section_(b, l, m, ARG, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // Arg
  //            | ArgList ',' Arg
  //            | ArgList OptComma TERMINATOR Arg
  //            | INDENT ArgList OptComma OUTDENT
  //            | ArgList OptComma INDENT ArgList OptComma OUTDENT
  public static boolean ArgList(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ArgList")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, "<arg list>");
    r = Arg(b, l + 1);
    if (!r) r = ArgList_1(b, l + 1);
    if (!r) r = ArgList_2(b, l + 1);
    if (!r) r = ArgList_3(b, l + 1);
    if (!r) r = ArgList_4(b, l + 1);
    exit_section_(b, l, m, ARG_LIST, r, false, null);
    return r;
  }

  // ArgList ',' Arg
  private static boolean ArgList_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ArgList_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = ArgList(b, l + 1);
    r = r && consumeToken(b, ",");
    r = r && Arg(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // ArgList OptComma TERMINATOR Arg
  private static boolean ArgList_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ArgList_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = ArgList(b, l + 1);
    r = r && OptComma(b, l + 1);
    r = r && consumeToken(b, TERMINATOR);
    r = r && Arg(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // INDENT ArgList OptComma OUTDENT
  private static boolean ArgList_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ArgList_3")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, INDENT);
    r = r && ArgList(b, l + 1);
    r = r && OptComma(b, l + 1);
    r = r && consumeToken(b, OUTDENT);
    exit_section_(b, m, null, r);
    return r;
  }

  // ArgList OptComma INDENT ArgList OptComma OUTDENT
  private static boolean ArgList_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ArgList_4")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = ArgList(b, l + 1);
    r = r && OptComma(b, l + 1);
    r = r && consumeToken(b, INDENT);
    r = r && ArgList(b, l + 1);
    r = r && OptComma(b, l + 1);
    r = r && consumeToken(b, OUTDENT);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // CALL_START CALL_END
  //            | CALL_START ArgList OptComma CALL_END
  public static boolean Arguments(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Arguments")) return false;
    if (!nextTokenIs(b, CALL_START)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = parseTokens(b, 0, CALL_START, CALL_END);
    if (!r) r = Arguments_1(b, l + 1);
    exit_section_(b, m, ARGUMENTS, r);
    return r;
  }

  // CALL_START ArgList OptComma CALL_END
  private static boolean Arguments_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Arguments_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, CALL_START);
    r = r && ArgList(b, l + 1);
    r = r && OptComma(b, l + 1);
    r = r && consumeToken(b, CALL_END);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // '[' ']'
  //            | '[' ArgList OptComma ']'
  public static boolean Array(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Array")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, "<array>");
    r = Array_0(b, l + 1);
    if (!r) r = Array_1(b, l + 1);
    exit_section_(b, l, m, ARRAY, r, false, null);
    return r;
  }

  // '[' ']'
  private static boolean Array_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Array_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "[");
    r = r && consumeToken(b, "]");
    exit_section_(b, m, null, r);
    return r;
  }

  // '[' ArgList OptComma ']'
  private static boolean Array_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Array_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "[");
    r = r && ArgList(b, l + 1);
    r = r && OptComma(b, l + 1);
    r = r && consumeToken(b, "]");
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // Assignable '=' Expression
  //            | Assignable '=' TERMINATOR Expression
  //            | Assignable '=' INDENT Expression OUTDENT
  public static boolean Assign(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Assign")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, "<assign>");
    r = Assign_0(b, l + 1);
    if (!r) r = Assign_1(b, l + 1);
    if (!r) r = Assign_2(b, l + 1);
    exit_section_(b, l, m, ASSIGN, r, false, null);
    return r;
  }

  // Assignable '=' Expression
  private static boolean Assign_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Assign_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = Assignable(b, l + 1);
    r = r && consumeToken(b, "=");
    r = r && Expression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // Assignable '=' TERMINATOR Expression
  private static boolean Assign_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Assign_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = Assignable(b, l + 1);
    r = r && consumeToken(b, "=");
    r = r && consumeToken(b, TERMINATOR);
    r = r && Expression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // Assignable '=' INDENT Expression OUTDENT
  private static boolean Assign_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Assign_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = Assignable(b, l + 1);
    r = r && consumeToken(b, "=");
    r = r && consumeToken(b, INDENT);
    r = r && Expression(b, l + 1);
    r = r && consumeToken(b, OUTDENT);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // ''
  //              | AssignObj
  //              | AssignList ',' AssignObj
  //              | AssignList OptComma TERMINATOR AssignObj
  //              | AssignList OptComma INDENT AssignList OptComma OUTDENT
  public static boolean AssignList(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "AssignList")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, "<assign list>");
    r = consumeToken(b, "");
    if (!r) r = AssignObj(b, l + 1);
    if (!r) r = AssignList_2(b, l + 1);
    if (!r) r = AssignList_3(b, l + 1);
    if (!r) r = AssignList_4(b, l + 1);
    exit_section_(b, l, m, ASSIGN_LIST, r, false, null);
    return r;
  }

  // AssignList ',' AssignObj
  private static boolean AssignList_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "AssignList_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = AssignList(b, l + 1);
    r = r && consumeToken(b, ",");
    r = r && AssignObj(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // AssignList OptComma TERMINATOR AssignObj
  private static boolean AssignList_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "AssignList_3")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = AssignList(b, l + 1);
    r = r && OptComma(b, l + 1);
    r = r && consumeToken(b, TERMINATOR);
    r = r && AssignObj(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // AssignList OptComma INDENT AssignList OptComma OUTDENT
  private static boolean AssignList_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "AssignList_4")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = AssignList(b, l + 1);
    r = r && OptComma(b, l + 1);
    r = r && consumeToken(b, INDENT);
    r = r && AssignList(b, l + 1);
    r = r && OptComma(b, l + 1);
    r = r && consumeToken(b, OUTDENT);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // ObjAssignable
  //            | ObjAssignable ':' Expression
  //            | ObjAssignable ':' INDENT Expression OUTDENT
  //            | SimpleObjectAssignable '=' Expression
  //            | SimpleObjectAssignable '=' INDENT Expression OUTDENT
  //            | Comment
  public static boolean AssignObj(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "AssignObj")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, "<assign obj>");
    r = ObjAssignable(b, l + 1);
    if (!r) r = AssignObj_1(b, l + 1);
    if (!r) r = AssignObj_2(b, l + 1);
    if (!r) r = AssignObj_3(b, l + 1);
    if (!r) r = AssignObj_4(b, l + 1);
    if (!r) r = Comment(b, l + 1);
    exit_section_(b, l, m, ASSIGN_OBJ, r, false, null);
    return r;
  }

  // ObjAssignable ':' Expression
  private static boolean AssignObj_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "AssignObj_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = ObjAssignable(b, l + 1);
    r = r && consumeToken(b, ":");
    r = r && Expression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // ObjAssignable ':' INDENT Expression OUTDENT
  private static boolean AssignObj_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "AssignObj_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = ObjAssignable(b, l + 1);
    r = r && consumeToken(b, ":");
    r = r && consumeToken(b, INDENT);
    r = r && Expression(b, l + 1);
    r = r && consumeToken(b, OUTDENT);
    exit_section_(b, m, null, r);
    return r;
  }

  // SimpleObjectAssignable '=' Expression
  private static boolean AssignObj_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "AssignObj_3")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = SimpleObjectAssignable(b, l + 1);
    r = r && consumeToken(b, "=");
    r = r && Expression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // SimpleObjectAssignable '=' INDENT Expression OUTDENT
  private static boolean AssignObj_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "AssignObj_4")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = SimpleObjectAssignable(b, l + 1);
    r = r && consumeToken(b, "=");
    r = r && consumeToken(b, INDENT);
    r = r && Expression(b, l + 1);
    r = r && consumeToken(b, OUTDENT);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // SimpleAssignable
  //            | Array
  //            | Object
  public static boolean Assignable(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Assignable")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, "<assignable>");
    r = SimpleAssignable(b, l + 1);
    if (!r) r = Array(b, l + 1);
    if (!r) r = Object(b, l + 1);
    exit_section_(b, l, m, ASSIGNABLE, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // INDENT OUTDENT
  //            | INDENT Body OUTDENT
  public static boolean Block(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Block")) return false;
    if (!nextTokenIs(b, INDENT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = parseTokens(b, 0, INDENT, OUTDENT);
    if (!r) r = Block_1(b, l + 1);
    exit_section_(b, m, BLOCK, r);
    return r;
  }

  // INDENT Body OUTDENT
  private static boolean Block_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Block_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, INDENT);
    r = r && Body(b, l + 1);
    r = r && consumeToken(b, OUTDENT);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // Line
  //        | Body TERMINATOR Line
  //        | Body TERMINATOR
  public static boolean Body(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Body")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, "<body>");
    r = Line(b, l + 1);
    if (!r) r = Body_1(b, l + 1);
    if (!r) r = Body_2(b, l + 1);
    exit_section_(b, l, m, BODY, r, false, null);
    return r;
  }

  // Body TERMINATOR Line
  private static boolean Body_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Body_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = Body(b, l + 1);
    r = r && consumeToken(b, TERMINATOR);
    r = r && Line(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // Body TERMINATOR
  private static boolean Body_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Body_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = Body(b, l + 1);
    r = r && consumeToken(b, TERMINATOR);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // CATCH_T Identifier Block
  //            | CATCH_T Object Block
  //            | CATCH_T Block
  public static boolean Catch(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Catch")) return false;
    if (!nextTokenIs(b, CATCH_T)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = Catch_0(b, l + 1);
    if (!r) r = Catch_1(b, l + 1);
    if (!r) r = Catch_2(b, l + 1);
    exit_section_(b, m, CATCH, r);
    return r;
  }

  // CATCH_T Identifier Block
  private static boolean Catch_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Catch_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, CATCH_T);
    r = r && Identifier(b, l + 1);
    r = r && Block(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // CATCH_T Object Block
  private static boolean Catch_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Catch_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, CATCH_T);
    r = r && Object(b, l + 1);
    r = r && Block(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // CATCH_T Block
  private static boolean Catch_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Catch_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, CATCH_T);
    r = r && Block(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // CLASS_T
  //                    | CLASS_T Block
  //                    | CLASS_T EXTENDS Expression
  //                    | CLASS_T EXTENDS Expression Block
  //                    | CLASS_T SimpleAssignable
  //                    | CLASS_T SimpleAssignable Block
  //                    | CLASS_T SimpleAssignable EXTENDS Expression
  //                    | CLASS_T SimpleAssignable EXTENDS Expression Block
  public static boolean ClassDeclaration(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ClassDeclaration")) return false;
    if (!nextTokenIs(b, CLASS_T)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, CLASS_T);
    if (!r) r = ClassDeclaration_1(b, l + 1);
    if (!r) r = ClassDeclaration_2(b, l + 1);
    if (!r) r = ClassDeclaration_3(b, l + 1);
    if (!r) r = ClassDeclaration_4(b, l + 1);
    if (!r) r = ClassDeclaration_5(b, l + 1);
    if (!r) r = ClassDeclaration_6(b, l + 1);
    if (!r) r = ClassDeclaration_7(b, l + 1);
    exit_section_(b, m, CLASS_DECLARATION, r);
    return r;
  }

  // CLASS_T Block
  private static boolean ClassDeclaration_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ClassDeclaration_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, CLASS_T);
    r = r && Block(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // CLASS_T EXTENDS Expression
  private static boolean ClassDeclaration_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ClassDeclaration_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, CLASS_T, EXTENDS);
    r = r && Expression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // CLASS_T EXTENDS Expression Block
  private static boolean ClassDeclaration_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ClassDeclaration_3")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, CLASS_T, EXTENDS);
    r = r && Expression(b, l + 1);
    r = r && Block(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // CLASS_T SimpleAssignable
  private static boolean ClassDeclaration_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ClassDeclaration_4")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, CLASS_T);
    r = r && SimpleAssignable(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // CLASS_T SimpleAssignable Block
  private static boolean ClassDeclaration_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ClassDeclaration_5")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, CLASS_T);
    r = r && SimpleAssignable(b, l + 1);
    r = r && Block(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // CLASS_T SimpleAssignable EXTENDS Expression
  private static boolean ClassDeclaration_6(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ClassDeclaration_6")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, CLASS_T);
    r = r && SimpleAssignable(b, l + 1);
    r = r && consumeToken(b, EXTENDS);
    r = r && Expression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // CLASS_T SimpleAssignable EXTENDS Expression Block
  private static boolean ClassDeclaration_7(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ClassDeclaration_7")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, CLASS_T);
    r = r && SimpleAssignable(b, l + 1);
    r = r && consumeToken(b, EXTENDS);
    r = r && Expression(b, l + 1);
    r = r && Block(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // PARAM_START ParamList PARAM_END FuncGlyph Block
  //            | FuncGlyph Block
  public static boolean Code(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Code")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, "<code>");
    r = Code_0(b, l + 1);
    if (!r) r = Code_1(b, l + 1);
    exit_section_(b, l, m, CODE, r, false, null);
    return r;
  }

  // PARAM_START ParamList PARAM_END FuncGlyph Block
  private static boolean Code_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Code_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, PARAM_START);
    r = r && ParamList(b, l + 1);
    r = r && consumeToken(b, PARAM_END);
    r = r && FuncGlyph(b, l + 1);
    r = r && Block(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // FuncGlyph Block
  private static boolean Code_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Code_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = FuncGlyph(b, l + 1);
    r = r && Block(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // HERECOMMENT
  public static boolean Comment(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Comment")) return false;
    if (!nextTokenIs(b, HERECOMMENT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, HERECOMMENT);
    exit_section_(b, m, COMMENT, r);
    return r;
  }

  /* ********************************************************** */
  // Value
  //              | Invocation
  //              | Code
  //              | Operation
  //              | Assign
  //              | If
  //              | Try
  //              | While
  //              | For
  //              | Switch
  //              | ClassDeclaration
  //              | Throw
  public static boolean Expression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Expression")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, "<expression>");
    r = Value(b, l + 1);
    if (!r) r = Invocation(b, l + 1);
    if (!r) r = Code(b, l + 1);
    if (!r) r = Operation(b, l + 1);
    if (!r) r = Assign(b, l + 1);
    if (!r) r = If(b, l + 1);
    if (!r) r = Try(b, l + 1);
    if (!r) r = While(b, l + 1);
    if (!r) r = For(b, l + 1);
    if (!r) r = Switch(b, l + 1);
    if (!r) r = ClassDeclaration(b, l + 1);
    if (!r) r = Throw(b, l + 1);
    exit_section_(b, l, m, EXPRESSION, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // Statement ForBody
  //            | Expression ForBody
  //            | ForBody Block
  public static boolean For(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "For")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, "<for>");
    r = For_0(b, l + 1);
    if (!r) r = For_1(b, l + 1);
    if (!r) r = For_2(b, l + 1);
    exit_section_(b, l, m, FOR, r, false, null);
    return r;
  }

  // Statement ForBody
  private static boolean For_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "For_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = Statement(b, l + 1);
    r = r && ForBody(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // Expression ForBody
  private static boolean For_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "For_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = Expression(b, l + 1);
    r = r && ForBody(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // ForBody Block
  private static boolean For_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "For_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = ForBody(b, l + 1);
    r = r && Block(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // FOR_T Range
  //            | FOR_T Range BY Expression
  //            | ForStart ForSource
  public static boolean ForBody(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ForBody")) return false;
    if (!nextTokenIs(b, FOR_T)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = ForBody_0(b, l + 1);
    if (!r) r = ForBody_1(b, l + 1);
    if (!r) r = ForBody_2(b, l + 1);
    exit_section_(b, m, FOR_BODY, r);
    return r;
  }

  // FOR_T Range
  private static boolean ForBody_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ForBody_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, FOR_T);
    r = r && Range(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // FOR_T Range BY Expression
  private static boolean ForBody_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ForBody_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, FOR_T);
    r = r && Range(b, l + 1);
    r = r && consumeToken(b, BY);
    r = r && Expression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // ForStart ForSource
  private static boolean ForBody_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ForBody_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = ForStart(b, l + 1);
    r = r && ForSource(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // FORIN Expression
  //            | FOROF Expression
  //            | FORIN Expression WHEN_T Expression
  //            | FOROF Expression WHEN_T Expression
  //            | FORIN Expression BY Expression
  //            | FORIN Expression WHEN_T Expression BY Expression
  //            | FORIN Expression BY Expression WHEN_T Expression
  public static boolean ForSource(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ForSource")) return false;
    if (!nextTokenIs(b, "<for source>", FORIN, FOROF)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, "<for source>");
    r = ForSource_0(b, l + 1);
    if (!r) r = ForSource_1(b, l + 1);
    if (!r) r = ForSource_2(b, l + 1);
    if (!r) r = ForSource_3(b, l + 1);
    if (!r) r = ForSource_4(b, l + 1);
    if (!r) r = ForSource_5(b, l + 1);
    if (!r) r = ForSource_6(b, l + 1);
    exit_section_(b, l, m, FOR_SOURCE, r, false, null);
    return r;
  }

  // FORIN Expression
  private static boolean ForSource_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ForSource_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, FORIN);
    r = r && Expression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // FOROF Expression
  private static boolean ForSource_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ForSource_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, FOROF);
    r = r && Expression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // FORIN Expression WHEN_T Expression
  private static boolean ForSource_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ForSource_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, FORIN);
    r = r && Expression(b, l + 1);
    r = r && consumeToken(b, WHEN_T);
    r = r && Expression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // FOROF Expression WHEN_T Expression
  private static boolean ForSource_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ForSource_3")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, FOROF);
    r = r && Expression(b, l + 1);
    r = r && consumeToken(b, WHEN_T);
    r = r && Expression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // FORIN Expression BY Expression
  private static boolean ForSource_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ForSource_4")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, FORIN);
    r = r && Expression(b, l + 1);
    r = r && consumeToken(b, BY);
    r = r && Expression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // FORIN Expression WHEN_T Expression BY Expression
  private static boolean ForSource_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ForSource_5")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, FORIN);
    r = r && Expression(b, l + 1);
    r = r && consumeToken(b, WHEN_T);
    r = r && Expression(b, l + 1);
    r = r && consumeToken(b, BY);
    r = r && Expression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // FORIN Expression BY Expression WHEN_T Expression
  private static boolean ForSource_6(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ForSource_6")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, FORIN);
    r = r && Expression(b, l + 1);
    r = r && consumeToken(b, BY);
    r = r && Expression(b, l + 1);
    r = r && consumeToken(b, WHEN_T);
    r = r && Expression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // FOR_T ForVariables
  //            | FOR_T OWN ForVariables
  public static boolean ForStart(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ForStart")) return false;
    if (!nextTokenIs(b, FOR_T)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = ForStart_0(b, l + 1);
    if (!r) r = ForStart_1(b, l + 1);
    exit_section_(b, m, FOR_START, r);
    return r;
  }

  // FOR_T ForVariables
  private static boolean ForStart_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ForStart_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, FOR_T);
    r = r && ForVariables(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // FOR_T OWN ForVariables
  private static boolean ForStart_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ForStart_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, FOR_T, OWN);
    r = r && ForVariables(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // Identifier
  //            | ThisProperty
  //            | Array
  //            | Object
  public static boolean ForValue(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ForValue")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, "<for value>");
    r = Identifier(b, l + 1);
    if (!r) r = ThisProperty(b, l + 1);
    if (!r) r = Array(b, l + 1);
    if (!r) r = Object(b, l + 1);
    exit_section_(b, l, m, FOR_VALUE, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // ForValue
  //            | ForValue ',' ForValue
  public static boolean ForVariables(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ForVariables")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, "<for variables>");
    r = ForValue(b, l + 1);
    if (!r) r = ForVariables_1(b, l + 1);
    exit_section_(b, l, m, FOR_VARIABLES, r, false, null);
    return r;
  }

  // ForValue ',' ForValue
  private static boolean ForVariables_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ForVariables_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = ForValue(b, l + 1);
    r = r && consumeToken(b, ",");
    r = r && ForValue(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // '->' | '=>'
  public static boolean FuncGlyph(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "FuncGlyph")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, "<func glyph>");
    r = consumeToken(b, "->");
    if (!r) r = consumeToken(b, "=>");
    exit_section_(b, l, m, FUNC_GLYPH, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // IDENTIFIER_T
  public static boolean Identifier(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Identifier")) return false;
    if (!nextTokenIs(b, IDENTIFIER_T)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IDENTIFIER_T);
    exit_section_(b, m, IDENTIFIER, r);
    return r;
  }

  /* ********************************************************** */
  // IfBlock
  //            | IfBlock ELSE Block
  //            | Statement POST_IF Expression
  //            | Expression POST_IF Expression
  public static boolean If(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "If")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, "<if>");
    r = IfBlock(b, l + 1);
    if (!r) r = If_1(b, l + 1);
    if (!r) r = If_2(b, l + 1);
    if (!r) r = If_3(b, l + 1);
    exit_section_(b, l, m, IF, r, false, null);
    return r;
  }

  // IfBlock ELSE Block
  private static boolean If_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "If_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = IfBlock(b, l + 1);
    r = r && consumeToken(b, ELSE);
    r = r && Block(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // Statement POST_IF Expression
  private static boolean If_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "If_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = Statement(b, l + 1);
    r = r && consumeToken(b, POST_IF);
    r = r && Expression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // Expression POST_IF Expression
  private static boolean If_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "If_3")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = Expression(b, l + 1);
    r = r && consumeToken(b, POST_IF);
    r = r && Expression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // IF_T Expression Block
  //            | IfBlock ELSE IF_T Expression Block
  public static boolean IfBlock(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "IfBlock")) return false;
    if (!nextTokenIs(b, IF_T)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = IfBlock_0(b, l + 1);
    if (!r) r = IfBlock_1(b, l + 1);
    exit_section_(b, m, IF_BLOCK, r);
    return r;
  }

  // IF_T Expression Block
  private static boolean IfBlock_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "IfBlock_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IF_T);
    r = r && Expression(b, l + 1);
    r = r && Block(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // IfBlock ELSE IF_T Expression Block
  private static boolean IfBlock_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "IfBlock_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = IfBlock(b, l + 1);
    r = r && consumeTokens(b, 0, ELSE, IF_T);
    r = r && Expression(b, l + 1);
    r = r && Block(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // INDEX_START IndexValue INDEX_END
  //         | INDEX_SOAK Index
  public static boolean Index(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Index")) return false;
    if (!nextTokenIs(b, "<index>", INDEX_SOAK, INDEX_START)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, "<index>");
    r = Index_0(b, l + 1);
    if (!r) r = Index_1(b, l + 1);
    exit_section_(b, l, m, INDEX, r, false, null);
    return r;
  }

  // INDEX_START IndexValue INDEX_END
  private static boolean Index_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Index_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, INDEX_START);
    r = r && IndexValue(b, l + 1);
    r = r && consumeToken(b, INDEX_END);
    exit_section_(b, m, null, r);
    return r;
  }

  // INDEX_SOAK Index
  private static boolean Index_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Index_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, INDEX_SOAK);
    r = r && Index(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // Expression
  //              | Slice
  public static boolean IndexValue(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "IndexValue")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, "<index value>");
    r = Expression(b, l + 1);
    if (!r) r = Slice(b, l + 1);
    exit_section_(b, l, m, INDEX_VALUE, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // Value OptFuncExist Arguments
  //              | Invocation OptFuncExist Arguments
  //              | SUPER
  //              | SUPER Arguments
  public static boolean Invocation(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Invocation")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, "<invocation>");
    r = Invocation_0(b, l + 1);
    if (!r) r = Invocation_1(b, l + 1);
    if (!r) r = consumeToken(b, SUPER);
    if (!r) r = Invocation_3(b, l + 1);
    exit_section_(b, l, m, INVOCATION, r, false, null);
    return r;
  }

  // Value OptFuncExist Arguments
  private static boolean Invocation_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Invocation_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = Value(b, l + 1);
    r = r && OptFuncExist(b, l + 1);
    r = r && Arguments(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // Invocation OptFuncExist Arguments
  private static boolean Invocation_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Invocation_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = Invocation(b, l + 1);
    r = r && OptFuncExist(b, l + 1);
    r = r && Arguments(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // SUPER Arguments
  private static boolean Invocation_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Invocation_3")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, SUPER);
    r = r && Arguments(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // Expression
  //        | Statement
  public static boolean Line(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Line")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, "<line>");
    r = Expression(b, l + 1);
    if (!r) r = Statement(b, l + 1);
    exit_section_(b, l, m, LINE, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // AlphaNumeric
  //            | JS
  //            | Regex
  //            | DEBUGGER
  //            | UNDEFINED
  //            | NULL
  //            | BOOL
  public static boolean Literal(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Literal")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, "<literal>");
    r = AlphaNumeric(b, l + 1);
    if (!r) r = consumeToken(b, JS);
    if (!r) r = Regex(b, l + 1);
    if (!r) r = consumeToken(b, DEBUGGER);
    if (!r) r = consumeToken(b, UNDEFINED);
    if (!r) r = consumeToken(b, NULL);
    if (!r) r = consumeToken(b, BOOL);
    exit_section_(b, l, m, LITERAL, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // LOOP_T Block
  //            | LOOP_T Expression
  public static boolean Loop(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Loop")) return false;
    if (!nextTokenIs(b, LOOP_T)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = Loop_0(b, l + 1);
    if (!r) r = Loop_1(b, l + 1);
    exit_section_(b, m, LOOP, r);
    return r;
  }

  // LOOP_T Block
  private static boolean Loop_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Loop_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LOOP_T);
    r = r && Block(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // LOOP_T Expression
  private static boolean Loop_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Loop_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LOOP_T);
    r = r && Expression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // SimpleObjectAssignable | AlphaNumeric
  public static boolean ObjAssignable(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ObjAssignable")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, "<obj assignable>");
    r = SimpleObjectAssignable(b, l + 1);
    if (!r) r = AlphaNumeric(b, l + 1);
    exit_section_(b, l, m, OBJ_ASSIGNABLE, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // '{' AssignList OptComma '}'
  public static boolean Object(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Object")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, "<object>");
    r = consumeToken(b, "{");
    r = r && AssignList(b, l + 1);
    r = r && OptComma(b, l + 1);
    r = r && consumeToken(b, "}");
    exit_section_(b, l, m, OBJECT, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // UNARY Expression
  //            | UNARY_MATH Expression
  //            | '-' Expression
  //            | '+' Expression
  //            | YIELD Statement
  //            | YIELD Expression
  //            | YIELD FROM Expression
  //            | '--' SimpleAssignable
  //            | '++' SimpleAssignable
  //            | SimpleAssignable '--'
  //            | SimpleAssignable '++'
  //            | Expression '?'
  //            | Expression '+' Expression
  //            | Expression '-' Expression
  //            | Expression MATH Expression
  //            | Expression '**' Expression
  //            | Expression SHIFT Expression
  //            | Expression COMPARE Expression
  //            | Expression LOGIC Expression
  //            | Expression RELATION Expression
  //            | SimpleAssignable COMPOUND_ASSIGN Expression
  //            | SimpleAssignable COMPOUND_ASSIGN INDENT Expression OUTDENT
  //            | SimpleAssignable COMPOUND_ASSIGN TERMINATOR Expression
  //            | SimpleAssignable EXTENDS Expression
  public static boolean Operation(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Operation")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, "<operation>");
    r = Operation_0(b, l + 1);
    if (!r) r = Operation_1(b, l + 1);
    if (!r) r = Operation_2(b, l + 1);
    if (!r) r = Operation_3(b, l + 1);
    if (!r) r = Operation_4(b, l + 1);
    if (!r) r = Operation_5(b, l + 1);
    if (!r) r = Operation_6(b, l + 1);
    if (!r) r = Operation_7(b, l + 1);
    if (!r) r = Operation_8(b, l + 1);
    if (!r) r = Operation_9(b, l + 1);
    if (!r) r = Operation_10(b, l + 1);
    if (!r) r = Operation_11(b, l + 1);
    if (!r) r = Operation_12(b, l + 1);
    if (!r) r = Operation_13(b, l + 1);
    if (!r) r = Operation_14(b, l + 1);
    if (!r) r = Operation_15(b, l + 1);
    if (!r) r = Operation_16(b, l + 1);
    if (!r) r = Operation_17(b, l + 1);
    if (!r) r = Operation_18(b, l + 1);
    if (!r) r = Operation_19(b, l + 1);
    if (!r) r = Operation_20(b, l + 1);
    if (!r) r = Operation_21(b, l + 1);
    if (!r) r = Operation_22(b, l + 1);
    if (!r) r = Operation_23(b, l + 1);
    exit_section_(b, l, m, OPERATION, r, false, null);
    return r;
  }

  // UNARY Expression
  private static boolean Operation_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Operation_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, UNARY);
    r = r && Expression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // UNARY_MATH Expression
  private static boolean Operation_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Operation_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, UNARY_MATH);
    r = r && Expression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // '-' Expression
  private static boolean Operation_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Operation_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "-");
    r = r && Expression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // '+' Expression
  private static boolean Operation_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Operation_3")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "+");
    r = r && Expression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // YIELD Statement
  private static boolean Operation_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Operation_4")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, YIELD);
    r = r && Statement(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // YIELD Expression
  private static boolean Operation_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Operation_5")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, YIELD);
    r = r && Expression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // YIELD FROM Expression
  private static boolean Operation_6(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Operation_6")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, YIELD, FROM);
    r = r && Expression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // '--' SimpleAssignable
  private static boolean Operation_7(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Operation_7")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "--");
    r = r && SimpleAssignable(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // '++' SimpleAssignable
  private static boolean Operation_8(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Operation_8")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "++");
    r = r && SimpleAssignable(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // SimpleAssignable '--'
  private static boolean Operation_9(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Operation_9")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = SimpleAssignable(b, l + 1);
    r = r && consumeToken(b, "--");
    exit_section_(b, m, null, r);
    return r;
  }

  // SimpleAssignable '++'
  private static boolean Operation_10(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Operation_10")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = SimpleAssignable(b, l + 1);
    r = r && consumeToken(b, "++");
    exit_section_(b, m, null, r);
    return r;
  }

  // Expression '?'
  private static boolean Operation_11(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Operation_11")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = Expression(b, l + 1);
    r = r && consumeToken(b, FUNC_EXIST);
    exit_section_(b, m, null, r);
    return r;
  }

  // Expression '+' Expression
  private static boolean Operation_12(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Operation_12")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = Expression(b, l + 1);
    r = r && consumeToken(b, "+");
    r = r && Expression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // Expression '-' Expression
  private static boolean Operation_13(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Operation_13")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = Expression(b, l + 1);
    r = r && consumeToken(b, "-");
    r = r && Expression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // Expression MATH Expression
  private static boolean Operation_14(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Operation_14")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = Expression(b, l + 1);
    r = r && consumeToken(b, MATH);
    r = r && Expression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // Expression '**' Expression
  private static boolean Operation_15(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Operation_15")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = Expression(b, l + 1);
    r = r && consumeToken(b, "**");
    r = r && Expression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // Expression SHIFT Expression
  private static boolean Operation_16(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Operation_16")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = Expression(b, l + 1);
    r = r && consumeToken(b, SHIFT);
    r = r && Expression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // Expression COMPARE Expression
  private static boolean Operation_17(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Operation_17")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = Expression(b, l + 1);
    r = r && consumeToken(b, COMPARE);
    r = r && Expression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // Expression LOGIC Expression
  private static boolean Operation_18(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Operation_18")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = Expression(b, l + 1);
    r = r && consumeToken(b, LOGIC);
    r = r && Expression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // Expression RELATION Expression
  private static boolean Operation_19(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Operation_19")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = Expression(b, l + 1);
    r = r && consumeToken(b, RELATION);
    r = r && Expression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // SimpleAssignable COMPOUND_ASSIGN Expression
  private static boolean Operation_20(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Operation_20")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = SimpleAssignable(b, l + 1);
    r = r && consumeToken(b, COMPOUND_ASSIGN);
    r = r && Expression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // SimpleAssignable COMPOUND_ASSIGN INDENT Expression OUTDENT
  private static boolean Operation_21(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Operation_21")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = SimpleAssignable(b, l + 1);
    r = r && consumeTokens(b, 0, COMPOUND_ASSIGN, INDENT);
    r = r && Expression(b, l + 1);
    r = r && consumeToken(b, OUTDENT);
    exit_section_(b, m, null, r);
    return r;
  }

  // SimpleAssignable COMPOUND_ASSIGN TERMINATOR Expression
  private static boolean Operation_22(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Operation_22")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = SimpleAssignable(b, l + 1);
    r = r && consumeTokens(b, 0, COMPOUND_ASSIGN, TERMINATOR);
    r = r && Expression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // SimpleAssignable EXTENDS Expression
  private static boolean Operation_23(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Operation_23")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = SimpleAssignable(b, l + 1);
    r = r && consumeToken(b, EXTENDS);
    r = r && Expression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // ','?
  public static boolean OptComma(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "OptComma")) return false;
    Marker m = enter_section_(b, l, _NONE_, "<opt comma>");
    consumeToken(b, ",");
    exit_section_(b, l, m, OPT_COMMA, true, false, null);
    return true;
  }

  /* ********************************************************** */
  // FUNC_EXIST?
  public static boolean OptFuncExist(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "OptFuncExist")) return false;
    Marker m = enter_section_(b, l, _NONE_, "<opt func exist>");
    consumeToken(b, FUNC_EXIST);
    exit_section_(b, l, m, OPT_FUNC_EXIST, true, false, null);
    return true;
  }

  /* ********************************************************** */
  // ParamVar
  //            | ParamVar '...'
  //            | ParamVar '=' Expression
  //            | '...'
  public static boolean Param(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Param")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, "<param>");
    r = ParamVar(b, l + 1);
    if (!r) r = Param_1(b, l + 1);
    if (!r) r = Param_2(b, l + 1);
    if (!r) r = consumeToken(b, "...");
    exit_section_(b, l, m, PARAM, r, false, null);
    return r;
  }

  // ParamVar '...'
  private static boolean Param_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Param_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = ParamVar(b, l + 1);
    r = r && consumeToken(b, "...");
    exit_section_(b, m, null, r);
    return r;
  }

  // ParamVar '=' Expression
  private static boolean Param_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Param_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = ParamVar(b, l + 1);
    r = r && consumeToken(b, "=");
    r = r && Expression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // ''
  //             | Param
  //             | ParamList ',' Param
  //             | ParamList OptComma TERMINATOR Param
  //             | ParamList OptComma INDENT ParamList OptComma OUTDENT
  public static boolean ParamList(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ParamList")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, "<param list>");
    r = consumeToken(b, "");
    if (!r) r = Param(b, l + 1);
    if (!r) r = ParamList_2(b, l + 1);
    if (!r) r = ParamList_3(b, l + 1);
    if (!r) r = ParamList_4(b, l + 1);
    exit_section_(b, l, m, PARAM_LIST, r, false, null);
    return r;
  }

  // ParamList ',' Param
  private static boolean ParamList_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ParamList_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = ParamList(b, l + 1);
    r = r && consumeToken(b, ",");
    r = r && Param(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // ParamList OptComma TERMINATOR Param
  private static boolean ParamList_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ParamList_3")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = ParamList(b, l + 1);
    r = r && OptComma(b, l + 1);
    r = r && consumeToken(b, TERMINATOR);
    r = r && Param(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // ParamList OptComma INDENT ParamList OptComma OUTDENT
  private static boolean ParamList_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ParamList_4")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = ParamList(b, l + 1);
    r = r && OptComma(b, l + 1);
    r = r && consumeToken(b, INDENT);
    r = r && ParamList(b, l + 1);
    r = r && OptComma(b, l + 1);
    r = r && consumeToken(b, OUTDENT);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // Identifier
  //            | ThisProperty
  //            | Array
  //            | Object
  public static boolean ParamVar(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ParamVar")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, "<param var>");
    r = Identifier(b, l + 1);
    if (!r) r = ThisProperty(b, l + 1);
    if (!r) r = Array(b, l + 1);
    if (!r) r = Object(b, l + 1);
    exit_section_(b, l, m, PARAM_VAR, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // '(' Body ')'
  //            | '(' INDENT Body OUTDENT ')'
  public static boolean Parenthetical(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Parenthetical")) return false;
    if (!nextTokenIs(b, PARAM_START)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = Parenthetical_0(b, l + 1);
    if (!r) r = Parenthetical_1(b, l + 1);
    exit_section_(b, m, PARENTHETICAL, r);
    return r;
  }

  // '(' Body ')'
  private static boolean Parenthetical_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Parenthetical_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, PARAM_START);
    r = r && Body(b, l + 1);
    r = r && consumeToken(b, PARAM_END);
    exit_section_(b, m, null, r);
    return r;
  }

  // '(' INDENT Body OUTDENT ')'
  private static boolean Parenthetical_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Parenthetical_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, PARAM_START);
    r = r && consumeToken(b, INDENT);
    r = r && Body(b, l + 1);
    r = r && consumeToken(b, OUTDENT);
    r = r && consumeToken(b, PARAM_END);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // '[' Expression RangeDots Expression ']'
  public static boolean Range(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Range")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, "<range>");
    r = consumeToken(b, "[");
    r = r && Expression(b, l + 1);
    r = r && RangeDots(b, l + 1);
    r = r && Expression(b, l + 1);
    r = r && consumeToken(b, "]");
    exit_section_(b, l, m, RANGE, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // '..'
  //            | '...'
  public static boolean RangeDots(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "RangeDots")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, "<range dots>");
    r = consumeToken(b, "..");
    if (!r) r = consumeToken(b, "...");
    exit_section_(b, l, m, RANGE_DOTS, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // REGEX_T
  //         | REGEX_START Invocation REGEX_END
  public static boolean Regex(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Regex")) return false;
    if (!nextTokenIs(b, "<regex>", REGEX_START, REGEX_T)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, "<regex>");
    r = consumeToken(b, REGEX_T);
    if (!r) r = Regex_1(b, l + 1);
    exit_section_(b, l, m, REGEX, r, false, null);
    return r;
  }

  // REGEX_START Invocation REGEX_END
  private static boolean Regex_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Regex_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, REGEX_START);
    r = r && Invocation(b, l + 1);
    r = r && consumeToken(b, REGEX_END);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // RETURN_T Expression
  //            | RETURN_T
  public static boolean Return(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Return")) return false;
    if (!nextTokenIs(b, RETURN_T)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = Return_0(b, l + 1);
    if (!r) r = consumeToken(b, RETURN_T);
    exit_section_(b, m, RETURN, r);
    return r;
  }

  // RETURN_T Expression
  private static boolean Return_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Return_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, RETURN_T);
    r = r && Expression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // Body?
  static boolean Root(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Root")) return false;
    Body(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // Expression
  //              | SimpleArgs ',' Expression
  public static boolean SimpleArgs(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "SimpleArgs")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, "<simple args>");
    r = Expression(b, l + 1);
    if (!r) r = SimpleArgs_1(b, l + 1);
    exit_section_(b, l, m, SIMPLE_ARGS, r, false, null);
    return r;
  }

  // SimpleArgs ',' Expression
  private static boolean SimpleArgs_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "SimpleArgs_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = SimpleArgs(b, l + 1);
    r = r && consumeToken(b, ",");
    r = r && Expression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // Identifier
  //            | Value Accessor
  //            | Invocation Accessor
  //            | ThisProperty
  public static boolean SimpleAssignable(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "SimpleAssignable")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, "<simple assignable>");
    r = Identifier(b, l + 1);
    if (!r) r = SimpleAssignable_1(b, l + 1);
    if (!r) r = SimpleAssignable_2(b, l + 1);
    if (!r) r = ThisProperty(b, l + 1);
    exit_section_(b, l, m, SIMPLE_ASSIGNABLE, r, false, null);
    return r;
  }

  // Value Accessor
  private static boolean SimpleAssignable_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "SimpleAssignable_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = Value(b, l + 1);
    r = r && Accessor(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // Invocation Accessor
  private static boolean SimpleAssignable_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "SimpleAssignable_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = Invocation(b, l + 1);
    r = r && Accessor(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // Identifier | ThisProperty
  public static boolean SimpleObjectAssignable(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "SimpleObjectAssignable")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, "<simple object assignable>");
    r = Identifier(b, l + 1);
    if (!r) r = ThisProperty(b, l + 1);
    exit_section_(b, l, m, SIMPLE_OBJECT_ASSIGNABLE, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // Expression RangeDots Expression
  //            | Expression RangeDots
  //            | RangeDots Expression
  //            | RangeDots
  public static boolean Slice(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Slice")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, "<slice>");
    r = Slice_0(b, l + 1);
    if (!r) r = Slice_1(b, l + 1);
    if (!r) r = Slice_2(b, l + 1);
    if (!r) r = RangeDots(b, l + 1);
    exit_section_(b, l, m, SLICE, r, false, null);
    return r;
  }

  // Expression RangeDots Expression
  private static boolean Slice_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Slice_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = Expression(b, l + 1);
    r = r && RangeDots(b, l + 1);
    r = r && Expression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // Expression RangeDots
  private static boolean Slice_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Slice_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = Expression(b, l + 1);
    r = r && RangeDots(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // RangeDots Expression
  private static boolean Slice_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Slice_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = RangeDots(b, l + 1);
    r = r && Expression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // Expression '...'
  public static boolean Splat(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Splat")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, "<splat>");
    r = Expression(b, l + 1);
    r = r && consumeToken(b, "...");
    exit_section_(b, l, m, SPLAT, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // Return
  //            | Comment
  //            | STATEMENT_T
  public static boolean Statement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Statement")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, "<statement>");
    r = Return(b, l + 1);
    if (!r) r = Comment(b, l + 1);
    if (!r) r = consumeToken(b, STATEMENT_T);
    exit_section_(b, l, m, STATEMENT, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // STRING_T
  //          | STRING_START Body STRING_END
  public static boolean String(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "String")) return false;
    if (!nextTokenIs(b, "<string>", STRING_START, STRING_T)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, "<string>");
    r = consumeToken(b, STRING_T);
    if (!r) r = String_1(b, l + 1);
    exit_section_(b, l, m, STRING, r, false, null);
    return r;
  }

  // STRING_START Body STRING_END
  private static boolean String_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "String_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, STRING_START);
    r = r && Body(b, l + 1);
    r = r && consumeToken(b, STRING_END);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // SWITCH_T Expression INDENT Whens OUTDENT
  //            | SWITCH_T Expression INDENT Whens ELSE Block OUTDENT
  //            | SWITCH_T INDENT Whens OUTDENT
  //            | SWITCH_T INDENT Whens ELSE Block OUTDENT
  public static boolean Switch(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Switch")) return false;
    if (!nextTokenIs(b, SWITCH_T)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = Switch_0(b, l + 1);
    if (!r) r = Switch_1(b, l + 1);
    if (!r) r = Switch_2(b, l + 1);
    if (!r) r = Switch_3(b, l + 1);
    exit_section_(b, m, SWITCH, r);
    return r;
  }

  // SWITCH_T Expression INDENT Whens OUTDENT
  private static boolean Switch_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Switch_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, SWITCH_T);
    r = r && Expression(b, l + 1);
    r = r && consumeToken(b, INDENT);
    r = r && Whens(b, l + 1);
    r = r && consumeToken(b, OUTDENT);
    exit_section_(b, m, null, r);
    return r;
  }

  // SWITCH_T Expression INDENT Whens ELSE Block OUTDENT
  private static boolean Switch_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Switch_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, SWITCH_T);
    r = r && Expression(b, l + 1);
    r = r && consumeToken(b, INDENT);
    r = r && Whens(b, l + 1);
    r = r && consumeToken(b, ELSE);
    r = r && Block(b, l + 1);
    r = r && consumeToken(b, OUTDENT);
    exit_section_(b, m, null, r);
    return r;
  }

  // SWITCH_T INDENT Whens OUTDENT
  private static boolean Switch_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Switch_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, SWITCH_T, INDENT);
    r = r && Whens(b, l + 1);
    r = r && consumeToken(b, OUTDENT);
    exit_section_(b, m, null, r);
    return r;
  }

  // SWITCH_T INDENT Whens ELSE Block OUTDENT
  private static boolean Switch_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Switch_3")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, SWITCH_T, INDENT);
    r = r && Whens(b, l + 1);
    r = r && consumeToken(b, ELSE);
    r = r && Block(b, l + 1);
    r = r && consumeToken(b, OUTDENT);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // THIS_T
  //            | '@'
  public static boolean This(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "This")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, "<this>");
    r = consumeToken(b, THIS_T);
    if (!r) r = consumeToken(b, "@");
    exit_section_(b, l, m, THIS, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // '@' Identifier
  public static boolean ThisProperty(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ThisProperty")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, "<this property>");
    r = consumeToken(b, "@");
    r = r && Identifier(b, l + 1);
    exit_section_(b, l, m, THIS_PROPERTY, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // THROW_T Expression
  public static boolean Throw(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Throw")) return false;
    if (!nextTokenIs(b, THROW_T)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, THROW_T);
    r = r && Expression(b, l + 1);
    exit_section_(b, m, THROW, r);
    return r;
  }

  /* ********************************************************** */
  // TRY_T Block
  //            | TRY_T Block Catch
  //            | TRY_T Block FINALLY Block
  //            | TRY_T Block Catch FINALLY Block
  public static boolean Try(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Try")) return false;
    if (!nextTokenIs(b, TRY_T)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = Try_0(b, l + 1);
    if (!r) r = Try_1(b, l + 1);
    if (!r) r = Try_2(b, l + 1);
    if (!r) r = Try_3(b, l + 1);
    exit_section_(b, m, TRY, r);
    return r;
  }

  // TRY_T Block
  private static boolean Try_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Try_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, TRY_T);
    r = r && Block(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // TRY_T Block Catch
  private static boolean Try_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Try_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, TRY_T);
    r = r && Block(b, l + 1);
    r = r && Catch(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // TRY_T Block FINALLY Block
  private static boolean Try_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Try_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, TRY_T);
    r = r && Block(b, l + 1);
    r = r && consumeToken(b, FINALLY);
    r = r && Block(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // TRY_T Block Catch FINALLY Block
  private static boolean Try_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Try_3")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, TRY_T);
    r = r && Block(b, l + 1);
    r = r && Catch(b, l + 1);
    r = r && consumeToken(b, FINALLY);
    r = r && Block(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // Assignable
  //            | Literal
  //            | Parenthetical
  //            | Range
  //            | This
  public static boolean Value(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Value")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, "<value>");
    r = Assignable(b, l + 1);
    if (!r) r = Literal(b, l + 1);
    if (!r) r = Parenthetical(b, l + 1);
    if (!r) r = Range(b, l + 1);
    if (!r) r = This(b, l + 1);
    exit_section_(b, l, m, VALUE, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // LEADING_WHEN SimpleArgs Block
  //            | LEADING_WHEN SimpleArgs Block TERMINATOR
  public static boolean When(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "When")) return false;
    if (!nextTokenIs(b, LEADING_WHEN)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = When_0(b, l + 1);
    if (!r) r = When_1(b, l + 1);
    exit_section_(b, m, WHEN, r);
    return r;
  }

  // LEADING_WHEN SimpleArgs Block
  private static boolean When_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "When_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LEADING_WHEN);
    r = r && SimpleArgs(b, l + 1);
    r = r && Block(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // LEADING_WHEN SimpleArgs Block TERMINATOR
  private static boolean When_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "When_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LEADING_WHEN);
    r = r && SimpleArgs(b, l + 1);
    r = r && Block(b, l + 1);
    r = r && consumeToken(b, TERMINATOR);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // When
  //            | Whens When
  public static boolean Whens(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Whens")) return false;
    if (!nextTokenIs(b, LEADING_WHEN)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = When(b, l + 1);
    if (!r) r = Whens_1(b, l + 1);
    exit_section_(b, m, WHENS, r);
    return r;
  }

  // Whens When
  private static boolean Whens_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Whens_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = Whens(b, l + 1);
    r = r && When(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // WhileSource Block
  //            | Statement WhileSource
  //            | Expression WhileSource
  //            | Loop
  public static boolean While(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "While")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, "<while>");
    r = While_0(b, l + 1);
    if (!r) r = While_1(b, l + 1);
    if (!r) r = While_2(b, l + 1);
    if (!r) r = Loop(b, l + 1);
    exit_section_(b, l, m, WHILE, r, false, null);
    return r;
  }

  // WhileSource Block
  private static boolean While_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "While_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = WhileSource(b, l + 1);
    r = r && Block(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // Statement WhileSource
  private static boolean While_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "While_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = Statement(b, l + 1);
    r = r && WhileSource(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // Expression WhileSource
  private static boolean While_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "While_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = Expression(b, l + 1);
    r = r && WhileSource(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // WHILE_T Expression
  //            | WHILE_T Expression WHEN_T Expression
  //            | UNTIL Expression
  //            | UNTIL Expression WHEN_T Expression
  public static boolean WhileSource(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "WhileSource")) return false;
    if (!nextTokenIs(b, "<while source>", UNTIL, WHILE_T)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, "<while source>");
    r = WhileSource_0(b, l + 1);
    if (!r) r = WhileSource_1(b, l + 1);
    if (!r) r = WhileSource_2(b, l + 1);
    if (!r) r = WhileSource_3(b, l + 1);
    exit_section_(b, l, m, WHILE_SOURCE, r, false, null);
    return r;
  }

  // WHILE_T Expression
  private static boolean WhileSource_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "WhileSource_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, WHILE_T);
    r = r && Expression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // WHILE_T Expression WHEN_T Expression
  private static boolean WhileSource_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "WhileSource_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, WHILE_T);
    r = r && Expression(b, l + 1);
    r = r && consumeToken(b, WHEN_T);
    r = r && Expression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // UNTIL Expression
  private static boolean WhileSource_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "WhileSource_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, UNTIL);
    r = r && Expression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // UNTIL Expression WHEN_T Expression
  private static boolean WhileSource_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "WhileSource_3")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, UNTIL);
    r = r && Expression(b, l + 1);
    r = r && consumeToken(b, WHEN_T);
    r = r && Expression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

}
