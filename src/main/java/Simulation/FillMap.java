package Simulation;

import Simulation.Entityis.BasicEntity.Entity;
import Simulation.Entityis.MoovableEntytyis.Herbivore;
import Simulation.Entityis.MoovableEntytyis.Predator;
import Simulation.Entityis.StaticEntytyisImpl.Empty;
import Simulation.Entityis.StaticEntytyisImpl.Grass;
import Simulation.Entityis.StaticEntytyisImpl.Rock;
import Simulation.Entityis.StaticEntytyisImpl.Tree;


import java.util.HashMap;
import java.util.Map;

public class FillMap {
    private Simulation simulation;
    private GrassesAndHerbivoresAndPredatorsOnMap storage;

    public FillMap(Simulation simulation, GrassesAndHerbivoresAndPredatorsOnMap storage) {
        this.simulation = simulation;
        this.storage = storage;
    }

    public void fillMoovable() {
        storage.putIntoMoovableStorage(new Coordinate(2, 2), new Herbivore());
        storage.putIntoMoovableStorage(new Coordinate(7, 8), new Predator());
    }

    public void fillStatic(){
        storage.putIntoStaticStorage(new Coordinate(3, 5), new Rock());
        storage.putIntoStaticStorage(new Coordinate(6, 8), new Rock());

        storage.putIntoStaticStorage(new Coordinate(8, 8), new Tree());
        storage.putIntoStaticStorage(new Coordinate(7, 9), new Tree());

        storage.putIntoStaticStorage(new Coordinate(2, 5), new Grass());
        storage.putIntoStaticStorage(new Coordinate(6, 6), new Grass());
    }
}
