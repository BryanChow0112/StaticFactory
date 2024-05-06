package game.scraps;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.actions.AttackAction;
import game.types.Status;

public class WeaponScrap extends WeaponItem {

    /***
     * Constructor.
     *  @param name the name of this WeaponScrap
     * @param displayChar the character to use to represent this weapon scrap if it is on the ground
     */
    public WeaponScrap(String name, char displayChar, int damage, String verb, int hitRate) {
        super(name, displayChar, damage, verb, hitRate);
    }

    /**
     * List of allowable actions that the weapon scrap allows its owner do to other actor.
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
            // Allow attacking for other actor (Enemy) using WeaponScrap as weapon
            actions.add(new AttackAction(otherActor, locationString, this));
        }
        return actions;
    }
}
