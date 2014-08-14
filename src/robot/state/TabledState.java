
package robot.state;

import robot.Location;
import robot.command.ICommand;


/**
 * Robot is on the table, and any commands can be executed
 * @author Paul Esson
 */
public class TabledState implements IRobotState {
    
     /**
     * Executes a movement or reporting command against the robot.
     * 
     * @param cmd command to be executed.
     * @param currentLocation current location before command has been executed.
     * @return new location once command as been executed
     */
    
    @Override
    public Location executeCommand(ICommand cmd, Location currentLocation)
    {
        Location newLoc = cmd.execute(currentLocation);
        if ( !newLoc.isValid() )    //Check that we will not fall of the table.
        {
                newLoc = currentLocation;
        }
        return newLoc;
    }
    
    
    
}
