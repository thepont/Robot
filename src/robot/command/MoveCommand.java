
package robot.command;
import robot.Location;
/**
 * Moves robot one space in the direction it is faceing.
 * @author Paul Esson
 */
public class MoveCommand implements ICommand{
    public Location execute(Location robotLoc)
    {
        Location newLocation = new Location(robotLoc);
        int x = robotLoc.getX() + robotLoc.getFacing().getXDif();
        int y = robotLoc.getY() + robotLoc.getFacing().getYDif();
        newLocation.setX(x);
        newLocation.setY(y);
        return newLocation;
        
    }
}
