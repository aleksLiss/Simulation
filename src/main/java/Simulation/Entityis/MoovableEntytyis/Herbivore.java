package Simulation.Entityis.MoovableEntytyis;

import Simulation.Coordinate;
import Simulation.Entityis.StaticEntytyisImpl.Grass;
import Simulation.Simulation;
import Simulation.Storage.GrassesAndHerbivoresAndPredatorsOnMap;
import Simulation.Storage.Switcher;

import java.util.Map;

public class Herbivore extends Creature{
    private static final int SPEED = 2;
    private static final char NAME = 'H';
    private int hp;
    private Coordinate goal;
    private GrassesAndHerbivoresAndPredatorsOnMap storage;
    private Simulation simulation;
    private boolean isGoal;
    public Herbivore() {
        this.hp = 100;
        this.goal = null;
        this.isGoal = false;
    }

    @Override
    public void makeMove() {
        if(goal == null){
            setGoal();
        }

        Coordinate start = storage.getCoordinateOnMap(Switcher.HERBIVORE, this);

        int finishX = goal.getX();
        int finishY = goal.getY();
        System.out.println(finishX);
        System.out.println(finishY);


        int firstStep = start.getX() + 1;
        int secondStep = start.getY() + 1;



    }
    public void setGoal(){
        for(Map.Entry entry: simulation.getStorage().getGrasses().entrySet()){
            Grass grass = (Grass) entry.getValue();
            if(!grass.isGoal()){
                goal = (Coordinate) entry.getKey();
                break;
            }
        }
    }

    @Override
    public char getName() {
        return NAME;
    }

    private boolean isValidCoordinate(Coordinate coordinate){
        return true;
    }
}
