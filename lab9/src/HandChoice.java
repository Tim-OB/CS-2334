import java.util.HashMap;

/**
 * Lab 9
 *
 * An enumeration containing the possible hand choices that a player can make
 * in Rock-Paper-Scissors.
 *
 * @author Stephen, Tim O'Brien
 * @version 2018-10-26
 */
public enum HandChoice
{
    /**
     * The Player chooses Rock.
     */
    ROCK,

    /**
     * The Player chooses Paper.
     */
    PAPER,

    /**
     * The Player chooses Scissors.
     */
    SCISSORS;

    /**
     * Maps a Hand choice to the Hand choice that it wins against.
     * I.e. a key in the strength map wins against the associate value.
     * E.g. you might put the pair ROCK, SCISSORS into the map, because
     * ROCK wins against SCISSORS. ROCK would be the key and SCISSORS would
     * be the associated value.
     */
    private static final HashMap<HandChoice, HandChoice> STRENGTH_MAP;

    /* This is the static initializer, run when the class is first loaded. */
    static
    {
        // TODO: implement this. You should intialize and populate (load entries into) the STRENGTH_MAP.
        STRENGTH_MAP = new HashMap<HandChoice, HandChoice>();
        STRENGTH_MAP.put(ROCK, SCISSORS);
    }

    /**
     * Method that gives the hand choice that this hand choice wins against.
     *
     * @return The HandChoice that this type wins against. e.g. if the enum
     * is type Rock, the result of winsAgainst should be Scissors.
     */
    public HandChoice winsAgainst()
    {
        // TODO: implement this.
        HandChoice a = null;
        
        if (HandChoice.this.equals(ROCK))
        {
            a = HandChoice.SCISSORS;
        }
        if (HandChoice.this.equals(PAPER))
        {
            a = HandChoice.ROCK;
        }
        if (HandChoice.this.equals(SCISSORS))
        {
            a = HandChoice.PAPER;
        }
        
        return a;
    }

    /**
     * Returns the enum's name in lowercase.
     * 
     * @return The name of the enum as a lowercase string.
     */
    @Override
    public String toString()
    {
        // TODO: implement this.
        String name = name().toLowerCase();
        return name;
    }
}
