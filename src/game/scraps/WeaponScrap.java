package game.scraps;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.DropAction;
import edu.monash.fit2099.engine.items.PickUpAction;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.actions.AttackAction;
import game.types.Ability;

public class WeaponScrap extends WeaponItem {
    /***
     * Constructor.
     *  @param name the name of this Item
     * @param displayChar the character to use to represent this item if it is on the ground
     */
    public WeaponScrap(String name, char displayChar, int damage, String verb, int hitRate) {
        super(name, displayChar, damage, verb, hitRate);
    }

    /**
     * Create and return an action to pick this Item up.
     * If the actor can't pick up this item, return null
     *
     * @return a new PickUpItemAction if the actor can pick up this item, null otherwise.
     */
    @Override
    public PickUpAction getPickUpAction(Actor actor) {
        if(actor.hasCapability(Ability.PICK_UP_SCRAP))
            return new PickUpAction(this);
        return null;
    }

    /**
     * Create and return an action to drop this Item.
     * If the actor can't drop this item, return null
     *
     * @return a new DropItemAction if the actor can drop this item, null otherwise.
     */
    @Override
    public DropAction getDropAction(Actor actor) {
        if(actor.hasCapability(Ability.DROP_SCRAP))
            return new DropAction(this);
        return null;
    }

    /**
     * Returns the list of actions that this actor can perform on the other actor at the specified location.
     *
     * @param otherActor The actor to perform the action on.
     * @param location   The location where the action will be performed.
     * @return The list of allowable actions.
     */
    @Override
    public ActionList allowableActions(Actor otherActor, Location location) {
        ActionList actionList = new ActionList();
        actionList.add(new AttackAction(otherActor, location.toString(), this));
        return actionList;
    }
}
