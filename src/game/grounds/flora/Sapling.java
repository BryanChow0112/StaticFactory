package game.grounds.flora;

import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.Location;
import game.scraps.special.SmallFruit;
import game.types.Growable;

/**
 * Represents the sapling stage of inheritree
 */
public class Sapling extends FruitfulTree implements Growable {
    /**
     * The age of the sapling
     */
    private int age;

    /**
     * Construct new instance of sapling
     */
    public Sapling() {
        super('t');
    }

    /**
     * Method for the sapling to experience time
     * @param location The location of the Ground
     */
    @Override
    public void tick(Location location){
        produceFruit(location);
        grow(location);
    }

    /**
     * Method to get the fruit that can be spawned
     * @return small fruit
     */
    @Override
    public Item getFruit() {
        return new SmallFruit();
    }

    /**
     * % Chance of the fruit spawning
     * @return int representing a percentage
     */
    @Override
    public int getSpawnChance() {
        return 30;
    }

    /**
     * get the next stage once it ages enough
     * @return next stage new YoungInheritree
     */
    @Override
    public PlantBase nextStage() {
        return new YoungInheritree();
    }

    /**
     * Age that the Sapling grows
     * @return int growAge
     */
    @Override
    public int growAge() {
        return 6;
    }

    /**
     * Method for the sapling to grow each tick
     * @param location of sapling
     */
    @Override
    public void grow(Location location) {
        age++;
        if (isMature()){
            location.setGround(nextStage());
        };
    }

    /**
     * Check if the Sapling has matured
     * @return boolean if matured
     */
    @Override
    public boolean isMature() {
        return age >= growAge();
    }
}
