package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.types.Monologuer;

/**
 * An Action class that allows an Actor to listen to a monologue generated by a Monologuer.
 */
public class MonologueAction extends Action {

    private final Monologuer monologuer;

    /**
     * Constructs a new MonologueAction object.
     *
     * @param monologuer The Monologuer item that generates the monologue
     */
    public MonologueAction(Monologuer monologuer) {
        this.monologuer = monologuer;
    }

    /**
     * Perform the Action.
     *
     * @param actor The actor performing the monologue action.
     * @param map   The map the actor is on.
     * @return A string representing the monologue option.
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        return monologuer + ": " + monologuer.generateMonologue(actor);
    }

    /**
     * Return the menu description of this Action.
     *
     * @param actor The actor performing the action.
     * @return the action description to be displayed on the menu
     */
    @Override
    public String menuDescription(Actor actor) {
        return actor + " listens to the monologue of " + monologuer + ".";
    }
}