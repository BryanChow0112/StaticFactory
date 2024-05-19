package game.grounds.flora;


import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.Location;
import game.scraps.special.Fruit;
import game.utils.RandomUtils;


public abstract class FruitfulTree extends PlantBase {

    private int age;
    public FruitfulTree(char displayChar) {
        super(displayChar);
    }

    public void produceFruit(Location location) {
        if (RandomUtils.getRandomInt(100) <= getSpawnChance()) {
            Exit randomExit = RandomUtils.getRandomExit(location);
            Location exitLocation = randomExit.getDestination();
            exitLocation.addItem(getFruit());
        }
    }
    @Override
    public void tick(Location location) {
        super.tick(location);

    }

    public abstract Fruit getFruit();
    public abstract int getSpawnChance();
}