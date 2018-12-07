import java.io.IOException;

/**
 * @author Tim O'Brien, referenced example on Canvas
 * @version 2018-09-10
 * Project 1
 * 
 * Driver class that contains the main method which produces 
 * the output into the prompt
 */
public class Driver
{
    
    /**
     * @param args just for java stuff
     * @throws IOException Does stuff
     */
    public static void main(String[] args) throws IOException
    {
        final int YEAR = 2018;
        final int MONTH = 8;
        final int DAY = 30;
        final int HOUR = 17;
        final int MINUTE = 45;

        final String directory = "data";

        MapData mapData = new MapData(YEAR, MONTH, DAY, HOUR, MINUTE, directory);

        mapData.parseFile();

        System.out.println(mapData);

    }

}
