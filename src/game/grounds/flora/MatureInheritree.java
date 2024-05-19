package game.grounds.flora;

import edu.monash.fit2099.engine.positions.Location;
import game.scraps.special.Fruit;
import game.scraps.special.LargeFruit;
import game.utils.RandomUtils;

public class MatureInheritree extends PlantBase implements DropFruit {
    /**
     * Constructs a new PlantBase object with the specified display character.
     *
     * @param displayChar character to display for this type of terrain
     */
    public MatureInheritree() {
        super('T');
    }

    @Override
    public int getSpawnChance() {
        return 20;
    }

    @Override
    public Fruit getFruit() {
        return new LargeFruit();
    }

    @Override
    public void tick(Location location) {

        if (RandomUtils.getRandomInt(100) <= getSpawnChance()) {
            produceFruit(location);
        }
    }

}