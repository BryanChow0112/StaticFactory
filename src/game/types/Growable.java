package game.types;

import edu.monash.fit2099.engine.positions.Location;
import game.grounds.flora.PlantBase;

public interface Growable {


    PlantBase nextStage();

    int growAge();

    void grow(Location location);

    boolean isMature();


}
