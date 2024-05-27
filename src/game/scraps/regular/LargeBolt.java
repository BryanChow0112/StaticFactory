package game.scraps.regular;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.Location;
import game.actions.SellAction;
import game.types.Ability;
import game.types.Sellable;

/**
 * A concrete implementation of the Item class representing a large bolt item.
 */
public class LargeBolt extends Item implements Sellable {
    private static final int CREDITS_TO_SELL = 25;

    /**
     * Constructs a new LargeBolt object.
     * The large bolt is represented by the '+' character and is portable.
     */
    public LargeBolt() {
        super("Large Bolt", '+', true);
    }

    @Override
    public String sell(Actor actorSelling, Actor actorToSellTo) {
        return null;
    }

    @Override
    public int getSellCost() {
        return CREDITS_TO_SELL;
    }

    @Override
    public ActionList allowableActions(Actor otherActor, Location location) {
        ActionList actionList = new ActionList();
        if (otherActor.hasCapability(Ability.PURCHASE_ITEMS)) {
            actionList.add(new SellAction(otherActor, this));
        }
        return actionList;
    }
}
