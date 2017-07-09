/*
 * Project           : Robs SCL Interpreter
 * Program name      : RobsInterpreter.java
 * Author            : Robert Douma
 * Date created      : 6/18/2017
 * Class:            : Kennesaw State University - CS4308 - Concepts of Programming Languages
 * Instructor:       : Dr. Jose M. Garrido
 *
 * Purpose           : To implement a SCL subset interpreter using Java
 *
 */

import Lexer.LexicalAnalyzer;
import Parser.SyntaxAnalyzer;
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

                // create Lexical Analyzer object to scan files with
                LexicalAnalyzer lexer = new LexicalAnalyzer();

                lexer.analyze(file);
                // create Syntax Analyzer object to parse tokens
                SyntaxAnalyzer parser = new SyntaxAnalyzer(lexer);

                parser.parse();


                // show resulting token list after lexical analysis of the file
                // DisplayTokens(tokens);

            }
        }
    }


}
