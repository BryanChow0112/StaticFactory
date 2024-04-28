package game.scraps.special;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import game.actions.ConsumeAction;
import game.scraps.Consumable;
import game.scraps.Scrap;

public class PotOfGold extends Scrap implements Consumable {
    private static final int CREDIT_POINTS = 10;

    public PotOfGold() {
        super("Pot of Gold", '$');
    }

    @Override
    public ActionList allowableActions(Actor owner) {
        ActionList actionList = new ActionList();
        actionList.add(new ConsumeAction(this));
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
        actor.addBalance(CREDIT_POINTS);
        actor.removeItemFromInventory(this);
        return actor + " has increased credits by " + CREDIT_POINTS +  " credits.";
    }

}
