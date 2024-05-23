package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;

public class TeleportAction extends Action {
    private final String direction;
    private final Location destination;

    public TeleportAction(String direction, Location destination) {
        this.direction = direction;
        this.destination = destination;
    }

    @Override
    public String execute(Actor actor, GameMap map) {
        map.moveActor(actor, destination);
        return menuDescription(actor);
    }

    @Override
    public String menuDescription(Actor actor) {
        return actor + " teleports " + direction;
    }
}