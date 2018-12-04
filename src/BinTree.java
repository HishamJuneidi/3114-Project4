
public class BinTree {

	private TreeInterface empN;
	private int x, y, z, length, width, height, level;

	public BinTree(int newX, int newY, int newZ, int boxLength, int boxWidth, int boxHeight, int l) {
		length = boxLength;
		width = boxWidth;
		height = boxHeight;
		x = newX;
		y = newY;
		z = newZ;
		level = l;
		empN = new Flyweight(x, y, z, length, width, height, level);
	}

	public void insertTree(AirObject v) {

		// treeInterface flyNode = empN; //
		empN = empN.insert(v);
	}

	public int dump(int count) {
		System.out.println("Bintree dump:");
		count = empN.dump(count);
		return count;
	}

	public void collisions() {
		empN.collisions();
	}

	public int intersect(int x, int y, int z, int xWidth, int yWidth, int zWidth) {
		return empN.intersect(x, y, z, xWidth, yWidth, zWidth, 0);
	}

	public void delete(String name) {
		empN = empN.delete(name);
	}
}
