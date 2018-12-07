import java.io.IOException;

/**
 * Driver class that tests provided code. Unittests should provide full code
 * coverage, but you may edit the driver to better understand how the code
 * works.
 * 
 * @author Stephen
 * @version 2018-09-10
 */
public class Driver
{
    public static void main(String[] args) throws IOException
    {
        /*
         * You don't have to change any of this particular code however you may find it
         * useful to play around with how the code works here.
         */
        Animal a = new Animal("Cheetah", "Chester", 350.0, 40);
        Animal b = new Animal("Tiger", "Tony", 200.5, 15);

        // Create a zoo and add animals to it:
        Zoo zoo = new Zoo();
        zoo.addAnimal(a); // Gorilla
        zoo.addAnimal(b); // Tiger

        // Print out info about the zoo:
        System.out.println(zoo);

        Team team = new Team("Input.csv");

        team.writePlayers("TeamInfo.txt");
        team.writeStatistics("TeamStats.txt");
    }
}