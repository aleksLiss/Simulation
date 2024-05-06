package Simulation.Entityis.StaticEntytyisImpl;

import Simulation.Entityis.BasicEntity.Entity;

public class Rock extends Entity {
    private char name;
    public Rock() {
        this.name = 'R';
    }

    public char getName() {
        return name;
    }
}
