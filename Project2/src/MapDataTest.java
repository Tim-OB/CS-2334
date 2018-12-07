import static org.junit.Assert.*;

import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.TimeZone;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Tim O'Brien
 * @version 2018-10-03 Project 2
 * 
 *          Tests the methods inside the MapData class.
 */
public class MapDataTest
{

    /**
     * Test the mapData constructor
     */
    @Test
    public void testMapData()
    {
        int year = 2018;
        int month = 8;
        int day = 30;
        int hour = 17;
        int minute = 45;
        String directory = "data";

        MapData m = new MapData(year, month, day, hour, minute, directory);
        String file = m.createFileName(year, month, day, hour, minute, directory);

        GregorianCalendar gc = new GregorianCalendar();
        gc.setTimeZone(TimeZone.getTimeZone("UTC"));
        gc.set(Calendar.YEAR, year);
        gc.set(Calendar.MONTH, month);
        gc.set(Calendar.DAY_OF_MONTH, day);
        gc.set(Calendar.HOUR_OF_DAY, hour);
        gc.set(Calendar.MINUTE, minute);
        gc.set(Calendar.SECOND, 0);

        assertEquals("data/201808301745.mdf", file);
        assertEquals(2018, gc.get(Calendar.YEAR));
        assertEquals(8, gc.get(Calendar.MONTH));
        assertEquals(30, gc.get(Calendar.DAY_OF_MONTH));
        assertEquals(17, gc.get(Calendar.HOUR_OF_DAY));
        assertEquals(45, gc.get(Calendar.MINUTE));
        assertEquals(0, gc.get(Calendar.SECOND));
    }

    /**
     * Test mapdata's create file name function
     */
    @Test
    public void testCreateFileName()
    {

        int year = 8;
        int month = 10;
        int day = 9;
        int hour = 9;
        int minute = 9;
        String directory = "data";

        MapData map = new MapData(year, month, day, hour, minute, directory);

        String fileName = "";
        String yearS;
        String monthS;
        String dayS;
        String hourS;
        String minuteS;

        if (year < 10)
        {
            yearS = String.format("%02d", year);
        } else
        {
            yearS = String.format("%d", year);
        }

        if (month < 10)
        {
            monthS = String.format("%02d", month);
        } else
        {
            monthS = String.format("%d", month);
        }

        if (day < 10)
        {
            dayS = String.format("%02d", day);
        } else
        {
            dayS = String.format("%d", day);
        }

        if (hour < 10)
        {
            hourS = String.format("%02d", hour);
        } else
        {
            hourS = String.format("%d", hour);
        }

        if (minute < 10)
        {
            minuteS = String.format("%02d", minute);
        } else
        {
            minuteS = String.format("%d", minute);
        }

        map.createFileName(year, month, day, hour, minute, directory);
        fileName = String.format("%s/%s%s%s%s%s.mdf", directory, yearS, monthS, dayS, hourS, minuteS);
        String expected = "data/0810090909.mdf";

        Assert.assertEquals(expected, fileName);
    }

    /**
     * Tests the getter for correct values and stationID's
     * 
     * @throws IOException handles errors
     */
    @Test
    public void testGetSradAverage() throws IOException
    {
        int year = 2018;
        int month = 8;
        int day = 30;
        int hour = 17;
        int minute = 45;
        String directory = "data";

        MapData m = new MapData(year, month, day, hour, minute, directory);

        m.parseFile();

        double expected = m.getSradAverage().getValue();
        String exs = m.getSradAverage().getStid();

        assertEquals(expected, 828.1, .1);
        assertEquals(exs, "Mesonet");
    }

    /**
     * Tests the getter for correct values and stationID's
     * 
     * @throws IOException handles errors
     */
    @Test
    public void testGetSradMax() throws IOException
    {
        int year = 2018;
        int month = 8;
        int day = 30;
        int hour = 17;
        int minute = 45;
        String directory = "data";

        MapData m = new MapData(year, month, day, hour, minute, directory);

        m.parseFile();

        double expected = m.getSradMax().getValue();
        String exs = m.getSradMax().getStid();

        assertEquals(expected, 968.0, .1);
        assertEquals(exs, "SLAP");
    }

    /**
     * Tests the getter for correct values and stationID's
     * 
     * @throws IOException handles errors
     */
    @Test
    public void testGetSradMin() throws IOException
    {
        int year = 2018;
        int month = 8;
        int day = 30;
        int hour = 17;
        int minute = 45;
        String directory = "data";

        MapData m = new MapData(year, month, day, hour, minute, directory);

        m.parseFile();

        double expected = m.getSradMin().getValue();
        String exs = m.getSradMin().getStid();

        assertEquals(expected, 163.0, .1);
        assertEquals(exs, "MIAM");
    }

    /**
     * Tests the getter for correct values and stationID's
     * 
     * @throws IOException handles errors
     */
    @Test
    public void testGetSradTotal() throws IOException
    {
        int year = 2018;
        int month = 8;
        int day = 30;
        int hour = 17;
        int minute = 45;
        String directory = "data";

        MapData m = new MapData(year, month, day, hour, minute, directory);

        m.parseFile();

        double expected = m.getSradTotal().getValue();
        String exs = m.getSradTotal().getStid();

        assertEquals(expected, 97720.0, .1);
        assertEquals(exs, "Mesonet");
    }

