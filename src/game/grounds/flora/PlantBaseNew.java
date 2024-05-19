package game.grounds.flora;

import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;

public abstract class PlantBaseNew extends Ground {
    /**
     * Constructor.
     *
     * @param displayChar character to display for this type of terrain
     */
    public PlantBaseNew(char displayChar) {
        super(displayChar);
    }

    @Override
    public abstract void tick(Location location);
}

