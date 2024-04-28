package game.actors;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import game.behaviours.CollectScrapBehaviour;
import game.behaviours.FollowBehaviour;
import game.types.Ability;
import game.types.Status;
import game.utils.RandomUtils;

import java.util.List;

public class AlienBug extends Enemy implements Spawnable {

    /**
     * Constructs a new AlienBug object.
     */
    public AlienBug() {
        super("Feature-" + RandomUtils.getRandomInt(100, 999), 'a', 2);
        this.addBehaviour(0, new CollectScrapBehaviour());
        this.addCapability(Ability.PICK_UP_SCRAP);
        this.addCapability(Ability.ENTER_SPACESHIP);
    }

    @Override
    public Actor create() {
        return new AlienBug();
    }

    @Override
    public double getSpawnChance() {
        return 0.1;
    }

    @Override
    public String unconscious(Actor actor, GameMap map) {
        // Get the list of items in the AlienBug's inventory
        List<Item> items = this.getItemInventory();
        // Get the current location of the AlienBug
        Location actorLocation = map.locationOf(this);
        // Drop all the items at the AlienBug's current location
        for (Item item : items) {
            actorLocation.addItem(item);
        }
        return super.unconscious(actor, map);
    }

    @Override
    public ActionList allowableActions(Actor otherActor, String direction, GameMap map) {
        ActionList actions = new ActionList();
        // Get the current location of the AlienBug
        Location actorLocation = map.locationOf(this);
        List<Exit> exits = actorLocation.getExits();
        if (!exits.isEmpty()) {
            // Check each exit to see if the Intern is in the surroundings
            for (Exit exit : exits) {
                Location destination = exit.getDestination();
                // Check if the destination contains the Intern
                if (destination.containsAnActor()) {
                    // If the Intern is found, start following the Intern
                    if (otherActor.hasCapability(Status.HOSTILE_TO_ENEMY)) {
                        this.addBehaviour(1, new FollowBehaviour(otherActor));
                        break; // Exit the loop once the Intern is found
                    }
                }
            }
        }
        return actions;
    }

}
