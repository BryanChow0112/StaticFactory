package game.scraps.special;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import game.actions.ConsumeAction;
import game.scraps.Scrap;
import game.types.Buyable;
import game.scraps.Consumable;
import game.utils.BuyUtils;
import game.utils.RandomUtils;

import java.util.Scanner;

public class EnergyDrink extends Scrap implements Buyable, Consumable {
    private static final int WORTH_IN_CREDITS = 10;
    private static final int HIT_POINTS = 1;
    private static final double DOUBLE_COST_CHANCE = 0.2;

    public EnergyDrink() {
        super("Energy Drink", '*', true);
    }

    @Override
    public String buy(Actor actor) {
        double randDouble = RandomUtils.getRandomDouble();
        Scanner scanner = new Scanner(System.in);

        if (randDouble < DOUBLE_COST_CHANCE) {
            int doubleCost = WORTH_IN_CREDITS * 2;
            System.out.println("The computer terminal is asking you to pay " + doubleCost + " credits for " + this + ". Do you want to continue? (y/n)");
            String choice = scanner.nextLine().toLowerCase();

            if (choice.equals("y") && actor.getBalance() >= doubleCost) {
                return BuyUtils.buyItem(actor, this, doubleCost);
            } else {
                return "Purchase cancelled.";
            }
        } else {
            return BuyUtils.buyItem(actor, this, WORTH_IN_CREDITS);
        }
    }

    @Override
    public ActionList allowableActions(Actor owner) {
        ActionList actionList = new ActionList();
        actionList.add(new ConsumeAction(this));
        return actionList;
    }

    @Override
    public int getCost() {
        return WORTH_IN_CREDITS;
    }

    @Override
    public String handleConsume(Actor actor) {
        actor.removeItemFromInventory(this);
        actor.heal(HIT_POINTS);
        return actor + " gains " + HIT_POINTS + " HP from consuming the " + this;
    }

}
