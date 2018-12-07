import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.TimeZone;

/**
 * @author Tim O'Brien, referenced UML diagram
 * @version 2018-10-3 Project 2
 * 
 *          Reads in data from a given file, parses it, and then takes the
 *          averages, max's, min's, and then outputs them.
 * 
 *          Worked with Reece Reinke, and Tim Weaver.
 */
public class MapData
{
    // ArrayLists for the various parameter ID's
    private ArrayList<Observation> sradData = new ArrayList<>();
    private ArrayList<Observation> tairData = new ArrayList<>();
    private ArrayList<Observation> ta9mData = new ArrayList<>();

    // Param Id's
    private String TA9M = "TA9M";
    private String TAIR = "TAIR";
    private String SRAD = "SRAD";
    private String STID = "STID";

    // Position of the parameter ID's
    private int stidPosition = -1;
    private int tairPosition = -1;
    private int sradPosition = -1;
    private int ta9mPosition = -1;

    private final String MESONET = "Mesonet";

    // Holds all of the statistics calculated
    private Statistics tairMin;
    private Statistics tairMax;
    private Statistics tairAverage;
    private Statistics ta9mMin;
    private Statistics ta9mMax;
    private Statistics ta9mAverage;
    private Statistics sradMin;
    private Statistics sradMax;
    private Statistics sradAverage;
    private Statistics sradTotal;

    // File name
    private String fileName;
    // Date set within the constructor
    private GregorianCalendar utcDateTime;

    /**
     * Main constructor for MapData
     * 
     * @param year      'YYYY'
     * @param month     'MM'
     * @param day       'dd'
     * @param hour      'HH'
     * @param minute    'mm'
     * @param directory file path
     */
    public MapData(int year, int month, int day, int hour, int minute, String directory)
    {
        createFileName(year, month, day, hour, minute, directory);

        // Setting the GregorianCalendar.
        utcDateTime = new GregorianCalendar();
        utcDateTime.setTimeZone(TimeZone.getTimeZone("UTC"));
        utcDateTime.set(Calendar.YEAR, year);
        utcDateTime.set(Calendar.MONTH, month - 1);
        utcDateTime.set(Calendar.DAY_OF_MONTH, day);
        utcDateTime.set(Calendar.HOUR_OF_DAY, hour);
        utcDateTime.set(Calendar.MINUTE, minute);
        utcDateTime.set(Calendar.SECOND, 0);

    }

    /**
     * Creates the file name from the data given in the parameters
     * 
     * @param year      yyyy format
     * @param month     mm format
     * @param day       dd format
     * @param hour      hh format
     * @param minute    MM format
     * @param directory path
     * @return the string containing the fileName
     */
    public String createFileName(int year, int month, int day, int hour, int minute, String directory)
    {
        String fN = "";
        String y;
        String m;
        String d;
        String h;
        String mi;
        String di = directory;

        // If year is less than 10 pad it with 0's
        if (year < 10)
        {
            y = String.format("%02d", year);
        } else
        {
            y = String.format("%d", year);
        }

        // If month is less than 10 pad it with 0's
        if (month < 10)
        {
            m = String.format("%02d", month);
        } else
        {
            m = String.format("%d", month);
        }

        // If day is less than 10 pad it with 0's
        if (day < 10)
        {
            d = String.format("%02d", day);
        } else
        {
            d = String.format("%d", day);
        }

        // If hour is less than 10 pad it with 0's
        if (hour < 10)
        {
            h = String.format("%02d", hour);
        } else
        {
            h = String.format("%d", hour);
        }

        // If minute is less than 10 pad it with 0's
        if (minute < 10)
        {
            mi = String.format("%02d", minute);
        } else
        {
            mi = String.format("%d", minute);
        }

        // format filename to the newly padded values
        fN = String.format("%s/%s%s%s%s%s.mdf", di, y, m, d, h, mi);
        this.fileName = fN;

        return fileName;
    }

    /**
     * 
     * @param inParamStr contains the string of the data file that contains if it is
     *                   TAIR, SRAD, or Ta9m
     */
    private void parseParamHeader(String inParamStr)
    {
        ArrayList<String> positions = new ArrayList<>();

        // Trims the string by whitespace characters
        String[] id = (inParamStr.trim().split("\\s+"));

        // Add the arrays string to an arrayList
        positions.addAll(Arrays.asList(id));

        // Set the positions of tair, ta9m, srad, and stid based on their index.
        tairPosition = positions.indexOf(TAIR);
        ta9mPosition = positions.indexOf(TA9M);
        sradPosition = positions.indexOf(SRAD);
        stidPosition = positions.indexOf(STID);

    }

