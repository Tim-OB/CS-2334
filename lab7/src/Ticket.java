/**
 * Lab 7
 * 
 * Class representing a Ticket/order of a restaurant.
 * 
 * @author  Tim O'Brien
 * @version 2018-10-12
 */
public class Ticket implements Comparable<Ticket>
{
    // Variables setting up a ticket
    private String description;
    private int timeOrdered;

    /**
     * Constructor for ticket
     * 
     * @param description of the ticket
     * @param timeOrdered time of the order
     */
    public Ticket(String description, int timeOrdered)
    {
        this.description = description;
        this.timeOrdered = timeOrdered;
    }

    /**
     * 
     * @return a description of whatever the order is
     */
    public String getDescription()
    {
        return description;
    }

    /**
     * 
     * @return the time ordered
     */
    public int getTimeOrdered()
    {
        return timeOrdered;
    }

    /**
     * @return the description
     */
    public String toString()
    {
        return description;
    }

    /**
     * Compare the tickets to each other.
     * 
     * @return 0 if they are the same, 
     *         1 if this is greater than other,
     *         -1 if this is less than other.
     */
    public int compareTo(Ticket other)
    {
        int c = -3;

        //If the time ordered is equal to the other ticket set equal to 0
        if (this.timeOrdered == other.timeOrdered)
        {
            c = 0;
        }

        //If the time ordered is greater than the other ticket set equal to 1
        if (this.timeOrdered > other.timeOrdered)
        {
            c = 1;
        }

        //If the time ordered is less than the other ticket set equal to -1
        if (this.timeOrdered < other.timeOrdered)
        {
            c = -1;
        }

        return c;
    }

}
