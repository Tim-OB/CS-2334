import org.dreambot.api.methods.Calculations;
import org.dreambot.api.methods.map.Area;
import org.dreambot.api.methods.map.Tile;
import org.dreambot.api.methods.world.World;
import org.dreambot.api.script.AbstractScript;
import org.dreambot.api.script.Category;
import org.dreambot.api.script.ScriptManifest;
import org.dreambot.api.utilities.Timer;
import org.dreambot.api.wrappers.interactive.NPC;

import java.awt.*;

@ScriptManifest(name = "Simple Rune", author = "Einsteinium", description = "Buys death runes from Aubrey, "
        + "and then sells them.", version = 1.0, category = Category.MONEYMAKING)
public class RuneBuyer extends AbstractScript
{
    private Area runAway = new Area(new Tile(3254, 3420), new Tile(3251, 3420), new Tile(3254, 3422),
            new Tile(3251, 3422), new Tile(3252, 3422), new Tile(3253, 3422), new Tile(3254, 3421),
            new Tile(3251, 3421), new Tile(3252, 3421), new Tile(3253, 3421), new Tile(3253, 3420),
            new Tile(3252, 3420));

    private Area startArea = new Area(new Tile(3252, 3399), new Tile(3253, 3399), new Tile(3255, 3401),
            new Tile(3253, 3404), new Tile(3252, 3402), new Tile(3252, 3403));

    private Area bankArea = new Area(new Tile(3169, 3485), new Tile(3169, 3494), new Tile(3160, 3494),
            new Tile(3160, 3485));

    private Timer t = new Timer();

    private int deathRune = 0;
    private int totalDeathRune = 0;
    private int storePrice = 225;
    private int profit = 0;
    private int profitPerHour = 0;
    private int runesPerHour = 0;

    @Override
    public void onStart()
    {

    }

    @Override
    public int onLoop()
    {

        if (getLocalPlayer().isInCombat())
        {
            getWalking().walk(runAway.getRandomTile());

            sleep(20000);
        } else
        {
            if (getInventory().count("Coins") < 225)
            {
                sell();
                sleep(2500);
            } else
            {

                buy();
            }
        }

        return Calculations.random(300, 600);
    }

    @Override
    public void onExit()
    {

    }

    public void hopWorld()
    {
        World world = getWorlds().getRandomWorld(
                w -> w != null && !w.isPVP() && !w.isHighRisk() && w.isF2P() && w.getMinimumLevel() == 0);

        if (getShop().count("Death rune") == 0)
        {
            getShop().close();
            getWorldHopper().openWorldHopper();
            if (getWorldHopper().isWorldHopperOpen())
            {

                sleep(3000);
                getWorldHopper().hopWorld(world);

            }
        }
    }

    public void sell()
    {
        int price;

        getWalking().walk(bankArea.getRandomTile());

        if (bankArea.contains(getLocalPlayer()))
        {
            totalDeathRune += deathRune;
            getGrandExchange().open();
            sleep(1500);

            getGrandExchange().openSellScreen(1);
            sleep(500);
            getGrandExchange().addSellItem("Death rune");
            sleep(1000);
            price = (int) (getGrandExchange().getCurrentPrice() * (1 - 0.05));
            profit += deathRune * (price - storePrice);
            getGrandExchange().setPrice(price);
            sleep(2000);
            getGrandExchange().getEnterAllButton().interact();
            sleep(450);
            getGrandExchange().confirm();
            sleep(10000);

            if (getGrandExchange().isReadyToCollect())
            {
                sleep(500);
                getGrandExchange().collect();
            }
            getGrandExchange().close();

        }
    }

    public void buy()
    {
        if (startArea.contains(getLocalPlayer()))
        {

            NPC shop = getNpcs().closest("Aubury");

            shop.interact("Trade");
            sleep(2000);

            if (getShop().count("Death rune") != 0)
            {
                getShop().purchaseFifty("Death rune");
                deathRune = getInventory().count("Death rune") + totalDeathRune;
                sleep(1000);
                getShop().close();
                sleep(10000);
            }

            if (getShop().count("Death rune") == 0)
            {
                sleep(7000);
                hopWorld();
                sleep(3000);
            }

        } else
        {
            getWalking().walk(startArea.getRandomTile());
            sleep(3000);
        }

    }

    public void onPaint(Graphics2D g)
    {

        if (getClient().isLoggedIn())
        {

            runesPerHour = (int) (deathRune * 3600000 / t.elapsed());
            profitPerHour = (int) (profit * 3600000 / t.elapsed());

            g.setColor(Color.BLUE);
            g.fillRect(10, 340, 500, 130);

            g.setColor(Color.BLACK);
            g.setFont(new Font("Arial", 1, 15));

            g.drawString("Time Running: " + t.formatTime(), 25, 370);

            g.drawString("Death runes bought : " + deathRune, 25, 390);
            g.drawString("Death runes bought / hr : " + runesPerHour, 25, 410);

            g.drawString("Total profit : " + profit, 25, 430);
            g.drawString("Total profit / hr: " + profitPerHour, 25, 450);

        }

    }
}
