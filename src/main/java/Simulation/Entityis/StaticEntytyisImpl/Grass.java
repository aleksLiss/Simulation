package Simulation.Entityis.StaticEntytyisImpl;

import Simulation.Entityis.BasicEntity.Entity;

public class Grass extends Entity {
    private char name;
    public Grass(){
        this.name = 'G';
    }

    public char getName() {
        return name;
    }

}
