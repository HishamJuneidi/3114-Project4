
public class BinLeaf {
	
	private int x, y, z, xLen, yLen, zLen, level, numNodes;
	private BinLeaf left, right;
	private boolean isSplit;
	private linkedList[] nodes;
	private final int MAX_NODES = 3;
	
	private BinLeaf(int xLength, int yLength, int zLength) {
		x = 0;
		y = 0;
		z = 0;
		xLen = xLength;
		yLen = yLength;
		zLen = zLength;
		level = 1;
		numNodes = 0;
		isSplit = false;
		nodes = new linkedList[MAX_NODES];
		for (int i = 0; i < MAX_NODES; i++) {
			nodes[i] = new linkedList();
		}
	}
	
	private BinLeaf(int newX, int newY, int newZ, int xLength, int yLength, int zLength, int l) {
		x = newX;
		y = newY;
		z = newZ;
		xLen = xLength;
		yLen = yLength;
		zLen = zLength;
		level = l;
		numNodes = 0;
		isSplit = false;
		nodes = new linkedList[MAX_NODES];
		for (int i = 0; i < MAX_NODES; i++) {
			nodes[i] = new linkedList();
		}
	}
	
	public void insert(AirObject ao) {
		if (numNodes == 3) {
			split();
		}
		for (int i = 0; i < MAX_NODES; i++) {
			if (nodes[i].head() == null) {
				nodes[i].insert(new linkedNode(ao));
				numNodes++;
				break;
			}
			if (nodes[i].head().collides(ao)) {
				nodes[i].insert(new linkedNode(ao));
				break;
			}
		}
		int tempLen = 0;
		int numLocations = 0;
		for (int j = 0; j < MAX_NODES; j++) {
			tempLen += nodes[j].length();
			if (nodes[j].length() > 0) {
				numLocations++;
			}
		}
		if (tempLen > 3 && numLocations > 1) {
			split();
		}
	}
	
	private void split() {
		isSplit = true;
		// split by x axis
		if (level % 3 == 1) {
			this.setLeft(new BinLeaf(x, y, z, xLen / 2, yLen, zLen, this.level + 1));
			this.setRight(new BinLeaf(x + (xLen / 2), y, z, xLen / 2, yLen, zLen, this.level + 1));
		}
		// split by y axis
		else if (level % 3 == 2) {
			this.setLeft(new BinLeaf(x, y, z, xLen, yLen / 2, zLen, this.level + 1));
			this.setRight(new BinLeaf(x, y + (yLen / 2), z, xLen, yLen / 2, zLen, this.level + 1));
		}
		// split by z axis
		else {
			this.setLeft(new BinLeaf(x, y, z, xLen, yLen, zLen / 2, this.level + 1));
			this.setRight(new BinLeaf(x, y, z + (zLen / 2), xLen, yLen, zLen / 2, this.level + 1));
		}
	}
	
	public int x() {
		return x;
	}
	
	public void setX(int newX) {
		x = newX;
	}
	
	public int y() {
		return y;
	}
	
	public void setY(int newY) {
		y = newY;
	}
	
	public int z() {
		return z;
	}
	
	public void setZ(int newZ) {
		z = newZ;
	}
	
	public int xLen() {
		return xLen;
	}
	
	public void setXLen(int xLength) {
		xLen = xLength;
	}
	
	public int yLen() {
		return yLen;
	}
	
	public void setYLen(int yLength) {
		yLen = yLength;
	}
	
	public int zLen() {
		return zLen;
	}
	
	public void setZLen(int zLength) {
		zLen = zLength;
	}
	
	public int numNodes() {
		return numNodes;
	}
	
	public void setNumNodes(int newNumNodes) {
		numNodes = newNumNodes;
	}
	
	public int level() {
		return level;
	}
	
	public void setLevel(int l) {
		level = l;
	}
	
	public void setLeft(BinLeaf l) {
		left = l;
	}
	
	public BinLeaf left() {
		return left;
	}
	
	public void setRight(BinLeaf r) {
		left = r;
	}
	
	public BinLeaf right() {
		return right;
	}
	
	public boolean isSplit() {
		return isSplit;
	}
}
