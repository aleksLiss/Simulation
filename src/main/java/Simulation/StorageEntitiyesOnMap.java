package Simulation;

import Simulation.Entityis.BasicEntity.Entity;
import Simulation.Entityis.MoovableEntytyis.Creature;
import Simulation.Entityis.MoovableEntytyis.Herbivore;
import Simulation.Entityis.MoovableEntytyis.Predator;
import Simulation.Entityis.StaticEntytyisImpl.Grass;
import Simulation.Entityis.StaticEntytyisImpl.Rock;
import Simulation.Entityis.StaticEntytyisImpl.Tree;

import java.util.HashMap;
import java.util.Map;

public class StorageEntitiyesOnMap {
    private Map<Coordinate, Entity> staticStorage;
    private Map<Coordinate, Creature> moovableStorage;
    public StorageEntitiyesOnMap() {
        this.staticStorage = new HashMap<>();
        this.moovableStorage = new HashMap<>();
    }

    public Coordinate getCoordinateOfCreature(Creature creature){
        Coordinate result = null;
        for(Map.Entry entry: moovableStorage.entrySet()){
            if(entry.getValue().equals(creature)){
                result = (Coordinate) entry.getKey();
            }
        }
        return result;
    };
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

    public void fillMoovable() {
        moovableStorage.put(new Coordinate(2, 2), new Herbivore());
        moovableStorage.put(new Coordinate(7, 8), new Predator());
    }

    public void fillStatic(){
        staticStorage.put(new Coordinate(3, 5), new Rock());
        staticStorage.put(new Coordinate(6, 8), new Rock());

        staticStorage.put(new Coordinate(8, 8), new Tree());
        staticStorage.put(new Coordinate(7, 9), new Tree());

        staticStorage.put(new Coordinate(2, 5), new Grass());
        staticStorage.put(new Coordinate(6, 6), new Grass());
    }
}

