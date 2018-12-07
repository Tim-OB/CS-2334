import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.FileReader;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Tim O'Brien
 * @version 2018-09-19 Project 1
 * 
 *          Tests the methods inside the MapData class.
 */
public class MapDataTest
{

    /**
     * Tests the MapData constructor.
     */
    @Test
    public void testMapDataConstructor()
    {
        // Use full constructor
        MapData map = new MapData(2018, 8, 10, 15, 20, "data");

        /*
         * Tests the getters for year, month, day, hour, minute, and directory
         */
        Assert.assertEquals(2018, map.getYear());
        Assert.assertEquals(8, map.getMonth());
        Assert.assertEquals(10, map.getDay());
        Assert.assertEquals(15, map.getHour());
        Assert.assertEquals(20, map.getMinute());
        Assert.assertEquals("data", map.getDirectory());

    }

    /**
     * Makes sure the createFileName method works.
     */
    @Test
    public void testCreateFileName()
    {
        MapData map = new MapData(2018, 8, 10, 15, 20, "data");

        String fileName = "";
        String year;
        String month;
        String day;
        String hour;
        String minute;
        String directory;

        if (map.getYear() < 10)
        {
            year = String.format("%02d", map.getYear());
        } else
        {
            year = String.format("%d", map.getYear());
        }

        if (map.getMonth() < 10)
        {
            month = String.format("%02d", map.getMonth());
        } else
        {
            month = String.format("%d", map.getMonth());
        }

        if (map.getDay() < 10)
        {
            day = String.format("%02d", map.getDay());
        } else
        {
            day = String.format("%d", map.getDay());
        }

        if (map.getHour() < 10)
        {
            hour = String.format("%02d", map.getHour());
        } else
        {
            hour = String.format("%d", map.getHour());
        }

        if (map.getMinute() < 10)
        {
            minute = String.format("%02d", map.getMinute());
        } else
        {
            minute = String.format("%d", map.getMinute());
        }

        fileName = String.format("%s/%s%s%s%s%s.mdf", map.getDirectory(), year, month, day, hour, minute);
        String expected = "data/201808101520.mdf";

        Assert.assertEquals(expected, fileName);

    }

    /**
     * Makes sure the toString method in the MapData class works.
     */
    @Test
    public void testToString()
    {
        MapData map = new MapData(2018, 8, 30, 17, 45, "data");
        String expected = map.toString();
        
        assertEquals(expected, map.toString());
    }

}
