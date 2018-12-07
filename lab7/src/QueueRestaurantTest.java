import static org.junit.Assert.*;

import org.junit.Test;
/**
 * Lab 7
 * 
 * Test of QueueRestaurant.
 * 
 * @author  Tim O'Brien
 * @version 2018-10-12
 */
public class QueueRestaurantTest
{

    @Test
    public void testAddTicket()
    {
        //Set up a few tickets
        Ticket t = new Ticket("Pie", 300);
        Ticket t2 = new Ticket("Pie", 300);

        //Set up a few QR's
        QueueRestaurant qr = new QueueRestaurant(2);
        QueueRestaurant qr2 = new QueueRestaurant(1);

        //Add all of the tickets setup
        qr.addTicket(t);
        qr2.addTicket(t);
        qr2.addTicket(t2);
        
        assertEquals(qr2.addTicket(t2), false);
    }
    
    /**
     * Tests the complete ticket method in QueueRestaurant
     */
    @Test
    public void testCompleteTicket()
    {
        //Set up some tickets
        Ticket t = new Ticket("Pie", 300);
        Ticket t2 = new Ticket("Pie", 300);

        //Set up a couple QR's
        QueueRestaurant qr = new QueueRestaurant(2);
        QueueRestaurant qr2 = new QueueRestaurant(1);

        //Add the tickets
        qr.addTicket(t);
        qr.addTicket(t2);
        
        //Complete a ticket
        qr.completeTicket();
        
        //Make a complete ticket result in, null.
        Ticket nl = qr2.completeTicket();
        
        assertEquals(qr.completeTicket(), t2);
        assertEquals(nl, null);
    }

    /**
     * Tests the check next completed method in QR
     */
    @Test
    public void testCheckNextCompletedTicket()
    {
        //Make some tickets
        Ticket t = new Ticket("Pie", 300);
        Ticket t2 = new Ticket("Pie", 300);

        //Make some QR's
        QueueRestaurant qr = new QueueRestaurant(2);
        QueueRestaurant qr2 = new QueueRestaurant(2);

        //Add the tickets
        qr.addTicket(t);
        qr.addTicket(t2);
        
        //Complete a ticket
        qr.completeTicket();
        
        //Get the next completed ticket
        Ticket next = qr.checkNextCompletedTicket();
        Ticket nl = qr2.checkNextCompletedTicket();

        assertEquals(next, t2);
        assertEquals(nl, null);

    }

    /**
     * Tests the number of remaining tickets
     */
    @Test
    public void testNumberRemainingTickets()
    {
        //Set up tickets
        Ticket t = new Ticket("Pie", 300);
        Ticket t2 = new Ticket("Pie", 300);

        //Set up a QR
        QueueRestaurant qr = new QueueRestaurant(2);

        //Add the tickets to the QR
        qr.addTicket(t);
        qr.addTicket(t2);
        
        //Complete a ticket
        qr.completeTicket();
        
        //Get the number of tickets remaining into an int
        int next = qr.numberRemainingTickets();
        
        assertEquals(next, 1);
    }

}
