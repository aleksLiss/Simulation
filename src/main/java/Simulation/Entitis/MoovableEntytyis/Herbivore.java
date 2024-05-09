package Simulation.Entitis.MoovableEntytyis;

import Simulation.Coordinate;
import Simulation.Entitis.StaticEntytyisImpl.Grass;
import Simulation.Entitis.StaticEntytyisImpl.StaticEnt;
import Simulation.Storage;
import Simulation.Switcher;

import java.util.*;

public class Herbivore extends Creature {
    private Double id;
    private static final int SPEED = 2;
    private static final char NAME = 'H';
    private int hp;
    private Coordinate goal;
    public Storage storage;
    private boolean isGoal;
    private Queue<Coordinate> wayToGoal;
    public Herbivore(Storage storage, Double id) {
        this.hp = 100;
        this.goal = null;
        this.isGoal = false;
        this.storage = storage;
        this.wayToGoal = new ArrayDeque<>();
        this.id = id;
    }



    @Override
    public void makeMove() {
        if (goal == null) {
            setGoal();
            calculateWayToGoal();
            Coordinate nextStep = wayToGoal.remove();
            storage.removeFromStorage(Switcher.MOVABLE, this);
            storage.addToStorage(Switcher.MOVABLE, nextStep, this);
        } else {
            Coordinate nextStep = wayToGoal.remove();
            storage.removeFromStorage(Switcher.MOVABLE, this);
            storage.addToStorage(Switcher.MOVABLE, nextStep, this);

        }
    }


    private void calculateWayToGoal() {

        Coordinate start = storage.getCoordinateForEntity(Switcher.MOVABLE, this);

        int finishX = goal.getX();
        int finishY = goal.getY();

        int copyStartX = start.getX();
        int copyStartY = start.getY();

        while ((copyStartX != finishX) || (copyStartY != finishY)) {
            int counterStep = SPEED;

            if (copyStartX < finishX) {
                copyStartX++;
                counterStep--;
            } else if (copyStartX > finishX) {
                copyStartX--;
                counterStep--;
            }

            if (copyStartY < finishY) {
                copyStartY++;
                counterStep--;
            } else if (copyStartY > finishY) {
                copyStartY--;
                counterStep--;
            }

            if (counterStep == 0) {
                wayToGoal.add(new Coordinate(copyStartX, copyStartY));
            } else {
                if (copyStartX == finishX) {
                    if (copyStartY > finishY) {
                        copyStartY--;
                    } else {
                        copyStartY++;
                    }
                    wayToGoal.add(new Coordinate(copyStartX, copyStartY));
                } else {
                    if (copyStartX > finishX) {
                        copyStartX--;
                    } else {
                        copyStartX++;
                    }
                }
                wayToGoal.add(new Coordinate(copyStartX, copyStartY));
            }
        }
    }

    private void setGoal() {
        for (Map.Entry entry : storage.getStaticStorage().entrySet()) {
            StaticEnt staticEnt = (StaticEnt) entry.getValue();
            if (staticEnt.getName() == 'G') {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Herbivore herbivore = (Herbivore) o;
        return Objects.equals(id, herbivore.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
