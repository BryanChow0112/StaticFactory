package game.scraps.special;

import edu.monash.fit2099.engine.actors.Actor;
import game.scraps.WeaponScrap;
import game.types.Buyable;
import game.utils.BuyUtils;
import game.utils.RandomUtils;

public class DragonSlayerSword extends WeaponScrap implements Buyable {
    private static final int WORTH_IN_CREDITS = 100;

    public DragonSlayerSword() {
        super("Dragon Slayer Sword", 'x', 50, "slices", 75);
    }

    @Override
    public String buy(Actor actor) {
        double randDouble = RandomUtils.getRandomDouble();
        if (randDouble < 0.5) {
            actor.deductBalance(WORTH_IN_CREDITS);
            return "An error occurred while purchasing, your credits were deducted anyway...";
        } else {
            return BuyUtils.buyItem(actor, this, WORTH_IN_CREDITS);
        }
    }

    @Override
    public int getCost() {
        return WORTH_IN_CREDITS;
    }

}