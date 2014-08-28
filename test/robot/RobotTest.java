package robot;

import robot.state.IRobotState;
import robot.state.UntabledState;
import robot.state.TabledState;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.*;
import static org.junit.Assert.assertThat;
import org.junit.Test;
import robot.command.ICommand;
import robot.command.PlaceCommand;

/**
 *
 * @author Paul Esson
 */
public class RobotTest {

    Robot instance;

    public RobotTest() {
        instance = Robot.getInstance();
    }

    /*
     *   Check non place commands cannot be executed while robot is not tabled.
     */
    @Test
    public void testExecuteCommandFailWhileNotOnTable() {
        Location expectedResult = new Location(instance.getCurrentLocation());
        Location result;
        ICommand cmd = new robot.command.LeftCommand();
        instance.setState(new UntabledState());
        instance.executeCommand(cmd);
        result = instance.getCurrentLocation();
        assertEquals(expectedResult, result);
    }

    /**
     * Check that we can execute a valid place command while the robot is not on
     * the table.
     */
    @Test
    public void testExecutePlaceCommandSuccessNotOnTable() {
        Location placeLocation = new Location(3, 3, Direction.EAST);
        Location expectedResult = new Location(placeLocation);
        Location result;
        PlaceCommand cmd = new robot.command.PlaceCommand();
        cmd.setNewLocation(placeLocation);
        instance.setState(new UntabledState());
        instance.executeCommand(cmd);
        result = instance.getCurrentLocation();
        assertEquals(expectedResult, result);
    }

    /**
     * Test that successfully executing the place command changes the robots
     * status
     */
    @Test
    public void testExecutePlaceCommandChangeStatus() {
        Location placeLocation = new Location(3, 3, Direction.EAST);
        IRobotState result;
        PlaceCommand cmd = new robot.command.PlaceCommand();
        cmd.setNewLocation(placeLocation);
        instance.setState(new UntabledState());
        instance.executeCommand(cmd);
        result = instance.getState();
        assertThat(result, instanceOf(TabledState.class));
    }

}
