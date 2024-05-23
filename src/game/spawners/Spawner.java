package game.spawners;

import edu.monash.fit2099.engine.positions.Location;

/**
 * An interface that defines the contract for spawning enemies in the game.
 */
public interface Spawner {

    /**
     * Spawns an enemy at the specified location.
     *
     * @param location the location where the enemy is spawned
     */
    void spawnEnemy(Location location);
}
