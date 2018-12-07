import static org.junit.Assert.*;

import org.junit.Test;

public class PlayerTest
{

    @Test
    public void testPlayerConstructor()
    {
        String str = "Kyler,64.2,120,Allen/Texas";
        Player p = new Player(str);

        assertEquals("Kyler", p.getName());
        assertEquals(64.2, p.getHeight(), .001);
        assertEquals(120, p.getWeight());
        assertEquals("Allen", p.getHomeCity());
        assertEquals("Texas", p.getHomeState());

    }

    @Test
    public void testToString()
    {
        String str = "Kyler,64.2,120,Allen/Texas";
        Player p = new Player(str);
        String s = String.format("Name: %s, Height: %.2f ft, Weight: %s lbs, Home City: %s, Home State: %s\n",
                p.getName(), p.getHeight(), p.getWeight(), p.getHomeCity(), p.getHomeState());

        assertEquals(s, p.toString());
    }

    @Test
    public void testGetName()
    {
        String str = "Kyler,64.2,120,Allen/Texas";
        Player p = new Player(str);

        assertEquals("Kyler", p.getName());
    }

    @Test
    public void testGetHeight()
    {
        String str = "Kyler,64.2,120,Allen/Texas";
        Player p = new Player(str);

        assertEquals(64.2, p.getHeight(), .001);
    }

    @Test
    public void testGetWeight()
    {
        String str = "Kyler,64.2,120,Allen/Texas";
        Player p = new Player(str);

        assertEquals(120, p.getWeight());
    }

    @Test
    public void testGetHomeCity()
    {
        String str = "Kyler,64.2,120,Allen/Texas";
        Player p = new Player(str);

        assertEquals("Allen", p.getHomeCity());
    }

    @Test
    public void testGetHomeState()
    {
        String str = "Kyler,64.2,120,Allen/Texas";
        Player p = new Player(str);

        assertEquals("Texas", p.getHomeState());
    }

}
