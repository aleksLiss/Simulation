package Simulation.Entitis.MoovableEntytyis;

import Simulation.Coordinate;
import Simulation.Entitis.StaticEntytyisImpl.Grass;
import Simulation.Entitis.StaticEntytyisImpl.StaticEnt;
import Simulation.Storage;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Herbivore extends Creature{
    private static final int SPEED = 2;
    private static final char NAME = 'H';
    private int hp;
    private Coordinate goal;
    public Storage storage;
    private boolean isGoal;
    public Herbivore(Storage storage) {
        this.hp = 100;
        this.goal = null;
        this.isGoal = false;
        this.storage = storage;
    }

    @Override
    public void makeMove() {
        if(goal == null){
            setGoal();
        }

        Coordinate start = storage.getMovableStorage();

        int finishX = goal.getX();
        int finishY = goal.getY();

        int copyStartX = start.getX();
        int copyStartY = start.getY();

        System.out.println(start.getX());
        System.out.println(start.getY());

        List<Coordinate> wayToGoal = new ArrayList<>();

        while((copyStartX != finishX) || (copyStartY != finishY)){
            int counterStep = SPEED;

            if(copyStartX < finishX){
                copyStartX++;
                counterStep--;
            }else if(copyStartX > finishX){
                copyStartX--;
                counterStep--;
            }

            if(copyStartY < finishY){
                copyStartY++;
                counterStep--;
            }else if(copyStartY > finishY){
                copyStartY--;
                counterStep--;
            }

            if(counterStep == 0){
                wayToGoal.add(new Coordinate(copyStartX, copyStartY));
            }else{
                if(copyStartX == finishX){
                    if(copyStartY > finishY){
                        copyStartY--;
                    }else{
                        copyStartY++;
                    }
                    wayToGoal.add(new Coordinate(copyStartX, copyStartY));
                }else {
                    if(copyStartX > finishX){
                        copyStartX--;
                    }else {
                        copyStartX++;
                    }
                }
                wayToGoal.add(new Coordinate(copyStartX, copyStartY));
            }
        }


        int step = 1;
        for(Coordinate coordinate: wayToGoal){
            System.out.printf("%d - step to goal\n", step);
            System.out.println(coordinate.getX());
            System.out.println(coordinate.getY());
            step++;
        }
    }


    private void setGoal(){
        for(Map.Entry entry: storage.getStaticStorage().entrySet()){
            StaticEnt staticEnt = (StaticEnt) entry.getValue();
            if(staticEnt.getName() == 'G'){
                Grass grass = (Grass) entry.getValue();
                goal = (Coordinate) entry.getKey();
                grass.setGoal();
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
