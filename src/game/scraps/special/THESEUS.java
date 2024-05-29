package game.scraps.special;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.Location;
import game.actions.TeleportAction;
import game.types.Buyable;
import game.utils.BuyUtils;
import game.utils.RandomUtils;

public class THESEUS extends Item implements Buyable {
    private static final int WORTH_IN_CREDITS = 100;

    /**
     * Constructs a new THESEUS instance.
     */
    public THESEUS() {
        super("THESEUS", '^', true);
    }

    /**
     * Returns the list of actions that can be performed with this item while on the ground.
     *
     * @param location The location where the item sits.
     * @return The list of allowable actions for this item while on the ground.
     */
    @Override
    public ActionList allowableActions(Location location) {
        int xVal = RandomUtils.getRandomInt(location.map().getXRange().max());
        int yVal = RandomUtils.getRandomInt(location.map().getYRange().max());

        ActionList actionList = new ActionList();
        actionList.add(new TeleportAction("current map",location.map().at(xVal,yVal)));
        return actionList;
    }

    /**
     * Attempts to buy this THESEUS for the given actor.
     *
     * @param actor The actor attempting to buy the THESEUS.
     * @return A message indicating the result of the purchase attempt.
     */
    @Override
    public String buy(Actor actor) {
        return BuyUtils.buyItem(actor, this, WORTH_IN_CREDITS);
    }

    /**
     * Returns the cost of this item in credits.
     *
     * @return The cost of this item in credits.
     */
    @Override
    public int getBuyCost() {
        return WORTH_IN_CREDITS;
    }
}