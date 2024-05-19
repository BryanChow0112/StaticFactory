package game.grounds.flora;

import edu.monash.fit2099.engine.positions.Location;
import game.types.Growable;

public class YoungInheritree extends NonFruitfulTree implements Growable {

    private int age;
    /**
     * Constructs a new PlantBase object with the specified display character.
     *
     * @param displayChar character to display for this type of terrain
     */
    public YoungInheritree() {
        super('y');
    }


    @Override
    public void tick(Location location){
        grow(location);
    }

    @Override
    public PlantBase nextStage() {
        return new MatureInheritree();
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
        }
    }

    @Override
    public boolean isMature() {
        return age >= growAge();
    }
}
