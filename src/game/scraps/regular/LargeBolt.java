package game.scraps.regular;

import game.scraps.Scrap;

/**
 * A concrete implementation of the Scrap class representing a large bolt item.
 */
public class LargeBolt extends Scrap {

    /**
     * Constructs a new LargeBolt object.
     * The large bolt is represented by the '+' character and is portable.
     */
    public LargeBolt() {
        super("Large Bolt", '+', true);
    }
}
