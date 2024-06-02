package game.utils;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;

/**
 * A utility class containing methods for handling item sales.
 */
public class SellUtils {

    /**
    * Performs the sale of an item from one actor to another.
    *
    * @param actorSelling The actor selling the item.
    * @param actorToSellTo The actor to whom the item is being sold.
    * @param item The item being sold.
    * @param cost The cost or price of the item being sold.
    * @return A string describing the successful sale of the item.
    */
    public static String sellItem(Actor actorSelling, Actor actorToSellTo, Item item, int cost) {
        actorSelling.removeItemFromInventory(item);
        actorToSellTo.addItemToInventory(item);
        actorSelling.addBalance(cost);
        return item + " was sold to " + actorToSellTo + " for " + cost + " credits.";
    }
}