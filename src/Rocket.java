/**
 * holds info for rockets
 * 
 * @author risha97, hishamj6
 * @version 12/04/2018
 */
public class Rocket extends AirObject {

    private int x;
    private int y;
    private int z;
    private int xWidth;
    private int yWidth;
    private int zWidth;
    private int ascentRate;
    private double trajectory;

    /**
     * constructor for rocket
     * 
     * @param inname name of rocket
     */
    public Rocket(String inname) {
        super(inname);
    }

    /**
     * Getter for x origin
     * 
     * @return x origin
     */
    public int getXorig() {
        return x;
    }

    /**
     * Getter for x width
     * 
     * @return x width
     */
    public int getXwidth() {
        return xWidth;
    }

    /**
     * Getter for y origin
     * 
     * @return y origin
     */
    public int getYorig() {
        return y;
    }

    /**
     * Getter for y width
     * 
     * @return y width
     */
    public int getYwidth() {
        return yWidth;
    }

    /**
     * Getter for z origin
     * 
     * @return z origin
     */
    public int getZorig() {
        return z;
    }

    /**
     * Getter for z width
     * 
     * @return z width
     */
    public int getZwidth() {
        return zWidth;
    }
    
    /**
     * sets x value
     * @param newX new x
     */
    public void setX(int newX) {
        x = newX;
    }
    
    /**
     * sets y value
     * @param newY new y
     */
    public void setY(int newY) {
        y = newY;
    }
    
    /**
     * sets z value
     * @param newZ new z
     */
    public void setZ(int newZ) {
        z = newZ;
    }
    
    /**
     * sets xwidth
     * @param newXWidth new xwidth
     */
    public void setXWidth(int newXWidth) {
        xWidth = newXWidth;
    }
    
    /**
     * sets y width
     * @param newYWidth new y width
     */
    public void setYWidth(int newYWidth) {
        yWidth = newYWidth;
    }
    
    /**
     * sets z width
     * @param newZWidth new z width
     */
    public void setZWidth(int newZWidth) {
        zWidth = newZWidth;
    }
    
    /**
     * sets ascent rate
     * @param ar new ascent rate
     */
    public void setAscentRate(int ar) {
        ascentRate = ar;
    }
    
    /**
     * sets trajectory
     * @param t new trajectory
     */
    public void setTrajectory(double t) {
        trajectory = t;
    }
    
    /**
     * turns attributes to string for printing
     * @return string representation
     */
    public String toString() {
        StringBuilder output = new StringBuilder();
        output.append("(Rocket ");
        output.append(this.getName() + " ");
        output.append(this.x + " ");
        output.append(this.y + " ");
        output.append(this.z + " ");
        output.append(this.xWidth + " ");
        output.append(this.yWidth + " ");
        output.append(this.zWidth + " ");
        output.append(this.ascentRate + " ");
        output.append(this.trajectory + ")");
        return output.toString();
    }
}
