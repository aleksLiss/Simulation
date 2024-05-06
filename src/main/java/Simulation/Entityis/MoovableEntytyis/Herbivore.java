package Simulation.Entityis.MoovableEntytyis;

public class Herbivore extends Creature{
    private static final int SPEED = 2;
    private static final char NAME = 'H';
    private int hp;

    public Herbivore() {
        this.hp = 100;
    }

    @Override
    void makeMove() {

    }
    @Override
    public char getName() {
        return NAME;
    }
}
