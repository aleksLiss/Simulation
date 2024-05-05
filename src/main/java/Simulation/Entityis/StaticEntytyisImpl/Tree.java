package Simulation.Entityis.StaticEntytyisImpl;

import Simulation.Entityis.BasicEntity.Entity;

public class Tree extends Entity {
    private String name;
    public Tree() {
        this.name = "T";
    }

    public String getName(){
        return name;
    }
    @Override
    public String toString(){
        return getName();
    }

}
