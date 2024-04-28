package game.actors;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.actors.attributes.BaseActorAttributes;
import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;
import game.behaviours.AttackBehaviour;
import game.behaviours.WanderBehaviour;

public class SuspiciousAstronaut extends Enemy implements Spawnable{
    Player player;
    /**
     * Constructs a new Enemy object.
     *
     * @param name        The name of the enemy.
     * @param displayChar The character used to represent the enemy on the display.
     * @param hitPoints   The initial hit points of the enemy.
     */
    public SuspiciousAstronaut(Player player) {
        super("Suspicious Astronaut", 'ඞ', 99);
        this.player = player;
        this.addBehaviour(new AttackBehaviour());
        this.addBehaviour(new WanderBehaviour());




    @Override
    public Actor create() {
        return new SuspiciousAstronaut(player);
    }

    @Override
    public double getSpawnChance() {
        return 0.05;
    }

}
    @Override
    public IntrinsicWeapon getIntrinsicWeapon() {

        int damage = player.getAttributeMaximum(BaseActorAttributes.HEALTH);
        return new IntrinsicWeapon(damage, "bonks", 100);
    }
}
