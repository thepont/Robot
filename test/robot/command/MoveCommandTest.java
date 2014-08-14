/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package robot.command;

import org.junit.Test;
import static org.junit.Assert.*;
import robot.Direction;
import robot.Location;

/**
 *
 * @author Paul Esson
 */
public class MoveCommandTest {
    
    public MoveCommandTest() {
    }
    /**
     * Test of execute method, heading north.
     */
    @Test
    public void testExecuteMoveNorth(){
        MoveCommand instance = new MoveCommand();
        Location robotLoc = new Location(0,0,Direction.NORTH);
        Location expResult = new Location(0,1,Direction.NORTH);
        Location result = instance.execute(robotLoc);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of execute method, heading south.
     */
    @Test
    public void testExecuteMoveSouth(){
        MoveCommand instance = new MoveCommand();
        Location robotLoc = new Location(0,0,Direction.SOUTH);
        Location expResult = new Location(0,-1,Direction.SOUTH);
        Location result = instance.execute(robotLoc);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of execute method, heading east.
     */
    @Test
    public void testExecuteMoveEast(){
        MoveCommand instance = new MoveCommand();
        Location robotLoc = new Location(0,0,Direction.EAST);
        Location expResult = new Location(1,0,Direction.EAST);
        Location result = instance.execute(robotLoc);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of execute method, heading west.
     */
    @Test
    public void testExecuteMoveWest(){
        MoveCommand instance = new MoveCommand();
        Location robotLoc = new Location(0,0,Direction.WEST);
        Location expResult = new Location(-1,0,Direction.WEST);
        Location result = instance.execute(robotLoc);
        assertEquals(expResult, result);
    }
    
}
