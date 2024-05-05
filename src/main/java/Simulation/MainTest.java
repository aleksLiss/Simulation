package Simulation;

public class MainTest {

    private static final int COORDINATE_X = 7;
    private static final int COORDINATE_Y = 7;
    public static void main(String[] args) {
        Simulation simulation = new Simulation();
        Filler filler = new Filler(simulation, COORDINATE_X, COORDINATE_Y);
        filler.fill();
        filler.renderMap();
    }
}
