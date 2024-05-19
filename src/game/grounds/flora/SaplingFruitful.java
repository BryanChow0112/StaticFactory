package game.grounds.flora;

import edu.monash.fit2099.engine.positions.Location;
import game.scraps.special.Fruit;
import game.scraps.special.SmallFruit;

public class SaplingFruitful extends FruitfulTree implements Growable{

    private int age;
    public SaplingFruitful() {
        super('t');
    }

    @Override
    public void tick(Location location){
        produceFruit(location);
        grow(location);
    }
    @Override
    public Fruit getFruit() {
        return new SmallFruit();
    }

    @Override
    public int getSpawnChance() {
        return 30;
    }

    @Override
    public PlantBase nextStage() {
        return new YoungInheritreeNonFruitful();
    }

    @Override
    public int growAge() {
        return 6;
    }

    @Override
    public void grow(Location location) {
        age++;
        if (isMature()){
            location.setGround(nextStage());
        };
    }

    @Override
    public boolean isMature() {
        return age >= growAge();
    }
}
