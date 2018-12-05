import student.TestCase;

/**
 * @author risha97, hishamj6
 * @version 12/04/2018
 */
public class AirControlTest extends TestCase {
    /**
     * Sets up the tests that follow. In general, used for initialization
     */
    public void setUp() {
        // Nothing Here
    }

    /**
     * Get code coverage of the class declaration.
     */
    public void testRInit() {
        AirControl recstore = new AirControl();
        assertNotNull(recstore);
        String[] args = {"BigInputFile.txt"};
        AirControl.main(args);
        args[0] = "P4SampleInput.txt";
        AirControl.main(args);
    }
    
    /**
     * Get code coverage for AirObject class
     */
    public void testAO() {
        AirObject ao = new AirObject("myName");
        AirObject ao2 = new AirObject("myName2");
        assertTrue((ao.getName()).equals("myName"));
        assertEquals(ao.getXorig(), 0);
        assertEquals(ao.getYorig(), 0);
        assertEquals(ao.getZorig(), 0);
        assertEquals(ao.getXwidth(), 0);
        assertEquals(ao.getYwidth(), 0);
        assertEquals(ao.getZwidth(), 0);
        assertTrue(ao.compareTo(ao2) < 0);
    }
}
