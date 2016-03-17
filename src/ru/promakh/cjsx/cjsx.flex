package ru.promakh.cjsx.lang;


import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

import com.intellij.lang.javascript.JSTokenTypes;
import org.coffeescript.lang.lexer.CoffeeScriptTokenTypes;
import ru.promakh.cjsx.psi.CjsxTokenType;

/**
 * The CoffeeScript lexer is responsible for generating a token stream of any CoffeeScript source file.
 *
 * @author Michael Kessler, Andrey Vokin
 * @since 0.1.0
 */
%%

/* %debug */

%unicode

%public
%class CjsxLexer
%implements FlexLexer
%type IElementType

%function advance

%{
  private boolean stringJustBegun;

  private IElementType characterClassType;

  private final Stack<Integer> stack = new Stack<Integer>();

  private final List<Character> operationSigns = Arrays.asList('+', '-', '*', '/', '%', '&', '<', '>', '!');

  private final Stack<Integer> bracesInsideInterpolation = new Stack<Integer>();;

  /**
   * Push the actual state on top of the stack
   */
  private void pushState() {
    stack.push(yystate());
  }

  /**
   * Push the actual state on top of the stack
   * and change into another state
   *
   * @param state The new state
   */
  private void pushStateAndBegin(int state) {
    stack.push(yystate());
    yybegin(state);
  }

  /**
   * Pop the last state from the stack and change to it.
   * If the stack is empty, go to YYINITIAL
   */
  private void popState() {
    if (!stack.empty()) {
      yybegin(stack.pop());
    } else {
      pushStateAndBegin(YYINITIAL);
    }
  }

  /**
   * Push the stream back to the position before the text match
   *
   * @param text The text to match
   * @return true when matched
   */
  private boolean pushBackTo(String text) {
    final int position = yytext().toString().indexOf(text);

    if (position != -1) {
      yypushback(yylength() - position);
      return true;
    }

    return false;
  }

  private void startInterpolation() {
    bracesInsideInterpolation.push(0);
  }

  private boolean pushBackToObjectKey() {
    int position = yytext().toString().lastIndexOf(":");
    if (position > 0) {
      position--;
      while (position > 0 && (yytext().toString().charAt(position) == ' ' || yytext().toString().charAt(position) == '\t')) {
        position--;
      }
      position++;
      yypushback(yylength() - position);
      return true;
    }
    return false;
  }

  private boolean isInsideInterpolation() {
      return stack.contains(YYINTERPOLATION);
    }

    private void popUntilInterpolation() {
      while (stack.size() > 0 && stack.get(stack.size() - 1) != YYINTERPOLATION) {
        popState();
      }
      if (stack.size() > 0) {
        popState();
      }
    }

    private void beginState(int state) {
      if (state == YYINITIAL && isInsideInterpolation()) {
        state = YYNORMAL;
      }
      yybegin(state);
    }


  /**
   * Push the stream back to the position before the text match
   * and change into the given state
   *
   * @param text The text to match
   * @param state The new state
   * @return true when matched
   */
  private boolean pushBackAndState(String text, int state) {
    final boolean success = pushBackTo(text);

    if (success) {
      pushStateAndBegin(state);
    }

    return success;
  }

  private char previousChar() {
    final int loc = getTokenStart() - 1;
    return 0 <= loc && loc < zzBuffer.length() ? zzBuffer.charAt(loc) : (char) -1;
  }

  private boolean isOperationSign(char c) {
    return operationSigns.contains(c);
  }
%}

WHITE_SPACE     = ([ \f\n\r\t\u000b​\u00a0\u1680​\u180e\u2000-\u200a​\u2028\u2029​​\u202f\u205f​\u3000])+
SKIP_EOL = \\

