package game.types;

import edu.monash.fit2099.engine.actors.Actor;

/**
 * An interface representing objects that can generate monologues.
 */
public interface Monologuer {

    /**
     * Generates a monologue based on the given actor's state.
     *
     * @param actor The actor listening to the monologue.
     * @return A string representing the generated monologue.
     */
    String generateMonologue(Actor actor);
}
