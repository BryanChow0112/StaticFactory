package game.grounds.flora;

import edu.monash.fit2099.engine.positions.Location;
import game.types.Growable;

/**
 * Represents a YoungInheritree
 */
public class YoungInheritree extends NonFruitfulTree implements Growable {

    /**
     * Age of the YoungInheritree
     */
    private int age;

    /**
     * Construct a new Young Inheritree
     */
    public YoungInheritree() {
        super('y');
    }

    /**
     * Experience Time
     * @param location The location of the Ground
     */
    @Override
    public void tick(Location location){
        grow(location);
    }

    /**
     * The next stage of the inheritree
     * @return Mature Inheritree
     */
    @Override
    public PlantBase nextStage() {
        return new MatureInheritree();
    }

    /**
     * The age the tree will grow
     * @return int of the grow age
     */
    @Override
    public int growAge() {
        return 6;
    }

    /**
     * grow the tree each tick
     * @param location of the YoungInheritree
     */
    @Override
    public void grow(Location location) {
        age++;
        if (isMature()){
            location.setGround(nextStage());
        }
    }

    /**
     * Check if tree is mature
     * @return boolean if mature
     */
    @Override
    public boolean isMature() {
        return age >= growAge();
    }
}
