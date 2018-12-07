import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * @author Tim O'Brien, referenced UML diagram
 * @version 2018-09-10 Project 1
 * 
 *          Reads in data from a given file, parses it, and then takes the
 *          averages, max's, min's, and then outputs them.
 * 
 *          Talked to Reece Reinke to help with parsing the file.
 */
public class MapData
{
    private Observation[] sradData;
    private Observation[] tairData;
    private Observation[] ta9mData;

    private static int SIZE = 1000;
    private static int NUMBER_OF_MISSING_OBSERVATIONS = 10;

    private Integer numberOfStations = null;

    /**
     * Contains the column positions of the .mdf file.
     */
    private int STID_POSITION = 0;
    private int TAIR_POSITION = 4;
    private int SRAD_POSITION = 13;
    private int TA9M_POSITION = 14;

    // Holds Mesonet in the string
    private String MESONET = "Mesonet";
    // Hold the directory of the data files
    private String directory;

    /**
     * Creates Observation statistic variables which i never used whoops
     */
    private Observation tairMin;
    private Observation tairMax;
    private Observation tairAverage;
    private Observation ta9mMin;
    private Observation ta9mMax;
    private Observation ta9mAverage;
    private Observation sradMin;
    private Observation sradMax;
    private Observation sradAverage;
    private Observation sradTotal;

    /**
     * Integers containing year, month, day, hour, and minute
     */
    private int year;
    private int month;
    private int day;
    private int hour;
    private int minute;

    /**
     * MapData constructor with the parameters of year, month, day, hour, minute,
     * and directory
     * 
     * @param year      holds the double for year
     * @param month     holds the double month
     * @param day       holds the double for day
     * @param hour      holds the double for hour
     * @param minute    holds the double for minute
     * @param directory holds the string for directory
     */
    public MapData(int year, int month, int day, int hour, int minute, String directory)
    {
        this.tairData = new Observation[SIZE];
        this.ta9mData = new Observation[SIZE];
        this.sradData = new Observation[SIZE];
        this.year = year;
        this.month = month;
        this.day = day;
        this.hour = hour;
        this.minute = minute;
        this.directory = directory;
    }

    /**
     * @return the year
     */
    public int getYear()
    {
        return year;
    }

    /**
     * @return the month
     */
    public int getMonth()
    {
        return month;
    }

    /**
     * @return the day
     */
    public int getDay()
    {
        return day;
    }

    /**
     * @return the hour
     */
    public int getHour()
    {
        return hour;
    }

    /**
     * @return the minute
     */
    public int getMinute()
    {
        return minute;
    }

    /**
     * @return the directory
     */
    public String getDirectory()
    {
        return directory;
    }

    /**
     * Method to create the file name string in the format, "yyyyMMddHHmm"
     * 
     * @return the fileName
     */
    public String createFileName()
    {
        String fileName = "";
        String year;
        String month;
        String day;
        String hour;
        String minute;
        String directory = this.directory;

        // If year is less than 10 pad it with 0's
        if (this.year < 10)
        {
            year = String.format("%02d", this.year);
        } else
        {
            year = String.format("%d", this.year);
        }

        // If month is less than 10 pad it with 0's
        if (this.month < 10)
        {
            month = String.format("%02d", this.month);
        } else
        {
            month = String.format("%d", this.month);
        }

        // If day is less than 10 pad it with 0's
        if (this.day < 10)
        {
            day = String.format("%02d", this.day);
        } else
        {
            day = String.format("%d", this.day);
        }

        // If hour is less than 10 pad it with 0's
        if (this.hour < 10)
        {
            hour = String.format("%02d", this.hour);
        } else
        {
            hour = String.format("%d", this.hour);
        }

        // If minute is less than 10 pad it with 0's
        if (this.minute < 10)
        {
            minute = String.format("%02d", this.minute);
        } else
        {
            minute = String.format("%d", this.minute);
        }

        // format filename to the newly padded values
        fileName = String.format("%s/%s%s%s%s%s.mdf", directory, year, month, day, hour, minute);

        return fileName;
    }

