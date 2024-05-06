package Simulation.Entityis.StaticEntytyisImpl;

import Simulation.Entityis.BasicEntity.Entity;

public class Grass extends Entity {
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
