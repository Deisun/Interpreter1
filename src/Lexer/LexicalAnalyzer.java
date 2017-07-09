/*
 * Created by Rob on 6/19/2017.
 *
 * Lexer.LexicalAnalyzer scans a file and returns
 * a list of tokens based on the rules and conditions of the language
 *
 */

package Lexer;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



public class LexicalAnalyzer {

    private List<Token> tokens;
    private int lineNumber;
    private static int tokIndex;


    public LexicalAnalyzer() {

        this.tokens = new ArrayList<>();
        this.lineNumber = 0;
        tokIndex = 0;
    }

    public void analyze(File file) {
        try {

            // try opening file
            Scanner input = new Scanner(file);

            while (input.hasNext()) {

                // get the next line
                String line = input.nextLine();

                // process the line
                processLine(line, lineNumber);

                lineNumber++;

            }

            // at the end of the token list, we add an EOS - End of String token
            tokens.add(new Token (lineNumber, 1, "EOS", TokenType.EOS_TOK));


            // close the file
            input.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public Token getNextToken() {
        Token tok = tokens.get(tokIndex);
        tokIndex++;
        return tok;
    }


    // processLine() will take a line and process it to look for tokens
    private void processLine(String line, int lineNumber) {

        // make sure there's something to process
        assert (line != null && lineNumber >= 1);
        int index = 0;

        // skip any whitespace at the beginning
        index = skipWhiteSpace(line, index);

        try {
            // loop through all characters in the line
            while (index < line.length()) {

                // get the next lexeme
                String lexeme = getLexeme(line, lineNumber, index);

                // get the token type of the lexeme
                TokenType tokType = getTokenType(lexeme, lineNumber, index);

                // add the token to the token list
                tokens.add(new Token(lineNumber + 1, index + 1, lexeme, tokType));

                // move the index to the end of the lexeme in the string
                index += lexeme.length();

                // skip more white space
                index = skipWhiteSpace(line, index);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }


    // skipWhiteSpace() will skip any whitespace between lexemes
    private int skipWhiteSpace(String line, int index) {

        // make sure there's something to process
        assert (line != null && index >= 0);

        // loop until end of line OR end of whitespace
        while (index < line.length() && Character.isWhitespace(line.charAt(index)))
            index++;

        return index;
    }


    // getLexeme() takes a string line and returns a luxeme
    private String getLexeme(String line, int lineNumber, int index) {

        // make sure there's something to process
        assert (line != null && lineNumber >= 1 && index >= 0);

        int i = index;



        // loop until whitespace or end of line
        while (i < line.length() && !Character.isWhitespace(line.charAt(i))) {

            i++;
        }

        // get the substring and return it as the lexeme string
        return line.substring(index, i);
    }


    // getTokenType() takes a lexeme and matches and returns its Token Type
    private TokenType getTokenType(String lexeme, int lineNumber, int columnNumber) throws LexicalException {

        // make sure there's something to process
        assert (lexeme != null && lineNumber >= 1 && columnNumber >= 1);

        TokenType tokType = null;

        // get the first character
        Character firstChar = lexeme.charAt(0);



        // check for keywords first
        for (Keyword k : Keyword.values()) {
            if (k.getLexeme().equals(lexeme)) {
                tokType = k.getTokType();
                return tokType;
            } else
                tokType = TokenType.INVALID_TOK;
        }

        // check if lexeme matches identifier tokens
        if (Character.isLetter(firstChar)) {

            if (lexeme.matches("[a-zA-Z0-9_]+"))
                tokType = TokenType.ID_TOK;
            else
                throw new LexicalException("Error: invalid lexeme at line number: " + (lineNumber+1) + " and column " + (columnNumber+1));

        }
        // check if lexeme matches constant tokens
        else if (Character.isDigit(firstChar)) {

            if (lexeme.matches("[0-9]+"))
                tokType = TokenType.CONSTANT_TOK;
            else
                throw new LexicalException("Error: invalid lexeme at line number: " + (lineNumber+1) + " and column " + (columnNumber+1));

        }
        // check for operator tokens with 1 character
        else if (lexeme.length() == 1) {

            switch (lexeme) {

                case "+":
                    tokType = TokenType.ADD_TOK;
                    break;

                case "-":
                    tokType = TokenType.SUB_TOK;
                    break;

                case "*":
                    tokType = TokenType.MUL_TOK;
                    break;

                case "\\":
                    tokType = TokenType.DIV_TOK;
                    break;

                case "=":
                    tokType = TokenType.ASSIGN_TOK;
                    break;

                case "<":
                    tokType = TokenType.LT_TOK;
                    break;

                case ">":
                    tokType = TokenType.GT_TOK;
                    break;

                case "[":
                    tokType = TokenType.LEFTBRACKET_TOK;
                    break;

                case "]":
                    tokType = TokenType.RIGHTBRACKET_TOK;
                    break;

                case "(":
                    tokType = TokenType.LEFTPAREN_TOK;
                    break;

                case ")":
                    tokType = TokenType.RIGHTPAREN_TOK;
                    break;

                case ",":
                    tokType = TokenType.COMMA_TOK;
                    break;


                default:
                    tokType = TokenType.INVALID_TOK;
            }
        }
        // check for operators tokens with 2 characters
        else if (lexeme.length() == 2) {

            switch (lexeme) {

                case "<=":
                    tokType = TokenType.LE_TOK;
                    break;

                case ">=":
                    tokType = TokenType.GE_TOK;
                    break;

                case "==":
                    tokType = TokenType.EQ_TOK;
                    break;

                case "!=":
                    tokType = TokenType.NE_TOK;
                    break;

                case "[]":
                    tokType = TokenType.LEFTRIGHTBRACKET_TOK;
                    break;

                default:
                    tokType = TokenType.INVALID_TOK;
            }
        }

        return tokType;
    }



    private  void DisplayTokens() {
        System.out.printf("\n \t%-20s%20s%20s \n", "Lexeme", "Token Type", "Token Code");
        System.out.printf("\t%-20s \n", "-------------------------------------------------------------");
        for (Token t : tokens) {

            System.out.printf("\t%-20s%20s%20s \n", t.getLexeme(), t.getTokType(), t.getTokCode());
        }
    }
}
