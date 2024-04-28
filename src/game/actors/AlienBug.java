package game.actors;

import edu.monash.fit2099.engine.actors.Actor;
import game.types.Ability;

public class AlienBug extends Enemy implements Spawnable {

    /**
     * Constructs a new AlienBug object.
     */
    public AlienBug() {
        super("Alien Bug", 'a', 2);
        this.addCapability(Ability.PICK_UP_SCRAP);
        this.addCapability(Ability.ENTER_SPACESHIP);

        // TODO: Implement PickUpScrapBehaviour and FollowBehaviour
        // TODO: Implement naming “Feature-XXX”, where XXX is three random digits
    }

    @Override
    public Actor create() {
        return new AlienBug();
    }

    @Override
    public double getSpawnChance() {
        return 0.1;
    }

    // TODO: Implement dropping all scraps when AlienBug dies
}
