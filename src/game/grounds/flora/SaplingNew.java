package game.grounds.flora;

import edu.monash.fit2099.engine.positions.Location;
import game.scraps.special.Fruit;
import game.scraps.special.SmallFruit;
import game.utils.RandomUtils;

public class SaplingNew extends PlantBase implements FruitFul, Growable{
    /**
     * The current age of the sapling.
     */
    private int age = 0;
    /**
     * The probability of the spawn being produced by plant.
     */
    /**
     * The next stage of the plant after the sapling matures.
     */

    public SaplingNew() {

        super('t');

    }

    @Override
    public void tick(Location location) {
        age++;
        if (age >= 6) {
            // Replace the current sapling with the next stage
            location.setGround(nextStage());

        }
        if (RandomUtils.getRandomInt(100) <= getSpawnChance()) {
            produceFruit(location);
        }

    }

    @Override
    public int getSpawnChance() {
        return 30;
    }

    @Override
    public Fruit getFruit() {
        return new SmallFruit();
    }

    @Override
    public PlantBase nextStage() {
        return new YoungInheritree();
    }

    @Override
    public int getAge() {
        return this.age;
    }

    @Override
    public int growAge() {
        return 6;
    }


}