    /**
     * Method to take in input from the given file.
     * 
     * @throws IOException does stuff
     */
    public void parseFile() throws IOException
    {
        // Set the fileName string to the returned string from createString
        String fileName = createFileName();

        int i = 0;

        BufferedReader br = new BufferedReader(new FileReader(fileName));
        String line;

        // Get the headers out
        line = br.readLine();
        line = br.readLine();
        line = br.readLine();
        line = br.readLine();

        while (line != null)
        {

            // Split the file by whitespace chars
            String[] info = line.split("\\s+");

            tairData[i] = new Observation(Double.parseDouble(info[TAIR_POSITION + 1]), info[STID_POSITION]);
            ta9mData[i] = new Observation(Double.parseDouble(info[TAIR_POSITION + 1]), info[STID_POSITION]);
            sradData[i] = new Observation(Double.parseDouble(info[TAIR_POSITION + 1]), info[STID_POSITION]);

            i++;
            // Get the next line of the file
            line = br.readLine();

        }
        // Close that bufferedReader
        br.close();

        System.out.println("AHHHHHHHHHHHHHHH")
        // When parseFile is called it takes the data and calculates the statistics.
        calculateAirTemperatureStatistics();
        calculateTa9mTemperatureStatistics();
        calculateSolarRadiationStatistics();
    }

    /**
     * @return the sradAverage
     */
    public Observation getSradAverage()
    {
        return sradAverage;
    }

    /**
     * @return the sradMax
     */
    public Observation getSradMax()
    {
        return sradMax;
    }

    /**
     * @return the sradMin
     */
    public Observation getSradMin()
    {
        return sradMin;
    }

    /**
     * @return the sradTotal
     */
    public Observation getSradTotal()
    {
        return sradTotal;
    }

    /**
     * @return the ta9mAverage
     */
    public Observation getTa9mAverage()
    {
        return ta9mAverage;
    }

    /**
     * @return the ta9mMax
     */
    public Observation getTa9mMax()
    {
        return ta9mMax;
    }

    /**
     * @return the ta9mMin
     */
    public Observation getTa9mMin()
    {
        return ta9mMin;
    }

    /**
     * @return the ta9mAverage
     */
    public Observation getTairAverage()
    {
        return ta9mAverage;
    }

    /**
     * @return the ta9mMax
     */
    public Observation getTairMax()
    {
        return ta9mMax;
    }

    /**
     * @return the ta9mMin
     */
    public Observation getTairMin()
    {
        return ta9mMin;
    }

    /**
     * toString method to format output into the prompt
     */
    public String toString()
    {

        /**
         * Make a bunch of strings to help with formatting that holds values such as;
         * date, maxAir, minAir, averageAir, max9Air, min9Air, average9Air, maxSolarRad,
         * minSolarRad, and averageSolarRad
         */
        String divider = "==========================================================\n";
        String smallDivider = "===";
        String date = String.format(smallDivider + " %02d-%02d-%02d %02d:%02d " + smallDivider + "\n", this.year,
                this.month, this.day, this.hour, this.minute);
        String maxAir = String.format("Maximum Air Temperature[1.5m] = %.1f C at %s", getTairMax().toString());
        String minAir = String.format("Minimum Air Temperature[1.5m] = %.1f C at %s", getTairMin().toString());
        String averageAir = String.format("Average Air Temperature[1.5m] = %.1f C at %s", getTairAverage(), MESONET);
        String max9Air = String.format("Maximum Air Temperature[9.0m] = %.1f C at %s", getTa9mMax().toString());
        String min9Air = String.format("Minimum Air Temperature[9.0m] = %.1f C at %s", getTa9mMin().toString());
        String average9Air = String.format("Average Air Temperature[9.0m] = %.1f C at %s", getTa9mAverage().toString(),
                MESONET);
        String maxSolarRad = String.format("Maximum Solar Radiation[1.5m] = %.1f W/m^2 at %s", getSradMax().toString());
        String minSolarRad = String.format("Minimum Solar Radiation[1.5m] = %.1f W/m^2 at %s", getSradMin().toString());
        String averageSolarRad = String.format("Average Solar Radiation[1.5m] = %.1f W/m^2 at %s",
                getSradAverage().toString(), MESONET);

        // Add all the strings to the dataString to return the formatted string
        String dataString = divider + date + divider + maxAir + "\n" + minAir + "\n" + averageAir + "\n" + divider
                + divider + max9Air + "\n" + min9Air + "\n" + average9Air + "\n" + divider + divider + maxSolarRad
                + "\n" + minSolarRad + "\n" + averageSolarRad + "\n" + divider;

        return dataString;
    }

