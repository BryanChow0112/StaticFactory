package game.actors;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actions.DoNothingAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.actors.Behaviour;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;
import game.actions.AttackAction;
import game.types.Status;

import java.util.ArrayList;

/**
 * An abstract class representing an enemy in the game.
 * Enemies are hostile to the player and can have behaviors that determine their actions.
 */
public abstract class Enemy extends Actor {
    private final ArrayList<Behaviour> behaviours = new ArrayList<>();

    /**
     * Constructs a new Enemy object.
     *
     * @param name        The name of the enemy.
     * @param displayChar The character used to represent the enemy on the display.
     * @param hitPoints   The initial hit points of the enemy.
     */
    public Enemy(String name, char displayChar, int hitPoints) {
        super(name, displayChar, hitPoints);
        this.addCapability(Status.HOSTILE_TO_PLAYER);
    }

    /**
     * Adds a behaviour to the enemy.
     *
     * @param behaviour The behaviour to be added.
     */
    public void addBehaviour(Behaviour behaviour) {
        this.behaviours.add(behaviour);
    }

    @Override
    public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {
        for (Behaviour behaviour : behaviours) {
            Action action = behaviour.getAction(this, map);
            if (action != null)
                return action;
        }
        return new DoNothingAction();
    }

    /**
     * Returns the intrinsic weapon of the enemy.
     * This method must be implemented by concrete subclasses.
     *
     * @return The intrinsic weapon of the enemy.
     */
    @Override
    public abstract IntrinsicWeapon getIntrinsicWeapon();

    @Override
    public ActionList allowableActions(Actor otherActor, String direction, GameMap map) {
        ActionList actions = new ActionList();
        if (otherActor.hasCapability(Status.HOSTILE_TO_ENEMY)) {
            actions.add(new AttackAction(this, direction));
        }
        return actions;
    }
}
