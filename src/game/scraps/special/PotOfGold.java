package game.scraps.special;

import game.scraps.Consumable;
import game.scraps.Scrap;

public class PotOfGold extends Scrap implements Consumable {
    private static final int CREDIT_POINTS = 10;

    public PotOfGold() {
        super("Pot of Gold", '$');
    }


}
