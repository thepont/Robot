
package robot.command;

import robot.Direction;
import robot.Location;


/**
 * Turns the robot right from the direction it is facing.
 * @author Paul Esson
 */
public class RightCommand implements ICommand {
    public Location execute(Location robotLoc)
    {
        Location newLocation = new Location(robotLoc);
        Direction robotFac = robotLoc.getFacing();
        newLocation.setFacing(robotFac.getRight());
        return newLocation;
    }
}
