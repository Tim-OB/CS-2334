/**
 * Lab 9
 *
 * ContestantInfo takes in a region and a choice, provides getters for these
 * variables as well
 *
 * @author Stephen, Tim O'Brien
 * @version 2018-10-26
 */
public class ContestantInfo
{
    private Region region;
    private HandChoice choice;

    public ContestantInfo(Region region, HandChoice choice)
    {
        this.region = region;
        this.choice = choice;
    }

    public Region getRegion()
    {
        return region;
    }

    public HandChoice getChoice()
    {
        return choice;
    }

    public String toString()
    {
        String a = String.format("contestant from %s throwing %s", getRegion(), getChoice());
        return a;
    }
}
