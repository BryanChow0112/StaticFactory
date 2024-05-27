package game.actors;

import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;
import game.behaviours.AttackBehaviour;

/**
 * Class that represents SuspiciousAstronaut enemy
 */
public class SuspiciousAstronaut extends Enemy {

    /**
     * A constant that represents the priority of the attack behaviour.
     */
    public static final int ATTACK_PRIORITY = 0;

    /**
     * A constant that represents the attack damage of the SuspiciousAstronaut.
     */
    public static final int ATTACK_DAMAGE = Integer.MAX_VALUE;

    /**
     * Constructs new SuspiciousAstronaut object
     */
    public SuspiciousAstronaut() {
        super("Suspicious Astronaut", 'ඞ', 99);
        this.addBehaviour(ATTACK_PRIORITY, new AttackBehaviour());
    }

    /**
     * Method to get SuspiciousAstronauts intrinsic weapon
     *
     * @return SuspiciousAstronaut intrinsic weapon
     */
    @Override
    public IntrinsicWeapon getIntrinsicWeapon() {
        return new IntrinsicWeapon(ATTACK_DAMAGE, "bonks", 100);
    }

}
