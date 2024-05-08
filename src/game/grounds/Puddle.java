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



public class Puddle extends Ground implements Consumable {
    private final static int INCREASE_HP = 1;
    public Puddle() {
        super('~');
    }

    @Override
    public String handleConsume(Actor actor) {
        actor.modifyAttributeMaximum(BaseActorAttributes.HEALTH, ActorAttributeOperations.INCREASE, INCREASE_HP);
        return actor + " consumes the puddle to increase max health by " + INCREASE_HP + " HP.";
    }

    @Override
    public ActionList allowableActions(Actor actor, Location location, String direction){
        ActionList actionList = new ActionList();
        if (Objects.equals(direction, "")){
            actionList.add(new ConsumeAction(this));
        }
        return actionList;
    }
    @Override
    public String toString(){
        return "the puddle underneath the player";
    }
}