    /**
     * Method to read in the dataFile given and populate into arrayLists. Calculates
     * the statistics based off of this data.
     * 
     * @throws IOException nothing wacky
     */
    public void parseFile() throws IOException
    {

        BufferedReader br = new BufferedReader(new FileReader(fileName));
        String line;

        // Throw headers
        br.readLine();
        br.readLine();

        // Call the parseParamHeader method using the line given by the BufferedReader
        parseParamHeader(br.readLine());

        line = br.readLine();

        // Loop through the file parsing as we go along
        while (line != null)
        {
            // Split the data file by white spaces
            String[] info = line.trim().split("\\s+");

            // Parse the file and put into tair's arrayList
            double v = Double.parseDouble(info[tairPosition]);
            tairData.add(new Observation(v, info[stidPosition]));

            // Parse the file and put into ta9m's arrayList
            double v1 = Double.parseDouble(info[ta9mPosition]);
            ta9mData.add(new Observation(v1, info[stidPosition]));

            // Parse the file and put into srad's arrayList
            double v2 = Double.parseDouble(info[sradPosition]);
            sradData.add(new Observation(v2, info[stidPosition]));

            // Get the next line of the file
            line = br.readLine();
        }
        // Close this or BAD things happen.
        br.close();

        // Call calculate statistics for each paramId
        calculateStatistics(tairData, TAIR);
        calculateStatistics(ta9mData, TA9M);
        calculateStatistics(sradData, SRAD);
    }

    /**
     * Calculates the statistics based off of the parameters given.
     * 
     * @param inData  the arrayList
     * @param paramId Tair, srad, or Ta9m
     */
    private void calculateStatistics(ArrayList<Observation> inData, String paramId)
    {

        // Loop for the tair Stats
        if (paramId.equalsIgnoreCase("TAIR"))
        {
            double total = 0.0;
            int count = 0;
            double average = 0.0;
            double min = Double.POSITIVE_INFINITY;
            double max = Double.NEGATIVE_INFINITY;
            String stationMax = null;
            String stationMin = null;

            for (int i = 0; i < inData.size(); i++)
            {
                if (inData.get(i).isValid())
                {
                    count++;
                    total += inData.get(i).getValue();

                    if (inData.get(i).getValue() < min)
                    {
                        stationMin = inData.get(i).getStid();
                        min = inData.get(i).getValue();
                    }

                    if (inData.get(i).getValue() > max)
                    {
                        stationMax = inData.get(i).getStid();
                        max = inData.get(i).getValue();
                    }

                }
                average = total / count;
            }
            // Populate the statistic variables with the appropriate values
            tairMin = new Statistics(min, stationMin, utcDateTime, count, StatsType.MINIMUM);
            tairMax = new Statistics(max, stationMax, utcDateTime, count, StatsType.MAXIMU);
            tairAverage = new Statistics(average, MESONET, utcDateTime, count, StatsType.AVERAGE);

        }

        // Loop for the Ta9m Stats
        if (paramId.equalsIgnoreCase("TA9M"))
        {
            double total = 0.0;
            int count = 0;
            double average = 0.0;
            double min = Double.POSITIVE_INFINITY;
            double max = Double.NEGATIVE_INFINITY;
            String stationMax = null;
            String stationMin = null;

            for (int i = 0; i < inData.size(); i++)
            {
                if (inData.get(i).isValid())
                {
                    count++;
                    total += inData.get(i).getValue();

                    if (inData.get(i).getValue() < min)
                    {
                        stationMin = inData.get(i).getStid();
                        min = inData.get(i).getValue();
                    }

                    if (inData.get(i).getValue() > max)
                    {
                        stationMax = inData.get(i).getStid();
                        max = inData.get(i).getValue();
                    }

                }
                average = total / count;
            }
            // Populate the statistic variables with the appropriate values
            ta9mMin = new Statistics(min, stationMin, utcDateTime, count, StatsType.MINIMUM);
            ta9mMax = new Statistics(max, stationMax, utcDateTime, count, StatsType.MAXIMU);
            ta9mAverage = new Statistics(average, MESONET, utcDateTime, count, StatsType.AVERAGE);

        }

        // Loop for Srad calculatiosn
        if (paramId.equalsIgnoreCase("SRAD"))
        {
            double total = 0.0;
            int count = 0;
            double average = 0.0;
            double min = Double.POSITIVE_INFINITY;
            double max = Double.NEGATIVE_INFINITY;
            String stationMax = null;
            String stationMin = null;

            for (int i = 0; i < inData.size(); i++)
            {
                if (inData.get(i).isValid())
                {
                    count++;
                    total += inData.get(i).getValue();

                    if (inData.get(i).getValue() < min)
                    {
                        stationMin = inData.get(i).getStid();
                        min = inData.get(i).getValue();
                    }

                    if (inData.get(i).getValue() > max)
                    {
                        stationMax = inData.get(i).getStid();
                        max = inData.get(i).getValue();
                    }

                }

                average = total / count;
            }
            // Populate the statistic variables with the appropriate values
            sradMin = new Statistics(min, stationMin, utcDateTime, count, StatsType.MINIMUM);
            sradMax = new Statistics(max, stationMax, utcDateTime, count, StatsType.MAXIMU);
            sradAverage = new Statistics(average, MESONET, utcDateTime, count, StatsType.AVERAGE);
            sradTotal = new Statistics(total, MESONET, utcDateTime, count, StatsType.TOTAL);
        }
    }

