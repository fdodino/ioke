grammar ioke;

options { 
    output = AST; 
    backtrack = true;
}

tokens {
    MESSAGE_SEND;
    MESSAGE_SEND_OP;
    MESSAGE_SEND_EMPTY;
}

@lexer::header {
package ioke.lang.parser;
}

@header {
package ioke.lang.parser;
}

@members {
  protected void mismatch(IntStream input, int ttype, BitSet follow) throws RecognitionException {
    throw new MismatchedTokenException(ttype, input);
  }

  public Object recoverFromMismatchedSet(IntStream input, RecognitionException e, BitSet follow) throws RecognitionException {
			reportError(e);
    throw e;
  }

  public Tree parseFully() throws RecognitionException {
      messageChain_return result = messageChain();
      return result == null ? (Tree)null : (Tree)(result.getTree());
  }

  public boolean print(String s) {
      System.err.println(s);
      return true;
  }
}

@rulecatch {
  catch(RecognitionException e) {
    throw e;
  }
}

@lexer::members {
    public Token nextToken() {
        Token t = super.nextToken();
//        System.err.println("RETURNING TOKEN: " + t);
        return t;
    }


  public void reportError(RecognitionException e) {
    displayRecognitionError(this.getTokenNames(), e);
    throw new RuntimeException(e);
  }

  private final static Object IPOL_STRING = new Object();
  private final static Object IPOL_ALT_STRING = new Object();
  private final static Object IPOL_REGEXP = new Object();
  private final static Object IPOL_ALT_REGEXP = new Object();
  private java.util.List<Object> interpolation = new java.util.LinkedList<Object>();

  public void startInterpolation() {
      interpolation.add(0, IPOL_STRING);
  }

  public void startAltInterpolation() {
      interpolation.add(0, IPOL_ALT_STRING);
  }

  public void startRegexpInterpolation() {
      interpolation.add(0, IPOL_REGEXP);
  }

  public void startAltRegexpInterpolation() {
      interpolation.add(0, IPOL_REGEXP);
  }

  public void endInterpolation() {
      interpolation.remove(0);
  }

  public void endAltInterpolation() {
      interpolation.remove(0);
  }

  public void endRegexpInterpolation() {
      interpolation.remove(0);
  }

  public void endAltRegexpInterpolation() {
      interpolation.remove(0);
  }

  public boolean isInterpolating() {
      return interpolation.size() > 0 && interpolation.get(0) == IPOL_STRING;
  }

  public boolean isAltInterpolating() {
      return interpolation.size() > 0 && interpolation.get(0) == IPOL_ALT_STRING;
  }

  public boolean isRegexpInterpolating() {
      return interpolation.size() > 0 && interpolation.get(0) == IPOL_REGEXP;
  }

  public boolean isAltRegexpInterpolating() {
      return interpolation.size() > 0 && interpolation.get(0) == IPOL_ALT_REGEXP;
  }
}

messageChain
    :
        expression* EOF!
    ;

commatedExpression
    :
        expression+ (Comma expression+)*
    ;

expression
    :
        Identifier (OpenParen commatedExpression? CloseParen)? -> ^(MESSAGE_SEND Identifier commatedExpression?)
    |   operator OpenParen commatedExpression? CloseParen -> ^(MESSAGE_SEND_OP operator OpenParen commatedExpression?)
    |   OpenParen commatedExpression? CloseParen -> ^(MESSAGE_SEND_EMPTY commatedExpression?)
    |   '[' ']'                          -> ^(MESSAGE_SEND Identifier["[]"])
    |   '{' '}'                          -> ^(MESSAGE_SEND Identifier["{}"])
    |   '[' commatedExpression ']'       -> ^(MESSAGE_SEND Identifier["[]"] commatedExpression)
    |   '{' commatedExpression '}'       -> ^(MESSAGE_SEND Identifier["{}"] commatedExpression)
    |   operator
    |   literals
    |   Terminator
    ;

literals
    :
        StringLiteral
    |   RegexpLiteral
    |   NumberLiteral
    |   DecimalLiteral
    |   UnitLiteral
    ;

