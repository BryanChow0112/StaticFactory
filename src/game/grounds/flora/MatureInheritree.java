package game.grounds.flora;

import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.Location;
import game.scraps.special.LargeFruit;

/**
 * Class that represents the final stage of inheritree
 */
public class MatureInheritree extends FruitfulTree {

    /**
     * Construct a new MatureInheritree
     */
    public MatureInheritree() {
        super('T');
    }

    /**
     * Method for the tree to experience time
     * @param location The location of the Ground
     */
    @Override
    public void tick(Location location){
        produceFruit(location);
    }

    /**
     * Method to see what fruit can be spawned
     * @return new large fruit
     */
    @Override
    public Item getFruit() {
        return new LargeFruit();
    }

    /**
     * Percentage change of fruit being spawned
     * @return int as a %
     */
    @Override
    public int getSpawnChance() {
        return 20;
    }
}
