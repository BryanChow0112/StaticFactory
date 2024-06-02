package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;

/**
 * An Action class that allows an Actor to teleport to another location on the game map.
 */
public class TeleportAction extends Action {
    private final String direction;
    private final Location destination;

    /**
     * Constructs a new TeleportAction object.
     *
     * @param direction The direction of the player.
     * @param destination The location of the player.
     */
    public TeleportAction(String direction, Location destination) {
        this.direction = direction;
        this.destination = destination;
    }

    /**
     * Executes the buy action for the given actor.
     *
     * @param actor The actor performing the buy action.
     * @param map   The game map (not used in this action).
     * @return The result message of the buy attempt.
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        if (destination.containsAnActor()) {
            return "Teleport fails";
        } else {
            map.moveActor(actor, destination);
            return actor + " arrives at " + destination + " in " + direction;
        }
    }

    /**
     * Returns the menu description of this action.
     *
     * @param actor The actor performing the action.
     * @return The menu description of this action.
     */
    @Override
    public String menuDescription(Actor actor) {
        return actor + " travels to " + direction;
    }
}