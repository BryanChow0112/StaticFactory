package game.behaviours;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.actors.Behaviour;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.items.PickUpAction;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import game.utils.RandomUtils;

import java.util.List;

public class CollectScrapBehaviour implements Behaviour {
    @Override
    public Action getAction(Actor actor, GameMap map) {
        // Get the current location of the actor
        Location actorLocation = map.locationOf(actor);
        // Get the list of items available at the actor's location
        List<Item> items = actorLocation.getItems();
        // Check if the list of items is not empty
        if (!items.isEmpty()) {
            // Select a random item from the list
            Item item = items.get(RandomUtils.getRandomInt(items.size()));
            return new PickUpAction(item);
        }
        return null;
    }
}