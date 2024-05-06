package game.scraps.regular;

import game.scraps.Scrap;

/**
 * A concrete implementation of the Scrap class representing a metal sheet item.
 */
public class MetalSheet extends Scrap {

    /**
     * Constructs a new MetalSheet object.
     * The metal sheet is represented by the '%' character and is portable.
     */
    public MetalSheet() {
        super("Metal Sheet", '%', true);
    }
}
