package Simulation.Entityis.StaticEntytyisImpl;

import Simulation.Entityis.BasicEntity.Entity;

public class Grass extends Entity {
    private String name;
    public Grass(){
        this.name = "G";
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString(){
        return name;
    }

}
