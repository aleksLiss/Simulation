package Simulation.Map;

import Simulation.Coordinate;
import Simulation.Entityis.MoovableEntytyis.Herbivore;
import Simulation.Entityis.MoovableEntytyis.Predator;

import java.util.HashMap;
import java.util.Map;

public class MapSimulation {
    private Map<Coordinate, Herbivore> herbivores;
    private Map<Coordinate, Predator> predators;
    public MapSimulation() {
        this.herbivores = new HashMap<>();
        this.predators = new HashMap<>();
    }


}
