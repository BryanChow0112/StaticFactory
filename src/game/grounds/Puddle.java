package game.grounds;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Ground;
import game.scraps.Consumable;

public class Puddle extends Ground implements Consumable {
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
