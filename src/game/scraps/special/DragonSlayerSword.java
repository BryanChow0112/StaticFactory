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

public class DragonSlayerSword extends WeaponItem implements Buyable {
    private static final int WORTH_IN_CREDITS = 100;

    public DragonSlayerSword() {
        super("Dragon Slayer Sword", 'x', 50, "slices", 75);
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
        return actions;
    }

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

    @Override
    public int getCost() {
        return WORTH_IN_CREDITS;
    }

}