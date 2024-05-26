package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.types.Monologuer;

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

    @Override
    public String execute(Actor actor, GameMap map) {
        return monologuer + ": " + monologuer.generateMonologue();
    }

    @Override
    public String menuDescription(Actor actor) {
        return actor + " listens to the monologue of " + monologuer + ".";
    }
}
