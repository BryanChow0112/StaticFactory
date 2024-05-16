package game.spawners;

import edu.monash.fit2099.engine.positions.Location;
import game.actors.AlienBug;
import game.utils.RandomUtils;

/**
 * A Spawner implementation that spawns Alien Bugs.
 */
public class AlienBugSpawner implements Spawner {

    private static final int SPAWN_RATE = 10;

    /**
     * Spawns a Alien Bug at the specified location with a 10% chance if the location has no actor on it.
     *
     * @param location the location where the Alien Bug is spawned
     */
    @Override
    public void spawnEnemy(Location location) {
        if (RandomUtils.getRandomInt(100) <= SPAWN_RATE && !location.containsAnActor()) {
            location.addActor(new AlienBug());
        }
    }
}
