/**
 * @author Tim O'Brien, referenced UML diagram
 * @version 2018-10-03 Project 2
 * 
 *          Contains one measurement and checks it to make sure it is valid.
 */
public class Observation extends AbstractObservation
{
    private double value;
    private String stid;

    /**
     * Observations constructor taking in a value and a station id
     * 
     * @param value of observation
     * @param stid  station id
     */
    public Observation(double value, String stid)
    {
        this.value = value;
        this.stid = stid;
    }

    /**
     * 
     * @return value
     */
    public double getValue()
    {
        return value;
    }

    /**
     * Checks to see if the value is valid.
     */
    public boolean isValid()
    {
        boolean valid;

        // If the value is greater or less than 1000 it is valid
        if (value < 0 | value > 1000)
        {
            valid = false;
        } else
        {
            valid = true;
        }

        return valid;
    }

    /**
     * 
     * @return stid
     */
    public String getStid()
    {
        return this.stid;
    }

    /**
     * @return the formatted string containing value and stid
     */
    public String toString()
    {
        String s = String.format("%.1f C at %s", value, stid);

        return s;
    }
}
