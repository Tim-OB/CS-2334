import static org.junit.Assert.*;

import org.junit.Test;
/**
 * Lab 7
 * 
 * Test of Restaurant.
 * 
 * @author  Tim O'Brien
 * @version 2018-10-12
 */
public class RestaurantTest
{

    @Test
    public void testGetCurrentStatus()
    {
        Ticket t = new Ticket("Pie", 300);
        
        StackRestaurant sr = new StackRestaurant();
        
        sr.addTicket(t);
        
        String status = sr.getCurrentStatus();
        
        sr.completeTicket();
        String status2 = sr.getCurrentStatus();
        
        assertEquals(status, "1 orders left. Working on: Pie");
        assertEquals(status2, "No orders left.");

    }

    @Test
    public void testCompleteTicketInt()
    {
        Ticket t = new Ticket("Pie", 300);
        
        StackRestaurant sr = new StackRestaurant();
        
        sr.addTicket(t);
        
        String complete = sr.completeTicket(505);
        String complete2 = sr.completeTicket(505);

        assertEquals(complete, "It tooks 205 time units to complete the following order: Pie");
        assertEquals(complete2, "No orders remain. Could not complete an Ticket.");

    }

}
