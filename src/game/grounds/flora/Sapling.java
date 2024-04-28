package game.grounds.flora;

import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.grounds.Spawner;
import game.scraps.special.SmallFruit;
import game.types.Status;

/**
 * Represents a Sapling, a type of Ground that grows into a Tree over time.
 * The Sapling has a chance to spawn a SmallFruit item each turn.
 */
public class Sapling extends Ground {
    private int age = 0;

    /**
     * Constructs a new Sapling object.
     */
    public Sapling() {
        super('t');
        addCapability(Status.ALIVE);
    }

    /**
     * Performs the actions for the Sapling's turn.
     * This includes spawning a SmallFruit item with a certain probability
     * and aging the Sapling towards becoming a Tree.
     *
     * @param location The location of the Sapling.
     */
    @Override
    public void tick(Location location) {
        super.tick(location);
        Spawner.spawnItem(location, new SmallFruit(), 0.3);
        ageGround(location);
    }

    private void ageGround(Location location) {
        age++;
        if (age == 5)
            location.setGround(new Tree());
    }
}
