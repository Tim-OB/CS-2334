/**
 * @author Tim O'Brien, referenced UML diagram
 * @version 2018-09-18 Project 1
 * 
 *          Contains one measurement and checks it to make sure it is valid.
 */
public class Observation
{
    private double value;
    private Boolean valid;
    private String stid;

    /**
     * Observation constructor with parameters of value, and stid.
     * 
     * @param value takes a value read from the input file
     * @param stid  takes the string value of the station from the input file
     */
    public Observation(double value, String stid)
    {
        this.value = value;
        this.stid = stid;
    }

    /**
     * 
     * @return the value
     */
    public double getValue()
    {
        return value;
    }

    /**
     * 
     * @return the Boolean valid
     */
    public Boolean isValid()
    {
        if (value > 999.99 | value < 0.00)
        {
            this.valid = false;
        } else
        {
            this.valid = true;
        }

        return valid;
    }

    /**
     * 
     * @return the stid
     */
    public String getStid()
    {
        return stid;
    }

    /**
     * toString method to format output
     */
    public String toString()
    {
        String out = String.format("%.1f C at %s", value, stid);

        return out;
    }
}
