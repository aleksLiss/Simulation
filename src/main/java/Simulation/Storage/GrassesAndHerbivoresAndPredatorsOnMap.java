package Simulation.Storage;

import Simulation.Coordinate;
import Simulation.Entityis.BasicEntity.Entity;
import Simulation.Entityis.MoovableEntytyis.Herbivore;
import Simulation.Entityis.MoovableEntytyis.Predator;
import Simulation.Entityis.StaticEntytyisImpl.Grass;

import java.util.HashMap;
import java.util.Map;

public class GrassesAndHerbivoresAndPredatorsOnMap {
    private Map<Coordinate, Herbivore> herbivores;
    private Map<Coordinate, Grass> grasses;
    private Map<Coordinate, Predator> predators;
    public GrassesAndHerbivoresAndPredatorsOnMap() {
        this.herbivores = new HashMap<>();
        this.predators = new HashMap<>();
        this.grasses = new HashMap<>();
    }

    public void addEntityToStorage(Switcher switcher, int x, int y, Entity entity) {
        switch (switcher) {
            case GRASS:
                grasses.put(new Coordinate(x, y), (Grass) entity);
                break;
            case HERBIVORE:
                herbivores.put(new Coordinate(x, y), (Herbivore) entity);
                break;
            case PREDATOR:
                predators.put(new Coordinate(x, y), (Predator) entity);
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
    public void updateEntity(Switcher switcher, int x, int y, Entity entity) {
        removeEntityFromMap(switcher, entity);
        addEntityToStorage(switcher, x, y, entity);
    }

    public Coordinate getEntityFromMap(Switcher switcher) {
        Coordinate coordinate = null;
        switch (switcher) {
            case GRASS:
                for (Map.Entry entry : grasses.entrySet()) {
                    coordinate = (Coordinate) entry.getKey();
                }
                break;
            case HERBIVORE:
                for (Map.Entry entry : herbivores.entrySet()) {
                    coordinate = (Coordinate) entry.getKey();
                    break;
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
}

