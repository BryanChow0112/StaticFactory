package game.grounds;

import java.util.Objects;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.actors.attributes.ActorAttributeOperations;
import edu.monash.fit2099.engine.actors.attributes.BaseActorAttributes;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.actions.ConsumeAction;
import game.types.Consumable;
import game.types.Status;


/**
 * Class that represents puddle ground on the map
 */
public class Puddle extends Ground implements Consumable {
    /**
     * Attribute that holds the amount of HP that is increased from puddle
     */
    private final static int INCREASE_HP = 1;

    /**
     * Constructs a new puddle object
     */
    public Puddle() {
        super('~');
    }

    /**
     * Method that handles the consume action
     *
     * @param actor The actor consuming the item.
     * @return string to be displayed for successful consume
     */
    @Override
    public String handleConsume(Actor actor) {
        actor.modifyAttributeMaximum(BaseActorAttributes.HEALTH, ActorAttributeOperations.INCREASE, INCREASE_HP);
        return actor + " consumes the puddle to increase max health by " + INCREASE_HP + " HP.";
    }

    /**
     * Method that get all the allowable actions
     *
     * @param actor     the Actor acting
     * @param location  the current Location
     * @param direction the direction of the Ground from the Actor
     * @return list of actions that are allowed
     */
    @Override
    public ActionList allowableActions(Actor actor, Location location, String direction) {
        ActionList actionList = new ActionList();
        // Check if there is an actor standing on the puddle
        if (location.containsAnActor()) {
            // Check if the actor (presumably the intern) has the HOSTILE_TO_ENEMY capability
            if (actor.hasCapability(Status.HOSTILE_TO_ENEMY)) {
                actionList.add(new ConsumeAction(this));
            }
        }
        return actionList;
    }

    /**
     * toString method once it is consumed
     *
     * @return string
     */
    @Override
    public String toString() {
        return "the puddle underneath the player";
    }
}
