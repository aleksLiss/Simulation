package Simulation.Entityis.StaticEntytyisImpl;

import Simulation.Entityis.BasicEntity.Entity;

public class Rock extends Entity {
    private String name;
    public Rock() {
        this.name = "R";
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString(){
        return name;
    }
}
