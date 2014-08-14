
package robot.command;
import robot.Direction;
import robot.Location;
/**
 * Turns Robot Left.
 * @author Paul Esson
 */
public class LeftCommand implements ICommand{
    @Override
    public Location execute(Location robotLoc)
    {
        Location newLocation = new Location(robotLoc);
        Direction robotFac = robotLoc.getFacing();
        newLocation.setFacing(robotFac.getLeft());
        return newLocation;
    }
}
