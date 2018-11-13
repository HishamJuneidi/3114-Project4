
public class Rocket extends AirObject {
	
	private int x, y, z, xWidth, yWidth, zWidth, ascentRate;
	private double trajectory;
	
	public Rocket(String inname) {
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
	
	public int ascentRate() {
		return ascentRate;
	}
	
	public void setAscentRate(int ar) {
		ascentRate = ar;
	}
	
	public double trajectory() {
		return trajectory;
	}
	
	public void setTrajectory(double t) {
		trajectory = t;
	}
	
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
