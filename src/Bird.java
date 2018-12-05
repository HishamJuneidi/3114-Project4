/**
 * stores info for birds
 * @author risha97, hishamj6
 * @version 12/04/2018
 */
public class Bird extends AirObject {
    
    private int x;
    private int y;
    private int z;
    private int xWidth;
    private int yWidth;
    private int zWidth;
    private int number;
    private String type;
    
    public Bird(String inname) {
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
     * @param new x coordinate
     */
    public void setX(int newX) {
        x = newX;
    }
    
    /**
     * sets y coordinate
     * @param new y coordinate
     */
    public void setY(int newY) {
        y = newY;
    }
    
    /**
     * sets z coordinate
     * @param new z coordinate
     */
    public void setZ(int newZ) {
        z = newZ;
    }
    
    /**
     * sets width in x direction
     * @param new x width
     */
    public void setXWidth(int newXWidth) {
        xWidth = newXWidth;
    }
    
    /**
     * sets width in y direction
     * @param new y width
     */
    public void setYWidth(int newYWidth) {
        yWidth = newYWidth;
    }
    
    /**
     * sets width in z direction
     * @param new z width
     */
    public void setZWidth(int newZWidth) {
        zWidth = newZWidth;
    }
    
    /**
     * gets the bird's number
     * @return bird's number
     */
    public int number() {
        return number;
    }
    
    /**
     * sets the bird's number
     * @param n new bird's number
     */
    public void setNumber(int n) {
        number = n;
    }
    
    /**
     * gets the bird's type
     * @return bird's type
     */
    public String type() {
        return type;
    }
    
    /**
     * sets the bird's type
     * @param t new type
     */
    public void setType(String t) {
        type = t;
    }
    
    /**
     * turns attributes of bird into
     * a string to print
     * @return string representation
     */
    public String toString() {
        StringBuilder output = new StringBuilder();
        output.append("(Bird ");
        output.append(this.getName() + " ");
        output.append(this.x + " ");
        output.append(this.y + " ");
        output.append(this.z + " ");
        output.append(this.xWidth + " ");
        output.append(this.yWidth + " ");
        output.append(this.zWidth + " ");
        output.append(this.type + " ");
        output.append(this.number + ")");
        return output.toString();
    }

}
