package Simulation;

import Simulation.Entityis.MoovableEntytyis.Herbivore;
import Simulation.Storage.GrassesAndHerbivoresAndPredatorsOnMap;

import java.util.Map;

public class Actions {
    private Simulation simulation;
    private GrassesAndHerbivoresAndPredatorsOnMap storage;
    public Actions(Simulation simulation, GrassesAndHerbivoresAndPredatorsOnMap storage) {
        this.simulation = simulation;
        this.storage = storage;
    }


    public void nextTurn(){
        // 1. go all herbivores
        Map<Coordinate, Herbivore> herbivores = storage.getHerbivores();
        for(Map.Entry entry: herbivores.entrySet()){
            Herbivore herbivore = (Herbivore) entry.getValue();
            herbivore.makeMove();
        }


    }

    public void startSimulation(){

    }
    public void stopSimulation(){

    }

}
