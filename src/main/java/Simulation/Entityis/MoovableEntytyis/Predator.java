package Simulation.Entityis.MoovableEntytyis;

public class Predator extends Creature{
    private static final int SPEED = 1;
    private static final String NAME = "P";
    private int hp;
    public Predator() {
        this.hp = 100;
    }
    @Override
    void makeMove() {

    }
    @Override
    public String toString(){
        return "Predator{" +
                "name=" + NAME + "; " +
                "speed=" + SPEED + "; " +
                "hp=" + hp + "}";
    }

}

