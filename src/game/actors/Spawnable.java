package game.actors;

import edu.monash.fit2099.engine.actors.Actor;

/**
 * An interface representing an entity that can be spawned in the game.
 * Implementing classes must provide a method to create an instance of the entity
 * and a method to retrieve the chance of the entity being spawned.
 */
public interface Spawnable {
    /**
     * Creates a new instance of the entity.
     *
     * @return A new instance of the entity.
     */
    Actor create();

    /**
     * Returns the chance of the entity being spawned.
     *
     * @return The spawn chance of the entity from 0 to 1.
     */
    double getSpawnChance();
}
