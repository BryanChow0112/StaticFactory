package game.grounds.flora;

import edu.monash.fit2099.engine.positions.Location;

public class YoungInheritree extends PlantBase implements Growable{

    /**
     * The current age of the sapling.
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
    public YoungInheritree() {
        super('y');

    }

    @Override
    public void tick(Location location) {
        age++;
        if (age >= 5) {
            // Replace the current sapling with the next stage
            location.setGround(nextStage());
        }

    }

    @Override
    public PlantBase nextStage() {
        return new MatureInheritree();
    }

    @Override
    public int getAge() {
        return 0;
    }

    @Override
    public int growAge() {
        return 0;
    }
}