OpenParen
    :
        '('
    ;

CloseParen
    :
        ')'
    ;

operator
    :
        BinaryOperator
    ;

Identifier
    :
        ('@')+
    |   ('\'')+
    |   ('`')+
    |   '[]'
    |   '{}'
    |   (Letter|':') (Letter|IDDigit|StrangeChars)*
    ;

DecimalLiteral
    :
    ;

fragment
UnitLiteral
    :
    ;

fragment
UnitDecimalLiteral
    :
    ;

NumberLiteral
    :
		'0'	('x'|'X') HexDigit+
    |   '0' (
            {(input.LA(2)>='0')&&(input.LA(2)<='9')}?=> (FloatWithLeadingDot) {$type=DecimalLiteral;}
        |
        ) (
            UnitSpecifier {if($type == DecimalLiteral) {$type=UnitDecimalLiteral;} else {$type=UnitLiteral;}}
        |
        )
    |   NonZeroDecimal (
            {(input.LA(2)>='0')&&(input.LA(2)<='9')}?=> (FloatWithLeadingDot) {$type=DecimalLiteral;}
        | Exponent {$type=DecimalLiteral;}
        |
        ) (
            UnitSpecifier {if($type == DecimalLiteral) {$type=UnitDecimalLiteral;} else {$type=UnitLiteral;}}
        |
        )
    ;

StringLiteral
    :  ('"' 
        ( ({!(input.LA(1) == '#' && input.LA(2) == '{')}?=> (EscapeSequence | ~('\\'|'"')))* ) 
        (
            '#{' {startInterpolation(); }
        |   '"'))
    |  ('#[' 
        ( ({!(input.LA(1) == '#' && input.LA(2) == '{')}?=> (EscapeSequence | ~('\\'|']')))* ) 
        (
            '#{' {startAltInterpolation(); }
        |   ']'))
    | {isInterpolating()}?=> ('}' ( ({!(input.LA(1) == '#' && input.LA(2) == '{')}?=> (EscapeSequence | ~('\\'|'"')))* ) 
        (
            '#{' {startInterpolation(); }
        |   '"'  {endInterpolation(); }))
    | {isAltInterpolating()}?=> ('}' ( ({!(input.LA(1) == '#' && input.LA(2) == '{')}?=> (EscapeSequence | ~('\\'|']')))* ) 
        (
            '#{' {startAltInterpolation(); }
        |   ']'  {endAltInterpolation(); }))
    ;

RegexpLiteral
    :  ('#/'
            ( ({!(input.LA(1) == '#' && input.LA(2) == '{')}?=> ( EscapeSequenceRegexp | ~('\\'|'/')))* )
            (
                '#{' {startRegexpInterpolation(); }
            |   '/' RegexpModifier))
    |  ('#r[' 
        ( ({!(input.LA(1) == '#' && input.LA(2) == '{')}?=> (EscapeSequenceRegexp | ~('\\'|']')))* ) 
        (
            '#{' {startAltRegexpInterpolation(); }
        |   ']' RegexpModifier))
    | {isRegexpInterpolating()}?=> ('}' (({!(input.LA(1) == '#' && input.LA(2) == '{')}?=> (EscapeSequenceRegexp | ~('\\'|'/')))* ) 
        (
            '#{' {startRegexpInterpolation(); }

        |   '/' RegexpModifier  {endRegexpInterpolation(); }))
    | {isAltRegexpInterpolating()}?=> ('}' ( ({!(input.LA(1) == '#' && input.LA(2) == '{')}?=> (EscapeSequenceRegexp | ~('\\'|']')))* ) 
        (
            '#{' {startAltRegexpInterpolation(); }
        |   '/' RegexpModifier {endAltRegexpInterpolation(); }))
    ;

fragment
EscapeSequence
    :   '\\' ('b'|'t'|'n'|'f'|'r'|'\"'|']'|'\\'|'\n'|'#'|'e')
    |   UnicodeEscape
    |   OctalEscape
    ;

