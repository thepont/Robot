package robot.command;
import robot.Location;
/**
 * Places robot in a location on the table
 * @author Paul Esson
 */
public class PlaceCommand implements ICommand {
    private Location newLocation;

    public Location getNewLocation() {
        return newLocation;
    }
    
    /**
     * Sets the location to place the robot
     * @param newLocation location to place the robot.
     */
    public void setNewLocation(Location newLocation){
        this.newLocation = newLocation;
    }
    
    @Override
    public Location execute(Location robotLoc)
    {
        return newLocation;
    }
}
