package Simulation.Entityis.StaticEntytyisImpl;

import Simulation.Entityis.BasicEntity.Entity;

public class Empty extends Entity {
    private char name;
    public Empty(){
        this.name = 'E';
    }

    public char getName() {
        return name;
    }
}

