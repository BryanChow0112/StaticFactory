package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.MoveActorAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;
import game.actors.Player;
import game.types.Consumable;

public class TeleportAction extends Action {

    private final Consumable teleporter;

    private final String direction;

    public TeleportAction(Consumable teleporter, String direction) {
        this.teleporter = teleporter;
        this.direction = direction;
    }

    @Override
    public String execute(Actor actor, GameMap map) {
        return this.teleporter.handleConsume(actor);
    }

    @Override
    public String menuDescription(Actor actor) {
        return actor + " moves " + this.direction;
    }
}
