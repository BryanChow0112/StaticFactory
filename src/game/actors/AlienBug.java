package game.actors;

import edu.monash.fit2099.engine.actors.Actor;
import game.behaviours.FollowBehaviour;
import game.types.Ability;

public class AlienBug extends Enemy implements Spawnable {


    private final Player playerToFollow;

    /**
     * Constructs a new AlienBug object.
     */
    public AlienBug(Player playerToFollow) {
        super("Alien Bug", 'a', 2);
        this.addBehaviour(0, new FollowBehaviour(playerToFollow));
        this.addCapability(Ability.PICK_UP_SCRAP);
        this.addCapability(Ability.ENTER_SPACESHIP);
        this.playerToFollow = playerToFollow;

        // TODO: Implement PickUpScrapBehaviour
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

    // TODO: Implement dropping all scraps when AlienBug dies
}
