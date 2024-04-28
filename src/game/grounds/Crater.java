package game.grounds;

import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.actors.Spawnable;

/**
 * Represents a Crater, a type of Ground that spawns a single type of enemy.
 */
public class Crater extends Ground {

    private final Spawnable spawnEnemy;

    /**
     * Constructs a new Crater object.
     *
     * @param spawnEnemy The Spawnable enemy that can be spawned around the Crater.
     */
    public Crater(Spawnable spawnEnemy) {
        super('u');
        this.spawnEnemy = spawnEnemy;
    }

    /**
     * Performs the actions for the Crater's turn.
     * This includes attempting to spawn the associated enemy around the Crater's location.
     *
     * @param location The location of the Crater.
     */
    @Override
    public void tick(Location location) {
        Spawner.spawnActor(location, spawnEnemy.create(), spawnEnemy.getSpawnChance());
    }
}