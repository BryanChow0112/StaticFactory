package game.scraps.special;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.actions.AttackAction;
import game.actions.SellAction;
import game.types.Ability;
import game.types.Sellable;
import game.types.Status;

/**
 * A metal pipe that can be used as a weapon.
 * It deals 1 damage with a 20% hit probability when used to attack hostile creatures.
 */
public class MetalPipe extends WeaponItem implements Sellable {
    private static final int CREDITS_TO_SELL = 35;

    /**
     * Constructor for MetalPipe class.
     */
    public MetalPipe() {
        super("Metal Pipe", '!', 1, "strikes", 20);
    }

    /**
     * List of allowable actions that the item allows its owner do to other actor.
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
            // Allow attacking for other actor (Enemy) using MetalPipe as weapon
            actions.add(new AttackAction(otherActor, locationString, this));
        }
        if (otherActor.hasCapability(Ability.PURCHASE_ITEMS)) {
            actions.add(new SellAction(otherActor,this));
        }
        return actions;
    }
    @Override
    public String sell(Actor actorSelling, Actor actorToSellTo) {
        actorSelling.removeItemFromInventory(this);
        actorToSellTo.addItemToInventory(this);
        actorSelling.addBalance(CREDITS_TO_SELL);
        return this + " was sold to " + actorToSellTo + " for " + CREDITS_TO_SELL + " credits.";
    }

    @Override
    public int getSellCost() {
        return CREDITS_TO_SELL;
    }
}
