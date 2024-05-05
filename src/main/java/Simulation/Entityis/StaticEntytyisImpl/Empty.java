package Simulation.Entityis.StaticEntytyisImpl;

import Simulation.Entityis.BasicEntity.Entity;

public class Empty extends Entity {

    private String name;

    public Empty(){
        this.name = "E";
    }

    @Override
    public String toString(){
        return name;
    }
}

