package Simulation.Entityis.StaticEntytyisImpl;

import Simulation.Entityis.BasicEntity.Entity;

public class Rock extends Entity {
    private String name;
    public Rock() {
        this.name = "R";
    }

    @Override
    public String toString(){
        return name;
    }
}
