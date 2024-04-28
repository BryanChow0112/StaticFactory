package game.grounds;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Ground;
import game.scraps.Consumable;

public class Puddle extends Ground implements Consumable {
    private final int INCREASE_HP = 1;
    public Puddle() {
        super('~');
    }

    @Override
    public String handleConsume(Actor actor) {
        return null;
    }

    @Override
    public String getConsumableDescription() {
        return null;
    }
}
