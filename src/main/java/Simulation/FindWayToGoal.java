package Simulation;

import Simulation.Storage.GrassesAndHerbivoresAndPredatorsOnMap;
import Simulation.Storage.Switcher;

public class FindWayToGoal {
    private Simulation simulation;
    private GrassesAndHerbivoresAndPredatorsOnMap storage;
    private Switcher switcher;
    public FindWayToGoal(Simulation simulation, GrassesAndHerbivoresAndPredatorsOnMap storage){
        this.simulation = simulation;
        this.storage = storage;
    }

    public Coordinate nextCoordinate(Switcher switcher){
        Coordinate nextCoordinate = null;
        switch (switcher){
            case HERBIVORE:
                Coordinate start = storage.getEntityFromMap(Switcher.HERBIVORE);
                Coordinate finish = storage.getEntityFromMap(Switcher.GRASS);
                int resultX = start.getX() + 1;
                int resultY = start.getY();
                System.out.printf("start: x=%d; y=%d\n", start.getX(), start.getY());
                System.out.printf("finish: x=%d; y=%d\n", finish.getX(), finish.getY());
                System.out.printf("next: x= %d; y= %d", resultX, resultY);
                break;
            case PREDATOR:

                break;
        }
        return nextCoordinate;
    }

}
