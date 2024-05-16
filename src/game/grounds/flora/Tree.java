package game.grounds.flora;

import game.scraps.special.LargeFruit;

/**
 * Represents a Tree, a type of plant that produces LargeFruit items with 20% chance.
 */
public class Tree extends PlantBase {

    /**
     * Constructs a new Tree object.
     */
    public Tree() {
        super('T');
        this.spawn = new LargeFruit();
        this.spawnChance = 20;
    }
}
