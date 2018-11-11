
public class Drone extends AirObject {
	
	private int x, y, z, xWidth, yWidth, zWidth, engines;
	private String brand;
	
	public Drone(String inname) {
		super(inname);
		// TODO Auto-generated constructor stub
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
    
    public void setX(int newX) {
		x = newX;
    }

	public void setY(int newY) {
		y = newY;
	}
	
	public void setZ(int newZ) {
		z = newZ;
	}
	
	public void setXWidth(int newXWidth) {
		xWidth = newXWidth;
	}
	
	public void setYWidth(int newYWidth) {
		yWidth = newYWidth;
	}
	
	public void setZWidth(int newZWidth) {
		zWidth = newZWidth;
	}
	
	public String brand() {
		return brand;
	}
	
	public void setBrand(String b) {
		brand = b;
	}
	
	public int engines() {
		return engines;
	}
	
	public void setEngines(int e) {
		engines = e;
	}

}
