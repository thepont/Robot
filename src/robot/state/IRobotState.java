
package robot.state;
import robot.Location;
import robot.command.ICommand;
/**
 *
 * @author Paul Esson
 */
public interface IRobotState {
    
     /**
     * Executes a command against the robot.
     * @param cmd Command to be executed
     * @param currentLocation robots current location
     * @return new robot location
     */
    Location executeCommand(ICommand cmd, Location currentLocation);
}
