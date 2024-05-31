package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.types.Sellable;

/**
 * An action that allows an actor to sell a sellable item.
 */
public class SellAction extends Action {
    private final Sellable sellable;
    private final Actor actorToSellTo;

    /**
     * Constructs a new SellAction instance.
     *
     * @param sellable The sellable item that the actor can sell.
     */
    public SellAction(Actor actorToSellTo, Sellable sellable) {
        this.sellable = sellable;
        this.actorToSellTo = actorToSellTo;
    }

    /**
     * Executes the sell action for the given actor.
     *
     * @param actorSelling The actor performing the sell action.
     * @param map   The game map (not used in this action).
     * @return The result message of the buy attempt.
     */
    @Override
    public String execute(Actor actorSelling, GameMap map) {
        return sellable.sell(actorSelling, actorToSellTo, map);
    }

    /**
     * Returns the menu description of this action.
     *
     * @param actor The actor performing the action.
     * @return The menu description of this action.
     */
    @Override
    public String menuDescription(Actor actor) {
        return actor + " sells " + sellable + " for " + sellable.getSellCost() + " credits.";
    }
}