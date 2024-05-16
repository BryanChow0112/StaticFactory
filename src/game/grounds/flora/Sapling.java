package game.grounds.flora;

import edu.monash.fit2099.engine.positions.Location;
import game.scraps.special.SmallFruit;

/**
 * Represents a Sapling, a type of PlantBase that grows into a Tree over time.
 * The Sapling has a 30% chance to spawn a SmallFruit item each turn.
 */
public class Sapling extends PlantBase {

    /**
     * The current age of the sapling.
     */
    private int age = 0;

    /**
     * The next stage of the plant after the sapling matures.
     */
    private final PlantBase nextStage;

    /**
     * Constructs a new Sapling object.
     */
    public Sapling() {
        super('t');
        this.spawn = new SmallFruit();
        this.spawnChance = 30;
        this.nextStage = new Tree();
    }

    /**
     * Performs the actions for the Sapling's turn.
     * If the sapling's age reaches 5, it will grow to its mature stage (Tree).
     *
     * @param location The location of the Sapling.
     */
    @Override
    public void tick(Location location) {
        super.tick(location);
        age++;
        if (age >= 5) {
            // Replace the current sapling with the next stage
            location.setGround(nextStage);
        }
    }
}
