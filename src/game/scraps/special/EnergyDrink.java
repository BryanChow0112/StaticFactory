package game.scraps.special;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import game.actions.ConsumeAction;
import game.types.Buyable;
import game.types.Consumable;
import game.utils.BuyUtils;
import game.utils.RandomUtils;

/**
 * An energy drink item that can be purchased and consumed by an actor.
 * Consuming the energy drink restores a small amount of hit points.
 * This item implements the Buyable and Consumable interfaces.
 */
public class EnergyDrink extends Item implements Buyable, Consumable {
    private static final int CREDITS_TO_BUY = 10;
    private static final int HIT_POINTS = 1;
    private static final int DOUBLE_COST_CHANCE = 20;

    /**
     * Constructs a new EnergyDrink instance.
     */
    public EnergyDrink() {
        super("Energy Drink", '*', true);
    }

    /**
     * Attempts to buy this energy drink for the given actor.
     * There is a 20% chance that the actor will be prompted to pay double the cost.
     *
     * @param actor The actor attempting to buy the energy drink.
     * @return A message indicating the result of the purchase attempt.
     */
    @Override
    public String buy(Actor actor) {
        if (RandomUtils.getRandomInt(100) <= DOUBLE_COST_CHANCE) {
            int doubleCost = CREDITS_TO_BUY * 2;
            return BuyUtils.buyItem(actor, this, doubleCost);
        } else {
            return BuyUtils.buyItem(actor, this, CREDITS_TO_BUY);
        }
    }

    /**
     * Returns the list of allowable actions for the owner of this energy drink.
     *
     * @param owner The actor that owns this energy drink.
     * @return The list of allowable actions for the owner.
     */
    @Override
    public ActionList allowableActions(Actor owner) {
        ActionList actionList = new ActionList();
        actionList.add(new ConsumeAction(this));
        return actionList;
    }

    /**
     * Returns the cost of this energy drink in credits.
     *
     * @return The cost of this energy drink in credits.
     */
    @Override
    public int getBuyCost() {
        return CREDITS_TO_BUY;
    }

    /**
     * Handles the consumption of this energy drink by the given actor.
     * Consuming the energy drink restores a small amount of hit points.
     *
     * @param actor The actor consuming the energy drink.
     * @return A message indicating the result of consuming the energy drink.
     */
    @Override
    public String handleConsume(Actor actor) {
        actor.removeItemFromInventory(this);
        actor.heal(HIT_POINTS);
        return actor + " gains " + HIT_POINTS + " HP from consuming the " + this;
    }
}