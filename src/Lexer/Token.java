/**
 * Created by Rob on 6/19/2017.
 *
 * Lexer.Token stores important token information such as location (row/col number) as well as
 * the lexeme and Lexer.TokenType.
 *
 */

package Lexer;


public class Token {

    private int rowNumber;
    private int colNumber;
    private String tokCode;
    private String lexeme;
    private TokenType tokType;


    public Token(int rowNumber, int colNumber, String lexeme, TokenType tokType) {

        // row number cannot be less than or equal to zero
        if (rowNumber <= 0)
            throw new IllegalArgumentException("invalid row number argument");

        // column number cannot be less than or equal to zero
        if (colNumber <= 0)
            throw new IllegalArgumentException("invalid column number argument");

        // lexeme must exist or error
        if (lexeme == null || lexeme.length() == 0)
            throw new IllegalArgumentException("invalid lexeme argument");

        // tokType must exist or error
        if (tokType == null)
            throw new IllegalArgumentException("invalid Lexer.TokenType argument");


        this.rowNumber = rowNumber;
        this.colNumber = colNumber;
        this.lexeme = lexeme;
        this.tokType = tokType;
        this.tokCode = tokType.getTokCode();
    }


    // public methods

    public int getRowNumber() {
        return rowNumber;
    }

    public int getColNumber() {
        return colNumber;
    }

    public String getLexeme() {
        return lexeme;
    }

    public TokenType getTokType() {
        return tokType;
    }

    public String getTokCode() { return tokCode; }


}
