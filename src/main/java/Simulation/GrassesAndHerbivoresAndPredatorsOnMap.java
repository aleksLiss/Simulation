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
    private Map<Coordinate, Herbivore> herbivores;
    private Map<Coordinate, Grass> grasses;
    private Map<Coordinate, Predator> predators;
    private Map<Coordinate, Entity> staticStorage;
    private Map<Coordinate, Creature> moovableStorage;
    public GrassesAndHerbivoresAndPredatorsOnMap() {
        this.herbivores = new HashMap<>();
        this.predators = new HashMap<>();
        this.grasses = new HashMap<>();
        this.staticStorage = new HashMap<>();
        this.moovableStorage = new HashMap<>();
    }

    /*
    public void putEntityToStorage(Switcher switcher, Coordinate coordinate, Entity entity) {
        switch (switcher) {
            case GRASS:
                grasses.put(coordinate, (Grass) entity);
                break;
            case HERBIVORE:
                herbivores.put(coordinate, (Herbivore) entity);
                break;
            case PREDATOR:
                predators.put(coordinate, (Predator) entity);
                break;
        }
    }
    public void removeEntityFromMap(Switcher switcher, Entity entity) {
        switch (switcher) {
            case GRASS:
                grasses.remove((Grass) entity);
                break;
            case HERBIVORE:
                herbivores.remove((Herbivore) entity);
                break;
            case PREDATOR:
                predators.remove((Predator) entity);
                break;
        }
    }

    public Coordinate getCoordinateOnMap(Switcher switcher, Entity entity) {
        Coordinate coordinate = null;
        switch (switcher) {
            case GRASS:
                for (Map.Entry entry : grasses.entrySet()) {
                    coordinate = (Coordinate) entry.getKey();
                }
                break;
            case HERBIVORE:
                for (Map.Entry entry : herbivores.entrySet()) {
                    if(entity.equals(entry.getValue())){
                        coordinate = (Coordinate) entry.getKey();
                    }
                }
                break;
            case PREDATOR:
                for (Map.Entry entry : predators.entrySet()) {
                    coordinate = (Coordinate) entry.getKey();
                }
                break;
        }
        return coordinate;
    }

    public Map<Coordinate, Herbivore> getHerbivores(){
        return herbivores;
    }

    public Map<Coordinate, Grass> getGrasses() {
        return grasses;
    }

    public Map<Coordinate, Predator> getPredators() {
        return predators;
    }

    */
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
}

