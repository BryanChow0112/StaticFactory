package game.types;

import edu.monash.fit2099.engine.positions.Location;
import game.grounds.flora.PlantBase;

/**
 * Interface if tree stage can grow further
 */
public interface Growable {

    /**
     * The next stage of the tree
     *
     */
    PlantBase nextStage();

    /**
     * The age to grow
     *
     */
    int growAge();

    /**
     * Implementation to grow
     * @param location
     */
    void grow(Location location);

    /**
     * Check if matured
     * @return boolean
     */
    boolean isMature();


}
