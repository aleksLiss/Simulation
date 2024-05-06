package Simulation.Entityis.StaticEntytyisImpl;

import Simulation.Entityis.BasicEntity.Entity;

public class Tree extends Entity {
    private char name;
    public Tree() {
        this.name = 'T';
    }

    public char getName(){
        return name;
    }
}
