package robot.command;
import robot.Location;
/**
 * A command that can execute against the robot.
 * @author Paul Esson
 */
public interface ICommand {
    public Location execute(Location current);
}
