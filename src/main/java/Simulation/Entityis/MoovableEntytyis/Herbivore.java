package Simulation.Entityis.MoovableEntytyis;

public class Herbivore extends Creature{
    private static final int SPEED = 2;
    private static final String NAME = "H";
    private int hp;
    @Override
    void makeMove() {
    }
    @Override
    public String toString() {
        return "H";
    }

    @Override
    public String getName() {
        return NAME;
    }
}
