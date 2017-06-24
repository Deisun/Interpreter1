/************************************************************************
 * Project           : Robs SCL Interpreter
 * Program name      : RobsInterpreter.java
 * Author            : Robert Douma
 * Date created      : 6/18/2017
 * Class:            : Kennesaw State University - CS4308 - Concepts of Programming Languages
 * Instructor:       : Dr. Jose M. Garrido
 *
 * Purpose           : To implement a SCL subset interpreter using Java
 *
 * Revision History  :
 *
 ***********************************************************************/

import Lexer.LexicalAnalyzer;
import Lexer.Token;

import java.io.*;

public class RobsInterpreter {

    public static void main(String[] args ) {



        // check to see if argument was provided correctly for filename.ext
        if (args.length == 0) {
            System.out.println("Error: No filename was given.  Syntax: RobsInterpreter [filename.ext]");
        } else {

            // create a file object using the filename provided by command line
            File file = new File(args[0]);

            // check to see if file exists
            if (!file.isFile()) {
                System.out.println("Error: No filename exists at: " + file.toString());
            } else {

                // get Lexical Analyzer object to scan files with
                LexicalAnalyzer lexer = new LexicalAnalyzer(file);

                // show resulting token list after lexical analysis of the file
                DisplayTokens(lexer);
            }
        }
    }

    // display the list of all tokens, token types and token codes
    private static void DisplayTokens(LexicalAnalyzer lexer) {
        System.out.printf("\n \t%-20s%20s%20s \n", "Lexeme", "Token Type", "Token Code");
        System.out.printf("\t%-20s \n", "-------------------------------------------------------------");
        for (Token t : lexer.getTokens()) {

            System.out.printf("\t%-20s%20s%20s \n", t.getLexeme(), t.getTokType(), t.getTokCode());
        }
    }
}
