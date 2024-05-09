package game.scraps.special;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.actions.AttackAction;
import game.types.Buyable;
import game.types.Status;
import game.utils.BuyUtils;
import game.utils.RandomUtils;

/**
 * A special weapon item called "Dragon Slayer Sword" that can be used to attack hostile actors.
 * This item also implements the Buyable interface, allowing actors to purchase it.
 */
public class DragonSlayerSword extends WeaponItem implements Buyable {
    private static final int WORTH_IN_CREDITS = 100;

    /**
     * Constructs a new DragonSlayerSword instance.
     */
    public DragonSlayerSword() {
        super("Dragon Slayer Sword", 'x', 50, "slices", 75);
    }

    /**
     * Returns a list of allowable actions that the item allows its owner to perform on other actors.
     *
     * @param otherActor the other actor
     * @param location   the location of the other actor
     * @return an unmodifiable list of Actions
     */
    @Override
    public ActionList allowableActions(Actor otherActor, Location location) {
        ActionList actions = new ActionList();
        String locationString = "(" + location.x() + ", " + location.y() + ")";
        if (otherActor.hasCapability(Status.HOSTILE_TO_PLAYER)) {
            // Allow attacking for other actor (Enemy) using DragonSlayerSword as weapon
            actions.add(new AttackAction(otherActor, locationString, this));
        }
        return actions;
    }

    /**
     * Attempts to buy this item for the given actor.
     * There is a 50% chance of successfully purchasing the item, and a 50% chance of having the credits deducted without receiving the item.
     *
     * @param actor The actor attempting to buy this item.
     * @return A message indicating the result of the purchase attempt.
     */
    @Override
    public String buy(Actor actor) {
        double randDouble = RandomUtils.getRandomDouble();
        if (randDouble < 0.5) {
            actor.deductBalance(WORTH_IN_CREDITS);
            return "An error occurred while purchasing, your credits were deducted anyway...";
        } else {
            return BuyUtils.buyItem(actor, this, WORTH_IN_CREDITS);
        }
    }

    /**
     * Returns the cost of this item in credits.
     *
     * @return The cost of this item in credits.
     */
    @Override
    public int getCost() {
        return WORTH_IN_CREDITS;
    }

}