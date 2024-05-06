package game.scraps;

import edu.monash.fit2099.engine.items.Item;

/**
 * An abstract class representing a scrap item in the game.
 * Scraps are items that can be picked up and dropped by the player.
 * The goal is for the player (Intern) to pick up scraps and drop them inside their spaceship.
 */
public abstract class Scrap extends Item {

    /***
     * Constructs a new Scrap object.
     *
     * @param name the name of this Scrap
     * @param displayChar the character to use to represent this Scrap if it is on the ground
     * @param portable true if and only if the Scrap can be picked up
     */
    public Scrap(String name, char displayChar, boolean portable) {
        super(name, displayChar, portable);
    }
}
