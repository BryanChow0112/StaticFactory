package game.scraps.special;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.actors.attributes.BaseActorAttributes;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.Location;
import game.actions.SellAction;
import game.types.Ability;
import game.types.Buyable;
import game.types.Sellable;
import game.utils.BuyUtils;
import game.utils.RandomUtils;

/**
 * A toilet paper roll item that can be purchased by an actor.
 * There is a chance of receiving a discount when attempting to buy this item.
 * This class implements the Buyable interface.
 */
public class ToiletPaperRoll extends Item implements Buyable, Sellable {
    private static final int CREDITS_TO_BUY = 5;
    private static final int CREDITS_TO_SELL = 1;
    private static final int DISCOUNT_CHANCE = 75;
    private static final int DISCOUNTED_CREDITS_TO_BUY = 1;

    /**
     * Constructs a new ToiletPaperRoll instance.
     */
    public ToiletPaperRoll() {
        super("Toilet Paper Roll", 's', true);
    }

    /**
     * Attempts to buy this toilet paper roll for the given actor.
     * There is a 75% chance of receiving a discount on the purchase.
     *
     * @param actor The actor attempting to buy the toilet paper roll.
     * @return A message indicating the result of the purchase attempt.
     */
    @Override
    public String buy(Actor actor) {
        if (RandomUtils.getRandomInt(100) <= DISCOUNT_CHANCE) {
            return BuyUtils.buyItem(actor, this, DISCOUNTED_CREDITS_TO_BUY);
        } else {
            return BuyUtils.buyItem(actor, this, CREDITS_TO_BUY);
        }
    }

    /**
     * Returns the cost of this toilet paper roll in credits.
     *
     * @return The cost of this toilet paper roll in credits.
     */
    @Override
    public int getBuyCost() {
        return CREDITS_TO_BUY;
    }

    @Override
    public String sell(Actor actorSelling, Actor actorToSellTo) {
        // If the intern attempts to sell the toilet paper roll,
        // there is a 50% chance that the intern will be killed
        // instantly by the humanoid figure.
        if (RandomUtils.getRandomInt(100) <= 50) {
            actorSelling.hurt(actorSelling.getAttribute(BaseActorAttributes.HEALTH));
            return "While " + this + " was being sold " + actorToSellTo + " decided to kill " + actorSelling;
        }
        actorSelling.removeItemFromInventory(this);
        actorToSellTo.addItemToInventory(this);
        actorSelling.addBalance(CREDITS_TO_SELL);
        return this + " was sold to " + actorToSellTo + " for " + CREDITS_TO_SELL + " credits.";
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