package Simulation;

import Simulation.Entityis.BasicEntity.Entity;
import Simulation.Entityis.MoovableEntytyis.Creature;
import Simulation.Entityis.MoovableEntytyis.Herbivore;
import Simulation.Entityis.MoovableEntytyis.Predator;
import Simulation.Entityis.StaticEntytyisImpl.Grass;
import Simulation.Entityis.StaticEntytyisImpl.Rock;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GrassesAndHerbivoresAndPredatorsOnMap {
    private Map<Coordinate, Entity> staticStorage;
    private Map<Coordinate, Creature> moovableStorage;
    public GrassesAndHerbivoresAndPredatorsOnMap() {
        this.staticStorage = new HashMap<>();
        this.moovableStorage = new HashMap<>();
    }

    public Map<Coordinate, Entity> getStaticStorage() {
        return staticStorage;
    }

    public void putIntoStaticStorage(Coordinate coordinate, Entity entity){
        staticStorage.put(coordinate, entity);
    }

    public Map<Coordinate, Creature> getMoovableStorage() {
        return moovableStorage;
    }

    public void putIntoMoovableStorage(Coordinate coordinate, Creature creature){
        moovableStorage.put(coordinate, creature);
    }

    public void removeFromStaticStorage(Entity entity){
        staticStorage.remove(entity);
    }
    public void removeFromMoovableStorage(Creature creature){
        moovableStorage.remove(creature);
    }
}

