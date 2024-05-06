package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;

public class DeathAction extends Action {

    /**
     * The actor that killed the target
     */
    private Actor attacker;

    /**
     * Constructor of DeathAction.
     *
     * @param attacker the actor that killed the target
     */
    public DeathAction(Actor attacker) {
        this.attacker = attacker;
    }

    @Override
    public String execute(Actor target, GameMap map) {
        String result = "";
        result += "\n" + target.unconscious(attacker, map);

        return result;
    }

    /**
     * Returns a description of DeathAction to be displayed in the menu.
     *
     * @param actor The actor performing the action.
     * @return a string, e.g. "Player is killed."
     */
    @Override
    public String menuDescription(Actor actor) {
        return actor + " is killed.";
    }
}
