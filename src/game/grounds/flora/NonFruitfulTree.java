package game.grounds.flora;

import edu.monash.fit2099.engine.positions.Location;

/**
 * Represents abstract class that is for stages of the tree that cannot produce fruit
 */
public abstract class NonFruitfulTree extends PlantBase {
    /**
     * Constructs a new PlantBase object with the specified display character.
     *
     * @param displayChar character to display for this type of terrain
     */

    public NonFruitfulTree(char displayChar) {
        super(displayChar);
    }

    /**
     * Method for the tree to experience time
     * @param location The location of the Ground
     */
    @Override
    public void tick(Location location) {
        super.tick(location);

    }
}
