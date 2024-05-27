package game.scraps.special;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.Location;
import game.actions.ConsumeAction;
import game.actions.SellAction;
import game.types.Ability;
import game.types.Consumable;
import game.types.Sellable;
import game.utils.RandomUtils;

public class PotOfGold extends Item implements Consumable, Sellable {
    private static final int CREDITS_TO_BUY = 10;
    private static final int CREDITS_TO_SELL = 500;

    /**
     * Constructs a new PotOfGold object.
     */
    public PotOfGold() {
        super("Pot of Gold", '$', true);
    }

    /**
     * Returns the list of actions that can be performed with this item.
     *
     * @param owner The actor that owns this item.
     * @return The list of allowable actions for this item.
     */
    @Override
    public ActionList allowableActions(Actor owner) {
        ActionList actionList = new ActionList();
        actionList.add(new ConsumeAction(this));
        return actionList;
    }

    @Override
    public ActionList allowableActions(Actor otherActor, Location location) {
        ActionList actionList = new ActionList();
        if (otherActor.hasCapability(Ability.PURCHASE_ITEMS)) {
            actionList.add(new SellAction(otherActor, this));
        }
        return actionList;
    }

    /**
     * Handles the consumption of this item by the actor.
     *
     * @param actor The actor consuming this item.
     * @return A description of the consumption effect.
     */
    @Override
    public String handleConsume(Actor actor) {
        actor.addBalance(CREDITS_TO_BUY);
        actor.removeItemFromInventory(this);
        return actor + " has increased credits by " + CREDITS_TO_BUY + " credits.";
    }

    @Override
    public String sell(Actor actorSelling, Actor actorToSellTo) {
        // If the intern attempts to sell this item, there is a 25% chance
        // that the factory will take the item directly from the intern
        // without paying anything.
        int finalCost = CREDITS_TO_SELL;
        actorSelling.removeItemFromInventory(this);
        actorToSellTo.addItemToInventory(this);
        if (RandomUtils.getRandomInt(100) <= 75) {
            actorSelling.addBalance(finalCost);
        }
        return this + " was sold to " + actorToSellTo + " for " + finalCost + " credits.";
    }

    @Override
    public int getSellCost() {
        return CREDITS_TO_SELL;
    }
}
