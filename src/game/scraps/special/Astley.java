package game.scraps.special;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.actors.attributes.BaseActorAttributes;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.Location;
import game.actions.MonologueAction;
import game.types.Ability;
import game.types.Buyable;
import game.types.Monologuer;
import game.utils.BuyUtils;
import game.utils.RandomUtils;

import java.util.ArrayList;
import java.util.List;

public class Astley extends Item implements Buyable, Monologuer {

    private static final int WORTH_IN_CREDITS = 50;

    // Counter to keep track of ticks for subscription fee payments
    private int counter = 0;

    // Flag to indicate if the subscription is active
    private boolean subscription = true;

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
        counter += 1;
        // need to pay subscription fee every 5 ticks
        if (counter % 5 == 0) {
            // Check if actor has the capability to pay subscription fees
            if (actor.hasCapability(Ability.CAN_PAY_SUBSCRIPTION)) {
                int balance = actor.getBalance();
                // Check if actor has sufficient balance to pay
                if (balance >= 1) {
                    actor.deductBalance(1);
                    subscription = true;
                    System.out.println("Subscription payment received! ヽ(^o^)ノ");

                } else {  // actor unable to pay
                    // Disable subscription
                    subscription = false;
                    System.out.println("Subscription payment not received. (ಠ_ಠ)");
                }
            }
        }

        this.generateMonologue(actor);
    }

    /**
     * List of allowable actions that the item can perform to the current actor
     *
     * @param owner the actor that owns the item
     * @return an unmodifiable list of Actions
     */
    @Override
    public ActionList allowableActions(Actor owner) {
        ActionList actionList = new ActionList();
        if (subscription) {
            actionList.add(new MonologueAction(this));
        }
        return actionList;
    }

    /**
     * Attempts to buy this Astley AI device for the given actor.
     *
     * @param actor The actor attempting to buy the Astley AI device.
     * @return A message indicating the result of the purchase attempt.
     */
    @Override
    public String buy(Actor actor) {
        return BuyUtils.buyItem(actor, this, WORTH_IN_CREDITS);
    }

    /**
     * Returns the cost of this Astley AI device in credits.
     *
     * @return The cost of this Astley AI device in credits.
     */
    @Override
    public int getCost() {
        return WORTH_IN_CREDITS;
    }

    /**
     * Generates a monologue based on the given actor's state.
     *
     * @param actor The actor listening to the monologue.
     * @return A string representing the generated monologue.
     */
    @Override
    public String generateMonologue(Actor actor) {

        // Initialise list of monologue options
        List<String> monologueOptions = new ArrayList<>();

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
