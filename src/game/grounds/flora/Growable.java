package game.grounds.flora;

import edu.monash.fit2099.engine.positions.Location;

public interface Growable {


    PlantBase nextStage();

    int growAge();

    void grow(Location location);

    boolean isMature();


}
