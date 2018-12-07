import static org.junit.Assert.*;
import org.junit.Test;
/**
 * Lab 7
 * 
 * Test representing an order of a restaurant.
 * 
 * @author  Tim O'Brien
 * @version 2018-10-12
 */
public class TicketTest
{

    @Test
    public void testTicket()
    {
        Ticket t = new Ticket("Apple Pie", 300);
        
        assertEquals(t.getDescription(), "Apple Pie");
    }

    @Test
    public void testGetDescription()
    {
        Ticket t = new Ticket("Apple Pie", 300);

        String descrip = t.getDescription();
        
        assertEquals(descrip, "Apple Pie");
    }

    @Test
    public void testGetTimeOrdered()
    {
        Ticket t = new Ticket("Apple Pie", 300);

        int time = t.getTimeOrdered();
        
        assertEquals(time, 300);
    }

    @Test
    public void testToString()
    {
        Ticket t = new Ticket("Apple Pie", 300);

        String descrip = t.toString();
        
        assertEquals(descrip, "Apple Pie");
    }

    @Test
    public void testCompareTo()
    {
        Ticket t = new Ticket("Apple Pie", 300);
        Ticket t2 = new Ticket("Apple Pie", 300);
        Ticket t3 = new Ticket("Apple Pie", 200);

        assertEquals(t.compareTo(t2), 0);
        assertEquals(t.compareTo(t3), 1);
        assertEquals(t3.compareTo(t2), -1);

    }

}
