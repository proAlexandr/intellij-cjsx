/* The following code was generated by JFlex 1.4.3 on 2/22/16 12:52 AM */

package ru.promakh.intellij_cjsx;
import com.intellij.lexer.*;
import com.intellij.psi.tree.IElementType;
import static ru.promakh.intellij_cjsx.psi.CjsxTypes.*;


/**
 * This class is a scanner generated by 
 * <a href="http://www.jflex.de/">JFlex</a> 1.4.3
 * on 2/22/16 12:52 AM from the specification file
 * <tt>/Users/promakh/program/intellij-cjsx-plugin/repository/src/ru/promakh/intellij_cjsx/_CjsxLexer.flex</tt>
 */
public class _CjsxLexer implements FlexLexer {
  /** initial size of the lookahead buffer */
  private static final int ZZ_BUFFERSIZE = 16384;

  /** lexical states */
  public static final int YYINITIAL = 0;

  /**
   * ZZ_LEXSTATE[l] is the state in the DFA for the lexical state l
   * ZZ_LEXSTATE[l+1] is the state in the DFA for the lexical state l
   *                  at the beginning of a line
   * l is of the form l = 2*k, k a non negative integer
   */
  private static final int ZZ_LEXSTATE[] = { 
     0, 0
  };

  /** 
   * Translates characters to character classes
   */
  private static final String ZZ_CMAP_PACKED = 
    "\11\0\1\1\1\2\1\4\1\1\1\1\22\0\1\1\1\0\1\26"+
    "\1\10\1\0\1\32\2\0\1\42\1\43\1\30\3\0\1\7\1\31"+
    "\12\6\1\0\1\3\3\0\1\44\1\0\1\60\1\63\1\65\1\50"+
    "\1\51\1\67\1\56\1\72\1\55\1\62\1\64\1\66\1\74\1\52"+
    "\1\45\1\73\1\5\1\54\1\53\1\47\1\46\1\5\1\71\1\61"+
    "\1\70\1\5\1\0\1\27\2\0\1\57\1\0\1\14\1\11\1\15"+
    "\1\41\1\13\1\23\1\5\1\33\1\22\1\5\1\5\1\24\1\37"+
    "\1\17\1\16\1\34\1\5\1\12\1\25\1\20\1\21\1\5\1\35"+
    "\1\40\1\36\1\5\uff85\0";

  /** 
   * Translates characters to character classes
   */
  private static final char [] ZZ_CMAP = zzUnpackCMap(ZZ_CMAP_PACKED);

  /** 
   * Translates DFA states to action switch labels.
   */
  private static final int [] ZZ_ACTION = zzUnpackAction();

  private static final String ZZ_ACTION_PACKED_0 =
    "\1\0\1\1\1\2\1\3\1\4\2\5\1\6\14\5"+
    "\1\1\3\7\2\5\1\10\1\11\1\12\13\5\1\0"+
    "\1\13\5\5\1\14\5\5\1\15\5\5\1\0\1\16"+
    "\1\0\1\17\11\5\1\20\6\5\1\21\5\5\1\22"+
    "\1\5\1\23\5\5\1\24\3\5\1\16\1\25\1\16"+
    "\1\26\22\5\1\27\3\5\1\30\1\5\1\31\2\5"+
    "\1\32\1\33\2\5\1\34\22\5\1\35\1\36\1\37"+
    "\1\40\1\5\1\41\1\5\1\42\1\43\1\5\1\44"+
    "\2\5\1\45\6\5\1\46\3\5\1\47\2\5\1\50"+
    "\16\5\1\51\1\5\1\52\10\5\1\53\3\5\1\54"+
    "\1\55\2\5\1\56\2\5\1\57\4\5\1\60\2\5"+
    "\1\61\3\5\1\62\5\5\1\63\2\5\1\64\2\5"+
    "\1\65\2\5\1\66\1\67\2\5\1\70\1\5\1\71"+
    "\2\5\1\72";

