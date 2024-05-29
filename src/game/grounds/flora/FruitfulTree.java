package game.grounds.flora;


import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.Location;
import game.scraps.special.Fruit;
import game.utils.RandomUtils;

/**
 * Abstract class for stages of the tree that can produce fruit
 */
public abstract class FruitfulTree extends PlantBase {

    /**
     * Contructor represents new Fruitful tree
     * @param displayChar display on map
     */
    public FruitfulTree(char displayChar) {
        super(displayChar);
    }

    /**
     * Method that all trees that can producefruit will use
     * @param location location of where the tree currently is
     */
    public void produceFruit(Location location) {
        if (RandomUtils.getRandomInt(100) <= getSpawnChance()) {
            Exit randomExit = RandomUtils.getRandomExit(location);
            Location exitLocation = randomExit.getDestination();
            exitLocation.addItem(getFruit());
        }
    }

    /**
     * The tree experiencing time
     * @param location The location of the Ground
     */
    @Override
    public void tick(Location location) {
        super.tick(location);

    }

    /**
     * Method to get the fruit that can be spawned by the tree
     * @return new fruit that can be spawns
     */
    public abstract Fruit getFruit();

    /**
     * The chance that the fruit will spawn on each tick
     * @return integer of spawn chance %
     */
    public abstract int getSpawnChance();
}