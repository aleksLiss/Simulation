package Simulation;

public class MainTest {

    private static final int COORDINATE_X = 10;
    private static final int COORDINATE_Y = 10;
    public static void main(String[] args) {

        StorageEntitiyesOnMap storage = new StorageEntitiyesOnMap();
        Simulation simulation = new Simulation(COORDINATE_X, COORDINATE_Y, storage);

        simulation.renderMap();

    }
}
