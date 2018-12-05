/**
 * implementation of drone
 * @author risha97, hishamj6
 * @version 12/04/2018
 */
public class Drone extends AirObject {
    
    private int x;
    private int y;
    private int z;
    private int xWidth;
    private int yWidth;
    private int zWidth;
    private int engines;
    private String brand;
    
    /**
     * constructor of drone
     * @param inname name of drone
     */
    public Drone(String inname) {
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
     * sets x
     * @param newX new x
     */
    public void setX(int newX) {
        x = newX;
    }
    
    /**
     * sets y
     * @param newY new y
     */
    public void setY(int newY) {
        y = newY;
    }
    
    /**
     * sets z
     * @param newZ new z
     */
    public void setZ(int newZ) {
        z = newZ;
    }
    
    /**
     * sets x width
     * @param newXWidth new x width
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
     * sets brand name
     * @param b new brand name
     */
    public void setBrand(String b) {
        brand = b;
    }
    
    /**
     * sets num of engines
     * @param e new engine count
     */
    public void setEngines(int e) {
        engines = e;
    }
    
    
    /**
     * puts attributes of drone into
     * string for printing
     * @return string representation
     */
    public String toString() {
        StringBuilder output = new StringBuilder();
        output.append("(Drone ");
        output.append(this.getName() + " ");
        output.append(this.x + " ");
        output.append(this.y + " ");
        output.append(this.z + " ");
        output.append(this.xWidth + " ");
        output.append(this.yWidth + " ");
        output.append(this.zWidth + " ");
        output.append(this.brand + " ");
        output.append(this.engines + ")");
        return output.toString();
    }

}
