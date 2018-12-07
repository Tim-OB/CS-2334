import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.util.LinkedHashMap;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Lab 9
 *
 * Test suite for the RPSArena class.
 *
 * @author Stephen, Tim O'Brien
 * @version 2018-10-26
 *
 */
public class RPSArenaTest {

    /**
     * The RPSArena instance to test.
     */
    private static RPSArena arena;

    /**
     * Creates a RPSArena instance for testing.
     */
    @BeforeClass
    public static void initialize()
    {
        arena = new RPSArena();
    }
    
    /**
     * Tests the constructor and the contestant lists
     */
    @Test
    public void testContestantList() {
        String expectedRock = "GEO - george: contestant from north throwing rock\n" +
                "JIL - jill: contestant from south throwing rock\n";
        String expectedPaper = "BET - betty: contestant from west throwing paper\n";
        String expectedScissors = "RAT - ratthew: contestant from east throwing scissors\n";
        Assert.assertEquals( expectedRock,
                arena.listContestantsWithHandChoice(HandChoice.ROCK));
        Assert.assertEquals("Contestant Map was not created properly.", expectedPaper,
                arena.listContestantsWithHandChoice(HandChoice.PAPER));
        Assert.assertEquals("Contestant Map was not created properly.", expectedScissors,
                arena.listContestantsWithHandChoice(HandChoice.SCISSORS));
    }

    /**
     * Tests getting the abbreviations.
     */
    @Test
    public void testContestantAbbreviations() {
        String expected = "[GEO, JIL, RAT, BET]";
        Assert.assertEquals("Contestant Map Keys were not created properly.", expected,
                arena.getContestantAbbreivations().toString());
    }
    
    // TODO: finish tests:
    
    /**
     * Tests getting the contestants that exist in the map.
     */
    @Test
    public void getContestants()
    {
        LinkedHashMap<String, Contestant> contestantMap = new LinkedHashMap<String, Contestant>();

        // Populate the Contestant HashMap:
        contestantMap.put("GEO", Contestant.GEORGE);
        contestantMap.put("JIL", Contestant.JILL);
        contestantMap.put("RAT", Contestant.RATTHEW);
        contestantMap.put("BET", Contestant.BETTY);
        
        Contestant b = arena.getContestant("GEO");
        
        assertEquals(b, Contestant.GEORGE);
    }
    
    
    /**
     * Tests getting a contestant that does not exist in the map.
     */
    @Test
    public void getNonExistentContestants()
    {
        LinkedHashMap<String, Contestant> contestantMap = new LinkedHashMap<String, Contestant>();

        // Populate the Contestant HashMap:
        contestantMap.put("GEO", Contestant.GEORGE);
        contestantMap.put("JIL", Contestant.JILL);
        contestantMap.put("RAT", Contestant.RATTHEW);
        contestantMap.put("BET", Contestant.BETTY);
        
        Contestant b = arena.getContestant("NOPE");
        
        assertNotEquals(b, Contestant.GEORGE);
    }
    
    /**
     * Tests a contestant battle ending in a tie.
     */
    @Test
    public void testTieBattleContestants()
    {
        LinkedHashMap<String, Contestant> contestantMap = new LinkedHashMap<String, Contestant>();

        // Populate the Contestant HashMap:
        contestantMap.put("GEO", Contestant.GEORGE);
        contestantMap.put("JIL", Contestant.JILL);
        contestantMap.put("RAT", Contestant.RATTHEW);
        contestantMap.put("BET", Contestant.BETTY);
        
        Contestant a = arena.getContestant("GEO");
        Contestant b = arena.getContestant("JIL");
        
        Contestant winner = RPSArena.battleContestants(a, b);
        
        assertEquals(winner, null);
    }
    
    
    /**
     * Tests a contestant battle ending in contestantA winning.
     */
    @Test
    public void testBattleContestantA()
    {
        LinkedHashMap<String, Contestant> contestantMap = new LinkedHashMap<String, Contestant>();

        // Populate the Contestant HashMap:
        contestantMap.put("GEO", Contestant.GEORGE);
        contestantMap.put("JIL", Contestant.JILL);
        contestantMap.put("RAT", Contestant.RATTHEW);
        contestantMap.put("BET", Contestant.BETTY);
        
        Contestant a = arena.getContestant("GEO");
        Contestant b = arena.getContestant("RAT");
        
        Contestant winner = RPSArena.battleContestants(a, b);
        
        assertEquals(winner, a);
    }
    
    /**
     * Tests a contestant battle ending in contestantB winning.
     */
    @Test
    public void testBattleContestantsB()
    {
        LinkedHashMap<String, Contestant> contestantMap = new LinkedHashMap<String, Contestant>();

        // Populate the Contestant HashMap:
        contestantMap.put("GEO", Contestant.GEORGE);
        contestantMap.put("JIL", Contestant.JILL);
        contestantMap.put("RAT", Contestant.RATTHEW);
        contestantMap.put("BET", Contestant.BETTY);
        
        Contestant a = arena.getContestant("GEO");
        Contestant b = arena.getContestant("BET");
        
        Contestant winner = RPSArena.battleContestants(a, b);
        
        assertEquals(winner, b);
    }
}
