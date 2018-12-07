import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Lab 7
 * 
 * Test representing QueueRestaurant.
 * 
 * @author Tim O'Brien
 * @version 2018-10-12
 */
public class StackRestaurantTest
{

    @Test
    public void testAddTicket()
    {
        // Set up a ticket
        Ticket t = new Ticket("Pie", 300);

        // Initiate a StackRestaurant
        StackRestaurant sr = new StackRestaurant();

        // Add the ticket
        sr.addTicket(t);
    }

    @Test
    public void testCheckNextCompletedTicket()
    {
        // Make a couple tickets
        Ticket t = new Ticket("Pie", 300);
        Ticket t2 = new Ticket("APPLES", 3500);

        // Initiate a couple SR's
        StackRestaurant sr = new StackRestaurant();
        StackRestaurant sr2 = new StackRestaurant();

        // Add the tickets
        sr.addTicket(t);
        sr.addTicket(t2);

        // Check the next ticket to be completed
        Ticket s = sr.checkNextCompletedTicket();
        Ticket nl = sr2.checkNextCompletedTicket();

        assertEquals(s, t2);
        assertEquals(nl, null);

    }

    @Test
    public void testCompleteTicket()
    {
        // Make tickets
        Ticket t = new Ticket("Pie", 300);
        Ticket t2 = new Ticket("APPLES", 3500);

        //Initiate a couple SR's
        StackRestaurant sr = new StackRestaurant();
        StackRestaurant sr2 = new StackRestaurant();

        //Add the tickets
        sr.addTicket(t);
        sr.addTicket(t2);

        //Complete a ticket
        Ticket s = sr.completeTicket();
        Ticket nl = sr2.completeTicket();

        assertEquals(s, t2);
        assertEquals(nl, null);
    }

    @Test
    public void testNumberRemainingTickets()
    {
        //Make a few tickets
        Ticket t = new Ticket("Pie", 300);
        Ticket t2 = new Ticket("APPLES", 3500);

        //Initiate a SR
        StackRestaurant sr = new StackRestaurant();

        //Add the tickets
        sr.addTicket(t);
        sr.addTicket(t2);

        //Get the number of remaining tickets
        int s = sr.numberRemainingTickets();

        assertEquals(s, 2);
    }

}