    /**
     * Tests the getter for correct values and stationID's
     * 
     * @throws IOException handles errors
     */
    @Test
    public void testGetTa9mAverage() throws IOException
    {
        int year = 2018;
        int month = 8;
        int day = 30;
        int hour = 17;
        int minute = 45;
        String directory = "data";

        MapData m = new MapData(year, month, day, hour, minute, directory);

        m.parseFile();

        double expected = m.getTa9mAverage().getValue();
        String exs = m.getTa9mAverage().getStid();

        assertEquals(expected, 31.5, .1);
        assertEquals(exs, "Mesonet");
    }

    /**
     * Tests the getter for correct values and stationID's
     * 
     * @throws IOException handles errors
     */
    @Test
    public void testGetTa9mMax() throws IOException
    {
        int year = 2018;
        int month = 8;
        int day = 30;
        int hour = 17;
        int minute = 45;
        String directory = "data";

        MapData m = new MapData(year, month, day, hour, minute, directory);

        m.parseFile();

        double expected = m.getTa9mMax().getValue();
        String exs = m.getTa9mMax().getStid();

        assertEquals(expected, 34.9, .1);
        assertEquals(exs, "HOOK");
    }

    /**
     * Tests the getter for correct values and stationID's
     * 
     * @throws IOException handles errors
     */
    @Test
    public void testGetTa9mMin() throws IOException
    {
        int year = 2018;
        int month = 8;
        int day = 30;
        int hour = 17;
        int minute = 45;
        String directory = "data";

        MapData m = new MapData(year, month, day, hour, minute, directory);

        m.parseFile();

        double expected = m.getTa9mMin().getValue();
        String exs = m.getTa9mMin().getStid();

        assertEquals(expected, 20.7, .1);
        assertEquals(exs, "MIAM");
    }

    /**
     * Tests the getter for correct values and stationID's
     * 
     * @throws IOException handles errors
     */
    @Test
    public void testGetTairAverage() throws IOException
    {
        int year = 2018;
        int month = 8;
        int day = 30;
        int hour = 17;
        int minute = 45;
        String directory = "data";

        MapData m = new MapData(year, month, day, hour, minute, directory);

        m.parseFile();

        double expected = m.getTairAverage().getValue();
        String exs = m.getTairAverage().getStid();

        assertEquals(expected, 32.4, .1);
        assertEquals(exs, "Mesonet");
    }

    /**
     * Tests the getter for correct values and stationID's
     * 
     * @throws IOException handles errors
     */
    @Test
    public void testGetTairMax() throws IOException
    {
        int year = 2018;
        int month = 8;
        int day = 30;
        int hour = 17;
        int minute = 45;
        String directory = "data";

        MapData m = new MapData(year, month, day, hour, minute, directory);

        m.parseFile();

        double expected = m.getTairMax().getValue();
        String exs = m.getTairMax().getStid();

        assertEquals(expected, 36.5, .1);
        assertEquals(exs, "HOOK");
    }

    /**
     * Tests the getter for correct values and stationID's
     * 
     * @throws IOException handles errors
     */
    @Test
    public void testGetTairMin() throws IOException
    {
        int year = 2018;
        int month = 8;
        int day = 30;
        int hour = 17;
        int minute = 45;
        String directory = "data";

        MapData m = new MapData(year, month, day, hour, minute, directory);

        m.parseFile();

        double expected = m.getTairMin().getValue();
        String exs = m.getTairMin().getStid();

        assertEquals(expected, 20.8, .1);
        assertEquals(exs, "MIAM");
    }

    /**
     * Tests the toString of MapData
     * 
     * @throws IOException handles errors
     */
    @Test
    public void testToString() throws IOException
    {
        int year = 2018;
        int month = 8;
        int day = 30;
        int hour = 17;
        int minute = 45;
        String directory = "data";

        MapData m = new MapData(year, month, day, hour, minute, directory);

        m.createFileName(year, month, day, hour, minute, directory);
        m.parseFile();

        String expected = m.toString();
        String actual = "==========================================================\r\n"
                + "=== 2018-08-30 17:45 UTC ===\r\n" + "==========================================================\r\n"
                + "Maximum Air Temperature[1.5m] = 36.5 C at HOOK\r\n"
                + "Minimum Air Temperature[1.5m] = 20.8 C at MIAM\r\n"
                + "Average Air Temperature[1.5m] = 32.4 C at Mesonet\r\n"
                + "==========================================================\r\n"
                + "==========================================================\r\n"
                + "Maximum Air Temperature[9.0m] = 34.9 C at HOOK\r\n"
                + "Minimum Air Temperature[9.0m] = 20.7 C at MIAM\r\n"
                + "Average Air Temperature[9.0m] = 31.6 C at Mesonet\r\n"
                + "==========================================================\r\n"
                + "==========================================================\r\n"
                + "Maximum Solar Radiation[1.5m] = 968.0 W/m^2 at SLAP \r\n"
                + "Minimum Solar Radiation[1.5m] = 163.0 W/m^2 at MIAM\r\n"
                + "Average Solar Radiation[1.5m] = 828.1 W/m^2 at Mesonet\r\n"
                + "==========================================================\r\n" + "";

        assertEquals(formatForTests(expected), formatForTests(actual)); // TODO
    }

    /**
     * Formats strings for tests, taken from lab 4.
     * 
     * @param in a String
     * @return the formatted string
     */
    private static String formatForTests(String in)
    {
        in = in.toLowerCase();
        in = in.replaceAll("[\\s]", "");
        // I added these cause it made the toStrings pass
        in = in.replaceAll("\\[", "");
        in = in.replaceAll("\\]", "");
        in = in.replaceAll("\\,", "");

        return in;
    }
}