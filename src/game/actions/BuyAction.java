package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.types.Buyable;

public class BuyAction extends Action {
    Buyable buyable;

    public BuyAction(Buyable buyable) {
        this.buyable = buyable;
    }

    @Override
    public String execute(Actor actor, GameMap map) {
        return buyable.buy(actor);
    }

    @Override
    public String menuDescription(Actor actor) {
        return actor + " buys " + buyable + " for " + buyable.getCost() + " credits.";
    }
}
