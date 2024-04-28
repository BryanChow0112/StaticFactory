package game.scraps;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.DropAction;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.items.PickUpAction;
import game.types.Ability;

public abstract class Scrap extends Item {
    /***
     * Constructor.
     *  @param name the name of this Item
     * @param displayChar the character to use to represent this item if it is on the ground
     */
    public Scrap(String name, char displayChar) {
        super(name, displayChar, true);
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
}
