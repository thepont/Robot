

package robot.command;

import org.junit.Test;
import static org.junit.Assert.*;
import robot.Direction;
import robot.Location;

/**
 *
 * @author Paul Esson
 */

public class LeftCommandTest {
   
    
    @Test
    public void testExecuteFromNorth() {
        LeftCommand instance = new LeftCommand();
        Location robotLoc = new Location(0,0,Direction.NORTH);
        Location expResult =new Location(0,0,Direction.WEST);
        Location result = instance.execute(robotLoc);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of execute method, of class RightCommand while facing west.
     */
     @Test
    public void testExecuteFromWest() {
        LeftCommand instance = new LeftCommand();
        Location robotLoc = new Location(0,0,Direction.WEST);
        Location expResult =new Location(0,0,Direction.SOUTH);
        Location result = instance.execute(robotLoc);
        assertEquals(expResult, result);
    }

     /**
     * Test of execute method, of class RightCommand while facing south.
     */
     @Test
    public void testExecuteFromSouth() {
        LeftCommand instance = new LeftCommand();
        Location robotLoc = new Location(0,0,Direction.SOUTH);
        Location expResult =new Location(0,0,Direction.EAST);
        Location result = instance.execute(robotLoc);
        assertEquals(expResult, result);
    }
    
     /**
     * Test of execute method, of class RightCommand while facing east.
     */
    @Test
    public void testExecuteFromEast() {
        LeftCommand instance = new LeftCommand();
        Location robotLoc = new Location(0,0,Direction.EAST);
        Location expResult =new Location(0,0,Direction.NORTH);
        Location result = instance.execute(robotLoc);
        assertEquals(expResult, result);
    }
}
