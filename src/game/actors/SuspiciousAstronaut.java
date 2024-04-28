package game.actors;

import edu.monash.fit2099.engine.actors.Actor;

public class SuspiciousAstronaut extends Enemy implements Spawnable{

    @Override
    public Actor create() {
        return null;
    }

    @Override
    public double getSpawnChance() {
        return 0;
    }
}
