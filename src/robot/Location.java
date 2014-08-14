
package robot;

import java.util.Objects;

/**
 * Location class for storing the location of the robot, or locations to direct the robot.
 * @author Paul Esson
 */
public class Location {
    
    //Settings for 5 space board with points 0 - 4
    static final int X_MAX = 4;
    static final int Y_MAX = 4;
    static final int X_MIN = 0;
    static final int Y_MIN = 0;
    
    private int x, y;
    private Direction facing;
    
    public Location(int x, int y, Direction facing){
        this.x = x;
        this.y = y;
        this.facing = facing;
    }

    public Location(Location loc)
    {
        this.x = loc.x;
        this.y = loc.y;
        this.facing = loc.facing;
    }
    
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Direction getFacing() {
        return facing;
    }

    public void setFacing(Direction facing) {
        this.facing = facing;
    }
    
    /**
     * Checks if the location is on the table.
     * @return true of the location is on the table
     */
    public boolean isValid(){
        return x <= X_MAX && y <= Y_MAX && x >= X_MIN  && y >= Y_MIN;
    }
    
    @Override
    public boolean equals(Object o) {
 
        if (o == this) {
            return true;
        }

        if (!(o instanceof Location)) {
            return false;
        }

        Location l = (Location) o;

        return    x == l.x
               && y == l.y
               && facing.equals(l.facing);
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 59 * hash + this.x;
        hash = 59 * hash + this.y;
        hash = 59 * hash + Objects.hashCode(this.facing);
        return hash;
    }
    
    @Override
    public String toString(){
        return String.format("x: %d y: %d %s",x,y,facing.toString());
    }
}
