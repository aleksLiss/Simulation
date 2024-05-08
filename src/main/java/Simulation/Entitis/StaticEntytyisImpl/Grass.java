package Simulation.Entitis.StaticEntytyisImpl;

import Simulation.Entitis.BasicEntity.Entity;

public class Grass extends StaticEnt {
    private char name;
    private boolean isGoal;
    public Grass(){
        this.name = 'G';
        this.isGoal = false;
    }

    public char getName() {
        return name;
    }
    public void setGoal(){
        isGoal = true;
    }

    public boolean isGoal(){
        return isGoal;
    }

}
