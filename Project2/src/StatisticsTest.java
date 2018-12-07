import static org.junit.Assert.*;

import java.text.ParseException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.TimeZone;

import org.junit.Test;

/**
 * @author Tim O'Brien
 * @version 2018-10-03 Project 2
 * 
 *          Tests the methods inside the Statistics class.
 */
public class StatisticsTest
{

    /**
     * Tests statistics toString
     * @throws ParseException for errors.
     */
    @Test
    public void testToString() throws ParseException
    {
        Statistics st = new Statistics(30.2, "MESONET", "2018-08-30 17:45:00 UTC", 5, StatsType.MAXIMU);

        String s = st.getUTCDateTimeString();

        String x = String.format("%s, %.1f, %s ", st.getStid(), st.getValue(), s);

        assertEquals(x, st.toString());
    }

    /**
     * Tests Statistics constructor with a string for date
     * @throws ParseException for errors
     */
    @Test
    public void testStatisticsDoubleStringStringIntStatsType() throws ParseException
    {
        Statistics st = new Statistics(30.2, "MESONET", "2018-08-30 17:45:00 UTC", 5, StatsType.MAXIMU);

        double value = st.getValue();
        String stid = st.getStid();
        String date = st.getUTCDateTimeString();
        int stations = st.getNumberOfReportingStations();

        assertEquals(value, 30.2, .1);
        assertEquals(stid, "MESONET");
        assertEquals(date, "2018-08-30 17:45:00 UTC");
        assertEquals(stations, 5);
    }

    /**
     * Test Statistics constructor taking in a gregorian calendar
     * 
     * @throws ParseException just in case
     */
    @Test
    public void testStatisticsDoubleStringGregorianCalendarIntStatsType() throws ParseException
    {

        int year = 2018;
        int month = 8;
        int day = 30;
        int hour = 17;
        int minute = 45;

        GregorianCalendar gc = new GregorianCalendar();
        gc.setTimeZone(TimeZone.getTimeZone("UTC"));
        gc.set(Calendar.YEAR, year);
        gc.set(Calendar.MONTH, month);
        gc.set(Calendar.DAY_OF_MONTH, day);
        gc.set(Calendar.HOUR_OF_DAY, hour);
        gc.set(Calendar.MINUTE, minute);
        gc.set(Calendar.SECOND, 0);

        Statistics st = new Statistics(30.2, "MESONET", gc, 5, StatsType.MAXIMU);

        String date = st.createStringFromDate(gc);

        assertEquals(30.2, st.getValue(), .1);
        assertEquals("2018-09-30 17:45:00 UTC", date);

    }

    /**
     * Tests the method to create a string from a Date
     * @throws ParseException makes sure nothing bad happens
     */
    @Test
    public void testCreateStringFromDate() throws ParseException
    {
        Statistics st = new Statistics(30.2, "MESONET", "2018-08-30 17:45:00 UTC", 5, StatsType.MAXIMU);

        int year = 2018;
        int month = 8;
        int day = 30;
        int hour = 17;
        int minute = 45;

        GregorianCalendar gc = new GregorianCalendar();
        gc.setTimeZone(TimeZone.getTimeZone("UTC"));
        gc.set(Calendar.YEAR, year);
        gc.set(Calendar.MONTH, month);
        gc.set(Calendar.DAY_OF_MONTH, day);
        gc.set(Calendar.HOUR_OF_DAY, hour);
        gc.set(Calendar.MINUTE, minute);
        gc.set(Calendar.SECOND, 0);

        String s = st.createStringFromDate(gc);

        assertEquals(s, "2018-09-30 17:45:00 UTC");

    }

    /**
     * Tests the getter for numberOfReportingStations
     * @throws ParseException dont mess up
     */
    @Test
    public void testGetNumberOfReportingStations() throws ParseException
    {
        Statistics st = new Statistics(30.2, "MESONET", "2018-08-30 17:45:00 UTC", 5, StatsType.MAXIMU);
        int a = st.getNumberOfReportingStations();

        assertEquals(a, 5);
    }

    /**
     * Tests the getter for utcDateTimeString
     * @throws ParseException handles errors
     */
    @Test
    public void testGetUTCDateTimeString() throws ParseException
    {
        Statistics st = new Statistics(30.2, "MESONET", "2018-08-30 17:45:00 UTC", 5, StatsType.MAXIMU);

        String s = st.getUTCDateTimeString();

        assertEquals(s, "2018-08-30 17:45:00 UTC");
    }

    /**
     * Compares the dates to see if it is newer
     * @throws ParseException handles error
     */
    @Test
    public void testNewerThan() throws ParseException
    {
        Boolean d;
        Statistics s = new Statistics(30.2, "MESONET", "2018-08-30 17:45:00 UTC", 5, StatsType.MAXIMU);

        int year = 2018;
        int month = 8;
        int day = 30;
        int hour = 17;
        int minute = 45;

        GregorianCalendar gc = new GregorianCalendar();
        gc.setTimeZone(TimeZone.getTimeZone("UTC"));
        gc.set(Calendar.YEAR, year);
        gc.set(Calendar.MONTH, month);
        gc.set(Calendar.DAY_OF_MONTH, day);
        gc.set(Calendar.HOUR_OF_DAY, hour);
        gc.set(Calendar.MINUTE, minute);
        gc.set(Calendar.SECOND, 0);

        d = s.newerThan(gc);

        assertEquals(false, d);
    }

    /**
     * Compares the dates to see if it is older
     * @throws ParseException handles error
     */
    @Test
    public void testOlderThan() throws ParseException
    {
        Boolean d;
        Statistics s = new Statistics(30.2, "MESONET", "2018-08-30 17:45:00 UTC", 5, StatsType.MAXIMU);

        int year = 2018;
        int month = 8;
        int day = 30;
        int hour = 17;
        int minute = 45;

        GregorianCalendar gc = new GregorianCalendar();
        gc.setTimeZone(TimeZone.getTimeZone("UTC"));
        gc.set(Calendar.YEAR, year);
        gc.set(Calendar.MONTH, month);
        gc.set(Calendar.DAY_OF_MONTH, day);
        gc.set(Calendar.HOUR_OF_DAY, hour);
        gc.set(Calendar.MINUTE, minute);
        gc.set(Calendar.SECOND, 0);

        d = s.olderThan(gc);

        assertEquals(true, d);
    }

    /**
     * Compares the dates to see if it is the same
     * @throws ParseException handles error
     */
    @Test
    public void testSameAs() throws ParseException
    {
        Boolean d;
        Statistics s = new Statistics(30.2, "MESONET", "2018-08-30 17:45:00 UTC", 5, StatsType.MAXIMU);

        int year = 2018;
        int month = 8;
        int day = 30;
        int hour = 17;
        int minute = 45;

        GregorianCalendar gc = new GregorianCalendar();
        gc.setTimeZone(TimeZone.getTimeZone("UTC"));
        gc.set(Calendar.YEAR, year);
        gc.set(Calendar.MONTH, month);
        gc.set(Calendar.DAY_OF_MONTH, day);
        gc.set(Calendar.HOUR_OF_DAY, hour);
        gc.set(Calendar.MINUTE, minute);
        gc.set(Calendar.SECOND, 0);

        d = s.sameAs(gc);

        assertEquals(false, d);
    }

}
