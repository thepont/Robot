
package robot.state;

import robot.Location;
import robot.Robot;
import robot.command.ICommand;
import robot.command.PlaceCommand;

/**
 * The robot is yet to be tabled, In this state the Robot requires a place command.
 * 
 * The robot will not operate unless it gets a place command that puts it onto the table.
 * 
 * @author Paul Esson
 */
public class UntabledState implements IRobotState {
    
    /**
     * Tabled state will only execute place commands.
     * @param cmd Command to be executed
     * @param currentLocation robots current location
     * @return new robot location
     */
    @Override
    public Location executeCommand(ICommand cmd, Location currentLocation)
    {
        Location newLoc = currentLocation;
        //Only accept PlaceCommands while in an untabled state.
        if ( cmd instanceof PlaceCommand){      
            newLoc = cmd.execute(currentLocation);
            if ( newLoc.isValid() )
            {
                Robot.getInstance().setState(new TabledState());
            } 
            else 
            { 
                newLoc = currentLocation;
            }
        }
        return newLoc;
    }
}
