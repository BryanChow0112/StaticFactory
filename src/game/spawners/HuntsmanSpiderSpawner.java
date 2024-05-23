package game.spawners;

import edu.monash.fit2099.engine.positions.Location;
import game.actors.HuntsmanSpider;
import game.utils.RandomUtils;

/**
 * A Spawner implementation that spawns Huntsman Spiders.
 */
public class HuntsmanSpiderSpawner implements Spawner {

    private static final int SPAWN_RATE = 5;

    /**
     * Spawns a Huntsman Spider at the specified location with a 5% chance if the location has no actor on it.
     *
     * @param location the location where the Huntsman Spider is spawned
     */
    @Override
    public void spawnEnemy(Location location) {
        if (RandomUtils.getRandomInt(100) <= SPAWN_RATE && !location.containsAnActor()) {
            location.addActor(new HuntsmanSpider());
        }
    }
}
