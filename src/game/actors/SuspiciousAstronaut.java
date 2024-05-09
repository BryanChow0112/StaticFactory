package game.actors;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.actors.attributes.BaseActorAttributes;
import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;
import game.behaviours.AttackBehaviour;

/**
 * Class that represents SuspiciousAstronaut enemy
 */
public class SuspiciousAstronaut extends Enemy implements Spawnable {
    /**
     * An attribute that represents a player on the map
     */
    Player player;

    /**
     * A constant that represents the priority of the attack behaviour.
     */
    public static final int ATTACK_PRIORITY = 0;

    /**
     * Constructs new SuspiciousAstronaut object
     * @param player player on the map
     */

    public SuspiciousAstronaut(Player player) {
        super("Suspicious Astronaut", 'ඞ', 99);
        this.player = player;
        this.addBehaviour(ATTACK_PRIORITY, new AttackBehaviour());
    }

    /**
     * Method to get SuspiciousAstronauts intrinsic weapon
     * @return SuspiciousAstronaut intrinsic weapon
     */
    @Override
    public IntrinsicWeapon getIntrinsicWeapon() {

        int damage = player.getAttributeMaximum(BaseActorAttributes.HEALTH);
        return new IntrinsicWeapon(damage, "bonks", 100);
    }

    /**
     * Method to create new SuspiciousAstronautObject
     * @return new SuspciousAstronaut object
     */
    @Override
    public Actor create() {
        return new SuspiciousAstronaut(player);
    }

    /**
     * Gets the chance of SuspiciousAstronaut object spawning
     * @return float chance of spawning
     */
    @Override
    public double getSpawnChance() {
        return 0.05;
    }

}
