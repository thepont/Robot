package robot;

import robot.state.UntabledState;
import robot.command.ICommand;
import robot.state.IRobotState;

/**
 *
 * Robot class
 *
 * @author Paul Esson
 */
public class Robot {

    private static final Robot INSTANCE = new Robot();
    private IRobotState currentState;
    Location currentLocation;

    public static Robot getInstance() {
        return INSTANCE;
    }

    private Robot() {
        currentLocation = new Location(0, 0, Direction.NORTH);
        currentState = new UntabledState();
    }

    /**
     * Executes a command on the robot.
     *
     * @param cmd ICommand to be executed.
     */
    public void executeCommand(ICommand cmd) {
        currentLocation = currentState.executeCommand(cmd, currentLocation);
    }

    public Location getCurrentLocation() {
        return currentLocation;
    }

    /**
     * Sets the robots current state
     *
     * Currently Tabled and Untabled states are available
     *
     * @param state
     */
    public void setState(IRobotState state) {
        this.currentState = state;
    }

    public IRobotState getState() {
        return currentState;
    }
}