    /**
     * 
     * @return the sradAverage values and stid
     */
    public Observation getSradAverage()
    {

        return sradAverage;

    }

    /**
     * 
     * @return the sradMax values and stid
     */
    public Observation getSradMax()
    {
        return sradMax;

    }

    /**
     * 
     * @return the sradMin values and stid
     */
    public Observation getSradMin()
    {
        return sradMin;
    }

    /**
     * 
     * @return the sradTotal values and stid
     */
    public Observation getSradTotal()
    {
        return sradTotal;
    }

    /**
     * 
     * @return the ta9mAverage values and stid
     */
    public Observation getTa9mAverage()
    {
        return ta9mAverage;
    }

    /**
     * 
     * @return the ta9mMax values and stid
     */
    public Observation getTa9mMax()
    {
        return ta9mMax;
    }

    /**
     * 
     * @return the ta9mMin values and stid
     */
    public Observation getTa9mMin()
    {
        return ta9mMin;
    }

    /**
     * 
     * @return the tairAverage values and stid
     */
    public Observation getTairAverage()
    {
        return tairAverage;
    }

    /**
     * 
     * @return the tairMax values and stid
     */
    public Observation getTairMax()
    {
        return tairMax;
    }

    /**
     * 
     * @return the tairMin values and stid
     */
    public Observation getTairMin()
    {
        return tairMin;
    }

    /**
     * toString method to format output into the prompt
     * 
     * @return the formatted string
     */
    public String toString()
    {

        // Build the string starting with all of the dividers needed.
        String divider = "==========================================================\n";
        String smallDivider = "==="
                + utcDateTime.toZonedDateTime().format(DateTimeFormatter.ofPattern("YYYY-MM-dd HH:mm z")) + "===";

        String maxAir = String.format("Maximum Air Temperature[1.5m] = %.1f C at %s", getTairMax().getValue(),
                getTairMax().getStid());
        String minAir = String.format("Minimum Air Temperature[1.5m] = %.1f C at %s", getTairMin().getValue(),
                getTairMin().getStid());
        String averageAir = String.format("Average Air Temperature[1.5m] = %.1f C at %s", getTairAverage().getValue(),
                MESONET);
        String max9Air = String.format("Maximum Air Temperature[9.0m] = %.1f C at %s", getTa9mMax().getValue(),
                getTa9mMax().getStid());
        String min9Air = String.format("Minimum Air Temperature[9.0m] = %.1f C at %s", getTa9mMin().getValue(),
                getTa9mMin().getStid());
        String average9Air = String.format("Average Air Temperature[9.0m] = %.1f C at %s", getTa9mAverage().getValue(),
                MESONET);
        String maxSolarRad = String.format("Maximum Solar Radiation[1.5m] = %.1f W/m^2 at %s", getSradMax().getValue(),
                getSradMax().getStid());
        String minSolarRad = String.format("Minimum Solar Radiation[1.5m] = %.1f W/m^2 at %s", getSradMin().getValue(),
                getSradMin().getStid());
        String averageSolarRad = String.format("Average Solar Radiation[1.5m] = %.1f W/m^2 at %s",
                getSradAverage().getValue(), MESONET);

        // Add all the strings to the dataString to return the formatted string
        String dataString = divider + smallDivider + "\n" + divider + maxAir + "\n" + minAir + "\n" + averageAir + "\n"
                + divider + divider + max9Air + "\n" + min9Air + "\n" + average9Air + "\n" + divider + divider
                + maxSolarRad + "\n" + minSolarRad + "\n" + averageSolarRad + "\n" + divider;

        return dataString;
    }
}
