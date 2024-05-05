package Simulation;

import Simulation.Storage.GrassesAndHerbivoresAndPredatorsOnMap;
import Simulation.Storage.Switcher;

public class MainTest {

    private static final int COORDINATE_X = 7;
    private static final int COORDINATE_Y = 7;
    public static void main(String[] args) {
        Simulation simulation = new Simulation(COORDINATE_X, COORDINATE_Y);
        GrassesAndHerbivoresAndPredatorsOnMap grassesAndHerbivoresAndPredatorsOnMap = new GrassesAndHerbivoresAndPredatorsOnMap();
        Filler filler = new Filler(simulation, COORDINATE_X, COORDINATE_Y, grassesAndHerbivoresAndPredatorsOnMap);
        filler.fill();

        FindWayToGoal findWayToGoal = new FindWayToGoal(simulation, grassesAndHerbivoresAndPredatorsOnMap);
        findWayToGoal.nextCoordinate(Switcher.HERBIVORE);
        RenderMap.render(simulation);
    }
}
