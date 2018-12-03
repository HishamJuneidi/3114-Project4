/**
 * Air traffic control general object type interface
 * All tracked objects must have a bounding prism and a name
 * *
 * 
 * @author {Your Name Here}
 * @version {Put Something Here}
 * 
 */

public class AirObject implements Comparable<AirObject> {
    private String name; // Name for this AirObject


    /**
     * Constructor for base AirObject
     * 
     * @param inname
     *            The object's name
     *
     */
    public AirObject(String inname) {
        name = inname;
    }


    /**
     * Getter for x origin
     * 
     * @return x origin
     */
    public int getXorig() {
        return 0;
    }


    /**
     * Getter for x width
     * 
     * @return x width
     */
    public int getXwidth() {
        return 0;
    }


    /**
     * Getter for y origin
     * 
     * @return y origin
     */
    public int getYorig() {
        return 0;
    }


    /**
     * Getter for y width
     * 
     * @return y width
     */

    public int getYwidth() {
        return 0;
    }


    /**
     * Getter for z origin
     * 
     * @return z origin
     */
    public int getZorig() {
        return 0;
    }


    /**
     * Getter for z width
     * 
     * @return z width
     */

    public int getZwidth() {
        return 0;
    }
    
    /**
     * sets x value
     * @param newX new value of x
     */
    public void setX(int newX) {
        return;
    }
    
    /**
     * sets y value
     * @param newY new value of y
     */
    public void setY(int newY) {
        return;
    }
    
    /**
     * sets z value
     * @param newZ new value of z
     */
    public void setZ(int newZ) {
        return;
    }
    
    /**
     * sets width in x direction
     * @param newXWidth new width
     */
    public void setXWidth(int newXWidth) {
        return;
    }
    
    /**
     * sets y width
     * @param newYWidth new y width
     */
    public void setYWidth(int newYWidth) {
        return;
    }
    
    /**
     * sets z width
     * @param newZWidth new z width
     */
    public void setZWidth(int newZWidth) {
        return;
    }

    /**
     * Getter for name
     * 
     * @return name
     */
    public String getName() {
        return name;
    }


    /**
     * Compare against a (name) String.
     *
     * @param it
     *            The String to compare to
     * 
     * @return Standard values for compareTo
     */
    public int compareTo(AirObject it) {
        return name.compareTo(it.getName());
    }
}
