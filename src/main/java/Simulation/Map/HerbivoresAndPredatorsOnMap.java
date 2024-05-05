package Simulation.Map;

import Simulation.Coordinate;
import Simulation.Entityis.MoovableEntytyis.Herbivore;
import Simulation.Entityis.MoovableEntytyis.Predator;

import java.util.HashMap;
import java.util.Map;

public class HerbivoresAndPredatorsOnMap {
    private Map<Coordinate, Herbivore> herbivores;
    private Map<Coordinate, Predator> predators;
    public HerbivoresAndPredatorsOnMap() {
        this.herbivores = new HashMap<>();
        this.predators = new HashMap<>();
    }

    public void addHerbivore(int x, int y, Herbivore herbivore){
        herbivores.put(new Coordinate(x, y), herbivore);
    }

    public void addPredator(int x, int y, Predator predator){
        predators.put(new Coordinate(x, y), predator);
    }

    public void herbivoreDied(Herbivore herbivore){
        herbivores.remove(herbivore);
    }

    public void predatorDied(Predator predator){
        predators.remove(predator);
    }

    public void updateHerbivoreOnMap(int x, int y, Herbivore herbivore){
        herbivoreDied(herbivore);
        addHerbivore(x, y, herbivore);

    }
    public void updatePredatorOnMap(int x, int y, Predator predator){
        predatorDied(predator);
        addPredator(x, y, predator);
    }
}

