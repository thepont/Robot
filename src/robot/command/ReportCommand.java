
package robot.command;
import robot.Location;

/**
 * The report command reports the robots current location in the format:
 * x,y,direction
 * @author Paul Esson   
 */
public class ReportCommand implements ICommand {
    @Override
    public Location execute(Location robotLoc)
    {
        System.out.printf("%d,%d,%s\n", robotLoc.getX(), robotLoc.getY(), robotLoc.getFacing());
        return robotLoc;
    }    
}
