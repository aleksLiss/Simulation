package Simulation.Map;

import Simulation.Coordinate;
import Simulation.Entityis.BasicEntity.Entity;
import Simulation.Entityis.MoovableEntytyisImpl.Herbivore;
import Simulation.Entityis.MoovableEntytyisImpl.Predator;

import java.util.HashMap;

public class Map {
    private Map<Coordinate, Herbivore> herbivores;
    private Map<Coordinate, Predator> predators;
    public Map() {
        this.herbivores = new HashMap<>();
        this.predators = new HashMap<>();
    }





}
