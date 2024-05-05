package Simulation;

import Simulation.Map.HerbivoresAndPredatorsOnMap;

public class FindWayToGoal {
    private Simulation simulation;
    private HerbivoresAndPredatorsOnMap storage;

    public FindWayToGoal(Simulation simulation, HerbivoresAndPredatorsOnMap storage){
        this.simulation = simulation;
        this.storage = storage;
    }

    public Coordinate nextCoordinate(){

        return new Coordinate(0 ,0 );
    }
}
