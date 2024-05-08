package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.types.Buyable;

/**
 * An action that allows an actor to buy a buyable item.
 */
public class BuyAction extends Action {
    private Buyable buyable;

    /**
     * Constructs a new BuyAction instance.
     *
     * @param buyable The buyable item that the actor can purchase.
     */
    public BuyAction(Buyable buyable) {
        this.buyable = buyable;
    }

    /**
     * Executes the buy action for the given actor.
     *
     * @param actor The actor performing the buy action.
     * @param map   The game map (not used in this action).
     * @return The result message of the buy attempt.
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        return buyable.buy(actor);
    }

    /**
     * Returns the menu description of this action.
     *
     * @param actor The actor performing the action.
     * @return The menu description of this action.
     */
    @Override
    public String menuDescription(Actor actor) {
        return actor + " buys " + buyable + " for " + buyable.getCost() + " credits.";
    }
}