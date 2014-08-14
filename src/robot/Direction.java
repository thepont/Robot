package robot;

/**
 * Enumeration for storing information about Directions, NORTH SOUTH EAST and WEST.
 * 
 * Stored here are the delta's if the robot is moved while in that direction 
 * and also the other directions in relation.
 * 
 * @author Paul Esson
 */

public enum Direction {
    NORTH("EAST","WEST",0,1),EAST("SOUTH", "NORTH", 1, 0),SOUTH("WEST","EAST",0,-1),WEST("NORTH","SOUTH",-1,0);
    
    String left;
    String right;
    int xDif;
    int yDif;
    /**
     * 
     * This enumeration represents the 4 different directions the robot can be facing.
     * 
     * Stored here are the delta's if the robot is moved while in that direction 
     * and also the other directions in relation.
     * 
     * @param right Direction to the right of the current direction
     * @param left Direction to the left of the current direction
     * @param xDif x delta when moving in direction
     * @param yDif y delta when moving in direction
     */
    Direction(String right, String left, int xDif,int yDif){
        this.right = right;
        this.left = left;
        this.xDif = xDif;
        this.yDif = yDif;
    }

    /**
     * Direction to the left of the current direction
     * @return Direction to the left of the current direction
     */
    public Direction getLeft() {
        return Direction.valueOf(left);
    }

    /**
     * Direction to the right of the current direction
     * @return Direction to the right of the current direction
     */
    public Direction getRight() {
        return Direction.valueOf(right);
    }

    /**
     * Stores the X movement of the robot when facing in the direction
     * @return difference in the X direction when move is called
     */
    public int getXDif() {
        return xDif;
    }

    /**
     * Stores the Y movement of the robot when facing in the direction
     * @return difference in the Y direction when move is called.
     */
    public int getYDif() {
        return yDif;
    }
    
}
