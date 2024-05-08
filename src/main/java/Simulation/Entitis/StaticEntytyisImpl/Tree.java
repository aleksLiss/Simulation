package Simulation.Entitis.StaticEntytyisImpl;

import Simulation.Entitis.BasicEntity.Entity;

public class Tree extends StaticEnt {
    private char name;
    public Tree() {
        this.name = 'T';
    }

    public char getName(){
        return name;
    }
}
