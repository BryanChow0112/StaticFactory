package game.utils;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;

public class BuyUtils {
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
