package game.scraps.special;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.actors.attributes.BaseActorAttributes;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.Location;
import game.types.Buyable;
import game.types.Monologuer;
import game.utils.BuyUtils;
import game.utils.RandomUtils;

import java.util.ArrayList;
import java.util.List;

public class Astley extends Item implements Buyable, Monologuer {

    private static final int WORTH_IN_CREDITS = 50;

    private static final List<String> monologueOptions = new ArrayList<>();

    /**
     * Constructs a new Astley object.
     */
    public Astley() {
        super("Astley, an AI Device", 'z', true);
    }

    /**
     * Inform a carried Item of the passage of time.
     * This method is called once per turn, if the Item is being carried.
     *
     * @param currentLocation The location of the actor carrying this Item.
     * @param actor           The actor carrying this Item.
     */
    @Override
    public void tick(Location currentLocation, Actor actor) {
        this.generateMonologue(actor);
    }

    @Override
    public String buy(Actor actor) {
        return BuyUtils.buyItem(actor, this, WORTH_IN_CREDITS);
    }

    @Override
    public int getCost() {
        return WORTH_IN_CREDITS;
    }

    @Override
    public String generateMonologue(Actor actor) {

        // available from the start
        monologueOptions.add("The factory will never gonna give you up, valuable intern!");
        monologueOptions.add("We promise we never gonna let you down with a range of staff benefits.");
        monologueOptions.add("We never gonna run around and desert you, dear intern!");

        // if the intern has more than 10 items in their inventory
        if (actor.getItemInventory().size() > 10) {
            monologueOptions.add("We never gonna make you cry with unfair compensation.");
        }
        // if the intern carries more than 50 credits in their wallet
        if (actor.getBalance() > 50) {
            monologueOptions.add("Trust is essential in this business. We promise we never gonna say goodbye to a valuable intern like you.");
        }
        // if the intern’s health point is below 2
        if (actor.getAttribute(BaseActorAttributes.HEALTH) < 2) {
            monologueOptions.add("Don't worry, we never gonna tell a lie and hurt you, unlike those hostile creatures.");
        }

        // Randomly select monologue from monologueOptions
        return monologueOptions.get(RandomUtils.getRandomInt(monologueOptions.size()));
    }

}