UNICODE_SYMBOL_WIHTOUT_NUMBER  = [:unicode_uppercase_letter:]|[:unicode_lowercase_letter:]|[:unicode_titlecase_letter:]|[:unicode_modifier_letter:]|[:unicode_other_letter:]|[:unicode_letter_number:]|[:unicode_non_spacing_mark:]|[:unicode_combining_spacing_mark:]|[:unicode_connector_punctuation:]
UNICODE_SYMBOL  = {UNICODE_SYMBOL_WIHTOUT_NUMBER}|[:unicode_decimal_digit_number:]
IDENTIFIER      = ([$_a-zA-Z]|{UNICODE_SYMBOL_WIHTOUT_NUMBER})([$_a-zA-Z0-9]|{UNICODE_SYMBOL})*
NUMBER          = (0b[01]+)|(0o[0-7]+)|(0(x|X)[0-9a-fA-F]+)|([0-9]+(\.[0-9]+)?(e[+\-]?[0-9]+)?)|(\.[0-9]+(e[+\-]?[0-9]+)?)
FUNCTION        = ([_a-zA-Z]|{UNICODE_SYMBOL_WIHTOUT_NUMBER})([$_a-zA-Z0-9]|{UNICODE_SYMBOL})*?[:]([^\n\r])*?(->|=>)
OBJECT_KEY      = (((-?0b[01]+)|(-?0o[0-7]+)|(-?0(x|X|o)[0-9a-fA-F]+)|(-?[0-9]+(\.[0-9]+)?(e[+\-]?[0-9]+)?))|(-?\.[0-9]+(e[+\-]?[0-9]+)?)|([_a-zA-Z]([$_a-zA-Z0-9])*))([ ])*[:][^:]
EOL             = "\r" | "\n" | "\r\n"

