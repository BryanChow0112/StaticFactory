package game.grounds.flora;

import edu.monash.fit2099.engine.positions.Location;

public abstract class NonFruitfulTree extends PlantBase {
    /**
     * Constructs a new PlantBase object with the specified display character.
     *
     * @param displayChar character to display for this type of terrain
     */

    public NonFruitfulTree(char displayChar) {
        super(displayChar);
    }

    @Override
    public void tick(Location location) {
        super.tick(location);

    }
}