    /**
     * Method to calculate the air temp.
     */
    private void calculateAirTemperatureStatistics()
    {

        int count = 0;
        double total = Double.NaN;
        double average = Double.NaN;
        double min = Double.POSITIVE_INFINITY;
        double max = Double.NEGATIVE_INFINITY;

        // Loops through tair array adding the valid data and then divides by the number
        // that were valid
        for (int i = 0; i < tairData.length; i++)
        {
            if (tairData[i].isValid())
            {
                count++;
                total += tairData[i].getValue();
            }
            average = total / count;
            tairAverage = new Observation(average, tairData[i].getStid());
        }

        // Loops through array and sets the min if the data is less than the previous
        // index
        for (int i = 0; i < tairData.length; i++)
        {
            if (tairData[i].isValid())
            {
                if (tairData[i].getValue() < min)
                {
                    min = tairData[i].getValue();
                    tairMin = new Observation(min, tairData[i].getStid());
                }
            }
        }

        // Loops through array and sets the max if the data is greater than the previous
        // index
        for (int i = 0; i < tairData.length; i++)
        {
            if (tairData[i].isValid())
            {
                if (tairData[i].getValue() > max)
                {
                    max = tairData[i].getValue();

                    tairMax = new Observation(max, tairData[i].getStid());

                }
            }
        }

    }

    /**
     * Method to calculate the Ta9m temp.
     */
    private void calculateTa9mTemperatureStatistics()
    {


        int count = 0;
        double total = Double.NaN;
        double average = Double.NaN;
        double min = Double.POSITIVE_INFINITY;
        double max = Double.NEGATIVE_INFINITY;

        // Loops through tair array adding the valid data and then divides by the number
        // that were valid
        for (int i = 0; i < ta9mData.length; i++)
        {
            if (ta9mData[i].isValid())
            {
                count++;
                total += ta9mData[i].getValue();
            }
            average = total / count;
            ta9mAverage = new Observation(average, ta9mData[i].getStid());
        }

        // Loops through array and sets the min if the data is less than the previous
        // index
        for (int i = 0; i < ta9mData.length; i++)
        {
            if (ta9mData[i].isValid())
            {
                if (ta9mData[i].getValue() < min)
                {
                    min = tairData[i].getValue();
                    ta9mMin = new Observation(min, ta9mData[i].getStid());
                }
            }
        }

        // Loops through array and sets the max if the data is greater than the previous
        // index
        for (int i = 0; i < ta9mData.length; i++)
        {
            if (ta9mData[i].isValid())
            {
                if (ta9mData[i].getValue() > max)
                {
                    max = ta9mData[i].getValue();

                    ta9mMax = new Observation(max, ta9mData[i].getStid());

                }
            }
        }

    }

    /**
     * Method to calculate the solar radiation
     */
    private void calculateSolarRadiationStatistics()
    {


        int count = 0;
        double total = Double.NaN;
        double average = Double.NaN;
        double min = Double.POSITIVE_INFINITY;
        double max = Double.NEGATIVE_INFINITY;

        // Loops through tair array adding the valid data and then divides by the number
        // that were valid
        for (int i = 0; i < sradData.length; i++)
        {
            if (sradData[i].isValid())
            {
                count++;
                total += sradData[i].getValue();
            }
            average = total / count;
            sradAverage = new Observation(average, sradData[i].getStid());
        }

        // Loops through array and sets the min if the data is less than the previous
        // index
        for (int i = 0; i < sradData.length; i++)
        {
            if (sradData[i].isValid())
            {
                if (sradData[i].getValue() < min)
                {
                    min = tairData[i].getValue();
                    sradMin = new Observation(min, sradData[i].getStid());
                }
            }
        }

        // Loops through array and sets the max if the data is greater than the previous
        // index
        for (int i = 0; i < sradData.length; i++)
        {
            if (sradData[i].isValid())
            {
                if (sradData[i].getValue() > max)
                {
                    max = sradData[i].getValue();

                    sradMax = new Observation(max, tairData[i].getStid());

                }
            }
        }


    }

}