package Simulation.Entityis.StaticEntytyisImpl;

import Simulation.Entityis.BasicEntity.Entity;

public class Empty extends Entity {

    private String name;

    public Empty(){
        this.name = "E";
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString(){
        return name;
    }
}

