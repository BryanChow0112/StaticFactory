package game.utils;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;

/**
 * A utility class containing methods for handling item sales.
 */
public class SellUtils {

    public static String sellItem(Actor actorSelling, Actor actorToSellTo, Item item, int cost) {
        actorSelling.removeItemFromInventory(item);
        actorToSellTo.addItemToInventory(item);
        actorSelling.addBalance(cost);
        return item + " was sold to " + actorToSellTo + " for " + cost + " credits.";
    }
}