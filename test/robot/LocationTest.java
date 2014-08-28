package robot;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

/**
 *
 * @author Paul Esson
 */
public class LocationTest {

    public LocationTest() {
    }

    /**
     * Test of isValid method, Checking that 0,0 is valid.
     */
    @Test
    public void testIsValidInBoundsLow() {
        Location instance = new Location(0, 0, Direction.NORTH);
        boolean expResult = true;
        boolean result = instance.isValid();
        assertEquals(expResult, result);
    }

    /**
     * Test of isValid method, Checking that 4,4 is valid.
     */
    @Test
    public void testIsValidInBoundsHigh() {
        Location instance = new Location(4, 4, Direction.NORTH);
        boolean expResult = true;
        boolean result = instance.isValid();
        assertEquals(expResult, result);
    }

    /**
     * Test of isValid method, Checking that 5,0 is invalid.
     */
    @Test
    public void testIsValidOutBoundsXHigh() {
        Location instance = new Location(5, 0, Direction.NORTH);
        boolean expResult = false;
        boolean result = instance.isValid();
        assertEquals(expResult, result);
    }

    /**
     * Test of isValid method, Checking that 0,5 is invalid.
     */
    @Test
    public void testIsValidOutBoundsYHigh() {
        Location instance = new Location(0, 5, Direction.NORTH);
        boolean expResult = false;
        boolean result = instance.isValid();
        assertEquals(expResult, result);
    }

    /**
     * Test of isValid method, Checking that -1,0 is invalid.
     */
    @Test
    public void testIsValidOutBoundsXLow() {
        Location instance = new Location(-1, 0, Direction.NORTH);
        boolean expResult = false;
        boolean result = instance.isValid();
        assertEquals(expResult, result);
    }

    /**
     * Test of isValid method, Checking that 0,-1 is invalid.
     */
    @Test
    public void testIsValidOutBoundsYLow() {
        Location instance = new Location(0, -1, Direction.NORTH);
        boolean expResult = false;
        boolean result = instance.isValid();
        assertEquals(expResult, result);
    }

    /**
     * Test of equals method, of class Location.
     */
    @Test
    public void testEquals() {

        Location l1 = new Location(0, 0, Direction.NORTH);
        Location l2 = new Location(0, 0, Direction.NORTH);
        assertEquals(l1, l2);

    }

    @Test
    public void testEqualsNotEqualX() {
        Location l1 = new Location(0, 0, Direction.NORTH);
        Location l2 = new Location(1, 0, Direction.NORTH);
        assertThat(l1, not(l2));
    }

    @Test
    public void testEqualsNotEqualY() {
        Location l1 = new Location(0, 0, Direction.NORTH);
        Location l2 = new Location(0, 1, Direction.NORTH);
        assertThat(l1, not(l2));
    }

    @Test
    public void testEqualsNotEqualDirection() {
        Location l1 = new Location(0, 0, Direction.EAST);
        Location l2 = new Location(0, 0, Direction.NORTH);
        assertThat(l1, not(l2));
    }
}
