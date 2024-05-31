package game.grounds;

import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.spawners.Spawner;

/**
 * A class that represents a crater on the game map.
 * Craters have the ability to spawn hostile creatures using a Spawner.
 */
public class Crater extends Ground {

    private final Spawner spawner;

    /**
     * Constructs a new Crater object.
     *
     * @param spawner The Spawner to be used for spawning hostile creatures
     */
    public Crater(Spawner spawner) {
        super('u');
        this.spawner = spawner;
    }

    /**
     * Performs the tick action for the Crater.
     * Calls the Spawner to spawn a hostile creature at the Crater's location.
     *
     * @param location the location of the Crater
     */
    @Override
    public void tick(Location location) {
        super.tick(location);
        spawner.spawnEnemy(location);
    }
}