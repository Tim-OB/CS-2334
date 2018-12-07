/**
 * A football player. The system keeps track of their name, homeCity/State,
 * height, and weight.
 * 
 * @author Stephen
 * @version 2018-09-10
 */
public class Player
{
    /**
     * The name of the player.
     */
    private String name;

    /**
     * The city the player is from.
     */
    private String homeCity;

    /**
     * The state the player is from.
     */
    private String homeState;

    /**
     * The height of the player in feet.
     */
    private double height;

    /**
     * The weight of the player in pounds.
     */
    private int weight;

    /**
     * Constructor for Player. Takes in information on the Player as a comma
     * delimited string, stores info on name, height, weight, homeCity and
     * homeState. Note that homeCity and homeState are not separated by a comma in
     * the input string, but by a forward slash.
     * 
     * @param strg Information about the Player in the format:
     *             "name,height,weight,home", where home is formatted as
     *             "homeCity/homeState"
     */
    public Player(String strg)
    {
        String[] tokens = strg.split(",");

        this.name = tokens[0];
        this.height = Double.parseDouble(tokens[1]);
        this.weight = Integer.parseInt(tokens[2]);
        String[] homeParts = tokens[3].split("/");
        this.homeCity = homeParts[0];
        this.homeState = homeParts[1];
    }

    /**
     * toString override. Gives all information about the Player.
     * 
     * @return All information about the Player formatted as (replacing parentheses
     *         with member variables): "Name: (name), Height: (height, to 2 decimal
     *         places) ft, Weight: (weight) lbs, Home City: (homeCity), Home State:
     *         (homeState)\n" e.g. "Name: Kyler Murray, Height: 5.83 ft, Weight: 195
     *         lbs, Home City: Allen, Home State: Texas\n"
     */
    @Override
    public String toString()
    {
        return String.format("Name: %s, Height: %.2f ft, Weight: %s lbs, Home City: %s, Home State: %s\n", name, height,
                weight, homeCity, homeState);
    }

    /**
     * Return the name of the Player.
     * 
     * @return String name of this Player.
     */
    public String getName()
    {
        return name;
    }

    /**
     * Return the height of the Player.
     * 
     * @return double height of this Player.
     */
    public double getHeight()
    {
        return height;
    }

    /**
     * Return the weight of the Player.
     * 
     * @return int weight of this Player.
     */
    public int getWeight()
    {
        return weight;
    }

    /**
     * Return the city that the Player is from.
     * 
     * @return String city that the Player is from.
     */
    public String getHomeCity()
    {
        return homeCity;
    }

    /**
     * Return the state that the Player is from.
     * 
     * @return String state that the Player is from.
     */
    public String getHomeState()
    {
        return homeState;
    }
}
