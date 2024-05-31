package game.grounds.flora;

import edu.monash.fit2099.engine.positions.Location;
import game.types.Growable;

/**
 * Represents first stage of inheritree Sprout
 */
public class Sprout extends NonFruitfulTree implements Growable {

    /**
     * Age of the Sprout
     */
    private int age;

    /**
     * Constructor for a new sprout
     */
    public Sprout() {
        super(',');
    }

    /**
     * Sprout to experience time
     * @param location The location of the Ground
     */
    @Override
    public void tick(Location location){
        grow(location);
    }

    /**
     * Represents the next stage of the tree
     * @return new Sapling
     */
    @Override
    public PlantBase nextStage() {
        return new Sapling();
    }

    /**
     * Represents the age to grow to next stage
     * @return int of the grow age
     */
    @Override
    public int growAge() {
        return 3;
    }

    /**
     * grow each tick
     * @param location of Sprout
     */
    @Override
    public void grow(Location location) {
        age++;
        if (isMature()){
            location.setGround(nextStage());
        }
    }

    /**
     * Check if Sprout is matured
     * @return boolean if matured
     */
    @Override
    public boolean isMature() {
        return age >= growAge();
    }
}
