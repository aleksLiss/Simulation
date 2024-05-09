package Simulation;

import Simulation.Entitis.BasicEntity.Entity;
import Simulation.Entitis.MoovableEntytyis.Creature;
import Simulation.Entitis.MoovableEntytyis.Herbivore;
import Simulation.Entitis.MoovableEntytyis.Predator;
import Simulation.Entitis.StaticEntytyisImpl.Grass;
import Simulation.Entitis.StaticEntytyisImpl.Rock;
import Simulation.Entitis.StaticEntytyisImpl.StaticEnt;
import Simulation.Entitis.StaticEntytyisImpl.Tree;

import java.util.HashMap;
import java.util.Map;

public class Storage {
    public Map<Coordinate, Entity> staticStorage;
    public Map<Coordinate, Creature> movableStorage;

    public Storage() {
        this.staticStorage = new HashMap<>();
        this.movableStorage = new HashMap<>();
    }


    public Coordinate getCoordinateForEntity(Switcher switcher, Entity entity) {
        Coordinate coordinate = null;
        switch (switcher) {
            case STATIC:
                for (Map.Entry entry : staticStorage.entrySet()) {
                    if (entity.equals(entry.getValue())) {
                        coordinate = (Coordinate) entry.getKey();
                    }
                }
                break;
            case MOVABLE:
                for (Map.Entry entry : movableStorage.entrySet()) {
                    if (entity.equals(entry.getValue())) {
                        coordinate = (Coordinate) entry.getKey();
                        movableStorage.remove(entry.getKey());
                        break;
                    }
                }
                break;
        }
        return coordinate;
    }

    public Map<Coordinate, Entity> getStaticStorage() {
        return staticStorage;
    }


    public Map<Coordinate, Creature> getMovableStorage() {
        return movableStorage;
    }

    public void addToStorage(Switcher switcher, Coordinate coordinate, Entity entity) {
        switch (switcher) {
            case MOVABLE:
                Creature creature = (Creature) entity;
                movableStorage.put(coordinate, creature);
                System.out.printf("INFO: ADD [%s: x=%d;y=%d] TO STORAGE\n", creature.getName(), coordinate.getX(), coordinate.getY());
                break;
            case STATIC:
                StaticEnt staticEnt = (StaticEnt) entity;
                staticStorage.put(coordinate, staticEnt);
                break;
        }
    }

    public void removeFromStorage(Switcher switcher, Entity entity) {
        switch (switcher) {
            case STATIC:
                Grass grass = (Grass) entity;
                for (Map.Entry entry : staticStorage.entrySet()) {
                    if (entry.getValue().equals(grass)) {
                        staticStorage.remove(entity);
                        break;
                    }
                }
                break;
            case MOVABLE:
                Creature creature = (Creature) entity;
                if (movableStorage.size() == 0) {
                    break;
                } else {
                    for (Map.Entry entry : movableStorage.entrySet()) {
                        if (entry.getValue().equals(creature)) {
                            Coordinate coordinate = (Coordinate) entry.getKey();
                            System.out.printf("INFO: REMOVED [%s: x=%d; y=%d] FROM STORAGE\n", creature.getName(), coordinate.getX(), coordinate.getY());
                            movableStorage.remove(entry.getKey());
                        }
                    }
                }
                break;
        }
    }


    public void fillDefaultMovable() {
        this.movableStorage.put(new Coordinate(2, 2), new Herbivore(this, 1.0));
        this.movableStorage.put(new Coordinate(7, 8), new Predator());
    }

    public void fillDefaultStatic() {
        staticStorage.put(new Coordinate(3, 5), new Rock());
        staticStorage.put(new Coordinate(6, 8), new Rock());

        staticStorage.put(new Coordinate(8, 8), new Tree());
        staticStorage.put(new Coordinate(7, 9), new Tree());

        staticStorage.put(new Coordinate(2, 5), new Grass());
        staticStorage.put(new Coordinate(6, 6), new Grass());
    }
}

