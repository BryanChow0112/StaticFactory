package game.types;

import edu.monash.fit2099.engine.actors.Actor;

/**
 * An interface representing an object that can be purchased by an actor in a game.
 */
public interface Buyable {

    /**
     * Performs the necessary actions to buy this object for the given actor.
     *
     * @param actor The actor attempting to buy this object.
     * @return A message indicating the result of the purchase attempt.
     */
    String buy(Actor actor);

    /**
     * Returns the cost of this object in credits.
     *
     * @return The cost of this object in credits.
     */
    int getCost();
}