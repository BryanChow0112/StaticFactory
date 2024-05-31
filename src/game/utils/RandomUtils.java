package game.utils;

import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.Location;

import java.util.List;
import java.util.Random;

/**
 * A utility class for generating random values and random selections.
 */
public class RandomUtils {
    private static final Random RANDOM = new Random();

    /**
     * Returns a random integer value between 0 (inclusive) and the specified bound (exclusive).
     *
     * @param bound The exclusive upper bound for the random number.
     * @return A random integer value.
     */
    public static int getRandomInt(int bound) {
        return RANDOM.nextInt(bound);
    }

    /**
     * Returns a random integer between the specified lower and upper bound.
     *
     * @param lowerBound the lower bound of the random number
     * @param upperBound the upper bound of the random number
     * @return a random integer
     */
    public static int getRandomInt(int lowerBound, int upperBound) {
        int range = upperBound - lowerBound + 1;
        return RANDOM.nextInt(range) + lowerBound;
    }

    /**
     * Returns a random exit from the given location.
     *
     * @param location The location for which to get a random exit.
     * @return A random exit from the location.
     */
    public static Exit getRandomExit(Location location) {
        List<Exit> exits = location.getExits();
        int randomIndex = RANDOM.nextInt(exits.size());
        return exits.get(randomIndex);
    }
}
