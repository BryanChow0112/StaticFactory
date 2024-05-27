package game.scraps.regular;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.Location;
import game.actions.SellAction;
import game.types.Ability;
import game.types.Sellable;

/**
 * A concrete implementation of the Item class representing a metal sheet item.
 */
public class MetalSheet extends Item implements Sellable {
    private static final int CREDITS_TO_SELL = 20;

    /**
     * Constructs a new MetalSheet object.
     * The metal sheet is represented by the '%' character and is portable.
     */
    public MetalSheet() {
        super("Metal Sheet", '%', true);
    }

    @Override
    public String sell(Actor actorSelling, Actor actorToSellTo) {
        // When the intern attempts to sell a metal sheet, there is a 60% chance
        // that the factory will ask for a discount, only paying the intern 10 credits.
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
