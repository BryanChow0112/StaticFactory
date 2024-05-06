package game.scraps.special;

import edu.monash.fit2099.engine.actors.Actor;
import game.scraps.Scrap;
import game.types.Buyable;
import game.utils.BuyUtils;
import game.utils.RandomUtils;

import java.util.Scanner;

public class ToiletPaperRoll extends Scrap implements Buyable {
    private static final int WORTH_IN_CREDITS = 5;
    private static final double DISCOUNT_CHANCE = 0.75;
    private static final int DISCOUNTED_COST = 1;

    public ToiletPaperRoll() {
        super("Toilet Paper Roll", 's', true);
    }

    @Override
    public String buy(Actor actor) {
        double randDouble = RandomUtils.getRandomDouble();
        Scanner scanner = new Scanner(System.in);

        if (randDouble < DISCOUNT_CHANCE) {
            System.out.println("The computer terminal is offering you a " + this + " for " + DISCOUNTED_COST + " credits. Do you want to purchase it? (y/n)");
            String choice = scanner.nextLine().toLowerCase();

            if (choice.equals("y") && actor.getBalance() >= DISCOUNTED_COST) {
                return BuyUtils.buyItem(actor, this, DISCOUNTED_COST);
            } else {
                return "Purchase cancelled.";
            }
        } else {
            return BuyUtils.buyItem(actor, this, WORTH_IN_CREDITS);
        }
    }

    @Override
    public int getCost() {
        return WORTH_IN_CREDITS;
    }
}
