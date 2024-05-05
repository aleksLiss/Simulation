package Simulation.Entityis.MoovableEntytyis;

import Simulation.Entityis.BasicEntity.Entity;

public abstract class Creature extends Entity {
    private int hp;
    public Creature(){
        this.hp = 100;
    }
    abstract void makeMove();
}
