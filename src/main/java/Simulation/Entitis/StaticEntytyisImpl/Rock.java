package Simulation.Entitis.StaticEntytyisImpl;

import Simulation.Entitis.BasicEntity.Entity;

public class Rock extends StaticEnt {
    private char name;
    public Rock() {
        this.name = 'R';
    }

    public char getName() {
        return name;
    }
}
