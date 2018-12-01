
public class emptyNode implements treeInterface {
	
	private leafNode lNode;
	private int x, y, z, xLen, yLen, zLen, level;
	
	public emptyNode(int newX, int newY, int newZ, int xLength, int yLength, int zLength, int l) {
		x = newX;
		y = newY;
		z = newZ;
		xLen = xLength;
		yLen = yLength;
		zLen = zLength;
		level = l;
	}
	
	public treeInterface insert(AirObject ao, int newX, int newY, int newZ, int xLength, int yLength, int zLength, int l) {
		leafNode output = new leafNode(newX, newY, newZ, xLength, yLength, zLength, l);
		
		return output.insert(ao);
	}
	public AirObject insertEmptyNode(AirObject x) {
		
		lNode.insert(x);
		return x;
	}
	
	@Override
	public treeInterface insert(AirObject ao) {
		// TODO Auto-generated method stub
		leafNode output = new leafNode(x, y, z, xLen, yLen, zLen, level);
		
		return output.insert(ao);
	}
	
	public void dump() {
		for (int i = 1; i < level; i++) {
			System.out.print("  ");
		}
		System.out.println("E");
	}

}