fragment
EscapeSequenceRegexp
    :   '\\' ('b'|'t'|'n'|'f'|'r'|'/'|'\\'|'\n'|'#')
    |   UnicodeEscape
    |   OctalEscape
    ;

fragment
RegexpModifier
		:	('o'|'x'|'p'|'n'|'i'|'u'|'m'|'s')*
		;

Terminator
    :
        (('\r'? '\n') | {(input.LA(2) != '.')}?=> '.')+
    ;

Whitespace : Separator {skip();};

LineComment
    : ';' ~('\n'|'\r')* {$channel=HIDDEN;}
    | '#!' ~('\n'|'\r')* {$channel=HIDDEN;}
    ;

fragment
OperatorChar
    : 
        '+'
    |   '-'
    |   '<'
    |   '>'
    |   '!'
    |   '~'
    |   '*'
    |   '/'
    |   '%'
    |   '&'
    |   '|'
    |   '?'
    |   '^'
    |   '$'
    |   '='
    ;

fragment
AtLeastOneOperatorChar
    :
        '@'
    |   '#'
    ;

BinaryOperator
    :
        OperatorChar+
    |   AtLeastOneOperatorChar (OperatorChar | AtLeastOneOperatorChar)+
    |   OperatorChar+ AtLeastOneOperatorChar (OperatorChar | AtLeastOneOperatorChar)*
    |   '.' '.'+
    |   'or'
    |   'nor'
    |   'xor'
    |   'and'
    |   'nand'
    ;

Comma
    :
        ','
    ;


fragment
OctalEscape
    :   '\\' ('0'..'3') ('0'..'7') ('0'..'7')
    |   '\\' ('0'..'7') ('0'..'7')
    |   '\\' ('0'..'7')
    ;

fragment
UnicodeEscape
    :   '\\' 'u' HexDigit HexDigit HexDigit HexDigit
    ;

fragment
FloatWithLeadingDot
        :
            '.' Digit+ (Exponent)?
        ;

fragment
UnitSpecifier
    :
        ('a'..'w'|'A'..'W'|'y'|'Y'|'z'|'Z'|'_') ('a'..'z'|'A'..'Z'|'_')*
    ;

fragment
Exponent
    :	
        ('e'|'E')	('+'|'-')?	('0'..'9')+
    ;

fragment
NonZeroDecimal
    :
     ('1'..'9') Digit*
    ;

fragment
Digit : '0'..'9' ;

fragment
HexDigit : ('0'..'9'|'a'..'f'|'A'..'F') ;

fragment
Separator : (' ' | '\u000c' | '\u0009' | '\u000b' | '\\' '\u000a' )+ ;

fragment
StrangeChars
    :
        '_' |
        '!' |
        '?' |
        ':'
    ;

fragment
IDDigit
    :  '\u0030'..'\u0039' |
       '\u0660'..'\u0669' |
       '\u06f0'..'\u06f9' |
       '\u0966'..'\u096f' |
       '\u09e6'..'\u09ef' |
       '\u0a66'..'\u0a6f' |
       '\u0ae6'..'\u0aef' |
       '\u0b66'..'\u0b6f' |
       '\u0be7'..'\u0bef' |
       '\u0c66'..'\u0c6f' |
       '\u0ce6'..'\u0cef' |
       '\u0d66'..'\u0d6f' |
       '\u0e50'..'\u0e59' |
       '\u0ed0'..'\u0ed9' |
       '\u1040'..'\u1049'
   ;

fragment
Letter
    :  
       '\u0041'..'\u005a' |
       '\u005f'           |
       '\u0061'..'\u007a' |
       '\u00c0'..'\u00d6' |
       '\u00d8'..'\u00f6' |
       '\u00f8'..'\u00ff' |
       '\u0100'..'\u1fff' |
       '\u3040'..'\u318f' |
       '\u3300'..'\u337f' |
       '\u3400'..'\u3d2d' |
       '\u4e00'..'\u9fff' |
       '\uf900'..'\ufaff'
    ;
