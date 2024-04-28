package game.grounds;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.Location;
import game.utils.RandomUtils;

/**
 * A utility class for spawning actors and items in the game.
 * This class provides static methods for attempting to spawn new actors or items
 * at random exit locations with a specified probability.
 */
public class Spawner {

    /**
     * Tries to spawn a new actor at a random exit location of the given location.
     *
     * @param location    the location where the spawning attempt is made
     * @param newActor  an actor instance
     * @param spawnChance the probability of spawning (between 0.0 and 1.0)
     */
    public static void spawnActor(Location location, Actor newActor, double spawnChance) {
        if (RandomUtils.getRandomDouble() <= spawnChance) {
            Exit randomExit = RandomUtils.getRandomExit(location);
            Location exitLocation = randomExit.getDestination();
            if (!exitLocation.containsAnActor() && exitLocation.getGround().canActorEnter(newActor)) {
                exitLocation.addActor(newActor);
            }
        }
    }

    /**
     * Tries to spawn a new item at a random exit location of the given location.
     *
     * @param location   the location where the spawning attempt is made
     * @param newItem  an item instance
     * @param spawnChance the probability of spawning (between 0.0 and 1.0)
     */
    public static void spawnItem(Location location, Item newItem, double spawnChance) {
        if (RandomUtils.getRandomDouble() <= spawnChance) {
            Exit randomExit = RandomUtils.getRandomExit(location);
            Location exitLocation = randomExit.getDestination();
            exitLocation.addItem(newItem);
        }
    }
}
