package Lexer; /**
 * Created by Rob on 6/19/2017.
 *
 * Lexer.LexicalAnalyzer scans a file and returns
 * a list of tokens based on the rules and conditions of the language
 *
 */

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class LexicalAnalyzer {

    private List<Token> tokens;

    public LexicalAnalyzer(File file) {

        tokens = new ArrayList<Token>();
        int lineNumber = 0;

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

    public List<Token> getTokens() {
        return tokens;
    }

    // processLine() will take a line and process it to look for tokens
    private void processLine(String line, int lineNumber) {

        // make sure there's something to process
        assert (line != null && lineNumber >= 1);
        int index = 0;

        // skip any whitespace at the beginning
        index = skipWhiteSpace(line, index);

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
    }

    // skipeWhiteSpace() will skip any whitespace between lexemes
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
    private TokenType getTokenType(String lexeme, int lineNumber, int columnNumber) {

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

        // check for identifiers
        if (Character.isLetter(firstChar)) {

            if (lexeme.matches("[a-zA-Z0-9]+"))
                tokType = TokenType.ID_TOK;

        }
        // check for constants
        else if (Character.isDigit(firstChar)) {

            if (lexeme.matches("[0-9]+"))
                tokType = TokenType.CONSTANT_TOK;

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

                default:
                    tokType = TokenType.INVALID_TOK;
            }
        }

        return tokType;

    }

}
