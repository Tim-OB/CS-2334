import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

/**
 * @author Tim O'Brien, referenced UML diagram
 * @version 2018-09-18 Project 1
 * 
 *          Takes in a value, stationId, date, statType, and a
 *          numberOfValidStations. Formats the date either from a string to a
 *          GregorianCalendar, or a GC to a String
 */
public class Statistics extends Observation implements DateTimeComparable
{
    // Foramt for the date
    protected String DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss z";
    // The date
    private GregorianCalendar utcDateTime;
    private int numberOfReportingStations;

    /**
     * Constructor for Statistics takes in a string for date
     * 
     * @param value                 the value of the observation
     * @param stid                  station id
     * @param dateTimeStr           a string calendar date
     * @param numberOfValidStations number that was valid in the count
     * @param inStatType            type of observation it was
     * @throws ParseException to handle errors
     */
    public Statistics(double value, String stid, String dateTimeStr, int numberOfValidStations, StatsType inStatType)
            throws ParseException
    {
        super(value, stid);
        this.numberOfReportingStations = numberOfValidStations;
        this.utcDateTime = createDateFromString(dateTimeStr);
    }

    /**
     * Constructor for Statistics takes in a GregorianCalendar for the date
     * 
     * @param value                 the value of the observation
     * @param stid                  station id
     * @param dateTime              a gregorian calendar date
     * @param numberOfValidStations number that was valid in the count
     * @param inStatType            type of observation it was
     * 
     */
    public Statistics(double value, String stid, GregorianCalendar dateTime, int numberOfValidStations,
            StatsType inStatType)
    {
        super(value, stid);
        this.utcDateTime = dateTime;

        createStringFromDate(dateTime);
    }

    /**
     * Formats a GC from a string
     * 
     * @param dateTimeStr a string containing a date
     * @return the formatted Calendar
     * @throws ParseException better not break
     */
    public GregorianCalendar createDateFromString(String dateTimeStr) throws ParseException
    {
        DateFormat df = new SimpleDateFormat(DATE_TIME_FORMAT);
        Date date = null;

        date = df.parse(dateTimeStr);

        Calendar cal = new GregorianCalendar();
        cal.setTime(date);

        return (GregorianCalendar) cal;
    }

    /**
     * Takes a date in the parameter and formats it into a string
     * 
     * @param calendar a gregorian calendar
     * @return the date string
     */
    public String createStringFromDate(GregorianCalendar calendar)
    {
        SimpleDateFormat df = new SimpleDateFormat(DATE_TIME_FORMAT);
        df.setTimeZone(TimeZone.getTimeZone("UTC"));
        String strFromDate = df.format(calendar.getTime());

        return strFromDate;
    }

    /**
     * 
     * @return numberOfReportingStation
     */
    public int getNumberOfReportingStations()
    {
        return numberOfReportingStations;
    }

    /**
     * 
     * @return the string created from createStringFromDate
     */
    public String getUTCDateTimeString()
    {
        return createStringFromDate(utcDateTime);
    }

    /**
     * Checks if the calendar date is newer
     */
    public boolean newerThan(GregorianCalendar inDateTime)
    {
        return utcDateTime.after(inDateTime);
    }

    /**
     * Checks if the calendar is older
     */
    public boolean olderThan(GregorianCalendar inDateTime)
    {

        return utcDateTime.before(inDateTime);
    }

    /**
     * Checks if the calendar date is the same
     */
    public boolean sameAs(GregorianCalendar inDateTime)
    {

        return utcDateTime.equals(inDateTime);
    }

    /**
     * Format a string containing the date string, station id, statType, and value.
     */
    public String toString()
    {
        String s = createStringFromDate(utcDateTime);
        String x = String.format("%s, %.1f, %s ", getStid(), getValue(), s);

        return x;
    }
}
