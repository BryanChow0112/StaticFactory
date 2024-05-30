package game.scraps.special;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import game.actions.ConsumeAction;
import game.actions.SellAction;
import game.types.Ability;
import game.types.Consumable;
import game.types.Sellable;
import game.utils.RandomUtils;
import game.utils.SellUtils;

public class JarOfPickles extends Item implements Consumable, Sellable {
    private static final int HIT_POINTS = 1;
    private static final int CREDITS_TO_SELL = 25;
    private static final int MARKED_UP_CREDITS_TO_SELL = 50;

    /**
     * Constructs a new LargeFruit object.
     */
    public JarOfPickles() {
        super("Jar of Pickles", 'n', true);
    }

    /**
     * Returns the list of actions that can be performed with this item.
     *
     * @param owner The actor that owns this item.
     * @return The list of allowable actions for this item.
     */
    @Override
    public ActionList allowableActions(Actor owner) {
        ActionList actionList = new ActionList();
        actionList.add(new ConsumeAction(this));
        return actionList;
    }

    @Override
    public ActionList allowableActions(Actor otherActor, Location location) {
        ActionList actionList = new ActionList();
        if (otherActor.hasCapability(Ability.PURCHASE_ITEMS)) {
            actionList.add(new SellAction(otherActor, this));
        }
        return actionList;
    }

    /**
     * Handles the consumption of this item by the actor.
     *
     * @param actor The actor consuming this item.
     * @return A description of the consumption effect.
     */
    @Override
    public String handleConsume(Actor actor) {

        if (RandomUtils.getRandomInt(100) <= 50) {
            // if less than 50% chance, it decreases player hp by 1
            actor.heal(HIT_POINTS * -1);
            actor.removeItemFromInventory(this);
            return actor + " consumes Jar of Pickles to heal " + HIT_POINTS * -1 + " hit points.";
        } else {
            // if greater than 50% chance, it increases player hp by 1
            actor.heal(HIT_POINTS);
            actor.removeItemFromInventory(this);
            return actor + " consumes Jar of Pickles to heal " + HIT_POINTS + " hit points.";
        }
    }

    @Override
    public String sell(Actor actorSelling, Actor actorToSellTo, GameMap map) {
        //  If the intern attempts to sell this item, there is a 50% chance
        //  that the factory will pay double the price,
        //  paying the intern 50 credits instead.
        if (RandomUtils.getRandomInt(100) <= 50) {
            return SellUtils.sellItem(actorSelling, actorToSellTo, this, MARKED_UP_CREDITS_TO_SELL);
        }
        return SellUtils.sellItem(actorSelling, actorToSellTo, this, CREDITS_TO_SELL);
    }

    @Override
    public int getSellCost() {
        return CREDITS_TO_SELL;
    }
}
