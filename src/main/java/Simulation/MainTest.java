package Simulation;

import Simulation.Entityis.StaticEntytyisImpl.Grass;
import Simulation.Storage.GrassesAndHerbivoresAndPredatorsOnMap;
import Simulation.Storage.Switcher;

import java.util.Map;

public class MainTest {

    private static final int COORDINATE_X = 7;
    private static final int COORDINATE_Y = 7;
    public static void main(String[] args) {
        GrassesAndHerbivoresAndPredatorsOnMap storage = new GrassesAndHerbivoresAndPredatorsOnMap();

        Simulation simulation = new Simulation(COORDINATE_X, COORDINATE_Y, storage);

        FillMap filler = new FillMap(simulation, COORDINATE_X, COORDINATE_Y, storage);

        filler.fill();

        FindWayToGoal findWayToGoal = new FindWayToGoal(simulation, storage);

        RenderMap.render(simulation);


        // first step
        findWayToGoal.nextCoordinate(Switcher.HERBIVORE);

        RenderMap.render(simulation);

        // two step
        findWayToGoal.nextCoordinate(Switcher.HERBIVORE);

        RenderMap.render(simulation);

        // three step
        findWayToGoal.nextCoordinate(Switcher.HERBIVORE);

        RenderMap.render(simulation);

    }
}
