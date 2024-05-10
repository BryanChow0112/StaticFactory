package game.grounds.flora;

import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.grounds.Spawner;

/**
 * An abstract class representing a plant in the game environment.
 * Plants have the ability to grow and produce fruits.
 */
public abstract class PlantBase extends Ground {

    /**
     * The scrap (fruit) that the plant can produce.
     */
    protected Item spawn;

    /**
     * The probability of the spawn being produced by plant.
     */
    protected double spawnChance;

    /**
     * Constructs a new PlantBase object with the specified display character.
     *
     * @param displayChar character to display for this type of terrain
     */
    public PlantBase(char displayChar) {
        super(displayChar);
    }

    @Override
    public void tick(Location location) {
        super.tick(location);
        // produce fruits
        Spawner.spawnItem(location, this.spawn, this.spawnChance);
    }
}