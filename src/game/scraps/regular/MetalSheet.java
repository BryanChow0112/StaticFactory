package game.scraps.regular;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import game.actions.SellAction;
import game.types.Ability;
import game.types.Sellable;
import game.utils.RandomUtils;
import game.utils.SellUtils;

/**
 * A concrete implementation of the Item class representing a metal sheet item.
 */
public class MetalSheet extends Item implements Sellable {
    private static final int CREDITS_TO_SELL = 20;
    private static final int DISCOUNTED_CREDITS_TO_SELL = 10;

    /**
     * Constructs a new MetalSheet object.
     * The metal sheet is represented by the '%' character and is portable.
     */
    public MetalSheet() {
        super("Metal Sheet", '%', true);
    }

    @Override
    public String sell(Actor actorSelling, Actor actorToSellTo, GameMap map) {
        // When the intern attempts to sell a metal sheet, there is a 60% chance
        // that the factory will ask for a discount, only paying the intern 10 credits.
        if (RandomUtils.getRandomInt(100) <= 60) {
            return SellUtils.sellItem(actorSelling, actorToSellTo, this, DISCOUNTED_CREDITS_TO_SELL);
        }
        return SellUtils.sellItem(actorSelling, actorToSellTo, this, CREDITS_TO_SELL);
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
