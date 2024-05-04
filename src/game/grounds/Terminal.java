package game.grounds;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.actions.BuyAction;
import game.types.Buyable;

import java.util.ArrayList;

public class Terminal extends Ground {
    ArrayList<Buyable> buyables;

    public Terminal(ArrayList<Buyable> buyables) {
        super('=');
        this.buyables = buyables;
    }

    @Override
    public ActionList allowableActions(Actor actor, Location location, String direction) {
        ActionList actionList = new ActionList();
        for (Buyable buyable : this.buyables) {
            actionList.add(new BuyAction(buyable));
        }
        return actionList;
    }
}
