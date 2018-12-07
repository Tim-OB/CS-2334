import org.junit.Assert;
import org.junit.Test;

/**
 * Lab 9
 *
 * Test suite for the Contestant enum.
 *
 * @author Stephen, Tim O'Brien
 * @version 2018-10-26
 *
 */
public class ContestantTest
{
    /**
     * Tests that George's region is the expected value.
     */
    @Test
    public void contestantGeorgeGetSpeciesTest()
    {
        Assert.assertEquals(Region.NORTH, Contestant.GEORGE.getRegion());
    }
    
    /**
     * Tests that Jill's region is the expected value.
     */
    @Test
    public void contestantJillGetSpeciesTest()
    {
        Assert.assertEquals(Region.SOUTH, Contestant.JILL.getRegion());
    }

    /**
     * Tests that Ratthew's region is the expected value.
     */
    @Test
    public void contestantRatthewGetSpeciesTest()
    {
        Assert.assertEquals(Region.EAST, Contestant.RATTHEW.getRegion());
    }

    /**
     * Tests that Betty's region is the expected value.
     */
    @Test
    public void contestantBettyGetSpeciesTest()
    {
        Assert.assertEquals(Region.WEST, Contestant.BETTY.getRegion());
    }

    /**
     * Tests that George's hand choice is the expected value.
     */
    @Test
    public void contestantGeorgeGetSuperpowerTest()
    {
        Assert.assertEquals(HandChoice.ROCK,
            Contestant.GEORGE.getChoice());
    }
    
    /**
     * Tests that Jill's hand choice is the expected value.
     */
    @Test
    public void contestantJillGetSuperpowerTest()
    {
        Assert.assertEquals(HandChoice.ROCK,
            Contestant.JILL.getChoice());
    }

    /**
     * Tests that Ratthew's hand choice is the expected value.
     */
    @Test
    public void contestantRatthewGetSuperpowerTest()
    {
        Assert.assertEquals(HandChoice.SCISSORS,
            Contestant.RATTHEW.getChoice());
    }

    /**
     * Tests that Betty's hand choice is the expected value.
     */
    @Test
    public void contestantBettyGetSuperpowerTest()
    {
        Assert.assertEquals(HandChoice.PAPER,
            Contestant.BETTY.getChoice());
    }

    /**
     * Tests that Supercontestant.toString() returns the expected value.
     */
    @Test
    public void contestantToStringTest()
    {
        Assert.assertEquals("george: contestant from north throwing rock",
            Contestant.GEORGE.toString());
        Assert.assertEquals("jill: contestant from south throwing rock",
            Contestant.JILL.toString());
        Assert.assertEquals("ratthew: contestant from east throwing scissors",
            Contestant.RATTHEW.toString());
        Assert.assertEquals("betty: contestant from west throwing paper",
            Contestant.BETTY.toString());
    }
}
