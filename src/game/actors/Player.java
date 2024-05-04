package game.actors;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.actors.attributes.BaseActorAttributes;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.displays.Menu;
import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;
import game.displays.FancyMessage;
import game.types.Ability;
import game.types.Status;

/**
 * Class representing the Player.
 * Created by:
 *
 * @author Adrian Kristanto
 * Modified by:
 */
public class Player extends Actor {
    /**
     * Constructor.
     *
     * @param name        Name to call the player in the UI
     * @param displayChar Character to represent the player in the UI
     * @param hitPoints   Player's starting number of hitpoints
     */
    public Player(String name, char displayChar, int hitPoints) {
        super(name, displayChar, hitPoints);
        this.addCapability(Status.HOSTILE_TO_ENEMY);
        this.addCapability(Ability.PICK_UP_SCRAP);
        this.addCapability(Ability.DROP_SCRAP);
        this.addCapability(Ability.ENTER_SPACESHIP);
    }

    @Override
    public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {
        // Handle multi-turn Actions
        if (lastAction.getNextAction() != null)
            return lastAction.getNextAction();

        // return/print the console menu
        Menu menu = new Menu(actions);
        // Displays the player's name
        display.println(this.name);
        // Displays the player's current health and maximum health
        display.println("HP: " + this.getAttribute(BaseActorAttributes.HEALTH) + "/" + this.getAttributeMaximum(BaseActorAttributes.HEALTH));
        return menu.showMenu(this, display);
    }

    /**
     * Creates and returns the intrinsic weapon of the Player (their bare fists)
     *
     * @return a freshly-instantiated IntrinsicWeapon (their bare fists)
     */
    @Override
    public IntrinsicWeapon getIntrinsicWeapon() {
        return new IntrinsicWeapon(1, "punches", 5);
    }

    @Override
    public String unconscious(Actor actor, GameMap map) {
        map.removeActor(this);
        for (String line : FancyMessage.YOU_ARE_FIRED.split("\n")) {
            System.out.println(line);
            try {
                Thread.sleep(200);
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        }
        return this + " met their demise at the hand of " + actor;
    }

}
