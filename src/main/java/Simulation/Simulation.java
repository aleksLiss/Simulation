package Simulation;

import Simulation.Entityis.BasicEntity.Entity;

import java.util.HashMap;
import java.util.Map;

public class Simulation {
    private Map<Coordinate, Entity> mapSimulation;
    private int length;
    private int width;
    private int counter;
    private Actions actions;
    public Simulation(int length, int width) {
        this.mapSimulation = new HashMap<>();
        this.counter = 0;
        this.actions = new Actions(this);
        this.length = length;
        this.width = width;
    }

    public Map<Coordinate, Entity> getMapSimulation(){
        return mapSimulation;
    }

    public int getLength() {
        return length;
    }

    public int getWidth() {
        return width;
    }
}
