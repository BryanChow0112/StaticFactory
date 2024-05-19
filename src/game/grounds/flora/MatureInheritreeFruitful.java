package game.grounds.flora;

import edu.monash.fit2099.engine.positions.Location;
import game.scraps.special.Fruit;
import game.scraps.special.LargeFruit;

public class MatureInheritreeFruitful extends FruitfulTree {


    public MatureInheritreeFruitful() {
        super('T');
    }

    @Override
    public void tick(Location location){
        produceFruit(location);
    }
    @Override
    public Fruit getFruit() {
        return new LargeFruit();
    }

    @Override
    public int getSpawnChance() {
        return 20;
    }
}
