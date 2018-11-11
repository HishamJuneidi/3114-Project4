import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Parser {
	
	public void parse(String filename) {
		String[] array;
		File file = new File(filename);
		try {
			Scanner sc = new Scanner(file);
			while (sc.hasNextLine()) {
				String line = sc.nextLine().trim();
				if (!line.equals("")) {
					//System.out.println(line);
					array = line.split("\\s+");
					if (array[0].equals("add")) {
						for (String s: array) {
							System.out.print(s + ",");
						}
						System.out.println();
						AirObject ao;
						String name = array[2];
						int x = Integer.parseInt(array[3]);
						int y = Integer.parseInt(array[4]);
						int z = Integer.parseInt(array[5]);
						int xWidth = Integer.parseInt(array[6]);
						int yWidth = Integer.parseInt(array[7]);
						int zWidth = Integer.parseInt(array[8]);
						if (array[1].equals("airplane")) {
							ao = new Airplane(name);
							//ao.setCarrier(array[9]);
						}
						else if (array[1].equals("balloon")) {
							ao = new Balloon(name);
						}
						else if (array[1].equals("bird")) {
							ao = new Bird(name);
						}
						else if (array[1].equals("drone")) {
							ao = new Drone(name);
						}
						else {
							ao = new Rocket(name);
						}
						ao.setX(x);
						ao.setY(y);
						ao.setZ(z);
						ao.setXWidth(xWidth);
						ao.setYWidth(yWidth);
						ao.setZWidth(zWidth);
						System.out.println("x: " + ao.getXorig());
						System.out.println("y: " + ao.getYorig());
						System.out.println("z: " + ao.getZorig());
						System.out.println("xWidth: " + ao.getXwidth());
						System.out.println("yWidth: " + ao.getYwidth());
						System.out.println("zWidth: " + ao.getZwidth());
					}
					else if (array[0].equals("delete")) {
						
					}
					else if (array[0].equals("print")) {
						
					}
					else if (array[0].equals("rangeprint")) {
						
					}
					else if (array[0].equals("collisions")) {
						
					}
					else { // intersect
						
					}
				}
				
			}
			sc.close();
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
