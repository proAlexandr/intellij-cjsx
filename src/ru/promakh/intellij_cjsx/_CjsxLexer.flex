package ru.promakh.intellij_cjsx;
import com.intellij.lexer.*;
import com.intellij.psi.tree.IElementType;
import static ru.promakh.intellij_cjsx.psi.CjsxTypes.*;

%%

%{
  public _CjsxLexer() {
    this((java.io.Reader)null);
  }
%}

%public
%class _CjsxLexer
%implements FlexLexer
%function advance
%type IElementType
%unicode

EOL="\r"|"\n"|"\r\n"
LINE_WS=[\ \t\f]
WHITE_SPACE=({LINE_WS}|{EOL})+

TERMINATOR=\n|;
INDENT=([ \t\n\x0B\f\r])|\t
IDENTIFIER_T=[a-zA-Z_0-9]+
NUMBER=[0-9]+(\.[0-9]+)*
HERECOMMENT=#.*
STATEMENT_T=break|contunue
IF_T=if|unless
STRING_T=\"([^\"]|\\\")*\"
BOOL=true|false
MATH=[*]|[\/]{1,2}|[%]{1,2}

%%
<YYINITIAL> {
  {WHITE_SPACE}        { return com.intellij.psi.TokenType.WHITE_SPACE; }

  "catch"              { return CATCH_T; }
  "class"              { return CLASS_T; }
  "super"              { return SUPER; }
  "return"             { return RETURN_T; }
  "else"               { return ELSE; }
  "for"                { return FOR_T; }
  "own"                { return OWN; }
  "by"                 { return BY; }
  "in"                 { return FORIN; }
  "of"                 { return FOROF; }
  "when"               { return WHEN_T; }
  "while"              { return WHILE_T; }
  "until"              { return UNTIL; }
  "from"               { return FROM; }
  "switch"             { return SWITCH_T; }
  "loop"               { return LOOP_T; }
  "throw"              { return THROW_T; }
  "this"               { return THIS_T; }
  "extends"            { return EXTENDS; }
  "yield"              { return YIELD; }
  "try"                { return TRY_T; }
  "\"\"\""             { return STRING_END; }
  "//"                 { return REGEX_T; }
  "///"                { return REGEX_END; }
  "undefined"          { return UNDEFINED; }
  "null"               { return NULL; }
  "("                  { return PARAM_START; }
  ")"                  { return PARAM_END; }
  "?"                  { return FUNC_EXIST; }
  "OUTDENT"            { return OUTDENT; }
  "STRING_START"       { return STRING_START; }
  "REGEX_START"        { return REGEX_START; }
  "JS"                 { return JS; }
  "DEBUGGER"           { return DEBUGGER; }
  "INDEX_START"        { return INDEX_START; }
  "INDEX_END"          { return INDEX_END; }
  "INDEX_SOAK"         { return INDEX_SOAK; }
  "CALL_START"         { return CALL_START; }
  "CALL_END"           { return CALL_END; }
  "FINALLY"            { return FINALLY; }
  "LEADING_WHEN"       { return LEADING_WHEN; }
  "POST_IF"            { return POST_IF; }
  "UNARY"              { return UNARY; }
  "UNARY_MATH"         { return UNARY_MATH; }
  "SHIFT"              { return SHIFT; }
  "COMPARE"            { return COMPARE; }
  "LOGIC"              { return LOGIC; }
  "RELATION"           { return RELATION; }
  "COMPOUND_ASSIGN"    { return COMPOUND_ASSIGN; }

  {TERMINATOR}         { return TERMINATOR; }
  {INDENT}             { return INDENT; }
  {IDENTIFIER_T}       { return IDENTIFIER_T; }
  {NUMBER}             { return NUMBER; }
  {HERECOMMENT}        { return HERECOMMENT; }
  {STATEMENT_T}        { return STATEMENT_T; }
  {IF_T}               { return IF_T; }
  {STRING_T}           { return STRING_T; }
  {BOOL}               { return BOOL; }
  {MATH}               { return MATH; }

  [^] { return com.intellij.psi.TokenType.BAD_CHARACTER; }
}
