package game.actors;

import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;
import game.behaviours.AttackBehaviour;

/**
 * Represents a Huntsman Spider enemy in the game.
 * The Huntsman Spider is a spawnable enemy with attack and wander behaviors.
 */
public class HuntsmanSpider extends Enemy{

    /**
     * A constant that represents the priority of the attack behaviour.
     */
    public static final int ATTACK_PRIORITY = 0;

    /**
     * Constructs a new HuntsmanSpider object.
     */
    public HuntsmanSpider() {
        super("Huntsman Spider", '8', 1);
        // Add the AttackBehaviour with priority 0 to ensure the HuntsmanSpider
        // attacks any nearby players before executing other behaviors
        this.addBehaviour(ATTACK_PRIORITY, new AttackBehaviour());
    }

    /**
     * Returns the intrinsic weapon of the Huntsman Spider.
     *
     * @return The intrinsic weapon of the Huntsman Spider.
     */
    @Override
    public IntrinsicWeapon getIntrinsicWeapon() {
        int damage = 1;
        return new IntrinsicWeapon(damage, "stabs", 25);
    }

}