ANY_CHAR_EXCEPT_SHARP = [^#]|{UNICODE_SYMBOL}|{EOL}
NON_BLOCK_COMMENT_END = ({ANY_CHAR_EXCEPT_SHARP}|#{ANY_CHAR_EXCEPT_SHARP}|##{ANY_CHAR_EXCEPT_SHARP})*
BLOCK_COMMENT   = ("######")|(###{ANY_CHAR_EXCEPT_SHARP}{NON_BLOCK_COMMENT_END}(###)?)|(###)
LINE_COMMENT    = ((##?)|(####+))([^#\n\r][^\n\r]*)?

BOOL            = true|yes|on|false|no|off|undefined|null
QUOTE           = super|this|class|extends|try|catch|finally|throw|if|then|else|unless|for|in|of|by|while|until|loop|switch|when|break|continue|return|instanceof|true|yes|on|false|no|off|undefined|null|do|new|typeof|delete|not|new|is|isnt|or|and|export|import|case|function|var|void|with|const|let|enum|native|__hasProp|__extends|__slice|__bind|__indexOf|do|delete|\~|\!
PROPERTY_PREFIX = (\.|::)

REGEXP          = ([^\\/]|\\\/|\\.|\[([^\]\\]|\\\]|\\.)*\])+
HEREGEXP        = ([^#/]|{EOL}|(\/[^/])|(\/\/[^/])|(\\#))+
LINE_COMMENT_INT= #[^{].*

%state YYNORMAL, YYIDENTIFIER, YYNUMBER, YYJAVASCRIPT
%state YYDOUBLEQUOTESTRING, YYSINGLEQUOTESTRING, YYFOR
%state YYDOUBLEQUOTEHEREDOC, YYSINGLEQUOTEHEREDOC
%state YYREGEX, YYHEREGEX, YYREGEXFLAG
%state YYINTERPOLATION, YYQUOTEPROPERTY, YYCLASSNAME, YYTHIS

%%

<YYTHIS> {
  {BOOL}|{QUOTE}              { popState();
                                return CoffeeScriptTokenTypes.IDENTIFIER; }

  "["                         { yybegin(YYNORMAL);
                                return CoffeeScriptTokenTypes.BRACKET_START; }
}

<YYINITIAL, YYNORMAL> {
  {BOOL}                      { return CoffeeScriptTokenTypes.BOOL; }

  "["                         { return CoffeeScriptTokenTypes.BRACKET_START; }
}

/*************************************************************************************************/
/* The initial state recognizes keywords, most operators and characters that start another state */
/*************************************************************************************************/

<YYINITIAL, YYNORMAL, YYTHIS> {
  {QUOTE}:                    { yypushback(1);
                                return CoffeeScriptTokenTypes.IDENTIFIER; }

  "@" | "this"                { pushStateAndBegin(YYTHIS);
                                return CoffeeScriptTokenTypes.THIS; }

  "class"                     { return CoffeeScriptTokenTypes.CLASS; }
  "extends"                   { return CoffeeScriptTokenTypes.EXTENDS; }
  "try"                       { return CoffeeScriptTokenTypes.TRY; }
  "catch"                     { return CoffeeScriptTokenTypes.CATCH; }
  "finally"                   { return CoffeeScriptTokenTypes.FINALLY; }
  "throw"                     { return CoffeeScriptTokenTypes.THROW; }
  "if"                        { return CoffeeScriptTokenTypes.IF; }
  "then"                      { return CoffeeScriptTokenTypes.THEN; }
  "else"                      { return CoffeeScriptTokenTypes.ELSE; }
  "unless"                    { return CoffeeScriptTokenTypes.UNLESS; }
  "for"                       { pushStateAndBegin(YYFOR);
                                return CoffeeScriptTokenTypes.FOR; }
  "in"                        { return CoffeeScriptTokenTypes.IN_KEYWORD; }
  "of"                        { return CoffeeScriptTokenTypes.IN_KEYWORD; }
  "by"                        { return CoffeeScriptTokenTypes.BY; }
  "while"                     { return CoffeeScriptTokenTypes.WHILE; }
  "loop"                      { return CoffeeScriptTokenTypes.LOOP; }
  "until"                     { return CoffeeScriptTokenTypes.UNTIL; }
  "switch"                    { return CoffeeScriptTokenTypes.SWITCH; }
  "when"                      { return CoffeeScriptTokenTypes.WHEN; }
  "break"                     { return CoffeeScriptTokenTypes.BREAK; }
  "continue"                  { return CoffeeScriptTokenTypes.CONTINUE; }
  "debugger"                  { return CoffeeScriptTokenTypes.DEBUGGER; }
  "return"                    { return CoffeeScriptTokenTypes.RETURN; }
  "instanceof"                { return CoffeeScriptTokenTypes.INSTANCEOF_KEYWORD; }
  "super"                     { return CoffeeScriptTokenTypes.SUPER; }
  "yield"                     { return CoffeeScriptTokenTypes.YIELD_KEYWORD; }
  "new"                       { return CoffeeScriptTokenTypes.NEW_KEYWORD; }
  "and"                       { return CoffeeScriptTokenTypes.AND_AND; }
  "or"                        { return CoffeeScriptTokenTypes.OR_OR; }
  "and="                      { return CoffeeScriptTokenTypes.AND_AND_EQ; }
  "or="                       { return CoffeeScriptTokenTypes.OR_OR_EQ; }
  "is"                        { return CoffeeScriptTokenTypes.EQ_EQ_EQ; }
  "isnt"                      { return CoffeeScriptTokenTypes.NOT_EQ_EQ; }
  "typeof"                    { return CoffeeScriptTokenTypes.TYPEOF_KEYWORD; }
  "do"                        { return CoffeeScriptTokenTypes.DO_KEYWORD; }
  "delete"                    { return CoffeeScriptTokenTypes.DELETE_KEYWORD; }
  "~"                         { return CoffeeScriptTokenTypes.TILDE; }
  "!"                         { return CoffeeScriptTokenTypes.EXCL; }
  "not"                       { return CoffeeScriptTokenTypes.EXCL; }


  \"                          {
                                stringJustBegun = true;
                                yypushback(1);
                                pushStateAndBegin(YYDOUBLEQUOTESTRING);
                              }

  \'                          {
                                stringJustBegun = true;
                                yypushback(1);
                                pushStateAndBegin(YYSINGLEQUOTESTRING);
                              }

  "\"\"\""                    { pushStateAndBegin(YYDOUBLEQUOTEHEREDOC);
                                return CoffeeScriptTokenTypes.HEREDOC_START; }

  "'''"                       { pushStateAndBegin(YYSINGLEQUOTEHEREDOC);
                                return CoffeeScriptTokenTypes.HEREDOC_START; }

  "`"                         { pushStateAndBegin(YYJAVASCRIPT);
                                return CoffeeScriptTokenTypes.JAVASCRIPT_LITERAL; }

  {OBJECT_KEY}                { pushBackToObjectKey();
                                return CoffeeScriptTokenTypes.IDENTIFIER; }

  {FUNCTION}                  { if (pushBackTo("::")) {
                                  pushStateAndBegin(YYCLASSNAME);
                                  return CoffeeScriptTokenTypes.IDENTIFIER;
                                }
                                pushBackTo(":");
                                return CoffeeScriptTokenTypes.IDENTIFIER;
                              }

  {NUMBER}                    { pushStateAndBegin(YYNUMBER);
                                return CoffeeScriptTokenTypes.NUMBER; }


  "->"                        { return CoffeeScriptTokenTypes.FUNCTION; }
  "=>"                        { return CoffeeScriptTokenTypes.FUNCTION_BIND; }

  "="                         { return CoffeeScriptTokenTypes.EQ; }

  "]"                         { return CoffeeScriptTokenTypes.BRACKET_END; }

  "("                         { return CoffeeScriptTokenTypes.PARENTHESIS_START; }
  ")"                         { return CoffeeScriptTokenTypes.PARENTHESIS_END; }

  /* Push the state because the braces are important for determining the interpolation */
  "{"                         { pushState();
                                if (isInsideInterpolation()) {
                                  int previous = bracesInsideInterpolation.pop();
                                  bracesInsideInterpolation.push(previous + 1);
                                }
                                return CoffeeScriptTokenTypes.BRACE_START; }

  "++"                        { return CoffeeScriptTokenTypes.PLUS_PLUS; }
  "--"                        { return CoffeeScriptTokenTypes.MINUS_MINUS; }

  "."                         { return CoffeeScriptTokenTypes.DOT; }
  "::"                        { return CoffeeScriptTokenTypes.PROTOTYPE; }
  ":"                         { return CoffeeScriptTokenTypes.COLON; }
  ";"                         { return CoffeeScriptTokenTypes.SEMICOLON; }
  ","                         { return CoffeeScriptTokenTypes.COMMA; }

  /* Relation symbols */
  ">"                         { return CoffeeScriptTokenTypes.GT; }
  ">="                        { return CoffeeScriptTokenTypes.GE; }
  "<"                         { return CoffeeScriptTokenTypes.LT; }
  "<="                        { return CoffeeScriptTokenTypes.LE; }
  "=="                        { return CoffeeScriptTokenTypes.EQ_EQ ;}
  "!="                        { return CoffeeScriptTokenTypes.NE; }

  /* Binary operations */
  "+"                         { return CoffeeScriptTokenTypes.PLUS; }
  "-"                         { return CoffeeScriptTokenTypes.MINUS; }
  "*"                         { return CoffeeScriptTokenTypes.MULT; }
  "%"                         { return CoffeeScriptTokenTypes.PERC; }
  "**"                        { return CoffeeScriptTokenTypes.POWER; }
  "//"                        { return CoffeeScriptTokenTypes.FLOOR; }
  "%%"                        { return CoffeeScriptTokenTypes.MODULO; }
  "/"                         { return CoffeeScriptTokenTypes.DIV; }
  "&"                         { return CoffeeScriptTokenTypes.AND; }
  "&&"                        { return CoffeeScriptTokenTypes.AND_AND; }
  "|"                         { return CoffeeScriptTokenTypes.OR; }
  "||"                        { return CoffeeScriptTokenTypes.OR_OR; }
  "^"                         { return CoffeeScriptTokenTypes.XOR; }
  "?"                         { return CoffeeScriptTokenTypes.EXIST; }
  "<<"                        { return CoffeeScriptTokenTypes.LT_LT; }
  ">>"                        { return CoffeeScriptTokenTypes.GT_GT; }
  ">>>"                       { return CoffeeScriptTokenTypes.GT_GT_GT; }

  /* Compound assignment symbols */
  "+="                        { return CoffeeScriptTokenTypes.PLUS_EQ; }
  "-="                        { return CoffeeScriptTokenTypes.MINUS_EQ; }
  "*="                        { return CoffeeScriptTokenTypes.MULT_EQ; }
  "/="                        { return CoffeeScriptTokenTypes.DIV_EQ; }
  "%="                        { return CoffeeScriptTokenTypes.PERC_EQ; }
  "**="                       { return CoffeeScriptTokenTypes.POWER_EQ; }
  "//="                       { return CoffeeScriptTokenTypes.FLOOR_EQ; }
  "%%="                       { return CoffeeScriptTokenTypes.MODULO_EQ; }
  "?="                        { return CoffeeScriptTokenTypes.EXIST_EQ; }
  "&&="                       { return CoffeeScriptTokenTypes.AND_AND_EQ; }
  "&="                        { return CoffeeScriptTokenTypes.AND_EQ; }
  "||="                       { return CoffeeScriptTokenTypes.OR_OR_EQ; }

  "|="                        { return CoffeeScriptTokenTypes.OR_EQ; }
  "?="                        { return CoffeeScriptTokenTypes.EXIST_EQ; }
  "<<="                       { return CoffeeScriptTokenTypes.LT_LT_EQ; }
  ">>="                       { return CoffeeScriptTokenTypes.GT_GT_EQ; }
  ">>>="                      { return CoffeeScriptTokenTypes.GT_GT_GT_EQ; }
  "^="                        { return CoffeeScriptTokenTypes.XOR_EQ; }

  /* Cjsx tags */
  "/>"                        { return CjsxTokenType.DIV_GT; }
  "</"                        { return CjsxTokenType.LT_DIV; }

  "///"                       { pushStateAndBegin(YYHEREGEX);
                                return CoffeeScriptTokenTypes.HEREGEX_START; }

  "/" / [^/= ]                { char c = previousChar();
                                if (c == '=' || c == ' ' || c == ':' || c == '(' || c == '[' || c == '{' || c == ',' || c == (char) -1 || c == '\n' || isOperationSign(c)) {
                                  pushStateAndBegin(YYREGEX);
                                  return CoffeeScriptTokenTypes.REGEX_START;
                                } else {
                                  return CoffeeScriptTokenTypes.DIV;
                                }
                              }

  "..."                       { return CoffeeScriptTokenTypes.SPLAT; }
  ".."                        { return CoffeeScriptTokenTypes.RANGE; }

  {BLOCK_COMMENT}             { return CoffeeScriptTokenTypes.BLOCK_COMMENT; }
  {LINE_COMMENT}              { return CoffeeScriptTokenTypes.LINE_COMMENT; }
}

<YYINITIAL, YYNORMAL> {
  {IDENTIFIER}                { pushStateAndBegin(YYIDENTIFIER);
                                return CoffeeScriptTokenTypes.IDENTIFIER; }

  {WHITE_SPACE}               { return CoffeeScriptTokenTypes.WHITE_SPACE; }
  {SKIP_EOL} / {WHITE_SPACE}*\n   { return CoffeeScriptTokenTypes.SKIP_EOL; }
}

<YYTHIS> {
  {IDENTIFIER}                { popState(); pushStateAndBegin(YYIDENTIFIER);
                                return CoffeeScriptTokenTypes.IDENTIFIER; }

  {WHITE_SPACE}               { popState();
                                return CoffeeScriptTokenTypes.WHITE_SPACE; }
  {SKIP_EOL} / \n                { return CoffeeScriptTokenTypes.SKIP_EOL; }
}

/*********************************************************************************************************************/
/* A closing brace pops a state from the stack. If this state is YYINITIAL, then it is a normal BRACE_END, otherwise */
/* push it back to the steram an let the specific state recognize the special brace type. */
/*********************************************************************************************************************/

<YYINITIAL, YYNORMAL, YYIDENTIFIER, YYNUMBER, YYCLASSNAME, YYTHIS> {
  "}"                         {
                                if (isInsideInterpolation()) {

                                  int value = bracesInsideInterpolation.peek();
                                  if (value == 0) {
                                    popUntilInterpolation();
                                    yypushback(1);
                                    bracesInsideInterpolation.pop();
                                  } else {
                                    int previous = bracesInsideInterpolation.pop();
                                    bracesInsideInterpolation.push(previous - 1);
                                    return CoffeeScriptTokenTypes.BRACE_END;
                                  }
                                } else {
                                  return CoffeeScriptTokenTypes.BRACE_END;
                                }
                              }
}

/*****************************************************************/
/* Characters than can follow an identifier or a number directly */
/*****************************************************************/

<YYIDENTIFIER, YYNUMBER, YYCLASSNAME> {
  "."                         { popState();
                                return CoffeeScriptTokenTypes.DOT; }

  ":"                         { popState();
                                return CoffeeScriptTokenTypes.COLON; }

  ";"                         { return CoffeeScriptTokenTypes.SEMICOLON; }

  "::"                        { popState();
                                return CoffeeScriptTokenTypes.PROTOTYPE; }

  ","                         { popState();
                                return CoffeeScriptTokenTypes.COMMA; }

  "["                         { popState();
                                return CoffeeScriptTokenTypes.BRACKET_START; }

  "]"                         { popState();
                                return CoffeeScriptTokenTypes.BRACKET_END; }

  ")"                         { popState();
                                return CoffeeScriptTokenTypes.PARENTHESIS_END; }

  /* Unary operations */
  "++"                        { return CoffeeScriptTokenTypes.PLUS_PLUS; }
  "--"                        { return CoffeeScriptTokenTypes.MINUS_MINUS; }

  /* Relation symbols */
  ">"                         { popState();
                                return CoffeeScriptTokenTypes.GT; }
  ">="                        { popState();
                                return CoffeeScriptTokenTypes.GE; }
  "<"                         { popState();
                                return CoffeeScriptTokenTypes.LT; }
  "<="                        { popState();
                                return CoffeeScriptTokenTypes.LE; }
  "=="                        { popState();
                                return CoffeeScriptTokenTypes.EQ_EQ; }
  "!="                        { popState();
                                return CoffeeScriptTokenTypes.NE; }

  /* Binary operations */
  "+"                         { popState();
                                return CoffeeScriptTokenTypes.PLUS; }
  "-"                         { popState();
                                return CoffeeScriptTokenTypes.MINUS; }
  "*"                         { popState();
                                return CoffeeScriptTokenTypes.MULT; }
  "%"                         { popState();
                                return CoffeeScriptTokenTypes.PERC; }
  "**"                        { popState();
                                return CoffeeScriptTokenTypes.POWER; }
  "//"                        { popState();
                                return CoffeeScriptTokenTypes.FLOOR; }
  "%%"                        { popState();
                                return CoffeeScriptTokenTypes.MODULO; }
  "/"                         { popState();
                                return CoffeeScriptTokenTypes.DIV; }
  "&"                         { popState();
                                return CoffeeScriptTokenTypes.AND; }
  "&&"                        { popState();
                                return CoffeeScriptTokenTypes.AND_AND; }
  "and"                       { popState();
                                return CoffeeScriptTokenTypes.AND_AND; }
  "|"                         { popState();
                                return CoffeeScriptTokenTypes.OR; }
  "||"                        { popState();
                                return CoffeeScriptTokenTypes.OR_OR; }
  "or"                        { popState();
                                return CoffeeScriptTokenTypes.OR_OR; }
  "^"                         { popState();
                                return CoffeeScriptTokenTypes.XOR; }
  "?"                         { popState();
                                return CoffeeScriptTokenTypes.EXIST; }
  "<<"                        { popState();
                                return CoffeeScriptTokenTypes.LT_LT; }
  ">>"                        { popState();
                                return CoffeeScriptTokenTypes.GT_GT; }
  ">>>"                       { popState();
                                return CoffeeScriptTokenTypes.GT_GT_GT; }

  /* Compound assignment symbols */
  "+="                        { popState();
                                return CoffeeScriptTokenTypes.PLUS_EQ; }
  "-="                        { popState();
                                return CoffeeScriptTokenTypes.MINUS_EQ; }
  "*="                        { popState();
                                return CoffeeScriptTokenTypes.MULT_EQ; }
  "/="                        { popState();
                                return CoffeeScriptTokenTypes.DIV_EQ; }
  "%="                        { popState();
                                return CoffeeScriptTokenTypes.PERC_EQ; }
  "**="                       { popState();
                                return CoffeeScriptTokenTypes.POWER_EQ; }
  "//="                       { popState();
                                return CoffeeScriptTokenTypes.FLOOR_EQ; }
  "%%="                       { popState();
                                return CoffeeScriptTokenTypes.MODULO_EQ; }
  "?="                        { popState();
                                return CoffeeScriptTokenTypes.EXIST_EQ; }
  "&&="                       { popState();
                                return CoffeeScriptTokenTypes.AND_AND_EQ; }
  "and="                      { popState();
                                return CoffeeScriptTokenTypes.AND_AND_EQ; }
  "&="                        { popState();
                                return CoffeeScriptTokenTypes.AND_EQ; }
  "||="                       { popState();
                                return CoffeeScriptTokenTypes.OR_OR_EQ; }
  "or="                       { popState();
                                return CoffeeScriptTokenTypes.OR_OR_EQ; }
  "|="                        { popState();
                                return CoffeeScriptTokenTypes.OR_EQ; }
  "?="                        { popState();
                                return CoffeeScriptTokenTypes.EXIST_EQ; }
  "<<="                       { popState();
                                return CoffeeScriptTokenTypes.LT_LT_EQ; }
  ">>="                       { popState();
                                return CoffeeScriptTokenTypes.GT_GT_EQ; }
  ">>>="                      { popState();
                                return CoffeeScriptTokenTypes.GT_GT_GT_EQ; }
  "^="                        { popState();
                                return CoffeeScriptTokenTypes.XOR_EQ; }

  /* Cjsx tags */
  "/>"                        { popState(); return CjsxTokenType.DIV_GT; }

  {WHITE_SPACE}               { popState();
                                return CoffeeScriptTokenTypes.WHITE_SPACE;}
  {SKIP_EOL} / \n                { return CoffeeScriptTokenTypes.SKIP_EOL; }
}

/**********************************************************************/
/* An identifier has some more characters that can follow it directly */
/**********************************************************************/

<YYIDENTIFIER, YYCLASSNAME> {
  "="                         { popState();
                                return CoffeeScriptTokenTypes.EQ; }

  "("                         { popState();
                                return CoffeeScriptTokenTypes.PARENTHESIS_START; }
}

<YYINITIAL, YYNORMAL, YYIDENTIFIER, YYNUMBER, YYCLASSNAME, YYTHIS> {
  {PROPERTY_PREFIX} (({QUOTE})|({BOOL})|({IDENTIFIER})) / [^\_a-zA-Z0-9]            { if (yystate() != YYINITIAL && yystate() != YYNORMAL) {
                                                                                        popState();
                                                                                      }
                                                                                      pushStateAndBegin(YYQUOTEPROPERTY);
                                                                                      yypushback(yylength()); }
}

/*******************************************************************************/
/* Certain reserved words an keywords are allowed as property of an identifier */
/*******************************************************************************/
<YYQUOTEPROPERTY> {
  "."                         { return CoffeeScriptTokenTypes.DOT; }

  "::"                        { return CoffeeScriptTokenTypes.PROTOTYPE; }

  {QUOTE}                     { popState();
                                return CoffeeScriptTokenTypes.IDENTIFIER; }
  {BOOL}                      { popState();
                                return CoffeeScriptTokenTypes.IDENTIFIER; }
  {IDENTIFIER}                { popState();
                                return CoffeeScriptTokenTypes.IDENTIFIER; }
}


/*****************************************************************/
/* A number has some more characters that can follow it directly */
/*****************************************************************/

<YYNUMBER, YYIDENTIFIER, YYCLASSNAME> {
  ".."                        { popState();
                                return CoffeeScriptTokenTypes.RANGE; }

  "..."                       { popState();
                                return CoffeeScriptTokenTypes.SPLAT; }
}


/**************************/
/* For and for own cycles */
/**************************/
<YYFOR> {
  "own" / {WHITE_SPACE}       { return CoffeeScriptTokenTypes.OWN; }

  {WHITE_SPACE}               { return CoffeeScriptTokenTypes.WHITE_SPACE; }

  [^]                         { yypushback(yytext().length());
                                popState(); }
}

/********************/
/* Escape sequences */
/********************/

<YYSINGLEQUOTEHEREDOC, YYDOUBLEQUOTEHEREDOC> {
  [\\][^\n\r]                 |
  [\\][0-8]{1,3}              |
  [\\]x[0-9a-fA-F]{1,2}       |
  [\\]u[0-9a-fA-F]{1,4}       { return CoffeeScriptTokenTypes.ESCAPE_SEQUENCE; }
}

/*************************************/
/* Content of a single quoted string */
/*************************************/

<YYSINGLEQUOTESTRING> {
  \'                          {
                                if (!stringJustBegun) {
                                  popState();
                                }
                                stringJustBegun = false;

                                return CoffeeScriptTokenTypes.STRING_LITERAL;
                              }

  ([^'\\]|\\\\|\\.|\\\')+     { return CoffeeScriptTokenTypes.STRING_LITERAL; }
  (\\) / \n                   { return CoffeeScriptTokenTypes.STRING_LITERAL; }

  [^]                         { yypushback(yytext().length());
                                popState(); }
}

/*************************************/
/* Content of a double quoted string */
/*************************************/

<YYDOUBLEQUOTESTRING> {
  \"                          {
                                if (!stringJustBegun) {
                                  popState();
                                }
                                stringJustBegun = false;

                                return CoffeeScriptTokenTypes.STRING_LITERAL;
                              }
  "\\\."                      { return CoffeeScriptTokenTypes.STRING_LITERAL; }
  "\\#{"                      { return CoffeeScriptTokenTypes.STRING_LITERAL; }
  "#"                         { return CoffeeScriptTokenTypes.STRING_LITERAL; }
  "#{"                        { yypushback(2);
                                pushStateAndBegin(YYINTERPOLATION); }
  ([^\"\\#]|\\\\|\\.|\\\")+   { return CoffeeScriptTokenTypes.STRING_LITERAL; }

  (\\) / \n                   { return CoffeeScriptTokenTypes.STRING_LITERAL; }
  [^]                         { yypushback(yytext().length());
                                popState(); }
}

/***************************************/
/* Content of a double quoted heredocs */
/***************************************/

<YYSINGLEQUOTEHEREDOC> {
  "'''"                       |
  "'''" / [^\n\r]+            { popState();
                                return CoffeeScriptTokenTypes.HEREDOC_END; }

  [^\n\r\\ \t]+               { pushBackTo("'''");
                                return CoffeeScriptTokenTypes.HEREDOC; }

  {WHITE_SPACE}               { return CoffeeScriptTokenTypes.WHITE_SPACE;}
  {SKIP_EOL} / {WHITE_SPACE}*\n   { return CoffeeScriptTokenTypes.SKIP_EOL; }
  [^]                         { yypushback(yytext().length());
                                popState(); }
}

/***************************************/
/* Content of a double quoted heredocs */
/***************************************/

<YYDOUBLEQUOTEHEREDOC> {
  "\"\"\""                    |
  "\"\"\"" / [^\n\r]+         { popState();
                                return CoffeeScriptTokenTypes.HEREDOC_END; }

  [^\n\r\\ \t]+                 { if (!pushBackAndState("#{", YYINTERPOLATION)) {
                                  pushBackTo("\"\"\"");
                                } else {
                                }
                                if (yylength() != 0) {
                                  return CoffeeScriptTokenTypes.HEREDOC;
                                }
                              }

  {WHITE_SPACE}               { return CoffeeScriptTokenTypes.WHITE_SPACE;}
  {SKIP_EOL} / {WHITE_SPACE}*\n   { return CoffeeScriptTokenTypes.SKIP_EOL; }

  [^]                         { yypushback(yytext().length());
                                popState(); }
}

<YYREGEX> {
  "/"                         |
  "/" / [imgy]{1,4}           { popState();
                                pushStateAndBegin(YYREGEXFLAG);
                                return CoffeeScriptTokenTypes.REGEX_END;
                              }

  {REGEXP}                    { return JSTokenTypes.REGEXP_LITERAL; }

  [^]                         { yypushback(yytext().length());
                                popState(); }
}

/*************************************************/
/* Content of a here doc like regular expression */
/*************************************************/

<YYHEREGEX> {
  "///"                       { popState();
                                return CoffeeScriptTokenTypes.HEREGEX_END; }

  "///" / [imgy]{1,4}         { popState();
                                pushStateAndBegin(YYREGEXFLAG);
                                return CoffeeScriptTokenTypes.HEREGEX_END;
                              }

  "#{"                        { yypushback(2);
                                pushStateAndBegin(YYINTERPOLATION); }

  {HEREGEXP}                  { return CoffeeScriptTokenTypes.HEREGEX_TOKEN; }

  {LINE_COMMENT_INT}              { return CoffeeScriptTokenTypes.LINE_COMMENT; }

  [^]                         { yypushback(yytext().length());
                                popState(); }
}

/*******************************************/
/* Content of the regular expression flags */
/*******************************************/

<YYREGEXFLAG> {
  [imgy]{1,4}                 { popState();
                                return CoffeeScriptTokenTypes.REGEX_FLAG; }

  [ .\[\n\r]                  { popState();
                                yypushback(1);
                              }
  [^]                         { yypushback(yytext().length());
                                popState(); }
}

/*******************************************************************************************/
/* An intermediate interpolation state that pops itself to the stack and starts over again */
/*******************************************************************************************/

<YYINTERPOLATION> {
  "#{"                        { pushStateAndBegin(YYNORMAL);
                                startInterpolation();
                                return CoffeeScriptTokenTypes.INTERPOLATION_START; }

  "}"                         { popState();
                                return CoffeeScriptTokenTypes.INTERPOLATION_END; }

  [^]                         { yypushback(yytext().length());
                                popState(); }
}

/***********************/
/* Embedded JavaScript */
/***********************/

<YYJAVASCRIPT> {
  "`"                         { popState();
                                return CoffeeScriptTokenTypes.JAVASCRIPT_LITERAL; }

  [^`]+                       { return CoffeeScriptTokenTypes.JAVASCRIPT; }

  [^]                         { yypushback(yytext().length());
                                popState(); }
}

/*******************/
/* Nothing matched */
/*******************/

.                             { stack.clear();
                                beginState(YYINITIAL);
                                return CoffeeScriptTokenTypes.BAD_CHARACTER; }
