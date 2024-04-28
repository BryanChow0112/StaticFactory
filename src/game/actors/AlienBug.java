package game.actors;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import game.behaviours.CollectScrapBehaviour;
import game.behaviours.FollowBehaviour;
import game.types.Ability;

import java.util.List;

public class AlienBug extends Enemy implements Spawnable {


    private final Player playerToFollow;

    /**
     * Constructs a new AlienBug object.
     */
    public AlienBug(Player playerToFollow) {
        super("Alien Bug", 'a', 2);
        this.addBehaviour(0, new CollectScrapBehaviour());
        this.addBehaviour(1, new FollowBehaviour(playerToFollow));
        this.addCapability(Ability.PICK_UP_SCRAP);
        this.addCapability(Ability.ENTER_SPACESHIP);
        this.playerToFollow = playerToFollow;

        // TODO: Implement naming “Feature-XXX”, where XXX is three random digits
    }

    @Override
    public Actor create() {
        return new AlienBug(this.playerToFollow);
    }

    @Override
    public double getSpawnChance() {
        return 0.1;
    }

    @Override
    public String unconscious(Actor actor, GameMap map) {
        // Get the list of items in the actor's inventory
        List<Item> items = this.getItemInventory();
        // Get the current location of the actor
        Location actorLocation = map.locationOf(this);
        // Drop all the items at the actor's current location
        for (Item item : items) {
            actorLocation.addItem(item);
        }
        return super.unconscious(actor, map);
    }
}
