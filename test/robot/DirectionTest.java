/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package robot;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Paul Esson
 */
public class DirectionTest {
  
    /**
     * Test of getLeft method, of Direction enumeration.
     */
    @Test
    public void testGetLeftFromNorth() {
        Direction expResult = Direction.WEST;
        Direction result = Direction.NORTH.getLeft();
        assertEquals(expResult, result);
    }
    
    @Test
    public void testGetLeftFromSouth() {
        Direction expResult = Direction.EAST;
        Direction result = Direction.SOUTH.getLeft();
        assertEquals(expResult, result);
    }
    
    @Test
    public void testGetLeftFromEast() {
        Direction expResult = Direction.NORTH;
        Direction result = Direction.EAST.getLeft();
        assertEquals(expResult, result);
    }
    
    
    @Test
    public void testGetLeftFromWest() {
        Direction expResult = Direction.SOUTH;
        Direction result = Direction.WEST.getLeft();
        assertEquals(expResult, result);
    }

    
    /**
     * Test of getRight method, of Direction enumeration.
     */
    @Test
    public void testGetRight() {
        Direction expResult = Direction.WEST;
        Direction result = Direction.SOUTH.getRight();
        assertEquals(expResult, result);
    }

    /**
     * Test of getXDif method, of Direction enumeration.
     */
    @Test
    public void testGetXDifNorth() {
        int expResult = 0;
        int result = Direction.NORTH.getXDif();
        assertEquals(expResult, result);
    }

    /**
     * Test of getXDif method, of Direction enumeration.
     */
    @Test
    public void testGetXDifEast() {
        int expResult = 1;
        int result = Direction.EAST.getXDif();
        assertEquals(expResult, result);
    }
    
    /**
     * Test of getYDif method, of Direction enumeration.
     */
    @Test
    public void testGetYDifNorth() {
        int expResult = 1;
        int result = Direction.NORTH.getYDif();
        assertEquals(expResult, result);
    }
    
    @Test
    public void testGetYDifEast() {
        int expResult = 0;
        int result = Direction.EAST.getYDif();
        assertEquals(expResult, result);
    }
    
}
