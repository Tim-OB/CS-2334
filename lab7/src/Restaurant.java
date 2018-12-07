/**
 * Lab 7
 * 
 * Class representing a Restaurant.
 * 
 * @author  Tim O'Brien
 * @version 2018-10-12
 */
public abstract class Restaurant
{
    
    /**
     * Abstract method for addTicket
     * 
     * @param order takes in a ticket object
     * @return true or false
     */
    public abstract boolean addTicket(Ticket order);

    /**
     * 
     * @return the next ticket to be completed
     */
    protected abstract Ticket checkNextCompletedTicket();

    /**
     * 
     * @return the completedTicket implemented in a stack or queue
     */
    protected abstract Ticket completeTicket();

    /**
     * 
     * @return the number of remaining tickets
     */
    protected abstract int numberRemainingTickets();

    /**
     * 
     * @return a message in the format of %d orders left. Working on: %s
     */
    public String getCurrentStatus()
    {
        String message;

        // Checks to see if the tickets left is 0, else it formats the message to the
        // specification
        if (numberRemainingTickets() == 0)
        {
            message = "No orders left.";
        } else
        {
            message = String.format("%d orders left. Working on: %s", numberRemainingTickets(),
                    checkNextCompletedTicket().toString());
        }

        return message;
    }

    /**
     * 
     * @param timeCompleted time it took for order to complete
     * @return a String with the format It tooks %d time units to complete the
     *         following order: %s
     */
    public String completeTicket(int timeCompleted)
    {

        String message;

        if (numberRemainingTickets() == 0)
        {
            message = "No orders remain. Could not complete an Ticket.";
        } else
        {
            Ticket t = completeTicket();

            message = String.format("It tooks %d time units to complete the following order: %s",
                    timeCompleted - t.getTimeOrdered(), t.toString());
        }

        return message;
    }
}
