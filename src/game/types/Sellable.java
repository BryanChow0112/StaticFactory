package game.types;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;

public interface Sellable {

    String sell(Actor actorSelling, Actor actorToSellTo, GameMap map);

    int getSellCost();
}