package game.actors;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actions.DoNothingAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.actors.Behaviour;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.GameMap;
import game.actions.AttackAction;
import game.behaviours.WanderBehaviour;
import game.types.Status;

import java.util.Map;
import java.util.TreeMap;

/**
 * An abstract class representing an enemy in the game.
 * Enemies are hostile to the player and can have behaviors that determine their actions.
 */
public abstract class Enemy extends Actor {

    private final Map<Integer, Behaviour> behaviours = new TreeMap<>();

    /**
     * Constructs a new Enemy object.
     *
     * @param name        The name of the enemy.
     * @param displayChar The character used to represent the enemy on the display.
     * @param hitPoints   The initial hit points of the enemy.
     */
    public Enemy(String name, char displayChar, int hitPoints) {
        super(name, displayChar, hitPoints);
        this.addBehaviour(999, new WanderBehaviour());
        this.addCapability(Status.HOSTILE_TO_PLAYER);
    }

    /**
     * Select and return an action for the Enemy to perform on the current turn.
     *
     * @param actions    collection of possible Actions for this Actor
     * @param lastAction The Action this Actor took last turn. Can do interesting things in conjunction with Action.getNextAction()
     * @param map        the map containing the Actor
     * @param display    the I/O object to which messages may be written
     * @return the Action to be performed
     */
    @Override
    public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {
        for (Behaviour behaviour : behaviours.values()) {
            Action action = behaviour.getAction(this, map);
            if (action != null)
                return action;
        }
        return new DoNothingAction();
    }

    /**
     * Returns a new collection of the Actions that the otherActor can do to the Enemy.
     *
     * @param otherActor the Actor that might be performing attack
     * @param direction  String representing the direction of the other Actor
     * @param map        current GameMap
     * @return A collection of Actions.
     */
    @Override
    public ActionList allowableActions(Actor otherActor, String direction, GameMap map) {
        ActionList actions = new ActionList();

        // Check if the other actor (presumably the player) has the HOSTILE_TO_ENEMY capability
        if (otherActor.hasCapability(Status.HOSTILE_TO_ENEMY)) {
            // Allow attacking for other actor (player) using the actor's intrinsic weapon
            actions.add(new AttackAction(this, direction));
        }
        return actions;
    }

    /**
     * Adds a behaviour to the enemy
     *
     * @param priority  the priority of the behaviour
     * @param behaviour the behaviour
     */
    public void addBehaviour(int priority, Behaviour behaviour) {
        this.behaviours.put(priority, behaviour);
    }

}
