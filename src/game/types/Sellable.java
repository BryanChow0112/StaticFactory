package game.types;

import edu.monash.fit2099.engine.actors.Actor;

public interface Sellable {

    String sell(Actor actorSelling, Actor actorToSellTo);

    int getSellCost();
}