package game.types;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;

/**
* The Sellable interface defines a contract for objects that can be sold within the game.
* Any class implementing this interface must provide implementations for the sell and getSellCost methods.
*/
public interface Sellable {    
    /**
    * Performs the action of selling an object.
    *
    * @param actorSelling  The Actor object representing the entity selling the item.
    * @param actorToSellTo The Actor object representing the entity to whom the item is being sold.
    * @param map           The GameMap object representing the game map where the sale is taking place.
    * @return A String containing a message or description related to the sale.
    */
    String sell(Actor actorSelling, Actor actorToSellTo, GameMap map);

    /**
    * Returns the cost or price at which the sellable object can be sold.
    *
    * @return An integer value representing the sell cost of the object.
    */
    int getSellCost();
}