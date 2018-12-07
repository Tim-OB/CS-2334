import static org.junit.Assert.*;

import java.text.Format;

import org.junit.Test;

/**
 * @author Tim O'Brien
 * @version 2018-09-19 Project 1
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
        Boolean valid;
        Observation o = new Observation(10.1, "STID");

        if (o.getValue() < 0 | o.getValue() > 1000)
        {
            valid = false;
        } else
        {
            valid = true;
        }
        
        assertEquals(valid, o.isValid());
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
        String expected = String.format("%.1fC at %s", a, b);

        assertEquals(expected, o.toString());
    }

}
