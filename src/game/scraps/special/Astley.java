package game.scraps.special;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import game.types.Buyable;
import game.types.Monologuer;
import game.utils.BuyUtils;

import java.util.ArrayList;
import java.util.List;

public class Astley extends Item implements Buyable, Monologuer {

    private static final int WORTH_IN_CREDITS = 50;

    private static final List<String> monologueOptions = new ArrayList<>();

    /**
     * Constructs a new Astley object.
     */
    public Astley() {
        super("Astley, an AI Device", 'z', true);
    }

    @Override
    public String buy(Actor actor) {
        return BuyUtils.buyItem(actor, this, WORTH_IN_CREDITS);
    }

    @Override
    public int getCost() {
        return WORTH_IN_CREDITS;
    }

    @Override
    public String generateMonologue() {
        return "";
    }
}
