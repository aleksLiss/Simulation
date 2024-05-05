package Simulation;

import Simulation.Entityis.BasicEntity.Entity;

import java.util.HashMap;
import java.util.Map;

public class Simulation {

    private Map<Coordinate, Entity> mapSimulation;
    private int counter;
    private Actions actions;
    public Simulation() {
        this.mapSimulation = new HashMap<>();
        this.counter = 0;
        this.actions = new Actions(this);
    }

    public Map<Coordinate, Entity> getMapSimulation(){
        return mapSimulation;
    }


}
