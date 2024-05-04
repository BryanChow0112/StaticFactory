package game.actors;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.actors.attributes.BaseActorAttributes;
import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;
import game.behaviours.AttackBehaviour;

public class SuspiciousAstronaut extends Enemy implements Spawnable {
    Player player;

    public SuspiciousAstronaut(Player player) {
        super("Suspicious Astronaut", 'ඞ', 99);
        this.player = player;
        this.addBehaviour(ATTACK_PRIORITY, new AttackBehaviour());
    }

    @Override
    public IntrinsicWeapon getIntrinsicWeapon() {

        int damage = player.getAttributeMaximum(BaseActorAttributes.HEALTH);
        return new IntrinsicWeapon(damage, "bonks", 100);
    }

    @Override
    public Actor create() {
        return new SuspiciousAstronaut(player);
    }

    @Override
    public double getSpawnChance() {
        return 0.05;
    }

}
