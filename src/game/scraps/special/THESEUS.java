package game.scraps.special;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.Location;
import game.actions.ConsumeAction;
import game.actions.TeleportAction;
import game.types.Buyable;
import game.types.Consumable;
import game.utils.BuyUtils;
import game.utils.RandomUtils;

public class THESEUS extends Item implements Buyable {
    private static final int WORTH_IN_CREDITS = 100;

    public THESEUS() {
        super("THESEUS", '^', true);
    }

    @Override
    public ActionList allowableActions(Location location) {
        // add actions in here
        int xVal = RandomUtils.getRandomInt(location.map().getXRange().max());
        int yVal = RandomUtils.getRandomInt(location.map().getYRange().max());

        ActionList actionList = new ActionList();
        actionList.add(new TeleportAction("",location.map().at(xVal,yVal)));
        return actionList;
    }

    @Override
    public String buy(Actor actor) {
        return BuyUtils.buyItem(actor, this, WORTH_IN_CREDITS);
    }

    @Override
    public int getCost() {
        return WORTH_IN_CREDITS;
    }

}