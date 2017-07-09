/**
 * Created by Rob on 6/24/2017.
 *
 * Used for exception output in case of lexical violation of rules
 */

package Lexer;


public class LexicalException extends Exception {
    public LexicalException(String s) {
        super(s);
    }
}
