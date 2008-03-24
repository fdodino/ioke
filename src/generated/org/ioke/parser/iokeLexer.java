// $ANTLR 3.0.1 ioke.g 2008-03-24 15:14:20

package org.ioke.parser;

import java.io.FileReader;
import java.io.BufferedReader;
import java.io.Reader;
import java.io.InputStreamReader;
import java.io.StringReader;

import java.util.List;
import java.util.ArrayList;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class iokeLexer extends Lexer {
    public static final int MultiString=4;
    public static final int Assignment=27;
    public static final int CloseCurly=14;
    public static final int Exponent=21;
    public static final int OpChars=25;
    public static final int HexLetter=17;
    public static final int IdentChars=29;
    public static final int Digit=16;
    public static final int Tokens=35;
    public static final int EOF=-1;
    public static final int OpenSimple=9;
    public static final int IdentStart=28;
    public static final int Identifier=30;
    public static final int Separator=32;
    public static final int NewLine=7;
    public static final int AssignmentOperator=23;
    public static final int SimpleString=5;
    public static final int OpenSquare=11;
    public static final int CloseSimple=10;
    public static final int Digits=19;
    public static final int NewlineComment=8;
    public static final int HexInteger=18;
    public static final int Real=22;
    public static final int BinaryOperator=26;
    public static final int MultiComment=6;
    public static final int UnaryOperator=24;
    public static final int Whitespace=33;
    public static final int CloseSquare=12;
    public static final int OpenCurly=13;
    public static final int Comma=15;
    public static final int Letter=34;
    public static final int Integer=20;
    public static final int PossibleTerminator=31;

        public static iokeLexer getLexerFor(String input) throws Exception {
            return getLexerFor(new StringReader(input));
        }

        public static iokeLexer getLexerFor(Reader input) throws Exception {
            return new iokeLexer(new ANTLRReaderStream(input));
        }

        public static List<Token> getTokens(String input) throws Exception {
            return getTokens(getLexerFor(input));
        }

        public static List<Token> getTokens(Reader reader) throws Exception {
            return getTokens(getLexerFor(reader));
        }

        private static List<Token> getTokens(iokeLexer lexer) throws Exception {
            List<Token> tokens = new ArrayList<Token>();
            Token t;
            while((t = lexer.nextToken()).getType() != EOF) {
                tokens.add(t);
            } 
            return tokens;
        }

        public static void main(final String[] args) throws Exception {
            Reader reader;
            if(args.length > 0) {
                reader = new BufferedReader(new FileReader(args[0]));
            } else {
                reader = new InputStreamReader(System.in);
            }
            List<Token> tokens = getTokens(reader);
            for(Token t : tokens) {
                System.out.println("{" + tokenToName(t.getType()) + "} " + t.getText());
            }
        }
        
        public final static String tokenToName(int token) {
            switch(token) {
            case Identifier: return "Identifier";
            case Whitespace: return "Whitespace";
            case PossibleTerminator: return "PossibleTerminator";
            case EOF: return "EOF";
            default: return "UNKNOWN TOKEN(" + token + ")";
            }
        }

    public iokeLexer() {;} 
    public iokeLexer(CharStream input) {
        super(input);
    }
    public String getGrammarFileName() { return "ioke.g"; }

    // $ANTLR start MultiString
    public final void mMultiString() throws RecognitionException {
        try {
            int _type = MultiString;
            // ioke.g:68:5: ( ( '%{' ( options {greedy=false; } : ( . )* ) '}' ) | ( '%[' ( options {greedy=false; } : ( . )* ) ']' ) )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0=='%') ) {
                int LA3_1 = input.LA(2);

                if ( (LA3_1=='{') ) {
                    alt3=1;
                }
                else if ( (LA3_1=='[') ) {
                    alt3=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("67:1: MultiString : ( ( '%{' ( options {greedy=false; } : ( . )* ) '}' ) | ( '%[' ( options {greedy=false; } : ( . )* ) ']' ) );", 3, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("67:1: MultiString : ( ( '%{' ( options {greedy=false; } : ( . )* ) '}' ) | ( '%[' ( options {greedy=false; } : ( . )* ) ']' ) );", 3, 0, input);

                throw nvae;
            }
            switch (alt3) {
                case 1 :
                    // ioke.g:68:7: ( '%{' ( options {greedy=false; } : ( . )* ) '}' )
                    {
                    // ioke.g:68:7: ( '%{' ( options {greedy=false; } : ( . )* ) '}' )
                    // ioke.g:68:8: '%{' ( options {greedy=false; } : ( . )* ) '}'
                    {
                    match("%{"); 

                    // ioke.g:68:13: ( options {greedy=false; } : ( . )* )
                    // ioke.g:68:41: ( . )*
                    {
                    // ioke.g:68:41: ( . )*
                    loop1:
                    do {
                        int alt1=2;
                        int LA1_0 = input.LA(1);

                        if ( (LA1_0=='}') ) {
                            alt1=2;
                        }
                        else if ( ((LA1_0>='\u0000' && LA1_0<='|')||(LA1_0>='~' && LA1_0<='\uFFFE')) ) {
                            alt1=1;
                        }


                        switch (alt1) {
                    	case 1 :
                    	    // ioke.g:68:41: .
                    	    {
                    	    matchAny(); 

                    	    }
                    	    break;

                    	default :
                    	    break loop1;
                        }
                    } while (true);


                    }

                    match('}'); 

                    }


                    }
                    break;
                case 2 :
                    // ioke.g:69:7: ( '%[' ( options {greedy=false; } : ( . )* ) ']' )
                    {
                    // ioke.g:69:7: ( '%[' ( options {greedy=false; } : ( . )* ) ']' )
                    // ioke.g:69:8: '%[' ( options {greedy=false; } : ( . )* ) ']'
                    {
                    match("%["); 

                    // ioke.g:69:13: ( options {greedy=false; } : ( . )* )
                    // ioke.g:69:41: ( . )*
                    {
                    // ioke.g:69:41: ( . )*
                    loop2:
                    do {
                        int alt2=2;
                        int LA2_0 = input.LA(1);

                        if ( (LA2_0==']') ) {
                            alt2=2;
                        }
                        else if ( ((LA2_0>='\u0000' && LA2_0<='\\')||(LA2_0>='^' && LA2_0<='\uFFFE')) ) {
                            alt2=1;
                        }


                        switch (alt2) {
                    	case 1 :
                    	    // ioke.g:69:41: .
                    	    {
                    	    matchAny(); 

                    	    }
                    	    break;

                    	default :
                    	    break loop2;
                        }
                    } while (true);


                    }

                    match(']'); 

                    }


                    }
                    break;

            }
            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end MultiString

    // $ANTLR start SimpleString
    public final void mSimpleString() throws RecognitionException {
        try {
            int _type = SimpleString;
            // ioke.g:71:14: ( ( '\"' ( ( '\\\\' ( '\"' | '\\\\' ) ) | ( '\\\\' )? ~ ( '\"' | '\\\\' ) )* '\"' ) )
            // ioke.g:71:16: ( '\"' ( ( '\\\\' ( '\"' | '\\\\' ) ) | ( '\\\\' )? ~ ( '\"' | '\\\\' ) )* '\"' )
            {
            // ioke.g:71:16: ( '\"' ( ( '\\\\' ( '\"' | '\\\\' ) ) | ( '\\\\' )? ~ ( '\"' | '\\\\' ) )* '\"' )
            // ioke.g:71:17: '\"' ( ( '\\\\' ( '\"' | '\\\\' ) ) | ( '\\\\' )? ~ ( '\"' | '\\\\' ) )* '\"'
            {
            match('\"'); 
            // ioke.g:71:21: ( ( '\\\\' ( '\"' | '\\\\' ) ) | ( '\\\\' )? ~ ( '\"' | '\\\\' ) )*
            loop5:
            do {
                int alt5=3;
                int LA5_0 = input.LA(1);

                if ( (LA5_0=='\\') ) {
                    int LA5_2 = input.LA(2);

                    if ( (LA5_2=='\"'||LA5_2=='\\') ) {
                        alt5=1;
                    }
                    else if ( ((LA5_2>='\u0000' && LA5_2<='!')||(LA5_2>='#' && LA5_2<='[')||(LA5_2>=']' && LA5_2<='\uFFFE')) ) {
                        alt5=2;
                    }


                }
                else if ( ((LA5_0>='\u0000' && LA5_0<='!')||(LA5_0>='#' && LA5_0<='[')||(LA5_0>=']' && LA5_0<='\uFFFE')) ) {
                    alt5=2;
                }


                switch (alt5) {
            	case 1 :
            	    // ioke.g:71:23: ( '\\\\' ( '\"' | '\\\\' ) )
            	    {
            	    // ioke.g:71:23: ( '\\\\' ( '\"' | '\\\\' ) )
            	    // ioke.g:71:24: '\\\\' ( '\"' | '\\\\' )
            	    {
            	    match('\\'); 
            	    if ( input.LA(1)=='\"'||input.LA(1)=='\\' ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse =
            	            new MismatchedSetException(null,input);
            	        recover(mse);    throw mse;
            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // ioke.g:71:43: ( '\\\\' )? ~ ( '\"' | '\\\\' )
            	    {
            	    // ioke.g:71:43: ( '\\\\' )?
            	    int alt4=2;
            	    int LA4_0 = input.LA(1);

            	    if ( (LA4_0=='\\') ) {
            	        alt4=1;
            	    }
            	    switch (alt4) {
            	        case 1 :
            	            // ioke.g:71:43: '\\\\'
            	            {
            	            match('\\'); 

            	            }
            	            break;

            	    }

            	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='!')||(input.LA(1)>='#' && input.LA(1)<='[')||(input.LA(1)>=']' && input.LA(1)<='\uFFFE') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse =
            	            new MismatchedSetException(null,input);
            	        recover(mse);    throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);

            match('\"'); 

            }


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end SimpleString

    // $ANTLR start MultiComment
    public final void mMultiComment() throws RecognitionException {
        try {
            int _type = MultiComment;
            // ioke.g:73:14: ( ( '{#' ( options {greedy=false; } : ( . )* ) '#}' ) )
            // ioke.g:73:16: ( '{#' ( options {greedy=false; } : ( . )* ) '#}' )
            {
            // ioke.g:73:16: ( '{#' ( options {greedy=false; } : ( . )* ) '#}' )
            // ioke.g:73:17: '{#' ( options {greedy=false; } : ( . )* ) '#}'
            {
            match("{#"); 

            // ioke.g:73:22: ( options {greedy=false; } : ( . )* )
            // ioke.g:73:50: ( . )*
            {
            // ioke.g:73:50: ( . )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0=='#') ) {
                    int LA6_1 = input.LA(2);

                    if ( (LA6_1=='}') ) {
                        alt6=2;
                    }
                    else if ( ((LA6_1>='\u0000' && LA6_1<='|')||(LA6_1>='~' && LA6_1<='\uFFFE')) ) {
                        alt6=1;
                    }


                }
                else if ( ((LA6_0>='\u0000' && LA6_0<='\"')||(LA6_0>='$' && LA6_0<='\uFFFE')) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // ioke.g:73:50: .
            	    {
            	    matchAny(); 

            	    }
            	    break;

            	default :
            	    break loop6;
                }
            } while (true);


            }

            match("#}"); 


            }

            skip();

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end MultiComment

    // $ANTLR start NewlineComment
    public final void mNewlineComment() throws RecognitionException {
        try {
            int _type = NewlineComment;
            // ioke.g:74:16: ( '#' (~ NewLine )* ( NewLine )? )
            // ioke.g:74:18: '#' (~ NewLine )* ( NewLine )?
            {
            match('#'); 
            // ioke.g:74:22: (~ NewLine )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( ((LA7_0>='\u0000' && LA7_0<='\t')||(LA7_0>='\u000B' && LA7_0<='\f')||(LA7_0>='\u000E' && LA7_0<='\uFFFE')) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // ioke.g:74:24: ~ NewLine
            	    {
            	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='\u0006')||(input.LA(1)>='\b' && input.LA(1)<='\uFFFE') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse =
            	            new MismatchedSetException(null,input);
            	        recover(mse);    throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    break loop7;
                }
            } while (true);

            // ioke.g:74:36: ( NewLine )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0=='\n'||LA8_0=='\r') ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // ioke.g:74:36: NewLine
                    {
                    mNewLine(); 

                    }
                    break;

            }

            _type=PossibleTerminator;setText(";");

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end NewlineComment

    // $ANTLR start OpenSimple
    public final void mOpenSimple() throws RecognitionException {
        try {
            int _type = OpenSimple;
            // ioke.g:76:12: ( '(' )
            // ioke.g:76:14: '('
            {
            match('('); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end OpenSimple

    // $ANTLR start CloseSimple
    public final void mCloseSimple() throws RecognitionException {
        try {
            int _type = CloseSimple;
            // ioke.g:77:13: ( ')' )
            // ioke.g:77:15: ')'
            {
            match(')'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end CloseSimple

    // $ANTLR start OpenSquare
    public final void mOpenSquare() throws RecognitionException {
        try {
            int _type = OpenSquare;
            // ioke.g:78:12: ( '[' )
            // ioke.g:78:14: '['
            {
            match('['); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end OpenSquare

    // $ANTLR start CloseSquare
    public final void mCloseSquare() throws RecognitionException {
        try {
            int _type = CloseSquare;
            // ioke.g:79:13: ( ']' )
            // ioke.g:79:15: ']'
            {
            match(']'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end CloseSquare

    // $ANTLR start OpenCurly
    public final void mOpenCurly() throws RecognitionException {
        try {
            int _type = OpenCurly;
            // ioke.g:80:11: ( '{' )
            // ioke.g:80:13: '{'
            {
            match('{'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end OpenCurly

    // $ANTLR start CloseCurly
    public final void mCloseCurly() throws RecognitionException {
        try {
            int _type = CloseCurly;
            // ioke.g:81:12: ( '}' )
            // ioke.g:81:14: '}'
            {
            match('}'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end CloseCurly

    // $ANTLR start Comma
    public final void mComma() throws RecognitionException {
        try {
            int _type = Comma;
            // ioke.g:83:7: ( ( ',' ( NewLine )* ) )
            // ioke.g:83:9: ( ',' ( NewLine )* )
            {
            // ioke.g:83:9: ( ',' ( NewLine )* )
            // ioke.g:83:10: ',' ( NewLine )*
            {
            match(','); 
            // ioke.g:83:14: ( NewLine )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0=='\n'||LA9_0=='\r') ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // ioke.g:83:14: NewLine
            	    {
            	    mNewLine(); 

            	    }
            	    break;

            	default :
            	    break loop9;
                }
            } while (true);


            }

            setText(",");

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end Comma

    // $ANTLR start HexInteger
    public final void mHexInteger() throws RecognitionException {
        try {
            int _type = HexInteger;
            // ioke.g:85:12: ( ( '+' | '-' )? '0' ( 'x' | 'X' ) ( Digit | HexLetter )+ )
            // ioke.g:85:14: ( '+' | '-' )? '0' ( 'x' | 'X' ) ( Digit | HexLetter )+
            {
            // ioke.g:85:14: ( '+' | '-' )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0=='+'||LA10_0=='-') ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // ioke.g:
                    {
                    if ( input.LA(1)=='+'||input.LA(1)=='-' ) {
                        input.consume();

                    }
                    else {
                        MismatchedSetException mse =
                            new MismatchedSetException(null,input);
                        recover(mse);    throw mse;
                    }


                    }
                    break;

            }

            match('0'); 
            if ( input.LA(1)=='X'||input.LA(1)=='x' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse =
                    new MismatchedSetException(null,input);
                recover(mse);    throw mse;
            }

            // ioke.g:85:41: ( Digit | HexLetter )+
            int cnt11=0;
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( ((LA11_0>='0' && LA11_0<='9')||(LA11_0>='A' && LA11_0<='F')||(LA11_0>='a' && LA11_0<='f')) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // ioke.g:
            	    {
            	    if ( (input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='F')||(input.LA(1)>='a' && input.LA(1)<='f') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse =
            	            new MismatchedSetException(null,input);
            	        recover(mse);    throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt11 >= 1 ) break loop11;
                        EarlyExitException eee =
                            new EarlyExitException(11, input);
                        throw eee;
                }
                cnt11++;
            } while (true);


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end HexInteger

    // $ANTLR start Integer
    public final void mInteger() throws RecognitionException {
        try {
            int _type = Integer;
            // ioke.g:87:9: ( ( '+' | '-' )? Digits )
            // ioke.g:87:11: ( '+' | '-' )? Digits
            {
            // ioke.g:87:11: ( '+' | '-' )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0=='+'||LA12_0=='-') ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // ioke.g:
                    {
                    if ( input.LA(1)=='+'||input.LA(1)=='-' ) {
                        input.consume();

                    }
                    else {
                        MismatchedSetException mse =
                            new MismatchedSetException(null,input);
                        recover(mse);    throw mse;
                    }


                    }
                    break;

            }

            mDigits(); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end Integer

    // $ANTLR start Real
    public final void mReal() throws RecognitionException {
        try {
            int _type = Real;
            // ioke.g:90:5: ( ( '+' | '-' )? ( Digits '.' ( Digit )* ( Exponent )? | '.' Digits ( Exponent )? | Digits Exponent ) )
            // ioke.g:90:9: ( '+' | '-' )? ( Digits '.' ( Digit )* ( Exponent )? | '.' Digits ( Exponent )? | Digits Exponent )
            {
            // ioke.g:90:9: ( '+' | '-' )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0=='+'||LA13_0=='-') ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // ioke.g:
                    {
                    if ( input.LA(1)=='+'||input.LA(1)=='-' ) {
                        input.consume();

                    }
                    else {
                        MismatchedSetException mse =
                            new MismatchedSetException(null,input);
                        recover(mse);    throw mse;
                    }


                    }
                    break;

            }

            // ioke.g:91:9: ( Digits '.' ( Digit )* ( Exponent )? | '.' Digits ( Exponent )? | Digits Exponent )
            int alt17=3;
            alt17 = dfa17.predict(input);
            switch (alt17) {
                case 1 :
                    // ioke.g:91:10: Digits '.' ( Digit )* ( Exponent )?
                    {
                    mDigits(); 
                    match('.'); 
                    // ioke.g:91:21: ( Digit )*
                    loop14:
                    do {
                        int alt14=2;
                        int LA14_0 = input.LA(1);

                        if ( ((LA14_0>='0' && LA14_0<='9')) ) {
                            alt14=1;
                        }


                        switch (alt14) {
                    	case 1 :
                    	    // ioke.g:91:21: Digit
                    	    {
                    	    mDigit(); 

                    	    }
                    	    break;

                    	default :
                    	    break loop14;
                        }
                    } while (true);

                    // ioke.g:91:28: ( Exponent )?
                    int alt15=2;
                    int LA15_0 = input.LA(1);

                    if ( (LA15_0=='E'||LA15_0=='e') ) {
                        alt15=1;
                    }
                    switch (alt15) {
                        case 1 :
                            // ioke.g:91:28: Exponent
                            {
                            mExponent(); 

                            }
                            break;

                    }


                    }
                    break;
                case 2 :
                    // ioke.g:92:10: '.' Digits ( Exponent )?
                    {
                    match('.'); 
                    mDigits(); 
                    // ioke.g:92:21: ( Exponent )?
                    int alt16=2;
                    int LA16_0 = input.LA(1);

                    if ( (LA16_0=='E'||LA16_0=='e') ) {
                        alt16=1;
                    }
                    switch (alt16) {
                        case 1 :
                            // ioke.g:92:21: Exponent
                            {
                            mExponent(); 

                            }
                            break;

                    }


                    }
                    break;
                case 3 :
                    // ioke.g:93:10: Digits Exponent
                    {
                    mDigits(); 
                    mExponent(); 

                    }
                    break;

            }


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end Real

    // $ANTLR start AssignmentOperator
    public final void mAssignmentOperator() throws RecognitionException {
        try {
            int _type = AssignmentOperator;
            // ioke.g:96:20: ( ( '+' | '++' | '-' | '--' | '/' | '//' | '*' | '**' | '%' | '%%' | '^' | '^^' | '<<' | '>>' | '&' | '&&' | '|' | '||' ) '=' )
            // ioke.g:97:9: ( '+' | '++' | '-' | '--' | '/' | '//' | '*' | '**' | '%' | '%%' | '^' | '^^' | '<<' | '>>' | '&' | '&&' | '|' | '||' ) '='
            {
            // ioke.g:97:9: ( '+' | '++' | '-' | '--' | '/' | '//' | '*' | '**' | '%' | '%%' | '^' | '^^' | '<<' | '>>' | '&' | '&&' | '|' | '||' )
            int alt18=18;
            switch ( input.LA(1) ) {
            case '+':
                {
                int LA18_1 = input.LA(2);

                if ( (LA18_1=='+') ) {
                    alt18=2;
                }
                else if ( (LA18_1=='=') ) {
                    alt18=1;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("97:9: ( '+' | '++' | '-' | '--' | '/' | '//' | '*' | '**' | '%' | '%%' | '^' | '^^' | '<<' | '>>' | '&' | '&&' | '|' | '||' )", 18, 1, input);

                    throw nvae;
                }
                }
                break;
            case '-':
                {
                int LA18_2 = input.LA(2);

                if ( (LA18_2=='-') ) {
                    alt18=4;
                }
                else if ( (LA18_2=='=') ) {
                    alt18=3;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("97:9: ( '+' | '++' | '-' | '--' | '/' | '//' | '*' | '**' | '%' | '%%' | '^' | '^^' | '<<' | '>>' | '&' | '&&' | '|' | '||' )", 18, 2, input);

                    throw nvae;
                }
                }
                break;
            case '/':
                {
                int LA18_3 = input.LA(2);

                if ( (LA18_3=='/') ) {
                    alt18=6;
                }
                else if ( (LA18_3=='=') ) {
                    alt18=5;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("97:9: ( '+' | '++' | '-' | '--' | '/' | '//' | '*' | '**' | '%' | '%%' | '^' | '^^' | '<<' | '>>' | '&' | '&&' | '|' | '||' )", 18, 3, input);

                    throw nvae;
                }
                }
                break;
            case '*':
                {
                int LA18_4 = input.LA(2);

                if ( (LA18_4=='*') ) {
                    alt18=8;
                }
                else if ( (LA18_4=='=') ) {
                    alt18=7;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("97:9: ( '+' | '++' | '-' | '--' | '/' | '//' | '*' | '**' | '%' | '%%' | '^' | '^^' | '<<' | '>>' | '&' | '&&' | '|' | '||' )", 18, 4, input);

                    throw nvae;
                }
                }
                break;
            case '%':
                {
                int LA18_5 = input.LA(2);

                if ( (LA18_5=='%') ) {
                    alt18=10;
                }
                else if ( (LA18_5=='=') ) {
                    alt18=9;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("97:9: ( '+' | '++' | '-' | '--' | '/' | '//' | '*' | '**' | '%' | '%%' | '^' | '^^' | '<<' | '>>' | '&' | '&&' | '|' | '||' )", 18, 5, input);

                    throw nvae;
                }
                }
                break;
            case '^':
                {
                int LA18_6 = input.LA(2);

                if ( (LA18_6=='^') ) {
                    alt18=12;
                }
                else if ( (LA18_6=='=') ) {
                    alt18=11;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("97:9: ( '+' | '++' | '-' | '--' | '/' | '//' | '*' | '**' | '%' | '%%' | '^' | '^^' | '<<' | '>>' | '&' | '&&' | '|' | '||' )", 18, 6, input);

                    throw nvae;
                }
                }
                break;
            case '<':
                {
                alt18=13;
                }
                break;
            case '>':
                {
                alt18=14;
                }
                break;
            case '&':
                {
                int LA18_9 = input.LA(2);

                if ( (LA18_9=='&') ) {
                    alt18=16;
                }
                else if ( (LA18_9=='=') ) {
                    alt18=15;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("97:9: ( '+' | '++' | '-' | '--' | '/' | '//' | '*' | '**' | '%' | '%%' | '^' | '^^' | '<<' | '>>' | '&' | '&&' | '|' | '||' )", 18, 9, input);

                    throw nvae;
                }
                }
                break;
            case '|':
                {
                int LA18_10 = input.LA(2);

                if ( (LA18_10=='|') ) {
                    alt18=18;
                }
                else if ( (LA18_10=='=') ) {
                    alt18=17;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("97:9: ( '+' | '++' | '-' | '--' | '/' | '//' | '*' | '**' | '%' | '%%' | '^' | '^^' | '<<' | '>>' | '&' | '&&' | '|' | '||' )", 18, 10, input);

                    throw nvae;
                }
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("97:9: ( '+' | '++' | '-' | '--' | '/' | '//' | '*' | '**' | '%' | '%%' | '^' | '^^' | '<<' | '>>' | '&' | '&&' | '|' | '||' )", 18, 0, input);

                throw nvae;
            }

            switch (alt18) {
                case 1 :
                    // ioke.g:97:10: '+'
                    {
                    match('+'); 

                    }
                    break;
                case 2 :
                    // ioke.g:98:11: '++'
                    {
                    match("++"); 


                    }
                    break;
                case 3 :
                    // ioke.g:99:11: '-'
                    {
                    match('-'); 

                    }
                    break;
                case 4 :
                    // ioke.g:100:11: '--'
                    {
                    match("--"); 


                    }
                    break;
                case 5 :
                    // ioke.g:101:11: '/'
                    {
                    match('/'); 

                    }
                    break;
                case 6 :
                    // ioke.g:102:11: '//'
                    {
                    match("//"); 


                    }
                    break;
                case 7 :
                    // ioke.g:103:11: '*'
                    {
                    match('*'); 

                    }
                    break;
                case 8 :
                    // ioke.g:104:11: '**'
                    {
                    match("**"); 


                    }
                    break;
                case 9 :
                    // ioke.g:105:11: '%'
                    {
                    match('%'); 

                    }
                    break;
                case 10 :
                    // ioke.g:106:11: '%%'
                    {
                    match("%%"); 


                    }
                    break;
                case 11 :
                    // ioke.g:107:11: '^'
                    {
                    match('^'); 

                    }
                    break;
                case 12 :
                    // ioke.g:108:11: '^^'
                    {
                    match("^^"); 


                    }
                    break;
                case 13 :
                    // ioke.g:109:11: '<<'
                    {
                    match("<<"); 


                    }
                    break;
                case 14 :
                    // ioke.g:110:11: '>>'
                    {
                    match(">>"); 


                    }
                    break;
                case 15 :
                    // ioke.g:111:11: '&'
                    {
                    match('&'); 

                    }
                    break;
                case 16 :
                    // ioke.g:112:11: '&&'
                    {
                    match("&&"); 


                    }
                    break;
                case 17 :
                    // ioke.g:113:11: '|'
                    {
                    match('|'); 

                    }
                    break;
                case 18 :
                    // ioke.g:114:11: '||'
                    {
                    match("||"); 


                    }
                    break;

            }

            match('='); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end AssignmentOperator

    // $ANTLR start UnaryOperator
    public final void mUnaryOperator() throws RecognitionException {
        try {
            int _type = UnaryOperator;
            // ioke.g:117:15: ( '@' | '@@' | '\\'' | '`' | '!' | ':' | 'return' )
            int alt19=7;
            switch ( input.LA(1) ) {
            case '@':
                {
                int LA19_1 = input.LA(2);

                if ( (LA19_1=='@') ) {
                    alt19=2;
                }
                else {
                    alt19=1;}
                }
                break;
            case '\'':
                {
                alt19=3;
                }
                break;
            case '`':
                {
                alt19=4;
                }
                break;
            case '!':
                {
                alt19=5;
                }
                break;
            case ':':
                {
                alt19=6;
                }
                break;
            case 'r':
                {
                alt19=7;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("117:1: UnaryOperator : ( '@' | '@@' | '\\'' | '`' | '!' | ':' | 'return' );", 19, 0, input);

                throw nvae;
            }

            switch (alt19) {
                case 1 :
                    // ioke.g:118:7: '@'
                    {
                    match('@'); 

                    }
                    break;
                case 2 :
                    // ioke.g:119:7: '@@'
                    {
                    match("@@"); 


                    }
                    break;
                case 3 :
                    // ioke.g:120:7: '\\''
                    {
                    match('\''); 

                    }
                    break;
                case 4 :
                    // ioke.g:121:7: '`'
                    {
                    match('`'); 

                    }
                    break;
                case 5 :
                    // ioke.g:122:7: '!'
                    {
                    match('!'); 

                    }
                    break;
                case 6 :
                    // ioke.g:123:7: ':'
                    {
                    match(':'); 

                    }
                    break;
                case 7 :
                    // ioke.g:124:7: 'return'
                    {
                    match("return"); 


                    }
                    break;

            }
            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end UnaryOperator

    // $ANTLR start BinaryOperator
    public final void mBinaryOperator() throws RecognitionException {
        try {
            int _type = BinaryOperator;
            // ioke.g:127:16: ( ( OpChars )+ | '==' | '===' | '====' | '<=' | '>=' | '~=' | '~~=' | '!=' | '!!=' | 'and' | 'or' )
            int alt21=12;
            switch ( input.LA(1) ) {
            case '<':
                {
                int LA21_1 = input.LA(2);

                if ( (LA21_1=='=') ) {
                    alt21=5;
                }
                else {
                    alt21=1;}
                }
                break;
            case '=':
                {
                int LA21_2 = input.LA(2);

                if ( (LA21_2=='=') ) {
                    int LA21_10 = input.LA(3);

                    if ( (LA21_10=='=') ) {
                        int LA21_16 = input.LA(4);

                        if ( (LA21_16=='=') ) {
                            alt21=4;
                        }
                        else {
                            alt21=3;}
                    }
                    else {
                        alt21=2;}
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("127:1: BinaryOperator : ( ( OpChars )+ | '==' | '===' | '====' | '<=' | '>=' | '~=' | '~~=' | '!=' | '!!=' | 'and' | 'or' );", 21, 2, input);

                    throw nvae;
                }
                }
                break;
            case '>':
                {
                int LA21_3 = input.LA(2);

                if ( (LA21_3=='=') ) {
                    alt21=6;
                }
                else {
                    alt21=1;}
                }
                break;
            case '~':
                {
                switch ( input.LA(2) ) {
                case '~':
                    {
                    int LA21_12 = input.LA(3);

                    if ( (LA21_12=='=') ) {
                        alt21=8;
                    }
                    else {
                        alt21=1;}
                    }
                    break;
                case '=':
                    {
                    alt21=7;
                    }
                    break;
                default:
                    alt21=1;}

                }
                break;
            case '!':
                {
                switch ( input.LA(2) ) {
                case '=':
                    {
                    alt21=9;
                    }
                    break;
                case '!':
                    {
                    int LA21_15 = input.LA(3);

                    if ( (LA21_15=='=') ) {
                        alt21=10;
                    }
                    else {
                        alt21=1;}
                    }
                    break;
                default:
                    alt21=1;}

                }
                break;
            case '%':
            case '&':
            case '\'':
            case '*':
            case '+':
            case '-':
            case '.':
            case '/':
            case ':':
            case '?':
            case '@':
            case '\\':
            case '^':
            case '_':
            case '`':
            case '|':
                {
                alt21=1;
                }
                break;
            case 'a':
                {
                alt21=11;
                }
                break;
            case 'o':
                {
                alt21=12;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("127:1: BinaryOperator : ( ( OpChars )+ | '==' | '===' | '====' | '<=' | '>=' | '~=' | '~~=' | '!=' | '!!=' | 'and' | 'or' );", 21, 0, input);

                throw nvae;
            }

            switch (alt21) {
                case 1 :
                    // ioke.g:128:7: ( OpChars )+
                    {
                    // ioke.g:128:7: ( OpChars )+
                    int cnt20=0;
                    loop20:
                    do {
                        int alt20=2;
                        int LA20_0 = input.LA(1);

                        if ( (LA20_0=='!'||(LA20_0>='%' && LA20_0<='\'')||(LA20_0>='*' && LA20_0<='+')||(LA20_0>='-' && LA20_0<='/')||LA20_0==':'||LA20_0=='<'||(LA20_0>='>' && LA20_0<='@')||LA20_0=='\\'||(LA20_0>='^' && LA20_0<='`')||LA20_0=='|'||LA20_0=='~') ) {
                            alt20=1;
                        }


                        switch (alt20) {
                    	case 1 :
                    	    // ioke.g:128:7: OpChars
                    	    {
                    	    mOpChars(); 

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt20 >= 1 ) break loop20;
                                EarlyExitException eee =
                                    new EarlyExitException(20, input);
                                throw eee;
                        }
                        cnt20++;
                    } while (true);


                    }
                    break;
                case 2 :
                    // ioke.g:129:7: '=='
                    {
                    match("=="); 


                    }
                    break;
                case 3 :
                    // ioke.g:130:7: '==='
                    {
                    match("==="); 


                    }
                    break;
                case 4 :
                    // ioke.g:131:7: '===='
                    {
                    match("===="); 


                    }
                    break;
                case 5 :
                    // ioke.g:132:7: '<='
                    {
                    match("<="); 


                    }
                    break;
                case 6 :
                    // ioke.g:133:7: '>='
                    {
                    match(">="); 


                    }
                    break;
                case 7 :
                    // ioke.g:134:7: '~='
                    {
                    match("~="); 


                    }
                    break;
                case 8 :
                    // ioke.g:135:7: '~~='
                    {
                    match("~~="); 


                    }
                    break;
                case 9 :
                    // ioke.g:136:7: '!='
                    {
                    match("!="); 


                    }
                    break;
                case 10 :
                    // ioke.g:137:7: '!!='
                    {
                    match("!!="); 


                    }
                    break;
                case 11 :
                    // ioke.g:138:7: 'and'
                    {
                    match("and"); 


                    }
                    break;
                case 12 :
                    // ioke.g:139:7: 'or'
                    {
                    match("or"); 


                    }
                    break;

            }
            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end BinaryOperator

    // $ANTLR start Assignment
    public final void mAssignment() throws RecognitionException {
        try {
            int _type = Assignment;
            // ioke.g:142:12: ( '=' )
            // ioke.g:142:14: '='
            {
            match('='); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end Assignment

    // $ANTLR start Identifier
    public final void mIdentifier() throws RecognitionException {
        try {
            int _type = Identifier;
            // ioke.g:144:12: ( IdentStart ( IdentChars )* )
            // ioke.g:144:14: IdentStart ( IdentChars )*
            {
            mIdentStart(); 
            // ioke.g:144:25: ( IdentChars )*
            loop22:
            do {
                int alt22=2;
                int LA22_0 = input.LA(1);

                if ( (LA22_0=='!'||(LA22_0>='%' && LA22_0<='\'')||(LA22_0>='*' && LA22_0<='+')||(LA22_0>='-' && LA22_0<=':')||LA22_0=='<'||(LA22_0>='>' && LA22_0<='Z')||LA22_0=='\\'||(LA22_0>='^' && LA22_0<='z')||LA22_0=='|'||LA22_0=='~') ) {
                    alt22=1;
                }


                switch (alt22) {
            	case 1 :
            	    // ioke.g:144:25: IdentChars
            	    {
            	    mIdentChars(); 

            	    }
            	    break;

            	default :
            	    break loop22;
                }
            } while (true);


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end Identifier

    // $ANTLR start PossibleTerminator
    public final void mPossibleTerminator() throws RecognitionException {
        try {
            int _type = PossibleTerminator;
            // ioke.g:146:20: ( ( ( ';' | NewLine )+ ) )
            // ioke.g:146:22: ( ( ';' | NewLine )+ )
            {
            // ioke.g:146:22: ( ( ';' | NewLine )+ )
            // ioke.g:146:23: ( ';' | NewLine )+
            {
            // ioke.g:146:23: ( ';' | NewLine )+
            int cnt23=0;
            loop23:
            do {
                int alt23=2;
                int LA23_0 = input.LA(1);

                if ( (LA23_0=='\n'||LA23_0=='\r'||LA23_0==';') ) {
                    alt23=1;
                }


                switch (alt23) {
            	case 1 :
            	    // ioke.g:
            	    {
            	    if ( input.LA(1)=='\n'||input.LA(1)=='\r'||input.LA(1)==';' ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse =
            	            new MismatchedSetException(null,input);
            	        recover(mse);    throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt23 >= 1 ) break loop23;
                        EarlyExitException eee =
                            new EarlyExitException(23, input);
                        throw eee;
                }
                cnt23++;
            } while (true);


            }

            setText(";");

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end PossibleTerminator

    // $ANTLR start Whitespace
    public final void mWhitespace() throws RecognitionException {
        try {
            int _type = Whitespace;
            // ioke.g:148:12: ( Separator )
            // ioke.g:148:14: Separator
            {
            mSeparator(); 
            skip();

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end Whitespace

    // $ANTLR start Exponent
    public final void mExponent() throws RecognitionException {
        try {
            // ioke.g:152:10: ( ( 'e' | 'E' ) ( '+' | '-' )? Digits )
            // ioke.g:152:12: ( 'e' | 'E' ) ( '+' | '-' )? Digits
            {
            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse =
                    new MismatchedSetException(null,input);
                recover(mse);    throw mse;
            }

            // ioke.g:152:22: ( '+' | '-' )?
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0=='+'||LA24_0=='-') ) {
                alt24=1;
            }
            switch (alt24) {
                case 1 :
                    // ioke.g:
                    {
                    if ( input.LA(1)=='+'||input.LA(1)=='-' ) {
                        input.consume();

                    }
                    else {
                        MismatchedSetException mse =
                            new MismatchedSetException(null,input);
                        recover(mse);    throw mse;
                    }


                    }
                    break;

            }

            mDigits(); 

            }

        }
        finally {
        }
    }
    // $ANTLR end Exponent

    // $ANTLR start Letter
    public final void mLetter() throws RecognitionException {
        try {
            // ioke.g:155:8: ( 'a' .. 'z' | 'A' .. 'Z' )
            // ioke.g:
            {
            if ( (input.LA(1)>='A' && input.LA(1)<='Z')||(input.LA(1)>='a' && input.LA(1)<='z') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse =
                    new MismatchedSetException(null,input);
                recover(mse);    throw mse;
            }


            }

        }
        finally {
        }
    }
    // $ANTLR end Letter

    // $ANTLR start Digit
    public final void mDigit() throws RecognitionException {
        try {
            // ioke.g:158:7: ( '0' .. '9' )
            // ioke.g:158:9: '0' .. '9'
            {
            matchRange('0','9'); 

            }

        }
        finally {
        }
    }
    // $ANTLR end Digit

    // $ANTLR start Digits
    public final void mDigits() throws RecognitionException {
        try {
            // ioke.g:161:8: ( ( Digit )+ )
            // ioke.g:161:10: ( Digit )+
            {
            // ioke.g:161:10: ( Digit )+
            int cnt25=0;
            loop25:
            do {
                int alt25=2;
                int LA25_0 = input.LA(1);

                if ( ((LA25_0>='0' && LA25_0<='9')) ) {
                    alt25=1;
                }


                switch (alt25) {
            	case 1 :
            	    // ioke.g:161:10: Digit
            	    {
            	    mDigit(); 

            	    }
            	    break;

            	default :
            	    if ( cnt25 >= 1 ) break loop25;
                        EarlyExitException eee =
                            new EarlyExitException(25, input);
                        throw eee;
                }
                cnt25++;
            } while (true);


            }

        }
        finally {
        }
    }
    // $ANTLR end Digits

    // $ANTLR start HexLetter
    public final void mHexLetter() throws RecognitionException {
        try {
            // ioke.g:164:11: ( 'a' .. 'f' | 'A' .. 'F' )
            // ioke.g:
            {
            if ( (input.LA(1)>='A' && input.LA(1)<='F')||(input.LA(1)>='a' && input.LA(1)<='f') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse =
                    new MismatchedSetException(null,input);
                recover(mse);    throw mse;
            }


            }

        }
        finally {
        }
    }
    // $ANTLR end HexLetter

    // $ANTLR start Separator
    public final void mSeparator() throws RecognitionException {
        try {
            // ioke.g:167:11: ( ( ' ' | '\\u000c' | '\\u0009' | '\\u000b' | '\\\\' '\\u000a' )+ )
            // ioke.g:167:13: ( ' ' | '\\u000c' | '\\u0009' | '\\u000b' | '\\\\' '\\u000a' )+
            {
            // ioke.g:167:13: ( ' ' | '\\u000c' | '\\u0009' | '\\u000b' | '\\\\' '\\u000a' )+
            int cnt26=0;
            loop26:
            do {
                int alt26=6;
                switch ( input.LA(1) ) {
                case ' ':
                    {
                    alt26=1;
                    }
                    break;
                case '\f':
                    {
                    alt26=2;
                    }
                    break;
                case '\t':
                    {
                    alt26=3;
                    }
                    break;
                case '\u000B':
                    {
                    alt26=4;
                    }
                    break;
                case '\\':
                    {
                    alt26=5;
                    }
                    break;

                }

                switch (alt26) {
            	case 1 :
            	    // ioke.g:167:14: ' '
            	    {
            	    match(' '); 

            	    }
            	    break;
            	case 2 :
            	    // ioke.g:167:20: '\\u000c'
            	    {
            	    match('\f'); 

            	    }
            	    break;
            	case 3 :
            	    // ioke.g:167:31: '\\u0009'
            	    {
            	    match('\t'); 

            	    }
            	    break;
            	case 4 :
            	    // ioke.g:167:42: '\\u000b'
            	    {
            	    match('\u000B'); 

            	    }
            	    break;
            	case 5 :
            	    // ioke.g:167:53: '\\\\' '\\u000a'
            	    {
            	    match('\\'); 
            	    match('\n'); 

            	    }
            	    break;

            	default :
            	    if ( cnt26 >= 1 ) break loop26;
                        EarlyExitException eee =
                            new EarlyExitException(26, input);
                        throw eee;
                }
                cnt26++;
            } while (true);


            }

        }
        finally {
        }
    }
    // $ANTLR end Separator

    // $ANTLR start OpChars
    public final void mOpChars() throws RecognitionException {
        try {
            // ioke.g:170:9: ( ( '!' | '?' | '@' | '&' | '%' | '.' | '|' | '<' | '>' | '/' | '+' | '-' | '_' | ':' | '\\\\' | '*' | '^' | '~' | '`' | '\\'' ) )
            // ioke.g:170:11: ( '!' | '?' | '@' | '&' | '%' | '.' | '|' | '<' | '>' | '/' | '+' | '-' | '_' | ':' | '\\\\' | '*' | '^' | '~' | '`' | '\\'' )
            {
            if ( input.LA(1)=='!'||(input.LA(1)>='%' && input.LA(1)<='\'')||(input.LA(1)>='*' && input.LA(1)<='+')||(input.LA(1)>='-' && input.LA(1)<='/')||input.LA(1)==':'||input.LA(1)=='<'||(input.LA(1)>='>' && input.LA(1)<='@')||input.LA(1)=='\\'||(input.LA(1)>='^' && input.LA(1)<='`')||input.LA(1)=='|'||input.LA(1)=='~' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse =
                    new MismatchedSetException(null,input);
                recover(mse);    throw mse;
            }


            }

        }
        finally {
        }
    }
    // $ANTLR end OpChars

    // $ANTLR start IdentChars
    public final void mIdentChars() throws RecognitionException {
        try {
            // ioke.g:173:12: ( Letter | Digit | ( '!' | '?' | '@' | '&' | '%' | '.' | '|' | '<' | '>' | '/' | '+' | '-' | '_' | ':' | '\\\\' | '*' | '^' | '~' | '`' | '\\'' ) )
            // ioke.g:
            {
            if ( input.LA(1)=='!'||(input.LA(1)>='%' && input.LA(1)<='\'')||(input.LA(1)>='*' && input.LA(1)<='+')||(input.LA(1)>='-' && input.LA(1)<=':')||input.LA(1)=='<'||(input.LA(1)>='>' && input.LA(1)<='Z')||input.LA(1)=='\\'||(input.LA(1)>='^' && input.LA(1)<='z')||input.LA(1)=='|'||input.LA(1)=='~' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse =
                    new MismatchedSetException(null,input);
                recover(mse);    throw mse;
            }


            }

        }
        finally {
        }
    }
    // $ANTLR end IdentChars

    // $ANTLR start IdentStart
    public final void mIdentStart() throws RecognitionException {
        try {
            // ioke.g:176:12: ( Letter | Digit | ( '?' | '&' | '%' | '|' | '<' | '>' | '/' | '+' | '-' | '_' | '\\\\' | '*' | '^' | '~' ) )
            // ioke.g:
            {
            if ( (input.LA(1)>='%' && input.LA(1)<='&')||(input.LA(1)>='*' && input.LA(1)<='+')||input.LA(1)=='-'||(input.LA(1)>='/' && input.LA(1)<='9')||input.LA(1)=='<'||(input.LA(1)>='>' && input.LA(1)<='?')||(input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='\\'||(input.LA(1)>='^' && input.LA(1)<='_')||(input.LA(1)>='a' && input.LA(1)<='z')||input.LA(1)=='|'||input.LA(1)=='~' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse =
                    new MismatchedSetException(null,input);
                recover(mse);    throw mse;
            }


            }

        }
        finally {
        }
    }
    // $ANTLR end IdentStart

    // $ANTLR start NewLine
    public final void mNewLine() throws RecognitionException {
        try {
            // ioke.g:179:9: ( ( '\\u000a' | '\\u000d' ) )
            // ioke.g:179:11: ( '\\u000a' | '\\u000d' )
            {
            if ( input.LA(1)=='\n'||input.LA(1)=='\r' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse =
                    new MismatchedSetException(null,input);
                recover(mse);    throw mse;
            }


            }

        }
        finally {
        }
    }
    // $ANTLR end NewLine

    public void mTokens() throws RecognitionException {
        // ioke.g:1:8: ( MultiString | SimpleString | MultiComment | NewlineComment | OpenSimple | CloseSimple | OpenSquare | CloseSquare | OpenCurly | CloseCurly | Comma | HexInteger | Integer | Real | AssignmentOperator | UnaryOperator | BinaryOperator | Assignment | Identifier | PossibleTerminator | Whitespace )
        int alt27=21;
        alt27 = dfa27.predict(input);
        switch (alt27) {
            case 1 :
                // ioke.g:1:10: MultiString
                {
                mMultiString(); 

                }
                break;
            case 2 :
                // ioke.g:1:22: SimpleString
                {
                mSimpleString(); 

                }
                break;
            case 3 :
                // ioke.g:1:35: MultiComment
                {
                mMultiComment(); 

                }
                break;
            case 4 :
                // ioke.g:1:48: NewlineComment
                {
                mNewlineComment(); 

                }
                break;
            case 5 :
                // ioke.g:1:63: OpenSimple
                {
                mOpenSimple(); 

                }
                break;
            case 6 :
                // ioke.g:1:74: CloseSimple
                {
                mCloseSimple(); 

                }
                break;
            case 7 :
                // ioke.g:1:86: OpenSquare
                {
                mOpenSquare(); 

                }
                break;
            case 8 :
                // ioke.g:1:97: CloseSquare
                {
                mCloseSquare(); 

                }
                break;
            case 9 :
                // ioke.g:1:109: OpenCurly
                {
                mOpenCurly(); 

                }
                break;
            case 10 :
                // ioke.g:1:119: CloseCurly
                {
                mCloseCurly(); 

                }
                break;
            case 11 :
                // ioke.g:1:130: Comma
                {
                mComma(); 

                }
                break;
            case 12 :
                // ioke.g:1:136: HexInteger
                {
                mHexInteger(); 

                }
                break;
            case 13 :
                // ioke.g:1:147: Integer
                {
                mInteger(); 

                }
                break;
            case 14 :
                // ioke.g:1:155: Real
                {
                mReal(); 

                }
                break;
            case 15 :
                // ioke.g:1:160: AssignmentOperator
                {
                mAssignmentOperator(); 

                }
                break;
            case 16 :
                // ioke.g:1:179: UnaryOperator
                {
                mUnaryOperator(); 

                }
                break;
            case 17 :
                // ioke.g:1:193: BinaryOperator
                {
                mBinaryOperator(); 

                }
                break;
            case 18 :
                // ioke.g:1:208: Assignment
                {
                mAssignment(); 

                }
                break;
            case 19 :
                // ioke.g:1:219: Identifier
                {
                mIdentifier(); 

                }
                break;
            case 20 :
                // ioke.g:1:230: PossibleTerminator
                {
                mPossibleTerminator(); 

                }
                break;
            case 21 :
                // ioke.g:1:249: Whitespace
                {
                mWhitespace(); 

                }
                break;

        }

    }


    protected DFA17 dfa17 = new DFA17(this);
    protected DFA27 dfa27 = new DFA27(this);
    static final String DFA17_eotS =
        "\5\uffff";
    static final String DFA17_eofS =
        "\5\uffff";
    static final String DFA17_minS =
        "\2\56\3\uffff";
    static final String DFA17_maxS =
        "\1\71\1\145\3\uffff";
    static final String DFA17_acceptS =
        "\2\uffff\1\2\1\1\1\3";
    static final String DFA17_specialS =
        "\5\uffff}>";
    static final String[] DFA17_transitionS = {
            "\1\2\1\uffff\12\1",
            "\1\3\1\uffff\12\1\13\uffff\1\4\37\uffff\1\4",
            "",
            "",
            ""
    };

    static final short[] DFA17_eot = DFA.unpackEncodedString(DFA17_eotS);
    static final short[] DFA17_eof = DFA.unpackEncodedString(DFA17_eofS);
    static final char[] DFA17_min = DFA.unpackEncodedStringToUnsignedChars(DFA17_minS);
    static final char[] DFA17_max = DFA.unpackEncodedStringToUnsignedChars(DFA17_maxS);
    static final short[] DFA17_accept = DFA.unpackEncodedString(DFA17_acceptS);
    static final short[] DFA17_special = DFA.unpackEncodedString(DFA17_specialS);
    static final short[][] DFA17_transition;

    static {
        int numStates = DFA17_transitionS.length;
        DFA17_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA17_transition[i] = DFA.unpackEncodedString(DFA17_transitionS[i]);
        }
    }

    class DFA17 extends DFA {

        public DFA17(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 17;
            this.eot = DFA17_eot;
            this.eof = DFA17_eof;
            this.min = DFA17_min;
            this.max = DFA17_max;
            this.accept = DFA17_accept;
            this.special = DFA17_special;
            this.transition = DFA17_transition;
        }
        public String getDescription() {
            return "91:9: ( Digits '.' ( Digit )* ( Exponent )? | '.' Digits ( Exponent )? | Digits Exponent )";
        }
    }
    static final String DFA27_eotS =
        "\1\uffff\1\50\1\uffff\1\54\7\uffff\1\50\2\62\11\50\5\77\1\42\1\50"+
        "\1\102\1\50\2\42\3\uffff\1\50\1\uffff\1\50\1\uffff\1\50\3\uffff"+
        "\2\50\2\62\1\42\1\uffff\1\42\1\65\1\uffff\10\50\1\77\1\uffff\1\42"+
        "\1\50\1\uffff\1\42\1\50\1\65\1\116\1\42\2\65\2\42\1\50\1\42\1\uffff"+
        "\1\42\1\65\2\42\1\65\1\42\1\77";
    static final String DFA27_eofS =
        "\126\uffff";
    static final String DFA27_minS =
        "\1\11\1\41\1\uffff\1\43\7\uffff\3\41\1\60\15\41\1\145\1\41\1\75"+
        "\1\12\1\156\1\162\3\uffff\1\41\1\uffff\1\41\1\uffff\1\41\3\uffff"+
        "\4\41\1\60\1\uffff\1\53\1\41\1\uffff\11\41\1\uffff\1\164\1\41\1"+
        "\uffff\1\144\3\41\1\60\2\41\1\53\1\165\1\41\1\53\1\uffff\1\60\1"+
        "\41\1\162\1\60\1\41\1\156\1\41";
    static final String DFA27_maxS =
        "\2\176\1\uffff\1\43\7\uffff\3\176\1\71\15\176\1\145\1\176\1\75\1"+
        "\176\1\156\1\162\3\uffff\1\176\1\uffff\1\176\1\uffff\1\176\3\uffff"+
        "\4\176\1\146\1\uffff\1\71\1\176\1\uffff\11\176\1\uffff\1\164\1\176"+
        "\1\uffff\1\144\3\176\1\71\2\176\1\71\1\165\1\176\1\71\1\uffff\1"+
        "\71\1\176\1\162\1\71\1\176\1\156\1\176";
    static final String DFA27_acceptS =
        "\2\uffff\1\2\1\uffff\1\4\1\5\1\6\1\7\1\10\1\12\1\13\27\uffff\1\23"+
        "\1\24\1\25\1\uffff\1\1\1\uffff\1\21\1\uffff\1\17\1\3\1\11\5\uffff"+
        "\1\15\2\uffff\1\16\11\uffff\1\20\2\uffff\1\22\13\uffff\1\14\7\uffff";
    static final String DFA27_specialS =
        "\126\uffff}>";
    static final String[] DFA27_transitionS = {
            "\1\44\1\43\2\44\1\43\22\uffff\1\44\1\32\1\2\1\4\1\uffff\1\1"+
            "\1\25\1\30\1\5\1\6\1\21\1\13\1\12\1\17\1\16\1\20\1\14\11\15"+
            "\1\33\1\43\1\23\1\36\1\24\1\45\1\27\32\42\1\7\1\37\1\10\1\22"+
            "\1\45\1\31\1\40\15\42\1\41\2\42\1\34\10\42\1\3\1\26\1\11\1\35",
            "\1\51\3\uffff\1\47\2\51\2\uffff\2\51\1\uffff\3\51\12\42\1\51"+
            "\1\uffff\1\51\1\52\3\51\32\42\1\46\1\51\1\uffff\3\51\32\42\1"+
            "\46\1\51\1\uffff\1\51",
            "",
            "\1\53",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\51\3\uffff\3\51\2\uffff\1\51\1\55\1\uffff\1\51\1\56\1\51"+
            "\1\57\11\60\1\51\1\uffff\1\51\1\52\3\51\32\42\1\uffff\1\51\1"+
            "\uffff\3\51\32\42\1\uffff\1\51\1\uffff\1\51",
            "\1\42\3\uffff\3\42\2\uffff\2\42\1\uffff\1\42\1\64\1\42\12\60"+
            "\1\42\1\uffff\1\42\1\uffff\7\42\1\63\22\42\1\61\2\42\1\uffff"+
            "\1\42\1\uffff\7\42\1\63\22\42\1\61\2\42\1\uffff\1\42\1\uffff"+
            "\1\42",
            "\1\42\3\uffff\3\42\2\uffff\2\42\1\uffff\1\42\1\64\1\42\12\60"+
            "\1\42\1\uffff\1\42\1\uffff\7\42\1\63\25\42\1\uffff\1\42\1\uffff"+
            "\7\42\1\63\25\42\1\uffff\1\42\1\uffff\1\42",
            "\12\65",
            "\1\51\3\uffff\3\51\2\uffff\2\51\1\uffff\1\66\1\56\1\51\1\57"+
            "\11\60\1\51\1\uffff\1\51\1\52\3\51\32\42\1\uffff\1\51\1\uffff"+
            "\3\51\32\42\1\uffff\1\51\1\uffff\1\51",
            "\1\51\3\uffff\3\51\2\uffff\2\51\1\uffff\2\51\1\67\12\42\1\51"+
            "\1\uffff\1\51\1\52\3\51\32\42\1\uffff\1\51\1\uffff\3\51\32\42"+
            "\1\uffff\1\51\1\uffff\1\51",
            "\1\51\3\uffff\3\51\2\uffff\1\70\1\51\1\uffff\3\51\12\42\1\51"+
            "\1\uffff\1\51\1\52\3\51\32\42\1\uffff\1\51\1\uffff\3\51\32\42"+
            "\1\uffff\1\51\1\uffff\1\51",
            "\1\51\3\uffff\3\51\2\uffff\2\51\1\uffff\3\51\12\42\1\51\1\uffff"+
            "\1\51\1\52\3\51\32\42\1\uffff\1\51\1\uffff\1\71\2\51\32\42\1"+
            "\uffff\1\51\1\uffff\1\51",
            "\1\51\3\uffff\3\51\2\uffff\2\51\1\uffff\3\51\12\42\1\51\1\uffff"+
            "\1\72\1\uffff\3\51\32\42\1\uffff\1\51\1\uffff\3\51\32\42\1\uffff"+
            "\1\51\1\uffff\1\51",
            "\1\51\3\uffff\3\51\2\uffff\2\51\1\uffff\3\51\12\42\1\51\1\uffff"+
            "\1\51\1\uffff\1\73\2\51\32\42\1\uffff\1\51\1\uffff\3\51\32\42"+
            "\1\uffff\1\51\1\uffff\1\51",
            "\1\51\3\uffff\1\51\1\74\1\51\2\uffff\2\51\1\uffff\3\51\12\42"+
            "\1\51\1\uffff\1\51\1\52\3\51\32\42\1\uffff\1\51\1\uffff\3\51"+
            "\32\42\1\uffff\1\51\1\uffff\1\51",
            "\1\51\3\uffff\3\51\2\uffff\2\51\1\uffff\3\51\12\42\1\51\1\uffff"+
            "\1\51\1\52\3\51\32\42\1\uffff\1\51\1\uffff\3\51\32\42\1\uffff"+
            "\1\75\1\uffff\1\51",
            "\1\50\3\uffff\3\50\2\uffff\2\50\1\uffff\3\50\12\uffff\1\50\1"+
            "\uffff\1\50\1\uffff\2\50\1\76\33\uffff\1\50\1\uffff\3\50\33"+
            "\uffff\1\50\1\uffff\1\50",
            "\1\50\3\uffff\3\50\2\uffff\2\50\1\uffff\3\50\12\uffff\1\50\1"+
            "\uffff\1\50\1\uffff\3\50\33\uffff\1\50\1\uffff\3\50\33\uffff"+
            "\1\50\1\uffff\1\50",
            "\1\50\3\uffff\3\50\2\uffff\2\50\1\uffff\3\50\12\uffff\1\50\1"+
            "\uffff\1\50\1\uffff\3\50\33\uffff\1\50\1\uffff\3\50\33\uffff"+
            "\1\50\1\uffff\1\50",
            "\1\50\3\uffff\3\50\2\uffff\2\50\1\uffff\3\50\12\uffff\1\50\1"+
            "\uffff\5\50\33\uffff\1\50\1\uffff\3\50\33\uffff\1\50\1\uffff"+
            "\1\50",
            "\1\50\3\uffff\3\50\2\uffff\2\50\1\uffff\3\50\12\uffff\1\50\1"+
            "\uffff\1\50\1\uffff\3\50\33\uffff\1\50\1\uffff\3\50\33\uffff"+
            "\1\50\1\uffff\1\50",
            "\1\100",
            "\1\51\3\uffff\3\51\2\uffff\2\51\1\uffff\3\51\12\42\1\51\1\uffff"+
            "\1\51\1\uffff\3\51\32\42\1\uffff\1\51\1\uffff\3\51\32\42\1\uffff"+
            "\1\51\1\uffff\1\101",
            "\1\50",
            "\1\44\26\uffff\1\51\3\uffff\3\51\2\uffff\2\51\1\uffff\3\51\12"+
            "\42\1\51\1\uffff\1\51\1\uffff\3\51\32\42\1\uffff\1\51\1\uffff"+
            "\3\51\32\42\1\uffff\1\51\1\uffff\1\51",
            "\1\103",
            "\1\104",
            "",
            "",
            "",
            "\1\51\3\uffff\3\51\2\uffff\2\51\1\uffff\3\51\12\42\1\51\1\uffff"+
            "\1\51\1\uffff\3\51\32\42\1\uffff\1\51\1\uffff\3\51\32\42\1\uffff"+
            "\1\51\1\uffff\1\51",
            "",
            "\1\51\3\uffff\3\51\2\uffff\2\51\1\uffff\3\51\12\42\1\51\1\uffff"+
            "\1\51\1\52\3\51\32\42\1\uffff\1\51\1\uffff\3\51\32\42\1\uffff"+
            "\1\51\1\uffff\1\51",
            "",
            "\1\51\3\uffff\3\51\2\uffff\2\51\1\uffff\3\51\12\42\1\51\1\uffff"+
            "\1\51\1\uffff\3\51\32\42\1\uffff\1\51\1\uffff\3\51\32\42\1\uffff"+
            "\1\51\1\uffff\1\51",
            "",
            "",
            "",
            "\1\51\3\uffff\3\51\2\uffff\2\51\1\uffff\3\51\12\42\1\51\1\uffff"+
            "\1\51\1\52\3\51\32\42\1\uffff\1\51\1\uffff\3\51\32\42\1\uffff"+
            "\1\51\1\uffff\1\51",
            "\1\51\3\uffff\3\51\2\uffff\2\51\1\uffff\3\51\12\105\1\51\1\uffff"+
            "\1\51\1\uffff\3\51\32\42\1\uffff\1\51\1\uffff\3\51\32\42\1\uffff"+
            "\1\51\1\uffff\1\51",
            "\1\42\3\uffff\3\42\2\uffff\2\42\1\uffff\1\42\1\64\1\42\12\60"+
            "\1\42\1\uffff\1\42\1\uffff\7\42\1\63\22\42\1\61\2\42\1\uffff"+
            "\1\42\1\uffff\7\42\1\63\22\42\1\61\2\42\1\uffff\1\42\1\uffff"+
            "\1\42",
            "\1\42\3\uffff\3\42\2\uffff\2\42\1\uffff\1\42\1\64\1\42\12\60"+
            "\1\42\1\uffff\1\42\1\uffff\7\42\1\63\25\42\1\uffff\1\42\1\uffff"+
            "\7\42\1\63\25\42\1\uffff\1\42\1\uffff\1\42",
            "\12\106\7\uffff\6\106\32\uffff\6\106",
            "",
            "\1\107\1\uffff\1\107\2\uffff\12\110",
            "\1\42\3\uffff\3\42\2\uffff\2\42\1\uffff\3\42\12\111\1\42\1\uffff"+
            "\1\42\1\uffff\7\42\1\112\25\42\1\uffff\1\42\1\uffff\7\42\1\112"+
            "\25\42\1\uffff\1\42\1\uffff\1\42",
            "",
            "\1\51\3\uffff\3\51\2\uffff\2\51\1\uffff\3\51\12\42\1\51\1\uffff"+
            "\1\51\1\52\3\51\32\42\1\uffff\1\51\1\uffff\3\51\32\42\1\uffff"+
            "\1\51\1\uffff\1\51",
            "\1\51\3\uffff\3\51\2\uffff\2\51\1\uffff\3\51\12\42\1\51\1\uffff"+
            "\1\51\1\52\3\51\32\42\1\uffff\1\51\1\uffff\3\51\32\42\1\uffff"+
            "\1\51\1\uffff\1\51",
            "\1\51\3\uffff\3\51\2\uffff\2\51\1\uffff\3\51\12\42\1\51\1\uffff"+
            "\1\51\1\52\3\51\32\42\1\uffff\1\51\1\uffff\3\51\32\42\1\uffff"+
            "\1\51\1\uffff\1\51",
            "\1\51\3\uffff\3\51\2\uffff\2\51\1\uffff\3\51\12\42\1\51\1\uffff"+
            "\1\51\1\52\3\51\32\42\1\uffff\1\51\1\uffff\3\51\32\42\1\uffff"+
            "\1\51\1\uffff\1\51",
            "\1\51\3\uffff\3\51\2\uffff\2\51\1\uffff\3\51\12\42\1\51\1\uffff"+
            "\1\51\1\52\3\51\32\42\1\uffff\1\51\1\uffff\3\51\32\42\1\uffff"+
            "\1\51\1\uffff\1\51",
            "\1\51\3\uffff\3\51\2\uffff\2\51\1\uffff\3\51\12\42\1\51\1\uffff"+
            "\1\51\1\52\3\51\32\42\1\uffff\1\51\1\uffff\3\51\32\42\1\uffff"+
            "\1\51\1\uffff\1\51",
            "\1\51\3\uffff\3\51\2\uffff\2\51\1\uffff\3\51\12\42\1\51\1\uffff"+
            "\1\51\1\52\3\51\32\42\1\uffff\1\51\1\uffff\3\51\32\42\1\uffff"+
            "\1\51\1\uffff\1\51",
            "\1\51\3\uffff\3\51\2\uffff\2\51\1\uffff\3\51\12\42\1\51\1\uffff"+
            "\1\51\1\52\3\51\32\42\1\uffff\1\51\1\uffff\3\51\32\42\1\uffff"+
            "\1\51\1\uffff\1\51",
            "\1\50\3\uffff\3\50\2\uffff\2\50\1\uffff\3\50\12\uffff\1\50\1"+
            "\uffff\1\50\1\uffff\3\50\33\uffff\1\50\1\uffff\3\50\33\uffff"+
            "\1\50\1\uffff\1\50",
            "",
            "\1\113",
            "\1\51\3\uffff\3\51\2\uffff\2\51\1\uffff\3\51\12\42\1\51\1\uffff"+
            "\1\51\1\uffff\3\51\32\42\1\uffff\1\51\1\uffff\3\51\32\42\1\uffff"+
            "\1\51\1\uffff\1\51",
            "",
            "\1\114",
            "\1\42\3\uffff\3\42\2\uffff\2\42\1\uffff\16\42\1\uffff\1\42\1"+
            "\uffff\35\42\1\uffff\1\42\1\uffff\35\42\1\uffff\1\42\1\uffff"+
            "\1\42",
            "\1\42\3\uffff\3\42\2\uffff\2\42\1\uffff\3\42\12\105\1\42\1\uffff"+
            "\1\42\1\uffff\7\42\1\115\25\42\1\uffff\1\42\1\uffff\7\42\1\115"+
            "\25\42\1\uffff\1\42\1\uffff\1\42",
            "\1\42\3\uffff\3\42\2\uffff\2\42\1\uffff\3\42\12\106\1\42\1\uffff"+
            "\1\42\1\uffff\3\42\6\106\24\42\1\uffff\1\42\1\uffff\3\42\6\106"+
            "\24\42\1\uffff\1\42\1\uffff\1\42",
            "\12\110",
            "\1\42\3\uffff\3\42\2\uffff\2\42\1\uffff\3\42\12\110\1\42\1\uffff"+
            "\1\42\1\uffff\35\42\1\uffff\1\42\1\uffff\35\42\1\uffff\1\42"+
            "\1\uffff\1\42",
            "\1\42\3\uffff\3\42\2\uffff\2\42\1\uffff\3\42\12\111\1\42\1\uffff"+
            "\1\42\1\uffff\7\42\1\112\25\42\1\uffff\1\42\1\uffff\7\42\1\112"+
            "\25\42\1\uffff\1\42\1\uffff\1\42",
            "\1\117\1\uffff\1\117\2\uffff\12\120",
            "\1\121",
            "\1\42\3\uffff\3\42\2\uffff\2\42\1\uffff\16\42\1\uffff\1\42\1"+
            "\uffff\35\42\1\uffff\1\42\1\uffff\35\42\1\uffff\1\42\1\uffff"+
            "\1\42",
            "\1\122\1\uffff\1\122\2\uffff\12\123",
            "",
            "\12\120",
            "\1\42\3\uffff\3\42\2\uffff\2\42\1\uffff\3\42\12\120\1\42\1\uffff"+
            "\1\42\1\uffff\35\42\1\uffff\1\42\1\uffff\35\42\1\uffff\1\42"+
            "\1\uffff\1\42",
            "\1\124",
            "\12\123",
            "\1\42\3\uffff\3\42\2\uffff\2\42\1\uffff\3\42\12\123\1\42\1\uffff"+
            "\1\42\1\uffff\35\42\1\uffff\1\42\1\uffff\35\42\1\uffff\1\42"+
            "\1\uffff\1\42",
            "\1\125",
            "\1\42\3\uffff\3\42\2\uffff\2\42\1\uffff\16\42\1\uffff\1\42\1"+
            "\uffff\35\42\1\uffff\1\42\1\uffff\35\42\1\uffff\1\42\1\uffff"+
            "\1\42"
    };

    static final short[] DFA27_eot = DFA.unpackEncodedString(DFA27_eotS);
    static final short[] DFA27_eof = DFA.unpackEncodedString(DFA27_eofS);
    static final char[] DFA27_min = DFA.unpackEncodedStringToUnsignedChars(DFA27_minS);
    static final char[] DFA27_max = DFA.unpackEncodedStringToUnsignedChars(DFA27_maxS);
    static final short[] DFA27_accept = DFA.unpackEncodedString(DFA27_acceptS);
    static final short[] DFA27_special = DFA.unpackEncodedString(DFA27_specialS);
    static final short[][] DFA27_transition;

    static {
        int numStates = DFA27_transitionS.length;
        DFA27_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA27_transition[i] = DFA.unpackEncodedString(DFA27_transitionS[i]);
        }
    }

    class DFA27 extends DFA {

        public DFA27(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 27;
            this.eot = DFA27_eot;
            this.eof = DFA27_eof;
            this.min = DFA27_min;
            this.max = DFA27_max;
            this.accept = DFA27_accept;
            this.special = DFA27_special;
            this.transition = DFA27_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( MultiString | SimpleString | MultiComment | NewlineComment | OpenSimple | CloseSimple | OpenSquare | CloseSquare | OpenCurly | CloseCurly | Comma | HexInteger | Integer | Real | AssignmentOperator | UnaryOperator | BinaryOperator | Assignment | Identifier | PossibleTerminator | Whitespace );";
        }
    }
 

}