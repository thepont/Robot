package robot;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import robot.interpreter.Interpreter;

/**
 *
 * @author Paul Esson
 */
public class Program {

    static final String FILE_ARG_MISSING_ERROR = "Please pass an input file for the robot to follow.\n";
    static final String FILE_MISSING_ERROR = "The file %s is an illusion, please check your reality then try again.\n";

    /**
     * @param args the command line arguments should contain the location of a file to interpret.
     */
    public static void main(String[] args) {
        //Open the file and pass the contents to our interpreter.
        Interpreter intepreter = new Interpreter();
        String filename = "";
        FileInputStream fin = null;
        if (args.length > 0) {
            filename = args[0];
        } else {
            System.out.printf(FILE_ARG_MISSING_ERROR);
            System.exit(1);
        }

        try {
            fin = new FileInputStream(filename);
            intepreter.interpret(fin);
        } catch (FileNotFoundException e) {
            System.err.printf(FILE_MISSING_ERROR, filename);
        } finally {
            try {
                if (fin != null) {
                    fin.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
