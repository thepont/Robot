package robot.interpreter;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.util.StringTokenizer;
import robot.Direction;
import robot.Location;
import robot.Robot;
import robot.command.*;

/**
 *
 * @author Paul Esson
 */
public class Interpreter {

    final static String LINE_NUMBER = "LINE : %d ";
    final static String UNKNOWN_COMMAND = "The command %s is unknown\n";
    final static String INVALID_FORMAT_LOCATION = "Unable to parse %s. Not part of a valid location\n";

    final static String TOKENS = " ,\n\r";
    final static String LINE_COMMENT = "//";

    /**
     * CommandExpression stores our basic commands against their names for execution by our robot.
     */
    public enum CommandExpression {

        PLACE(new PlaceCommand()),
        REPORT(new ReportCommand()),
        MOVE(new MoveCommand()),
        RIGHT(new RightCommand()),
        LEFT(new LeftCommand());

        ICommand cmd;

        CommandExpression(ICommand cmd) {
            this.cmd = cmd;
        }
    }

    /**
     * Parses the input stream interpreting robot commands.
     * 
     * @param context input stream to interpret.
     */
    public void interpret(InputStream context) {
        LineNumberReader in = new LineNumberReader(new InputStreamReader(context));
        Robot robot = Robot.getInstance();
        String line;
        Location placeLoc;
        try {
            while ((line = in.readLine()) != null) {
                //Read the next line if the current one is a comment
                if (line.startsWith(LINE_COMMENT)) {
                    continue;
                }

                StringTokenizer st = new StringTokenizer(line, TOKENS);
                CommandExpression currentCommand = null;
                while (st.hasMoreElements()) {

                    try {
                        currentCommand = interpretCommand(st);
                        if (currentCommand == CommandExpression.PLACE) {
                            placeLoc = interpretPlaceLocation(st);
                            ((PlaceCommand) CommandExpression.PLACE.cmd).setNewLocation(placeLoc);
                        }
                    } catch (CommandFormatException e) {
                        System.err.printf(LINE_NUMBER, in.getLineNumber());
                        System.err.println(e.getMessage());
                    }
                }
                if (currentCommand != null) {
                    robot.executeCommand(currentCommand.cmd);
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            try {
                in.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    /**
     * Checks a token in the input stream for a valid command.
     * 
     * @param st StringTokenizer containing command input. 
     * @return Command input relates to
     * @throws CommandFormatException if token interpreted does not correspond to a known command
     */
    public CommandExpression interpretCommand(StringTokenizer st) throws CommandFormatException {
        String commandText = st.nextToken();
        try {
            return CommandExpression.valueOf(commandText);
        } catch (IllegalArgumentException e) {
            String exceptionmessage = String.format(UNKNOWN_COMMAND, commandText);
            throw new CommandFormatException(exceptionmessage);
        }
    }
    /**
     * Attempts to interpret tokens as location data.
     * 
     * @param st StringTokenizer containing location input. 
     * @return Location parsed 
     * @throws CommandFormatException if the tokens do not correspond to location data.
     */
    
    public Location interpretPlaceLocation(StringTokenizer st) throws CommandFormatException {
        int newX = 0, newY = 0;
        Direction newDirection = null;
        String currentToken = "";
        try {
            currentToken = st.nextToken();
            newX = Integer.parseInt(currentToken);
            currentToken = st.nextToken();
            newY = Integer.parseInt(currentToken);
            currentToken = st.nextToken();
            newDirection = Direction.valueOf(currentToken);
        } catch (IllegalArgumentException e) {
            String exceptionmessage = String.format(INVALID_FORMAT_LOCATION, currentToken);
            throw new CommandFormatException(exceptionmessage);
        }
        return new Location(newX, newY, newDirection);

    }

}
