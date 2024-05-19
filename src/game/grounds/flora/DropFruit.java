package game.grounds.flora;

import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.Location;
import game.scraps.special.Fruit;
import game.utils.RandomUtils;

public interface DropFruit {
    default void produceFruit(Location location){
        Exit randomExit = RandomUtils.getRandomExit(location);
        Location exitLocation = randomExit.getDestination();
        exitLocation.addItem(getFruit());
    }



    int getSpawnChance();

    Fruit getFruit();

    default void tick(Location location) {
        if (RandomUtils.getRandomInt(100) <= getSpawnChance()) {
            produceFruit(location);
        }
    }
}
