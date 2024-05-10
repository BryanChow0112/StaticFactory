package game.grounds;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.actions.BuyAction;
import game.types.Buyable;

import java.util.ArrayList;

/**
 * A class representing a Terminal ground object in a game.
 * This ground object allows actors to purchase Buyable items.
 */
public class Terminal extends Ground {
    private final ArrayList<Buyable> buyables;

    /**
     * Constructs a new Terminal object with a list of buyable items.
     *
     * @param buyables The list of buyable items available for purchase.
     */
    public Terminal(ArrayList<Buyable> buyables) {
        super('=');
        this.buyables = buyables;
    }

    /**
     * Returns a list of allowable actions for an actor at this location.
     * The list includes a BuyAction for each buyable item available.
     *
     * @param actor     The actor performing the action.
     * @param location  The location of the actor.
     * @param direction The direction of the actor's movement (not used for this class).
     * @return A list of allowable actions for the actor at this location.
     */
    @Override
    public ActionList allowableActions(Actor actor, Location location, String direction) {
        ActionList actionList = new ActionList();
        for (Buyable buyable : this.buyables) {
            actionList.add(new BuyAction(buyable));
        }
        return actionList;
    }
}