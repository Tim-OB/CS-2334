import java.util.LinkedHashMap;
import java.util.Set;

/**
 * Lab 9
 *
 * Class that simulates a battle arena for a Rock-Paper-Scissors tournament. The
 * user can print out information about all the Contestants, or can pit two
 * Contestants against each other to see who would win. Victories are determined
 * by what hand choices the Contestants have.
 *
 * @author Stephen, Tim O'Brien
 * @version 2018-10-26
 */
public class RPSArena
{
    /**
     * Maps short strings (abbreviations) to members of the Contestant enumeration.
     * We use LinkedHashMap to preserve ordering of inputs, which HashMap does not
     * do by default. In most other ways, however, this Map works pretty much the
     * same as a normal HashMap.
     */
    private LinkedHashMap<String, Contestant> contestantMap;

    /**
     * Constructor: Creates a predetermined set of Contestants. We choose to create
     * one Contestant for each entry in the Contestant enum. The abbreviations
     * should be: -"GEO": george -"JIL": jill -"RAT": ratthew -"BET": betty
     */
    public RPSArena()
    {
        // TODO: implement this.
        // Initialize the Contestant HashMap:
        contestantMap = new LinkedHashMap<String, Contestant>();

        // Populate the Contestant HashMap:
        contestantMap.put("GEO", Contestant.GEORGE);
        contestantMap.put("JIL", Contestant.JILL);
        contestantMap.put("RAT", Contestant.RATTHEW);
        contestantMap.put("BET", Contestant.BETTY);

    }

    /**
     * Attempt to get a hero from contestantMap by using the abbreviated Contestant
     * name.
     * 
     * @param key The abbreviation for the Contestant in the contestantMap.
     * @return The Contestant affiliated with the abbreviated name if the key exists
     *         in the contestantMap. Null otherwise.
     */
    public Contestant getContestant(String key)
    {
        // TODO: implement this.
        return contestantMap.get(key);
    }

    /**
     * Gets the abbreviated names of the Contestant.
     * 
     * It may be helpful to look at the java documentation for LinkedHashMaps here:
     * https://docs.oracle.com/javase/8/docs/api/java/util/LinkedHashMap.html
     * 
     * @return the abbreviations for the Contestants (keyset of contestantMap).
     */
    public Set<String> getContestantAbbreivations()
    {
        // TODO: implement this.
        Set<String> abrv = contestantMap.keySet();
        return abrv;
    }

    /**
     * Print out a Contestant's three-letter abbreviation and the Contestant's
     * description for all contestants that have the same hand choice as the choice
     * specified.
     * 
     * If you are having issues looping over a map:
     * https://www.geeksforgeeks.org/iterate-map-java/
     * 
     * @param choice The hand choice for which we want to print out Contestants
     *               choosing the same hand choice.
     * @return The list of select Contestants as a string. Order is consistent
     *         across calls. Format is: "Abbreviation - Contestant Description",
     *         using a new line after each entry. If no contestants have the given
     *         hand choice, an empty string is returned.
     */
    public String listContestantsWithHandChoice(HandChoice choice)
    {
        String ret = "";

        // TODO: implement this
        for (String a : contestantMap.keySet())
        {
            Contestant cont = contestantMap.get(a);
            if (cont.getChoice() == choice)
            {
                ret += String.format("%s - %s\n", a, contestantMap.get(a).toString());
            }
        }

        return ret;
    }

    /**
     * Battles two Contestants against each other. A victor is determined by Hand
     * Choice. Specifically, if ContestantA's hand choice wins against ContestantB's
     * hand choice, HeroA will win the battle. If the hand choices are the same
     * type, the battle will end in a tie.
     * 
     * We can assert that if choice A wins choice B, then choice B loses choice type
     * A. We can assert that choice A and choice B cannot be defeat each other.
     * 
     * @param contestantA The first Contestant in the battle.
     * @param contestantB The second Contestant in the battle.
     * @return The Contestant that wins the battle, null if the Contestants tie.
     */
    public static Contestant battleContestants(Contestant contestantA, Contestant contestantB)
    {
        // TODO: implement this.
        Contestant ret = null;

        // Get the Contestant choices:
        HandChoice choiceA = contestantA.getChoice();
        HandChoice choiceB = contestantB.getChoice();

        // Check to see if ContestantA's choice type wins against ContestantB's:
        if (choiceA.winsAgainst() == choiceB)
        {
            ret = contestantA;
        }

        // Check to see if ContestantB's choice type wins against ContestantA's:
        if (choiceB.winsAgainst() == choiceA)
        {
            ret = contestantB;
        }

        // Tie otherwise (includes choices that are the same):
        if (choiceA.equals(choiceB))
        {
            ret = null;
        }

        return ret;
    }
}
