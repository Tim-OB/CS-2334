import java.util.Stack;

/**
 * Lab 7
 * 
 * Class representing a Stack of a restaurant.
 * 
 * @author Tim O'Brien
 * @version 2018-10-12
 */
public class StackRestaurant extends Restaurant
{
    Stack<Ticket> t;

    /**
     * Constructor for StackRestaurant initiates the Stack t.
     */
    public StackRestaurant()
    {
        t = new Stack<Ticket>();
    }

    /**
     * Adds a ticket object to the Stack
     * 
     * @return boolean checking if the Stack is empty. false if empty, true if not.
     */
    public boolean addTicket(Ticket order)
    {
        boolean ticketAdd;

        t.push(order);

        ticketAdd = true;

        return ticketAdd;
    }

    /**
     * @return the next ticket to be completed
     */
    protected Ticket checkNextCompletedTicket()
    {
        if (numberRemainingTickets() == 0)
        {
            return null;
        } else
        {
            return t.peek();
        }
    }

    /**
     * @return the top of the stack
     */
    protected Ticket completeTicket()
    {
        if (numberRemainingTickets() == 0)
        {
            return null;
        } else
        {
            return t.pop();
        }
    }

    /**
     * @return the number of tickets left in the queue
     */
    protected int numberRemainingTickets()
    {
        return t.size();
    }
}
