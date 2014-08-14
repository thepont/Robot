package robot.command;

import org.junit.Test;
import static org.junit.Assert.*;
import robot.Direction;
import robot.Location;

/**
 *
 * @author Paul Esson
 */
public class PlaceCommandTest {
    
    public PlaceCommandTest() {
    }

    /**
     * Test of execute method, of class PlaceCommand.
     */
    @Test
    public void testExecute() {
        Location robotLoc = new Location(0,1,Direction.NORTH);
        PlaceCommand instance = new PlaceCommand();
        instance.setNewLocation(robotLoc);
        Location expResult = new Location(0,1,Direction.NORTH);
        Location result = instance.execute(robotLoc);
        assertEquals(expResult, result);
    }
    
}
