package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.types.Consumable;

/**
 * Class representing an action that consumes a Consumable item.
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

    @Override
    public String execute(Actor actor, GameMap map) {
        return consumable.handleConsume(actor);
    }

    @Override
    public String menuDescription(Actor actor) {
        return actor + " consumes " + consumable;
    }
}
