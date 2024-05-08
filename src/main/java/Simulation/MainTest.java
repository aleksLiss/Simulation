package Simulation;

public class MainTest {
    private static final int COORDINATE_X = 10;
    private static final int COORDINATE_Y = 10;
    public static void main(String[] args) {
        Storage storage = new Storage();
        Simulation simulation = new Simulation(COORDINATE_X, COORDINATE_Y, storage);
        simulation.setSimulation();
        simulation.renderMap();
        simulation.nextTurn();
    }
}
