package game.scraps.special;

import game.scraps.Consumable;
import game.scraps.Scrap;

public class JarOfPickles extends Scrap implements Consumable {
    private static final int HIT_POINTS = 1;

    public JarOfPickles() {
        super("Jar of Pickles", 'n');
    }


}
