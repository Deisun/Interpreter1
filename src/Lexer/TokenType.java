/**
 * Created by Rob on 6/19/2017.
 *
 * A list of possible Lexer.Token types
 *
 */
package Lexer;

public enum TokenType {

    // type                     code
    ID_TOK                      ("1"),
    ASSIGN_TOK                  ("2"),
    LE_TOK                      ("3"),
    LT_TOK                      ("4"),
    GE_TOK                      ("5"),
    GT_TOK                      ("6"),
    EQ_TOK                      ("7"),
    NE_TOK                      ("8"),
    ADD_TOK                     ("9"),
    SUB_TOK                     ("10"),
    MUL_TOK                     ("11"),
    DIV_TOK                     ("12"),
    SPECIFICATIONS_TOK          ("13"),
    SYMBOL_TOK                  ("14"),
    FORWARD_TOK                 ("15"),
    REFERENCES_TOK              ("16"),
    FUNCTION_TOK                ("17"),
    POINTER_TOK                 ("18"),
    ARRAY_TOK                   ("19"),
    TYPE_TOK                    ("20"),
    STRUCT_TOK                  ("21"),
    INTEGER_TOK                 ("22"),
    ENUM_TOK                    ("23"),
    GLOBAL_TOK                  ("24"),
    DECLARATIONS_TOK            ("25"),
    IMPLEMENTATIONS_TOK         ("26"),
    MAIN_TOK                    ("27"),
    PARAMETERS_TOK              ("28"),
    CONSTANTS_TOK               ("29"),
    BEGIN_TOK                   ("30"),
    ENDFUN_TOK                  ("31"),
    IF_TOK                      ("32"),
    THEN_TOK                    ("33"),
    ELSE_TOK                    ("34"),
    ENDIF_TOK                   ("36"),
    REPEAT_TOK                  ("37"),
    UNTIL_TOK                   ("38"),
    ENDREPEAT_TOK               ("39"),
    DISPLAY_TOK                 ("40"),
    SET_TOK                     ("41"),
    RETURN_TOK                  ("42"),
    EOS_TOK                     ("43"),
    LEFTPAREN_TOK               ("44"),
    RIGHTPAREN_TOK              ("45"),
    LEFTBRACKET_TOK             ("46"),
    RIGHTBRACKET_TOK            ("47"),
    LEFTRIGHTBRACKET_TOK        ("48"),
    DEFINE_TOK                  ("49"),
    WHILE_TOK                   ("50"),
    DO_TOK                      ("51"),
    ENDWHILE_TOK                ("52"),
    COMMA_TOK                   ("53"),
    INT_TOK                     ("54"),
    VARIABLES_TOK               ("55"),
    INVALID_TOK                 ("99");

    private final String tokCode;

    TokenType(String tokCode) {
        this.tokCode = tokCode;
    }

    public String getTokCode() {
        return tokCode;
    }

}
