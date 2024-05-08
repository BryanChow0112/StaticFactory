package game.utils;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;

/**
 * A utility class containing methods for handling item purchases.
 */
public class BuyUtils {

    /**
     * Attempts to buy an item for an actor.
     *
     * @param actor The actor attempting to buy the item.
     * @param item  The item to be purchased.
     * @param cost  The cost of the item in credits.
     * @return A message indicating whether the purchase was successful or not.
     */
    public static String buyItem(Actor actor, Item item, int cost) {
        if (actor.getBalance() >= cost) {
            actor.deductBalance(cost);
            actor.addItemToInventory(item);
            return "You purchased " + item + " for " + cost + " credits.";
        } else {
            return "Insufficient credits to purchase " + item + ". It costs " + cost + " credits.";
        }
    }
}