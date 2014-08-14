

package robot.interpreter;

/**
 * An exception that will be thrown and caught by the interpreter when the file fails to parse.
 *
 * @author Paul Esson
 */
public class CommandFormatException extends Exception{
    public CommandFormatException(String message){
        super(message);
    }
}
