/**
 * holds info for balloons
 * 
 * @author risha97, hishamj6
 * @version 12/04/2018
 */
public class Balloon extends AirObject {

    private int x;
    private int y;
    private int z;
    private int xWidth;
    private int yWidth;
    private int zWidth;
    private int ascentRate;
    private String type;

    /**
     * constructor for balloon
     * 
     * @param inname name of balloon
     */
    public Balloon(String inname) {
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
     * sets x coordinate
     * @param newX new x coordinate
     */
    public void setX(int newX) {
        x = newX;
    }

    /**
     * sets y coordinate
     * @param newY new y coordinate
     */
    public void setY(int newY) {
        y = newY;
    }

    /**
     * sets z coordinate
     * @param newZ new z coordinate
     */
    public void setZ(int newZ) {
        z = newZ;
    }

    /**
     * sets width in x direction
     * @param newXWidth new x width
     */
    public void setXWidth(int newXWidth) {
        xWidth = newXWidth;
    }

    /**
     * sets width in y direction
     * @param newYWidth new y width
     */
    public void setYWidth(int newYWidth) {
        yWidth = newYWidth;
    }

    /**
     * sets width in z direction
     * @param newZWidth new z width
     */
    public void setZWidth(int newZWidth) {
        zWidth = newZWidth;
    }

    /**
     * sets balloon type
     * 
     * @param t new balloon type
     */
    public void setType(String t) {
        type = t;
    }
    
    /**
     * sets balloon ascent rate
     * @param ar new ascent rate
     */
    public void setAscentRate(int ar) {
        ascentRate = ar;
    }
    
    /**
     * takes attributes and creates a string
     * for printing
     * @return string representation
     */
    public String toString() {
        StringBuilder output = new StringBuilder();
        output.append("(Balloon ");
        output.append(this.getName() + " ");
        output.append(this.x + " ");
        output.append(this.y + " ");
        output.append(this.z + " ");
        output.append(this.xWidth + " ");
        output.append(this.yWidth + " ");
        output.append(this.zWidth + " ");
        output.append(this.type + " ");
        output.append(this.ascentRate + ")");
        return output.toString();
    }
}
