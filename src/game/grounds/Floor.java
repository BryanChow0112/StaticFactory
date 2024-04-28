package game.grounds;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Ground;
import game.types.Ability;

/**
 * A class that represents the floor inside a building.
 * Created by:
 * @author Riordan D. Alfredo
 * Modified by:
 * @author Lachlan MacPhee
 *
 */
public class Floor extends Ground {
    public Floor() {
        super('_');
    }

    /**
     * Determines whether an actor can enter the Floor.
     *
     * @param actor The actor attempting to enter the Floor.
     * @return true if the actor has the ENTER_SPACESHIP ability, false otherwise.
     */
    @Override
    public boolean canActorEnter(Actor actor) {
        return actor.hasCapability(Ability.ENTER_SPACESHIP);
    }
}
