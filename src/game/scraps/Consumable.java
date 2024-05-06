package game.scraps;

import edu.monash.fit2099.engine.actors.Actor;

/**
 * An interface representing a consumable item in the game.
 * Implementations of this interface must provide methods for handling
 * the consumption of the item and describing its consumable effect.
 */
public interface Consumable {

    /**
     * Handles the consumption of the item by the provided actor.
     *
     * @param actor The actor consuming the item.
     * @return A description of the consumption effect.
     */
    String handleConsume(Actor actor);

}
