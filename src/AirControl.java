/**
 * {Project Description Here}
 */

/**
 * The class containing the main method.
 *
 * @author {Your Name Here}
 * @version {Put Something Here}
 */

// On my honor:
//
// - I have not used source code obtained from another student,
// or any other unauthorized source, either modified or
// unmodified.
//
// - All source code and documentation used in my program is
// either my original work, or was derived by me from the
// source code published in the textbook for this course.
//
// - I have not discussed coding details about this project with
// anyone other than my partner (in the case of a joint
// submission), instructor, ACM/UPE tutors or the TAs assigned
// to this course. I understand that I may discuss the concepts
// of this program with other students, and that another student
// may help me debug my program so long as neither of us writes
// anything during the discussion or modifies any computer file
// during the discussion. I have violated neither the spirit nor
// letter of this restriction.

public class AirControl {
	
	static final int BOX_LENGTH = 1024;
	static final int BOX_HEIGHT = 1024;
	static final int BOX_WIDTH = 1024;
    /**
     * @param args
     *     Command line parameters
     */
    public static void main(String[] args) {
        // This is the main file for the program.
    		String inputFile = args[0];
    		Parser p = new Parser();
    		SkipList<AirObject, Object> sl = new SkipList<AirObject, Object>();
    		
    		BinTree t = new BinTree(0, 0, 0, BOX_LENGTH, BOX_WIDTH, BOX_HEIGHT, 1);
    		p.parse(inputFile, sl, t);
    }
}
