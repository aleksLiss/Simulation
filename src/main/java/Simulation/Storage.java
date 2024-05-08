package Simulation;

import Simulation.Entitis.BasicEntity.Entity;
import Simulation.Entitis.MoovableEntytyis.Creature;
import Simulation.Entitis.MoovableEntytyis.Herbivore;
import Simulation.Entitis.MoovableEntytyis.Predator;
import Simulation.Entitis.StaticEntytyisImpl.Grass;
import Simulation.Entitis.StaticEntytyisImpl.Rock;
import Simulation.Entitis.StaticEntytyisImpl.Tree;

import java.util.HashMap;
import java.util.Map;

public class Storage {
    private Map<Coordinate, Entity> staticStorage;
    private Map<Coordinate, Creature> movableStorage;
    public Storage() {
        this.staticStorage = new HashMap<>();
        this.movableStorage = new HashMap<>();
    }









    public Coordinate getCoordinateOfCreature(Creature creature){
        Coordinate result = null;
        for(Map.Entry entry: movableStorage.entrySet()){
            if(entry.getValue().equals(creature)){
                result = (Coordinate) entry.getKey();
            }
        }
        return result;
    };


    public Coordinate getStaticEntity(Entity entity){
        Coordinate result = null;
        for(Map.Entry entry: staticStorage.entrySet()){
            if(entity.equals(entry.getValue())){
                result = (Coordinate) entry.getKey();
            }
        }
        return result;
    }



    public Map<Coordinate, Entity> getStaticStorage() {
        return staticStorage;
    }

    public void putIntoStaticStorage(Coordinate coordinate, Entity entity){
        staticStorage.put(coordinate, entity);
    }

    public Map<Coordinate, Creature> getMovableStorage() {
        return movableStorage;
    }

    public void putIntoMovableStorage(Coordinate coordinate, Creature creature){
        movableStorage.put(coordinate, creature);
    }
    public void removeFromStaticStorage(Entity entity){
        staticStorage.remove(entity);
    }
    public void removeFromMovableStorage(Creature creature){
        movableStorage.remove(creature);
    }

    public void fillDefaultMoovable() {
        movableStorage.put(new Coordinate(2, 2), new Herbivore(this));
        movableStorage.put(new Coordinate(7, 8), new Predator());
    }

    public void fillDefaultStatic(){
        staticStorage.put(new Coordinate(3, 5), new Rock());
        staticStorage.put(new Coordinate(6, 8), new Rock());

        staticStorage.put(new Coordinate(8, 8), new Tree());
        staticStorage.put(new Coordinate(7, 9), new Tree());

        staticStorage.put(new Coordinate(2, 5), new Grass());
        staticStorage.put(new Coordinate(6, 6), new Grass());
    }
}

