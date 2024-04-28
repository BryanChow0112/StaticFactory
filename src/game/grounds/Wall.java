package game.grounds;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Ground;

/**
 * Created by:
 * @author Riordan D. Alfredo
 * Modified by:
 * @author Lachlan MacPhee
 *
 * Represents a Wall, an impassable type of Ground that actors cannot enter.
 */
public class Wall extends Ground {

    /**
     * Constructs a new Wall object.
     */
    public Wall() {
        super('#');
    }

    /**
     * Determines whether an actor can enter the Wall.
     *
     * @param actor The actor attempting to enter the Wall.
     * @return false, as actors cannot enter a Wall.
     */
    @Override
    public boolean canActorEnter(Actor actor) {
        return false;
    }
}
