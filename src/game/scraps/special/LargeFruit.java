package game.scraps.special;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import game.actions.ConsumeAction;
import game.types.Consumable;

/**
 * Represents a Large Fruit item that can be consumed to heal the actor.
 * The Large Fruit is a type of Scrap item that implements the Consumable interface.
 */
public class LargeFruit extends Fruit implements Consumable {
    private static final int HIT_POINTS = 2;

    /**
     * Constructs a new LargeFruit object.
     */
    public LargeFruit() {
        super("Large Fruit", 'O', true);
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

    /**
     * Handles the consumption of this item by the actor.
     *
     * @param actor The actor consuming this item.
     * @return A description of the consumption effect.
     */
    @Override
    public String handleConsume(Actor actor) {
        actor.heal(HIT_POINTS);
        actor.removeItemFromInventory(this);
        return actor + " is healed by " + HIT_POINTS + " hit points.";
    }

}
