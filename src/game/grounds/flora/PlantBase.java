package game.grounds.flora;

import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.utils.RandomUtils;

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
    protected int spawnChance;

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
        produceFruit(location, this.spawn, this.spawnChance);
    }

    /**
     * Tries to spawn a new item at a random exit location of the given location.
     *
     * @param location    the location where the spawning attempt is made
     * @param newItem     an item instance
     * @param spawnChance the probability of spawning
     */
    public static void produceFruit(Location location, Item newItem, int spawnChance) {
        if (RandomUtils.getRandomInt(100) <= spawnChance) {
            Exit randomExit = RandomUtils.getRandomExit(location);
            Location exitLocation = randomExit.getDestination();
            exitLocation.addItem(newItem);
        }
    }
}
