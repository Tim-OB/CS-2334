import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Class that represents a Team of Football Players. Stores a list of all the
 * Players on the Team and computes some statistics about the Team.
 * 
 * @author Stephen
 * @version 2018-09-10
 */
public class Team
{
    /**
     * The list of Players on the Team.
     * 
     * Note: because this variable has the "protected" access modifier, you may
     * directly access this variable in unit tests.
     */
    protected ArrayList<Player> players = new ArrayList<Player>();

    /**
     * Constructor, takes in a csv file of Players and stores them in a list.
     * 
     * @param filename The name of the csv file containing a list of Players, one
     *                 Player on each line. Assumes that the csv file is at the top
     *                 level of the project (not within any folders; at the same
     *                 level as src and TODO.json).
     */
    public Team(String filename)
    {
        // Attempt to read a csv file, catch an error if something goes wrong:
        try
        {
            read(filename);
        } catch (IOException e)
        {
            System.out.println("Error reading from file!\n");
            e.printStackTrace();
        }
    }

    /**
     * Loads a list of players from a CSV file. Each line of the csv represents a
     * single Player. The first line of the csv denotes the order of the fields, you
     * should not construct a player from the first line.
     * 
     * @param filename The file to read from.
     * @throws IOException
     */
    public void read(String filename) throws IOException
    {
        BufferedReader br = new BufferedReader(new FileReader(filename));
        String strg;

        // Throw out header
        strg = br.readLine();
        // First row containing data
        strg = br.readLine();
        // Loop over the lines in the file
        while (strg != null)
        {
            players.add(new Player(strg));
            strg = br.readLine();
        }
        br.close();
    }

    /**
     * Writes out information about the Players in the Team. Specifically, loop
     * through the list of players and add each toString to the output (adding each
     * new toString to the end of the previous, without any additional formatting).
     * 
     * @param filename the file to write out to (should be a .txt file). Assumes
     *                 that the file is at the top level of the project (not within
     *                 any folders; at the same level as src and TODO.json).
     * @throws IOException
     */
    public void writePlayers(String filename) throws IOException
    {
        // Set up the writer and string to output:
        BufferedWriter bw = new BufferedWriter(new FileWriter(filename));
        String out = "";

        // Build the output string:
        for (int i = 0; i < players.size(); i++)
        {
            out += players.get(i).toString();
        }

        // Write out the output string and close:
        bw.write(out);
        bw.close();
    }

    /**
     * Writes out information about a subset of Players in the Team. Only writes out
     * information about players from a given home state. Specifically, loop through
     * the list of players and add each toString to the output (adding each new
     * toString to the end of the previous, without any additional formatting).
     * 
     * @param filename  the file to write out to (should be a .txt file). Assumes
     *                  that the file is at the top level of the project (not within
     *                  any folders; at the same level as src and TODO.json).
     * @param homeState Players with a home state matching this input will have
     *                  their information written out to the file.
     * @throws IOException
     */
    public void writePlayers(String filename, String homeState) throws IOException
    {
        // Set up the writer and string to output:
        BufferedWriter bw = new BufferedWriter(new FileWriter(filename));
        String out = "";

        ArrayList<Player> subset = playersFromState(homeState);
        // Build the output string:
        for (int i = 0; i < subset.size(); i++)
        {
            out += subset.get(i).toString();
        }

        // Write out the output string and close:
        bw.write(out);
        bw.close();
    }

    /**
     * Formats and writes out information about the statistics of a Team.
     * Specifically, write out information in the following format:
     * 
     * "Total Height: (result of computeTotalHeight())\nLightest Player: (name of
     * Player returned by lightestPlayer()\n)"
     * 
     * @param filename the file to write out to (should be a .txt file). Assumes
     *                 that the file is at the top level of the project (not within
     *                 any folders; at the same level as src and TODO.json).
     * @throws IOException
     */
    public void writeStatistics(String filename) throws IOException
    {
        // Set up the writer and string to output:
        BufferedWriter bw = new BufferedWriter(new FileWriter(filename));
        String out = "";

        // Build the output string:
        out += "Total Height: " + computeTotalHeight() + "\n";
        out += "Lightest Player: " + lightestPlayer().getName() + "\n";

        // Write out the output string and close:
        bw.write(out);
        bw.close();
    }

    /**
     * Gives the total height of the Team.
     * 
     * @return Sum of the heights of the Players in the Team.
     */
    public double computeTotalHeight()
    {
        double height = 0;
        for (int i = 0; i < players.size(); i++)
        {
            height += players.get(i).getHeight();
        }
        return height;
    }

    /**
     * Calculates the subset of players which are from a given state.
     * 
     * @param state Players with a home state matching this input String "state"
     *              should be aggregated and returned.
     * @return An arraylist containing all players whose homeState is equal to the
     *         input variable "state".
     */
    public ArrayList<Player> playersFromState(String state)
    {
        ArrayList<Player> playersFromState = new ArrayList<Player>();
        for (int i = 0; i < players.size(); i++)
        {
            if (players.get(i).getHomeState().equals(state))
            {
                playersFromState.add(players.get(i));
            }
        }
        return playersFromState;
    }

    /**
     * Determines if any players are from a city with a given name (ignores the
     * states).
     * 
     * @param cityName the name to compare Player's cities to.
     * @return True if there is a player from a city with a name matching the input
     *         variable "cityName", else false.
     */
    public boolean anyPlayersFromCityName(String cityName)
    {
        for (int i = 0; i < players.size(); i++)
        {
            if (players.get(i).getHomeCity().equals(cityName))
            {
                return true;
            }
        }
        return false;
    }

    /**
     * Finds the lightest Player (lowest weight variable).
     * 
     * @return A Player object that has the lowest weight variable out of all
     *         Players recorded. If there are no players on the team, return null.
     */
    public Player lightestPlayer()
    {
        // Set arbitrarily high:
        int lowestWeight = Integer.MAX_VALUE;

        Player lightestPlayer = null;
        for (int i = 0; i < players.size(); i++)
        {
            int weight = players.get(i).getWeight();
            if (lowestWeight > weight)
            {
                // Update what the lowest weight is and which player has that weight:
                lowestWeight = weight;
                lightestPlayer = players.get(i);
            }
        }
        return lightestPlayer;
    }
}
