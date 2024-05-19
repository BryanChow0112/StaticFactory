package game.grounds.flora;

import edu.monash.fit2099.engine.positions.Location;
import game.scraps.special.SmallFruit;

public class Sprout extends PlantBase implements Growable {

    /**
     * The current age of the Sprout.
     */
    private int age = 0;

    /**
     * The next stage of the plant after the sapling matures.
     */
    /**
     * Constructor.
     *
     * @param displayChar character to display for this type of terrain
     */
    public Sprout() {
        super(',');

    }

    @Override
    public void tick(Location location) {
        age++;
        if (this.age >= 3) {
            // Replace the current sapling with the next stage
            location.setGround(nextStage());
        }

    }

    @Override
    public PlantBase nextStage() {
        return new SaplingNew();
    }

    @Override
    public int getAge() {
        return this.age;
    }

    @Override
    public int growAge() {
        return 3;
    }
}
