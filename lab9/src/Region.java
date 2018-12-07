/**
 * Lab 9
 *
 *Region enum, contains north, south, east, and west.
 *
 * @author Stephen, Tim O'Brien
 * @version 2018-10-26
 */
public enum Region
{
    NORTH, SOUTH, EAST, WEST;

    public String toString()
    {
        String a = name().toLowerCase();
        return a;
    }

}