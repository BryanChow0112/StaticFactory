package game.scraps.special;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import game.actions.ConsumeAction;
import game.scraps.Consumable;
import game.scraps.Scrap;
import game.utils.RandomUtils;

public class JarOfPickles extends Scrap implements Consumable {
    private static final int HIT_POINTS = 1;

    public JarOfPickles() {
        super("Jar of Pickles", 'n');
    }

    @Override
    public ActionList allowableActions(Actor owner) {
        ActionList actionList = new ActionList();
        actionList.add(new ConsumeAction(this));
        return actionList;
    }

    @Override
    public String handleConsume(Actor actor) {

        if (RandomUtils.getRandomDouble() <= 0.5){
            // if less than 50% chance, it decreases player hp by 1
            actor.heal(HIT_POINTS*-1);
            actor.removeItemFromInventory(this);
            return actor + "consumes Jar of Pickles to heal " + HIT_POINTS*-1 + " hit points.";
        } else {
            // if greater than 50% chance, it increases player hp by 1
            actor.heal(HIT_POINTS);
            actor.removeItemFromInventory(this);
            return actor + "consumes Jar of Pickles to heal " + HIT_POINTS + " hit points.";
        }
    }


    /**
     * Returns a description of the effect of consuming this item.
     *
     * @return A description of the consumption effect.
     */
    @Override
    public String getConsumableDescription() {
        return "heal " + HIT_POINTS + " hit points.";
    }


}
