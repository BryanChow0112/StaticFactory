package game.behaviours;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.actors.Behaviour;
import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import game.actions.AttackAction;
import game.types.Status;

public class AttackBehaviour implements Behaviour {

    /**
     * Returns an AttackAction to attack a player in its surroundings if possible.
     * If no attack is possible, it returns null.
     *
     * @param actor the Actor enacting the behaviour
     * @param map the map that actor is currently on
     * @return an Action, or null if no AttackAction is possible
     */
    @Override
    public Action getAction(Actor actor, GameMap map) {
        for (Exit exit : map.locationOf(actor).getExits()) {
            Location destination = exit.getDestination();
            Actor actorAtDestination = destination.getActor();
            if (actorAtDestination != null && actorAtDestination.hasCapability(Status.HOSTILE_TO_ENEMY)) {
                return new AttackAction(actorAtDestination, exit.getName());
            }
        }

        return null;
    }
}
