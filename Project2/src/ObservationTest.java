import static org.junit.Assert.*;
import org.junit.Test;

/**
 * @author Tim O'Brien
 * @version 2018-10-03 Project 2
 * 
 *          Tests the methods inside the Observation class.
 */
public class ObservationTest
{

    /**
     * Tests the Observation constructor.
     */
    @Test
    public void testObservationConstructor()
    {
        Observation o = new Observation(10.1, "STID");

        assertEquals(10.1, o.getValue(), .01);
        assertEquals("STID", o.getStid());

    }

    /**
     * Tests the getter for Value.
     */
    @Test
    public void testGetValue()
    {
        Observation o = new Observation(10.1, "STID");

        assertEquals(10.1, o.getValue(), .01);

    }

    /**
     * Makes sure the boolean for isValid is working.
     */
    @Test
    public void testIsValid()
    {
        Boolean valid = true;
        Boolean valid2 = true;
        Boolean valid3 = true;

        Observation o = new Observation(10.1, "STID");
        Observation a = new Observation(-1, "STID");
        Observation b = new Observation(1001, "STID");

        if (o.getValue() > 0 | o.getValue() < 1000)
        {
            valid = true;
        }

        if (a.getValue() < 0 | a.getValue() > 1000)
        {
            valid2 = false;
        }

        if (a.getValue() < 0 | a.getValue() > 1000)
        {
            valid3 = false;
        }

        assertEquals(valid, o.isValid());
        assertEquals(valid2, a.isValid());
        assertEquals(valid3, b.isValid());

    }

    /**
     * Makes sure the getter for Stid works.
     */
    @Test
    public void testGetStid()
    {
        Observation o = new Observation(10.1, "STID");

        assertEquals("STID", o.getStid());

    }

    /**
     * Makes sure the toString inside the Observation class works.
     */
    @Test
    public void testToString()
    {
        Observation o = new Observation(10.1, "STID");

        double a = o.getValue();
        String b = o.getStid();
        String expected = String.format("%.1f C at %s", a, b);

        assertEquals(expected, o.toString());
    }

}