  private static int [] zzUnpackAction() {
    int [] result = new int[252];
    int offset = 0;
    offset = zzUnpackAction(ZZ_ACTION_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAction(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /** 
   * Translates a state to a row index in the transition table
   */
  private static final int [] ZZ_ROWMAP = zzUnpackRowMap();

  private static final String ZZ_ROWMAP_PACKED_0 =
    "\0\0\0\75\0\172\0\75\0\75\0\267\0\364\0\u0131"+
    "\0\u016e\0\u01ab\0\u01e8\0\u0225\0\u0262\0\u029f\0\u02dc\0\u0319"+
    "\0\u0356\0\u0393\0\u03d0\0\u040d\0\u044a\0\75\0\u0487\0\u04c4"+
    "\0\u0501\0\u053e\0\75\0\75\0\75\0\u057b\0\u05b8\0\u05f5"+
    "\0\u0632\0\u066f\0\u06ac\0\u06e9\0\u0726\0\u0763\0\u07a0\0\u07dd"+
    "\0\u081a\0\267\0\u0857\0\u0894\0\u08d1\0\u090e\0\u094b\0\267"+
    "\0\u0988\0\u09c5\0\u0a02\0\u0a3f\0\u0a7c\0\267\0\u0ab9\0\u0af6"+
    "\0\u0b33\0\u0b70\0\u0bad\0\u0bea\0\u0c27\0\u0c64\0\u0ca1\0\u0cde"+
    "\0\u0d1b\0\u0d58\0\u0d95\0\u0dd2\0\u0e0f\0\u0e4c\0\u0e89\0\u0ec6"+
    "\0\267\0\u0f03\0\u0f40\0\u0f7d\0\u0fba\0\u0ff7\0\u1034\0\u1071"+
    "\0\u10ae\0\u10eb\0\u1128\0\u1165\0\u11a2\0\267\0\u11df\0\267"+
    "\0\u121c\0\u1259\0\u1296\0\u12d3\0\u1310\0\267\0\u134d\0\u138a"+
    "\0\u13c7\0\75\0\75\0\u0bea\0\75\0\u1404\0\u1441\0\u147e"+
    "\0\u14bb\0\u14f8\0\u1535\0\u1572\0\u15af\0\u15ec\0\u1629\0\u1666"+
    "\0\u16a3\0\u16e0\0\u171d\0\u175a\0\u1797\0\u17d4\0\u1811\0\267"+
    "\0\u184e\0\u188b\0\u18c8\0\267\0\u1905\0\267\0\u1942\0\u197f"+
    "\0\267\0\267\0\u19bc\0\u19f9\0\267\0\u1a36\0\u1a73\0\u1ab0"+
    "\0\u1aed\0\u1b2a\0\u1b67\0\u1ba4\0\u1be1\0\u1c1e\0\u1c5b\0\u1c98"+
    "\0\u1cd5\0\u1d12\0\u1d4f\0\u1d8c\0\u1dc9\0\u1e06\0\u1e43\0\267"+
    "\0\267\0\267\0\267\0\u1e80\0\267\0\u1ebd\0\267\0\267"+
    "\0\u1efa\0\u1f37\0\u1f74\0\u1fb1\0\267\0\u1fee\0\u202b\0\u2068"+
    "\0\u20a5\0\u20e2\0\u211f\0\267\0\u215c\0\u2199\0\u21d6\0\267"+
    "\0\u2213\0\u2250\0\267\0\u228d\0\u22ca\0\u2307\0\u2344\0\u2381"+
    "\0\u23be\0\u23fb\0\u2438\0\u2475\0\u24b2\0\u24ef\0\u252c\0\u2569"+
    "\0\u25a6\0\267\0\u25e3\0\267\0\u2620\0\u265d\0\u269a\0\u26d7"+
    "\0\u2714\0\u2751\0\u278e\0\u27cb\0\267\0\u2808\0\u2845\0\u2882"+
    "\0\267\0\267\0\u28bf\0\u28fc\0\267\0\u2939\0\u2976\0\267"+
    "\0\u29b3\0\u29f0\0\u2a2d\0\u2a6a\0\267\0\u2aa7\0\u2ae4\0\267"+
    "\0\u2b21\0\u2b5e\0\u2b9b\0\267\0\u2bd8\0\u2c15\0\u2c52\0\u2c8f"+
    "\0\u2ccc\0\267\0\u2d09\0\u2d46\0\267\0\u2d83\0\u2dc0\0\267"+
    "\0\u2dfd\0\u2e3a\0\267\0\267\0\u2e77\0\u2eb4\0\267\0\u2ef1"+
    "\0\267\0\u2f2e\0\u2f6b\0\267";

  private static int [] zzUnpackRowMap() {
    int [] result = new int[252];
    int offset = 0;
    offset = zzUnpackRowMap(ZZ_ROWMAP_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackRowMap(String packed, int offset, int [] result) {
    int i = 0;  /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int high = packed.charAt(i++) << 16;
      result[j++] = high | packed.charAt(i++);
    }
    return j;
  }

  /** 
   * The transition table of the DFA
   */
  private static final int [] ZZ_TRANS = zzUnpackTrans();

  private static final String ZZ_TRANS_PACKED_0 =
    "\1\2\2\3\1\4\1\5\1\6\1\7\1\2\1\10"+
    "\1\11\1\12\1\13\1\6\1\14\1\15\1\16\1\17"+
    "\1\20\1\21\1\22\1\23\1\24\1\25\1\2\1\26"+
    "\1\27\1\30\2\6\1\31\1\32\3\6\1\33\1\34"+
    "\1\35\1\36\1\37\1\6\1\40\2\6\1\41\1\42"+
    "\1\43\4\6\1\44\2\6\1\45\1\46\1\47\3\6"+
    "\1\50\1\6\76\0\2\3\77\0\2\6\2\0\15\6"+
    "\5\0\7\6\3\0\30\6\5\0\1\6\1\7\1\51"+
    "\1\0\15\6\5\0\7\6\3\0\30\6\2\10\1\0"+
    "\72\10\5\0\2\6\2\0\15\6\5\0\3\6\1\52"+
    "\3\6\3\0\30\6\5\0\2\6\2\0\2\6\1\53"+
    "\12\6\5\0\7\6\3\0\30\6\5\0\2\6\2\0"+
    "\13\6\1\54\1\6\5\0\5\6\1\55\1\6\3\0"+
    "\30\6\5\0\2\6\2\0\3\6\1\56\7\6\1\57"+
    "\1\6\5\0\7\6\3\0\30\6\5\0\2\6\2\0"+
    "\12\6\1\60\2\6\5\0\2\6\1\61\4\6\3\0"+
    "\30\6\5\0\2\6\2\0\10\6\1\62\4\6\5\0"+
    "\7\6\3\0\30\6\5\0\2\6\2\0\1\6\1\63"+
    "\13\6\5\0\1\64\6\6\3\0\30\6\5\0\2\6"+
    "\2\0\6\6\1\65\6\6\5\0\7\6\3\0\30\6"+
    "\5\0\2\6\2\0\6\6\1\66\6\6\5\0\7\6"+
    "\3\0\30\6\5\0\2\6\2\0\1\6\1\67\3\6"+
    "\1\70\7\6\5\0\7\6\3\0\30\6\5\0\2\6"+
    "\2\0\5\6\1\71\7\6\5\0\7\6\3\0\30\6"+
    "\5\0\2\6\2\0\10\6\1\72\4\6\5\0\2\6"+
    "\1\73\4\6\3\0\30\6\26\74\1\75\1\76\45\74"+
    "\31\0\1\77\75\0\1\26\47\0\2\6\2\0\15\6"+
    "\5\0\1\100\6\6\3\0\30\6\5\0\2\6\2\0"+
    "\11\6\1\101\3\6\5\0\7\6\3\0\30\6\5\0"+
    "\2\6\2\0\15\6\5\0\7\6\3\0\1\6\1\102"+
    "\26\6\5\0\2\6\2\0\15\6\5\0\7\6\3\0"+
    "\5\6\1\103\22\6\5\0\2\6\2\0\15\6\5\0"+
    "\7\6\3\0\4\6\1\104\23\6\5\0\2\6\2\0"+
    "\15\6\5\0\7\6\3\0\2\6\1\105\22\6\1\106"+
    "\2\6\5\0\2\6\2\0\15\6\5\0\7\6\3\0"+
    "\4\6\1\107\23\6\5\0\2\6\2\0\15\6\5\0"+
    "\7\6\3\0\5\6\1\110\22\6\5\0\2\6\2\0"+
    "\15\6\5\0\7\6\3\0\6\6\1\111\21\6\5\0"+
    "\2\6\2\0\15\6\5\0\7\6\3\0\1\112\12\6"+
    "\1\113\14\6\5\0\2\6\2\0\15\6\5\0\7\6"+
    "\3\0\1\114\3\6\1\115\23\6\5\0\2\6\2\0"+
    "\15\6\5\0\7\6\3\0\10\6\1\116\17\6\5\0"+
    "\2\6\2\0\15\6\5\0\7\6\3\0\1\117\27\6"+
    "\6\0\1\120\73\0\2\6\2\0\7\6\1\121\5\6"+
    "\5\0\7\6\3\0\30\6\5\0\2\6\2\0\14\6"+
    "\1\122\5\0\7\6\3\0\30\6\5\0\2\6\2\0"+
    "\7\6\1\123\5\6\5\0\7\6\3\0\30\6\5\0"+
    "\2\6\2\0\7\6\1\124\5\6\5\0\7\6\3\0"+
    "\30\6\5\0\2\6\2\0\3\6\1\125\11\6\5\0"+
    "\7\6\3\0\30\6\5\0\2\6\2\0\6\6\1\126"+
    "\6\6\5\0\7\6\3\0\30\6\5\0\2\6\2\0"+
    "\13\6\1\127\1\6\5\0\7\6\3\0\30\6\5\0"+
    "\2\6\2\0\15\6\5\0\3\6\1\130\3\6\3\0"+
    "\30\6\5\0\2\6\2\0\1\6\1\131\7\6\1\132"+
    "\3\6\5\0\7\6\3\0\30\6\5\0\2\6\2\0"+
    "\7\6\1\133\5\6\5\0\6\6\1\134\3\0\30\6"+
    "\5\0\2\6\2\0\5\6\1\135\7\6\5\0\7\6"+
    "\3\0\30\6\5\0\2\6\2\0\1\6\1\136\13\6"+
    "\5\0\7\6\3\0\30\6\5\0\2\6\2\0\5\6"+
    "\1\137\7\6\5\0\7\6\3\0\30\6\5\0\2\6"+
    "\2\0\15\6\5\0\1\6\1\140\5\6\3\0\30\6"+
    "\5\0\2\6\2\0\11\6\1\141\3\6\5\0\7\6"+
    "\3\0\30\6\26\74\1\142\1\76\45\74\26\0\1\143"+
    "\46\0\26\74\1\144\1\76\45\74\31\0\1\145\50\0"+
    "\2\6\2\0\2\6\1\146\6\6\1\147\3\6\5\0"+
    "\7\6\3\0\30\6\5\0\2\6\2\0\2\6\1\150"+
    "\12\6\5\0\7\6\3\0\30\6\5\0\2\6\2\0"+
    "\15\6\5\0\7\6\3\0\2\6\1\151\25\6\5\0"+
    "\2\6\2\0\15\6\5\0\7\6\3\0\13\6\1\152"+
    "\14\6\5\0\2\6\2\0\15\6\5\0\7\6\3\0"+
    "\16\6\1\153\11\6\5\0\2\6\2\0\15\6\5\0"+
    "\7\6\3\0\7\6\1\154\20\6\5\0\2\6\2\0"+
    "\15\6\5\0\7\6\3\0\10\6\1\155\17\6\5\0"+
    "\2\6\2\0\15\6\5\0\7\6\3\0\11\6\1\156"+
    "\7\6\1\157\6\6\5\0\2\6\2\0\15\6\5\0"+
    "\7\6\3\0\3\6\1\160\24\6\5\0\2\6\2\0"+
    "\15\6\5\0\7\6\3\0\27\6\1\161\5\0\2\6"+
    "\2\0\15\6\5\0\7\6\3\0\21\6\1\162\6\6"+
    "\5\0\2\6\2\0\15\6\5\0\7\6\3\0\11\6"+
    "\1\163\16\6\5\0\2\6\2\0\15\6\5\0\7\6"+
    "\3\0\13\6\1\164\14\6\5\0\2\6\2\0\15\6"+
    "\5\0\7\6\3\0\5\6\1\165\22\6\5\0\2\6"+
    "\2\0\15\6\5\0\7\6\3\0\6\6\1\166\21\6"+
    "\6\0\1\120\1\51\72\0\2\6\2\0\10\6\1\167"+
    "\4\6\5\0\7\6\3\0\30\6\5\0\2\6\2\0"+
    "\2\6\1\170\12\6\5\0\7\6\3\0\30\6\5\0"+
    "\2\6\2\0\2\6\1\171\12\6\5\0\7\6\3\0"+
    "\30\6\5\0\2\6\2\0\4\6\1\172\10\6\5\0"+
    "\7\6\3\0\30\6\5\0\2\6\2\0\14\6\1\173"+
    "\5\0\7\6\3\0\30\6\5\0\2\6\2\0\13\6"+
    "\1\174\1\6\5\0\7\6\3\0\30\6\5\0\2\6"+
    "\2\0\5\6\1\175\7\6\5\0\7\6\3\0\30\6"+
    "\5\0\2\6\2\0\14\6\1\176\5\0\7\6\3\0"+
    "\30\6\5\0\2\6\2\0\11\6\1\177\3\6\5\0"+
    "\7\6\3\0\30\6\5\0\2\6\2\0\2\6\1\200"+
    "\12\6\5\0\7\6\3\0\30\6\5\0\2\6\2\0"+
    "\15\6\5\0\4\6\1\201\2\6\3\0\30\6\5\0"+
    "\2\6\2\0\15\6\5\0\1\6\1\202\5\6\3\0"+
    "\30\6\5\0\2\6\2\0\2\6\1\203\12\6\5\0"+
    "\7\6\3\0\30\6\5\0\2\6\2\0\7\6\1\204"+
    "\5\6\5\0\7\6\3\0\30\6\5\0\2\6\2\0"+
    "\6\6\1\205\6\6\5\0\7\6\3\0\30\6\5\0"+
    "\2\6\2\0\13\6\1\206\1\6\5\0\7\6\3\0"+
    "\30\6\5\0\2\6\2\0\13\6\1\207\1\6\5\0"+
    "\7\6\3\0\30\6\5\0\2\6\2\0\15\6\5\0"+
    "\7\6\3\0\3\6\1\210\24\6\5\0\2\6\2\0"+
    "\15\6\5\0\7\6\3\0\7\6\1\211\20\6\5\0"+
    "\2\6\2\0\15\6\5\0\7\6\3\0\1\6\1\212"+
    "\26\6\5\0\2\6\2\0\15\6\5\0\7\6\3\0"+
    "\10\6\1\213\17\6\5\0\2\6\2\0\15\6\5\0"+
    "\7\6\3\0\22\6\1\214\5\6\5\0\2\6\2\0"+
    "\15\6\5\0\7\6\3\0\4\6\1\215\23\6\5\0"+
    "\2\6\2\0\15\6\5\0\7\6\3\0\13\6\1\216"+
    "\14\6\5\0\2\6\2\0\15\6\5\0\7\6\3\0"+
    "\4\6\1\217\23\6\5\0\2\6\2\0\15\6\5\0"+
    "\7\6\3\0\26\6\1\220\1\6\5\0\2\6\2\0"+
    "\15\6\5\0\7\6\3\0\21\6\1\221\6\6\5\0"+
    "\2\6\2\0\15\6\5\0\7\6\3\0\10\6\1\222"+
    "\17\6\5\0\2\6\2\0\15\6\5\0\7\6\3\0"+
    "\3\6\1\223\24\6\5\0\2\6\2\0\15\6\5\0"+
    "\7\6\3\0\13\6\1\224\14\6\5\0\2\6\2\0"+
    "\15\6\5\0\7\6\3\0\2\6\1\225\25\6\5\0"+
    "\2\6\2\0\1\6\1\226\13\6\5\0\7\6\3\0"+
    "\30\6\5\0\2\6\2\0\6\6\1\227\6\6\5\0"+
    "\7\6\3\0\30\6\5\0\2\6\2\0\15\6\5\0"+
    "\1\230\6\6\3\0\30\6\5\0\2\6\2\0\14\6"+
    "\1\231\5\0\7\6\3\0\30\6\5\0\2\6\2\0"+
    "\15\6\5\0\2\6\1\232\4\6\3\0\30\6\5\0"+
    "\2\6\2\0\13\6\1\233\1\6\5\0\7\6\3\0"+
    "\30\6\5\0\2\6\2\0\12\6\1\234\2\6\5\0"+
    "\7\6\3\0\30\6\5\0\2\6\2\0\1\6\1\235"+
    "\13\6\5\0\7\6\3\0\30\6\5\0\2\6\2\0"+
    "\4\6\1\236\10\6\5\0\7\6\3\0\30\6\5\0"+
    "\2\6\2\0\2\6\1\237\12\6\5\0\7\6\3\0"+
    "\30\6\5\0\2\6\2\0\15\6\5\0\6\6\1\240"+
    "\3\0\30\6\5\0\2\6\2\0\15\6\5\0\7\6"+
    "\3\0\4\6\1\241\23\6\5\0\2\6\2\0\15\6"+
    "\5\0\7\6\3\0\23\6\1\242\4\6\5\0\2\6"+
    "\2\0\15\6\5\0\7\6\3\0\11\6\1\243\16\6"+
    "\5\0\2\6\2\0\15\6\5\0\7\6\3\0\5\6"+
    "\1\244\22\6\5\0\2\6\2\0\15\6\5\0\7\6"+
    "\3\0\2\6\1\245\25\6\5\0\2\6\2\0\15\6"+
    "\5\0\7\6\3\0\14\6\1\246\13\6\5\0\2\6"+
    "\2\0\15\6\5\0\7\6\3\0\2\6\1\247\25\6"+
    "\5\0\2\6\2\0\15\6\5\0\7\6\3\0\14\6"+
    "\1\250\13\6\5\0\2\6\2\0\15\6\5\0\7\6"+
    "\3\0\1\251\12\6\1\252\14\6\5\0\2\6\2\0"+
    "\15\6\5\0\7\6\3\0\12\6\1\253\15\6\5\0"+
    "\2\6\2\0\15\6\5\0\7\6\3\0\20\6\1\254"+
    "\7\6\5\0\2\6\2\0\15\6\5\0\7\6\3\0"+
    "\10\6\1\255\17\6\5\0\2\6\2\0\15\6\5\0"+
    "\7\6\3\0\21\6\1\256\6\6\5\0\2\6\2\0"+
    "\15\6\5\0\7\6\3\0\12\6\1\257\15\6\5\0"+
    "\2\6\2\0\6\6\1\260\6\6\5\0\7\6\3\0"+
    "\30\6\5\0\2\6\2\0\15\6\5\0\6\6\1\261"+
    "\3\0\30\6\5\0\2\6\2\0\11\6\1\262\3\6"+
    "\5\0\7\6\3\0\30\6\5\0\2\6\2\0\15\6"+
    "\5\0\1\263\6\6\3\0\30\6\5\0\2\6\2\0"+
    "\15\6\5\0\7\6\3\0\5\6\1\264\22\6\5\0"+
    "\2\6\2\0\15\6\5\0\7\6\3\0\12\6\1\265"+
    "\15\6\5\0\2\6\2\0\15\6\5\0\7\6\3\0"+
    "\11\6\1\266\16\6\5\0\2\6\2\0\15\6\5\0"+
    "\7\6\3\0\11\6\1\267\16\6\5\0\2\6\2\0"+
    "\15\6\5\0\7\6\3\0\12\6\1\270\15\6\5\0"+
    "\2\6\2\0\15\6\5\0\7\6\3\0\10\6\1\271"+
    "\17\6\5\0\2\6\2\0\15\6\5\0\7\6\3\0"+
    "\12\6\1\272\15\6\5\0\2\6\2\0\15\6\5\0"+
    "\7\6\3\0\1\6\1\273\26\6\5\0\2\6\2\0"+
    "\15\6\5\0\7\6\3\0\7\6\1\274\20\6\5\0"+
    "\2\6\2\0\15\6\5\0\7\6\3\0\4\6\1\275"+
    "\1\6\1\276\21\6\5\0\2\6\2\0\15\6\5\0"+
    "\7\6\3\0\5\6\1\277\22\6\5\0\2\6\2\0"+
    "\15\6\5\0\7\6\3\0\21\6\1\300\6\6\5\0"+
    "\2\6\2\0\15\6\5\0\7\6\3\0\10\6\1\301"+
    "\17\6\5\0\2\6\2\0\14\6\1\302\5\0\7\6"+
    "\3\0\30\6\5\0\2\6\2\0\6\6\1\303\6\6"+
    "\5\0\7\6\3\0\30\6\5\0\2\6\2\0\15\6"+
    "\5\0\7\6\3\0\2\6\1\304\25\6\5\0\2\6"+
    "\2\0\15\6\5\0\7\6\3\0\27\6\1\305\5\0"+
    "\2\6\2\0\15\6\5\0\7\6\3\0\4\6\1\306"+
    "\23\6\5\0\2\6\2\0\15\6\5\0\7\6\3\0"+
    "\12\6\1\307\15\6\5\0\2\6\2\0\15\6\5\0"+
    "\7\6\3\0\6\6\1\310\21\6\5\0\2\6\2\0"+
    "\15\6\5\0\7\6\3\0\1\311\27\6\5\0\2\6"+
    "\2\0\15\6\5\0\7\6\3\0\4\6\1\312\1\6"+
    "\1\313\21\6\5\0\2\6\2\0\15\6\5\0\7\6"+
    "\3\0\5\6\1\314\22\6\5\0\2\6\2\0\15\6"+
    "\5\0\7\6\3\0\4\6\1\315\23\6\5\0\2\6"+
    "\2\0\15\6\5\0\7\6\3\0\5\6\1\316\22\6"+
    "\5\0\2\6\2\0\15\6\5\0\7\6\3\0\2\6"+
    "\1\317\25\6\5\0\2\6\2\0\15\6\5\0\7\6"+
    "\3\0\11\6\1\320\16\6\5\0\2\6\2\0\15\6"+
    "\5\0\7\6\3\0\23\6\1\321\4\6\5\0\2\6"+
    "\2\0\15\6\5\0\7\6\3\0\22\6\1\322\5\6"+
    "\5\0\2\6\2\0\2\6\1\323\12\6\5\0\7\6"+
    "\3\0\30\6\5\0\2\6\2\0\15\6\5\0\7\6"+
    "\3\0\13\6\1\324\14\6\5\0\2\6\2\0\15\6"+
    "\5\0\7\6\3\0\7\6\1\325\20\6\5\0\2\6"+
    "\2\0\15\6\5\0\7\6\3\0\6\6\1\326\21\6"+
    "\5\0\2\6\2\0\15\6\5\0\7\6\3\0\2\6"+
    "\1\327\25\6\5\0\2\6\2\0\15\6\5\0\7\6"+
    "\3\0\5\6\1\330\22\6\5\0\2\6\2\0\15\6"+
    "\5\0\7\6\3\0\5\6\1\331\22\6\5\0\2\6"+
    "\2\0\15\6\5\0\7\6\3\0\1\332\1\6\1\333"+
    "\25\6\5\0\2\6\2\0\15\6\5\0\7\6\3\0"+
    "\3\6\1\334\24\6\5\0\2\6\2\0\15\6\5\0"+
    "\7\6\3\0\3\6\1\335\24\6\5\0\2\6\2\0"+
    "\15\6\5\0\7\6\3\0\13\6\1\336\14\6\5\0"+
    "\2\6\2\0\15\6\5\0\7\6\3\0\12\6\1\337"+
    "\15\6\5\0\2\6\2\0\15\6\5\0\6\6\1\340"+
    "\3\0\30\6\5\0\2\6\2\0\15\6\5\0\7\6"+
    "\3\0\2\6\1\341\25\6\5\0\2\6\2\0\15\6"+
    "\5\0\7\6\3\0\2\6\1\342\25\6\5\0\2\6"+
    "\2\0\15\6\5\0\7\6\3\0\13\6\1\343\14\6"+
    "\5\0\2\6\2\0\15\6\5\0\7\6\3\0\3\6"+
    "\1\344\24\6\5\0\2\6\2\0\15\6\5\0\7\6"+
    "\3\0\13\6\1\345\14\6\5\0\2\6\2\0\15\6"+
    "\5\0\7\6\3\0\13\6\1\346\14\6\5\0\2\6"+
    "\2\0\15\6\5\0\7\6\3\0\12\6\1\347\15\6"+
    "\5\0\2\6\2\0\15\6\5\0\7\6\3\0\7\6"+
    "\1\350\20\6\5\0\2\6\2\0\15\6\5\0\7\6"+
    "\3\0\24\6\1\351\3\6\5\0\2\6\2\0\15\6"+
    "\5\0\7\6\3\0\25\6\1\352\2\6\5\0\2\6"+
    "\2\0\15\6\5\0\7\6\3\0\13\6\1\353\14\6"+
    "\5\0\2\6\2\0\15\6\5\0\7\6\3\0\7\6"+
    "\1\354\20\6\5\0\2\6\2\0\15\6\5\0\7\6"+
    "\3\0\17\6\1\355\10\6\5\0\2\6\2\0\15\6"+
    "\5\0\7\6\3\0\7\6\1\356\20\6\5\0\2\6"+
    "\2\0\15\6\5\0\7\6\3\0\13\6\1\357\14\6"+
    "\5\0\2\6\2\0\15\6\5\0\7\6\3\0\2\6"+
    "\1\360\25\6\5\0\2\6\2\0\15\6\5\0\7\6"+
    "\3\0\25\6\1\361\2\6\5\0\2\6\2\0\15\6"+
    "\5\0\7\6\3\0\7\6\1\362\20\6\5\0\2\6"+
    "\2\0\15\6\5\0\7\6\3\0\2\6\1\363\25\6"+
    "\5\0\2\6\2\0\15\6\5\0\7\6\3\0\2\6"+
    "\1\364\25\6\5\0\2\6\2\0\15\6\5\0\7\6"+
    "\3\0\6\6\1\365\21\6\5\0\2\6\2\0\15\6"+
    "\5\0\7\6\3\0\4\6\1\366\23\6\5\0\2\6"+
    "\2\0\15\6\5\0\7\6\3\0\2\6\1\367\25\6"+
    "\5\0\2\6\2\0\15\6\5\0\7\6\3\0\6\6"+
    "\1\370\21\6\5\0\2\6\2\0\15\6\5\0\7\6"+
    "\3\0\5\6\1\371\22\6\5\0\2\6\2\0\15\6"+
    "\5\0\7\6\3\0\10\6\1\372\17\6\5\0\2\6"+
    "\2\0\15\6\5\0\7\6\3\0\11\6\1\373\16\6"+
    "\5\0\2\6\2\0\15\6\5\0\7\6\3\0\5\6"+
    "\1\374\22\6";

  private static int [] zzUnpackTrans() {
    int [] result = new int[12200];
    int offset = 0;
    offset = zzUnpackTrans(ZZ_TRANS_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackTrans(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      value--;
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /* error codes */
  private static final int ZZ_UNKNOWN_ERROR = 0;
  private static final int ZZ_NO_MATCH = 1;
  private static final int ZZ_PUSHBACK_2BIG = 2;
  private static final char[] EMPTY_BUFFER = new char[0];
  private static final int YYEOF = -1;
  private static java.io.Reader zzReader = null; // Fake

  /* error messages for the codes above */
  private static final String ZZ_ERROR_MSG[] = {
    "Unkown internal scanner error",
    "Error: could not match input",
    "Error: pushback value was too large"
  };

  /**
   * ZZ_ATTRIBUTE[aState] contains the attributes of state <code>aState</code>
   */
  private static final int [] ZZ_ATTRIBUTE = zzUnpackAttribute();

  private static final String ZZ_ATTRIBUTE_PACKED_0 =
    "\1\0\1\11\1\1\2\11\20\1\1\11\4\1\3\11"+
    "\13\1\1\0\22\1\1\0\1\1\1\0\43\1\2\11"+
    "\1\1\1\11\227\1";

  private static int [] zzUnpackAttribute() {
    int [] result = new int[252];
    int offset = 0;
    offset = zzUnpackAttribute(ZZ_ATTRIBUTE_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAttribute(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }

  /** the current state of the DFA */
  private int zzState;

  /** the current lexical state */
  private int zzLexicalState = YYINITIAL;

  /** this buffer contains the current text to be matched and is
      the source of the yytext() string */
  private CharSequence zzBuffer = "";

  /** this buffer may contains the current text array to be matched when it is cheap to acquire it */
  private char[] zzBufferArray;

  /** the textposition at the last accepting state */
  private int zzMarkedPos;

  /** the textposition at the last state to be included in yytext */
  private int zzPushbackPos;

  /** the current text position in the buffer */
  private int zzCurrentPos;

  /** startRead marks the beginning of the yytext() string in the buffer */
  private int zzStartRead;

  /** endRead marks the last character in the buffer, that has been read
      from input */
  private int zzEndRead;

  /**
   * zzAtBOL == true <=> the scanner is currently at the beginning of a line
   */
  private boolean zzAtBOL = true;

  /** zzAtEOF == true <=> the scanner is at the EOF */
  private boolean zzAtEOF;

  /* user code: */
  public _CjsxLexer() {
    this((java.io.Reader)null);
  }


  /**
   * Creates a new scanner
   *
   * @param   in  the java.io.Reader to read input from.
   */
  public _CjsxLexer(java.io.Reader in) {
    this.zzReader = in;
  }


  /** 
   * Unpacks the compressed character translation table.
   *
   * @param packed   the packed character translation table
   * @return         the unpacked character translation table
   */
  private static char [] zzUnpackCMap(String packed) {
    char [] map = new char[0x10000];
    int i = 0;  /* index in packed string  */
    int j = 0;  /* index in unpacked array */
    while (i < 168) {
      int  count = packed.charAt(i++);
      char value = packed.charAt(i++);
      do map[j++] = value; while (--count > 0);
    }
    return map;
  }

  public final int getTokenStart(){
    return zzStartRead;
  }

  public final int getTokenEnd(){
    return getTokenStart() + yylength();
  }

  public void reset(CharSequence buffer, int start, int end,int initialState){
    zzBuffer = buffer;
    zzBufferArray = com.intellij.util.text.CharArrayUtil.fromSequenceWithoutCopying(buffer);
    zzCurrentPos = zzMarkedPos = zzStartRead = start;
    zzPushbackPos = 0;
    zzAtEOF  = false;
    zzAtBOL = true;
    zzEndRead = end;
    yybegin(initialState);
  }

  /**
   * Refills the input buffer.
   *
   * @return      <code>false</code>, iff there was new input.
   *
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  private boolean zzRefill() throws java.io.IOException {
    return true;
  }


  /**
   * Returns the current lexical state.
   */
  public final int yystate() {
    return zzLexicalState;
  }


  /**
   * Enters a new lexical state
   *
   * @param newState the new lexical state
   */
  public final void yybegin(int newState) {
    zzLexicalState = newState;
  }


  /**
   * Returns the text matched by the current regular expression.
   */
  public final CharSequence yytext() {
    return zzBuffer.subSequence(zzStartRead, zzMarkedPos);
  }


  /**
   * Returns the character at position <tt>pos</tt> from the
   * matched text.
   *
   * It is equivalent to yytext().charAt(pos), but faster
   *
   * @param pos the position of the character to fetch.
   *            A value from 0 to yylength()-1.
   *
   * @return the character at position pos
   */
  public final char yycharat(int pos) {
    return zzBufferArray != null ? zzBufferArray[zzStartRead+pos]:zzBuffer.charAt(zzStartRead+pos);
  }


  /**
   * Returns the length of the matched text region.
   */
  public final int yylength() {
    return zzMarkedPos-zzStartRead;
  }


  /**
   * Reports an error that occured while scanning.
   *
   * In a wellformed scanner (no or only correct usage of
   * yypushback(int) and a match-all fallback rule) this method
   * will only be called with things that "Can't Possibly Happen".
   * If this method is called, something is seriously wrong
   * (e.g. a JFlex bug producing a faulty scanner etc.).
   *
   * Usual syntax/scanner level error handling should be done
   * in error fallback rules.
   *
   * @param   errorCode  the code of the errormessage to display
   */
  private void zzScanError(int errorCode) {
    String message;
    try {
      message = ZZ_ERROR_MSG[errorCode];
    }
    catch (ArrayIndexOutOfBoundsException e) {
      message = ZZ_ERROR_MSG[ZZ_UNKNOWN_ERROR];
    }

    throw new Error(message);
  }


  /**
   * Pushes the specified amount of characters back into the input stream.
   *
   * They will be read again by then next call of the scanning method
   *
   * @param number  the number of characters to be read again.
   *                This number must not be greater than yylength()!
   */
  public void yypushback(int number)  {
    if ( number > yylength() )
      zzScanError(ZZ_PUSHBACK_2BIG);

    zzMarkedPos -= number;
  }


  /**
   * Resumes scanning until the next regular expression is matched,
   * the end of input is encountered or an I/O-Error occurs.
   *
   * @return      the next token
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  public IElementType advance() throws java.io.IOException {
    int zzInput;
    int zzAction;

    // cached fields:
    int zzCurrentPosL;
    int zzMarkedPosL;
    int zzEndReadL = zzEndRead;
    CharSequence zzBufferL = zzBuffer;
    char[] zzBufferArrayL = zzBufferArray;
    char [] zzCMapL = ZZ_CMAP;

    int [] zzTransL = ZZ_TRANS;
    int [] zzRowMapL = ZZ_ROWMAP;
    int [] zzAttrL = ZZ_ATTRIBUTE;

    while (true) {
      zzMarkedPosL = zzMarkedPos;

      zzAction = -1;

      zzCurrentPosL = zzCurrentPos = zzStartRead = zzMarkedPosL;

      zzState = ZZ_LEXSTATE[zzLexicalState];


      zzForAction: {
        while (true) {

          if (zzCurrentPosL < zzEndReadL)
            zzInput = (zzBufferArrayL != null ? zzBufferArrayL[zzCurrentPosL++] : zzBufferL.charAt(zzCurrentPosL++));
          else if (zzAtEOF) {
            zzInput = YYEOF;
            break zzForAction;
          }
          else {
            // store back cached positions
            zzCurrentPos  = zzCurrentPosL;
            zzMarkedPos   = zzMarkedPosL;
            boolean eof = zzRefill();
            // get translated positions and possibly new buffer
            zzCurrentPosL  = zzCurrentPos;
            zzMarkedPosL   = zzMarkedPos;
            zzBufferL      = zzBuffer;
            zzEndReadL     = zzEndRead;
            if (eof) {
              zzInput = YYEOF;
              break zzForAction;
            }
            else {
              zzInput = (zzBufferArrayL != null ? zzBufferArrayL[zzCurrentPosL++] : zzBufferL.charAt(zzCurrentPosL++));
            }
          }
          int zzNext = zzTransL[ zzRowMapL[zzState] + zzCMapL[zzInput] ];
          if (zzNext == -1) break zzForAction;
          zzState = zzNext;

          int zzAttributes = zzAttrL[zzState];
          if ( (zzAttributes & 1) == 1 ) {
            zzAction = zzState;
            zzMarkedPosL = zzCurrentPosL;
            if ( (zzAttributes & 8) == 8 ) break zzForAction;
          }

        }
      }

      // store back cached position
      zzMarkedPos = zzMarkedPosL;

      switch (zzAction < 0 ? zzAction : ZZ_ACTION[zzAction]) {
        case 39: 
          { return RETURN_T;
          }
        case 59: break;
        case 5: 
          { return IDENTIFIER_T;
          }
        case 60: break;
        case 25: 
          { return THIS_T;
          }
        case 61: break;
        case 28: 
          { return WHEN_T;
          }
        case 62: break;
        case 12: 
          { return FOROF;
          }
        case 63: break;
        case 49: 
          { return UNDEFINED;
          }
        case 64: break;
        case 50: 
          { return INDEX_END;
          }
        case 65: break;
        case 31: 
          { return THROW_T;
          }
        case 66: break;
        case 34: 
          { return WHILE_T;
          }
        case 67: break;
        case 13: 
          { return FORIN;
          }
        case 68: break;
        case 35: 
          { return YIELD;
          }
        case 69: break;
        case 56: 
          { return STRING_START;
          }
        case 70: break;
        case 17: 
          { return NUMBER;
          }
        case 71: break;
        case 30: 
          { return CLASS_T;
          }
        case 72: break;
        case 55: 
          { return INDEX_START;
          }
        case 73: break;
        case 43: 
          { return COMPARE;
          }
        case 74: break;
        case 38: 
          { return LOGIC;
          }
        case 75: break;
        case 45: 
          { return POST_IF;
          }
        case 76: break;
        case 53: 
          { return CALL_START;
          }
        case 77: break;
        case 42: 
          { return OUTDENT;
          }
        case 78: break;
        case 22: 
          { return REGEX_END;
          }
        case 79: break;
        case 15: 
          { return REGEX_T;
          }
        case 80: break;
        case 9: 
          { return PARAM_END;
          }
        case 81: break;
        case 24: 
          { return NULL;
          }
        case 82: break;
        case 37: 
          { return SHIFT;
          }
        case 83: break;
        case 51: 
          { return UNARY_MATH;
          }
        case 84: break;
        case 41: 
          { return EXTENDS;
          }
        case 85: break;
        case 48: 
          { return CALL_END;
          }
        case 86: break;
        case 36: 
          { return UNARY;
          }
        case 87: break;
        case 33: 
          { return SUPER;
          }
        case 88: break;
        case 14: 
          { return STRING_T;
          }
        case 89: break;
        case 58: 
          { return COMPOUND_ASSIGN;
          }
        case 90: break;
        case 11: 
          { return BY;
          }
        case 91: break;
        case 3: 
          { return TERMINATOR;
          }
        case 92: break;
        case 4: 
          { return INDENT;
          }
        case 93: break;
        case 32: 
          { return UNTIL;
          }
        case 94: break;
        case 16: 
          { return JS;
          }
        case 95: break;
        case 20: 
          { return FOR_T;
          }
        case 96: break;
        case 27: 
          { return LOOP_T;
          }
        case 97: break;
        case 23: 
          { return ELSE;
          }
        case 98: break;
        case 21: 
          { return STRING_END;
          }
        case 99: break;
        case 8: 
          { return PARAM_START;
          }
        case 100: break;
        case 26: 
          { return FROM;
          }
        case 101: break;
        case 46: 
          { return DEBUGGER;
          }
        case 102: break;
        case 57: 
          { return LEADING_WHEN;
          }
        case 103: break;
        case 2: 
          { return com.intellij.psi.TokenType.WHITE_SPACE;
          }
        case 104: break;
        case 10: 
          { return FUNC_EXIST;
          }
        case 105: break;
        case 54: 
          { return REGEX_START;
          }
        case 106: break;
        case 52: 
          { return INDEX_SOAK;
          }
        case 107: break;
        case 47: 
          { return RELATION;
          }
        case 108: break;
        case 44: 
          { return FINALLY;
          }
        case 109: break;
        case 18: 
          { return OWN;
          }
        case 110: break;
        case 7: 
          { return MATH;
          }
        case 111: break;
        case 40: 
          { return SWITCH_T;
          }
        case 112: break;
        case 29: 
          { return CATCH_T;
          }
        case 113: break;
        case 19: 
          { return TRY_T;
          }
        case 114: break;
        case 1: 
          { return com.intellij.psi.TokenType.BAD_CHARACTER;
          }
        case 115: break;
        case 6: 
          { return HERECOMMENT;
          }
        case 116: break;
        default:
          if (zzInput == YYEOF && zzStartRead == zzCurrentPos) {
            zzAtEOF = true;
            return null;
          }
          else {
            zzScanError(ZZ_NO_MATCH);
          }
      }
    }
  }


}
