package game.scraps.special;

import edu.monash.fit2099.engine.items.Item;
import game.types.Consumable;

public abstract class Fruit extends Item implements Consumable {
    /***
     * Constructor.
     *  @param name the name of this Item
     * @param displayChar the character to use to represent this item if it is on the ground
     * @param portable true if and only if the Item can be picked up
     */
    public Fruit(String name, char displayChar, boolean portable) {
        super(name, displayChar, portable);
    }
}
