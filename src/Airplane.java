/**
 * stores instances of airplanes
 * 
 * @author risha97, hishamj6
 * @version 12/02/2018
 */
public class Airplane extends AirObject {

    private int x;
    private int y;
    private int z;
    private int xWidth;
    private int yWidth;
    private int zWidth;
    private int flightNumber;
    private int engines;
    private String carrier;
    
    /**
     * constructor for plane
     * @param inname name of plane
     */
    public Airplane(String inname) {
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
     * sets x coordinate of bottom
     * left corner
     * @param new x
     */
    public void setX(int newX) {
        x = newX;
    }
    
    /**
     * sets y coordinate of
     * bottom left corner
     * @param new y
     */
    public void setY(int newY) {
        y = newY;
    }
    
    /**
     * sets z coordinate of
     * bottom left corner
     * @param new z
     */
    public void setZ(int newZ) {
        z = newZ;
    }
    
    /**
     * sets width in x direction of
     * box containing plane
     * @param new x width
     */
    public void setXWidth(int newXWidth) {
        xWidth = newXWidth;
    }
    
    /**
     * sets width in y direction of
     * box containing plane
     * @param new y width
     */
    public void setYWidth(int newYWidth) {
        yWidth = newYWidth;
    }
    /**
     * sets width in z direction
     * of box containing plane
     * @param new z width
     */
    public void setZWidth(int newZWidth) {
        zWidth = newZWidth;
    }
    
    /**
     * gets the carrier of plane
     * @return carrier
     */
    public String carrier() {
        return carrier;
    }
    
    /**
     * sets the carrier of plane
     * @param c new carrier
     */
    public void setCarrier(String c) {
        carrier = c;
    }
    
    /**
     * gets number of engines
     * @return number of engines
     */
    public int engines() {
        return engines;
    }
    
    /**
     * sets number of engines
     * @param e new number of engines
     */
    public void setEngines(int e) {
        engines = e;
    }

    /**
     * gets the flight number
     * 
     * @return flight number
     */
    public int flightNumber() {
        return flightNumber;
    }

    /**
     * sets the flight number
     * 
     * @param fn new flight number
     */
    public void setFlightNumber(int fn) {
        flightNumber = fn;
    }

    /**
     * turns attributes into a string for printing
     * @return string representation of object
     */
    public String toString() {
        StringBuilder output = new StringBuilder();
        output.append("(Airplane ");
        output.append(this.getName() + " ");
        output.append(this.x + " ");
        output.append(this.y + " ");
        output.append(this.z + " ");
        output.append(this.xWidth + " ");
        output.append(this.yWidth + " ");
        output.append(this.zWidth + " ");
        output.append(this.carrier + " ");
        output.append(this.flightNumber + " ");
        output.append(this.engines + ")");
        return output.toString();
    }

}
