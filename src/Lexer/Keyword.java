/**
 * Created by Rob on 6/21/2017.
 *
 * Contains all the pre-defined keywords of the SCL subset language
 *
 */

package Lexer;

public enum Keyword {

    // generate keywords with lexeme and token type properties
    SPECIFICATIONS_KEYWORD ("specifications", TokenType.SPECIFICATIONS_TOK),
    SYMBOL_KEYWORD         ("symbol", TokenType.SYMBOL_TOK),
    FORWARD_KEYWORD        ("forward", TokenType.FORWARD_TOK),
    REFERENCES_KEYWORD     ("references", TokenType.REFERENCES_TOK),
    FUNCTION_KEYWORD       ("function", TokenType.FUNCTION_TOK),
    POINTER_KEYWORD        ("pointer", TokenType.POINTER_TOK),
    ARRAY_KEYWORD          ("array", TokenType.ARRAY_TOK),
    TYPE_KEYWORD           ("type", TokenType.TYPE_TOK),
    STRUCT_KEYWORD         ("struct", TokenType.STRUCT_TOK),
    INTEGER_KEYWORD        ("integer", TokenType.INTEGER_TOK),
    ENUM_KEYWORD           ("enum", TokenType.ENUM_TOK),
    GLOBAL_KEYWORD         ("global", TokenType.GLOBAL_TOK),
    DECLARATIONS_KEYWORD   ("declarations", TokenType.DECLARATIONS_TOK),
    IMPLEMENTATIONS_KEYWORD("implementations", TokenType.IMPLEMENTATIONS_TOK),
    MAIN_KEYWORD           ("main", TokenType.MAIN_TOK),
    PARAMETERS_KEYWORD     ("parameters", TokenType.PARAMETERS_TOK),
    CONSTANT_KEYWORD       ("constant", TokenType.CONSTANT_TOK),
    BEGIN_KEYWORD          ("begin", TokenType.BEGIN_TOK),
    ENDFUN_KEYWORD         ("endfun", TokenType.ENDFUN_TOK),
    IF_KEYWORD             ("if", TokenType.IF_TOK),
    THEN_KEYWORD           ("then", TokenType.THEN_TOK),
    ELSE_KEYWORD           ("else", TokenType.ELSE_TOK),
    ENDIF_KEYWORD          ("endif", TokenType.ENDIF_TOK),
    REPEAT_KEYWORD         ("repeat", TokenType.REPEAT_TOK),
    UNTIL_KEYWORD          ("until", TokenType.UNTIL_TOK),
    ENDREPEAT_KEYWORD      ("endrepeat", TokenType.ENDREPEAT_TOK),
    DISPLAY_KEYWORD        ("display", TokenType.DISPLAY_TOK),
    SET_KEYWORD            ("set", TokenType.SET_TOK),
    RETURN_KEYWORD         ("return", TokenType.RETURN_TOK),
    DEFINE_KEYWORD         ("define", TokenType.DEFINE_TOK),
    WHILE_KEYWORD          ("while", TokenType.WHILE_TOK),
    ENDWHILE_KEYWORD       ("endwhile", TokenType.ENDWHILE_TOK),
    DO_KEYWORD             ("do", TokenType.DO_TOK);
    

    private final String lexeme;
    private final TokenType tokType;
    private final String tokCode;


    Keyword(String lexeme, TokenType tokType) {
        this.lexeme = lexeme;
        this.tokType = tokType;
        this.tokCode = tokType.getTokCode();
    }


    public String getLexeme() {return lexeme;}

    public TokenType getTokType() {return tokType;}

    public String getTokCode() {return tokCode;}


}
