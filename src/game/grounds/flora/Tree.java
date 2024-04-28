package game.grounds.flora;

import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.grounds.Spawner;
import game.scraps.special.LargeFruit;
import game.types.Status;

/**
 * Represents a Tree, a type of Ground that produces LargeFruit items.
 */
public class Tree extends Ground {
    /**
     * Constructs a new Tree object.
     */
    public Tree() {
        super('T');
        addCapability(Status.ALIVE);
    }

    /**
     * Performs the actions for the Tree's turn.
     * This includes spawning a LargeFruit item with a certain probability.
     *
     * @param location The location of the Tree.
     */
    @Override
    public void tick(Location location) {
        super.tick(location);
        Spawner.spawnItem(location, new LargeFruit(), 0.2);
    }
}
