import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * parses command
 * @author risha97, hishamj6
 * @version 12/04/2018
 */
public class Parser {
    
    /**
     * maximum width of box
     */
    public static final int MAX_BOX_WIDTH = 1024;
    
    /**
     * parses commands
     * @param filename name of file being read
     * @param sl skip list
     * @param t bintree
     */
    public void parse(String filename, 
            SkipList<AirObject, Object> sl, BinTree t) {
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
                        Boolean success = false;
                        Boolean valid;
                        //AirObject ao;
                        String name = array[2];
                        int x = Integer.parseInt(array[3]);
                        int y = Integer.parseInt(array[4]);
                        int z = Integer.parseInt(array[5]);
                        int xWidth = Integer.parseInt(array[6]);
                        int yWidth = Integer.parseInt(array[7]);
                        int zWidth = Integer.parseInt(array[8]);
                        String box = "(" + x + " " + y + " " + z + " " + 
                                    xWidth + " " + yWidth + " " + zWidth + ")";
                        if (xWidth <= 0 || yWidth <= 0 || zWidth <= 0) {
                            System.out.print("Bad box " + box + ". ");
                            System.out.println("All widths must be positive.");
                            valid = false;
                        }
                        else if (xWidth > MAX_BOX_WIDTH 
                                || yWidth > MAX_BOX_WIDTH 
                                || zWidth > MAX_BOX_WIDTH) {
                            System.out.print("Bad box " + box + ". ");
                            System.out.println("All boxes must be "
                                    + "entirely within the world box.");
                            valid = false;
                        }
                        else {
                            valid = true;
                        }
                        if (array[1].equals("airplane")) {
                            //Airplane ap = (Airplane) ao;
                            Airplane ap = new Airplane(name);
                            ap.setCarrier(array[9]);
                            ap.setFlightNumber(Integer.parseInt(array[10]));
                            ap.setEngines(Integer.parseInt(array[11]));
                            ap.setX(x);
                            ap.setY(y);
                            ap.setZ(z);
                            ap.setXWidth(xWidth);
                            ap.setYWidth(yWidth); 
                            ap.setZWidth(zWidth);
                            if (valid) {
                                success = sl.insert(ap, ap.getName());
                                if (success) {
                                    t.insert(ap);
                                }
                            }
                        }
                        else if (array[1].equals("balloon")) {
                            //Balloon b = (Balloon) ao;
                            Balloon b = new Balloon(name);
                            b.setType(array[9]);
                            b.setAscentRate(Integer.parseInt(array[10]));
                            b.setX(x);
                            b.setY(y);
                            b.setZ(z);
                            b.setXWidth(xWidth);
                            b.setYWidth(yWidth);
                            b.setZWidth(zWidth);
                            if (valid) {
                                success = sl.insert(b, b.getName());
                                if (success) {
                                    t.insert(b);
                                }
                            }
                        }
                        else if (array[1].equals("bird")) {
                            Bird bd = new Bird(name);
                            bd.setType(array[9]);
                            bd.setNumber(Integer.parseInt(array[10]));
                            bd.setX(x);
                            bd.setY(y);
                            bd.setZ(z);
                            bd.setXWidth(xWidth);
                            bd.setYWidth(yWidth);
                            bd.setZWidth(zWidth);
                            if (valid) {
                                success = sl.insert(bd, bd.getName());
                                if (success) {
                                    t.insert(bd);
                                }
                            }
                        }
                        else if (array[1].equals("drone")) {
                            //Drone d = (Drone) ao;
                            Drone d = new Drone(name);
                            d.setBrand(array[9]);
                            d.setEngines(Integer.parseInt(array[10]));
                            d.setX(x);
                            d.setY(y);
                            d.setZ(z);
                            d.setXWidth(xWidth);
                            d.setYWidth(yWidth);
                            d.setZWidth(zWidth);
                            if (valid) {
                                success = sl.insert(d, d.getName());
                                if (success) {
                                    t.insert(d);
                                }
                            }
                        }
                        else {
                            Rocket r = new Rocket(name);
                            r.setAscentRate(Integer.parseInt(array[9]));
                            r.setTrajectory(Double.parseDouble(array[10]));
                            r.setX(x);
                            r.setY(y);
                            r.setZ(z);
                            r.setXWidth(xWidth);
                            r.setYWidth(yWidth);
                            r.setZWidth(zWidth);
                            if (valid) {
                                success = sl.insert(r, r.getName());
                                if (success) {
                                    t.insert(r);
                                }
                            }
                        }
                        if (valid) {
                            if (success) {
                                System.out.println(name + 
                                        " has been added to the database");
                            }
                            else {
                                System.out.println("Duplicate "
                                        + "object names "
                                        + "not permitted: |" + name + "|");
                            }
                        }
                    }
                    else if (array[0].equals("delete")) {
                        Boolean deleted = sl.delete(array[1]);
                        if (deleted) {
                            t.delete(array[1]);
                            System.out.print("Deleted |" + array[1] + "|");
                            System.out.println(" from the database");
                        }
                        else {
                            System.out.print("Object |" + array[1] + "| ");
                            System.out.println("not in the database");
                        }
                    }
                    else if (array[0].equals("print")) {
                        if (array[1].equals("skiplist")) {
                            sl.dump();
                        }
                        else if (array[1].equals("object")) {
                            sl.printObject(array[2]);
                        }
                        else if (array[1].equals("bintree")) {
                            int count = 0;
                            count = t.dump(count);
                            System.out.println(count + 
                                    " bintree nodes printed");
                        }
                    }
                    else if (array[0].equals("rangeprint")) {
                        sl.rangePrint(array[1], array[2]);
                    }
                    else if (array[0].equals("collisions")) {
                        System.out.println("The following "
                                + "collisions exist in the database:");
                        t.collisions();
                    }
                    else { // intersect
                        int x = Integer.parseInt(array[1]);
                        int y = Integer.parseInt(array[2]);
                        int z = Integer.parseInt(array[3]);
                        int xWidth = Integer.parseInt(array[4]);
                        int yWidth = Integer.parseInt(array[5]);
                        int zWidth = Integer.parseInt(array[6]);
                        String box = "(" + x + " " + y + " " + z + " " + 
                                    xWidth + " " + yWidth + " " + zWidth + ")";
                        if (xWidth <= 0 || yWidth <= 0 || zWidth <= 0) {
                            System.out.print("Bad box " + box + ". ");
                            System.out.println("All widths must be positive.");
                        }
                        else if (xWidth > MAX_BOX_WIDTH 
                                || yWidth > MAX_BOX_WIDTH 
                                || zWidth > MAX_BOX_WIDTH) {
                            System.out.print("Bad box " + box + ". ");
                            System.out.println("All boxes "
                                    + "must be entirely "
                                    + "within the world box.");
                        }
                        else {
                            StringBuilder intersection = new StringBuilder();
                            intersection.append("(");
                            intersection.append(x + " " + y + " " + z + " ");
                            intersection.append(xWidth + " " 
                                    + yWidth + " " + zWidth);
                            intersection.append("):");
                            System.out.print("The following "
                                    + "objects intersect ");
                            System.out.println(intersection.toString());
                            int count = t.intersect(x, 
                                    y, z, xWidth, yWidth, zWidth);
                            System.out.print(count);
                            System.out.println(" nodes "
                                    + "were visited in the bintree");
                        }
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
