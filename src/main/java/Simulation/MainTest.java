package Simulation;

import Simulation.Entityis.StaticEntytyisImpl.Grass;
import Simulation.Storage.GrassesAndHerbivoresAndPredatorsOnMap;
import Simulation.Storage.Switcher;

import java.util.Map;

public class MainTest {

    private static final int COORDINATE_X = 10;
    private static final int COORDINATE_Y = 10;
    public static void main(String[] args) {
        GrassesAndHerbivoresAndPredatorsOnMap storage = new GrassesAndHerbivoresAndPredatorsOnMap();
        Simulation simulation = new Simulation(COORDINATE_X, COORDINATE_Y, storage);
        FillMap filler = new FillMap(simulation, COORDINATE_X, COORDINATE_Y, storage);
        filler.fill();



        Actions actions = new Actions(simulation, storage);

        // first step
        actions.nextTurn();
        simulation.renderMap();

        // two step
        actions.nextTurn();
        simulation.renderMap();

        // three step
        actions.nextTurn();
        simulation.renderMap();
    }
}
