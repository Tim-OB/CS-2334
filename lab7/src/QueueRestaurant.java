import java.util.LinkedList;
import java.util.Queue;
/**
 * Lab 7
 * 
 * Class representing a Queue of a restaurant.
 * 
 * @author  Tim O'Brien
 * @version 2018-10-12
 */
public class QueueRestaurant extends Restaurant
{
    // Setup the variables for the linked list
    Queue<Ticket> q;
    int maxSize;

    /**
     * Constructor for QueueRestaurant takes in a max size for the LinkedList q
     * 
     * @param maxSize determines the size of the Queue
     */
    public QueueRestaurant(int maxSize)
    {
        q = new LinkedList<Ticket>();
        this.maxSize = maxSize;
    }

    /**
     * Checks if the LinkedList is within its bounds return true or false if the
     * ticket should be added
     */
    public boolean addTicket(Ticket order)
    {
        boolean ticketAdd = true;

        if (q.size() == maxSize)
        {
            ticketAdd = false;
        } else
        {
            q.add(order);
        }

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
            return q.peek();
        }
    }

    /**
     * @return the first instance of the queue
     */
    protected Ticket completeTicket()
    {
        if (numberRemainingTickets() == 0)
        {
            return null;
        } else
        {
            return q.remove();
        }
    }

    /**
     * @return the number of tickets left in the queue
     */
    protected int numberRemainingTickets()
    {
        return q.size();
    }
}
