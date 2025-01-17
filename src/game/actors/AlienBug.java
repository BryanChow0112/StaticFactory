package game.actors;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import game.actions.AttackAction;
import game.behaviours.CollectScrapBehaviour;
import game.behaviours.FollowBehaviour;
import game.types.Ability;
import game.types.Status;
import game.utils.RandomUtils;

import java.util.List;

/**
 * Represents an Alien Bug enemy in the game.
 * The Alien Bug can collect scraps from the ground, follow the Intern, and enter the Intern's spaceship.
 * When defeated, the Alien Bug drops all the scraps it has collected.
 */
public class AlienBug extends Enemy {

    /**
     * A constant that represents the priority of the collect scrap behaviour.
     */
    public static final int COLLECT_SCRAP_PRIORITY = 0;

    /**
     * A constant that represents the priority of the follow behaviour.
     */
    public static final int FOLLOW_PRIORITY = 1;

    /**
     * Constructs a new AlienBug object.
     */
    public AlienBug() {
        super("Feature-" + RandomUtils.getRandomInt(100, 999), 'a', 2);
        this.addBehaviour(COLLECT_SCRAP_PRIORITY, new CollectScrapBehaviour());
        this.addCapability(Ability.ENTER_SPACESHIP);
    }

    /**
     * Method that can be executed when the AlienBug is unconscious due to the action of another actor
     *
     * @param actor the perpetrator
     * @param map   where the actor fell unconscious
     * @return a string describing what happened when the actor is unconscious
     */
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

    /**
     * Returns a new collection of the Actions that the otherActor can do to the AlienBug.
     *
     * @param otherActor the Actor that might be performing attack
     * @param direction  String representing the direction of the other Actor
     * @param map        current GameMap
     * @return A collection of Actions.
     */
    @Override
    public ActionList allowableActions(Actor otherActor, String direction, GameMap map) {
        ActionList actions = new ActionList();

        // Check if the other actor (presumably the player) has the HOSTILE_TO_ENEMY capability
        if (otherActor.hasCapability(Status.HOSTILE_TO_ENEMY)) {
            // Allow the other actor to attack using their intrinsic weapon
            actions.add(new AttackAction(this, direction));
        }

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
                        this.addBehaviour(FOLLOW_PRIORITY, new FollowBehaviour(otherActor));
                        break; // Exit the loop once the Intern is found
                    }
                }
            }
        }
        return actions;
    }

}
