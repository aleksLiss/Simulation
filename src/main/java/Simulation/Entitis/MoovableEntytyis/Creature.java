package Simulation.Entitis.MoovableEntytyis;

import Simulation.Entitis.BasicEntity.Entity;

public abstract class Creature extends Entity {
    private int hp;
    public Creature(){
        this.hp = 100;
    }
    abstract void makeMove();
}
