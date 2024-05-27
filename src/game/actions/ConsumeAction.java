package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.types.Consumable;

/**
 * An Action that allows an Actor to consume a Consumable item.
 */
public class ConsumeAction extends Action {

    private final Consumable consumable;

    /**
     * Constructs a new ConsumeAction object.
     *
     * @param consumable The Consumable item to be consumed.
     */
    public ConsumeAction(Consumable consumable) {
        this.consumable = consumable;
    }

    /**
     * Executes the consume action, calling the Consumable handleConsume() method
     * to handle the consumption of the item.
     *
     * @param actor The actor performing the consume action
     * @param map   The map the actor is on.
     * @return A string describing the result of the consume action
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        return consumable.handleConsume(actor);
    }

    /**
     * Return the menu description of this Action.
     *
     * @param actor The actor performing the action.
     * @return the action description to be displayed on the menu
     */
    @Override
    public String menuDescription(Actor actor) {
        return actor + " consumes " + consumable;
    }
}
