package Simulation;

import Simulation.Entityis.BasicEntity.Entity;
import Simulation.Entityis.MoovableEntytyis.Herbivore;
import Simulation.Entityis.MoovableEntytyis.Predator;
import Simulation.Entityis.StaticEntytyisImpl.Empty;
import Simulation.Entityis.StaticEntytyisImpl.Grass;


import java.util.Map;

public class Filler {
    private Simulation simulation;
    private int coordinateX;
    private int coordinateY;

    public Filler(Simulation simulation, int coordinateX, int coordinateY) {
        this.simulation = simulation;
        this.coordinateX = coordinateX;
        this.coordinateY = coordinateY;
    }

    public void fill() {
        Map<Coordinate, Entity> map = simulation.getMapSimulation();
        for (int i = 0; i <= coordinateX; i++) {
            for (int j = 0; j <= coordinateY; j++) {
                Coordinate coordinate = new Coordinate(i, j);
                Empty empty = new Empty();
                // 1 Grass
                if (i == j) {
                    map.put(new Coordinate(i, j), new Grass());
                } else {
                    if (i == 3 && j == 5) {
                        // 2 HERBIVORE
                        map.put(new Coordinate(i, j), new Herbivore());
                    } else if (i == 7 && j == 5) {
                        // 3 PREDATOR
                        map.put(new Coordinate(i, j), new Predator());
                    } else {
                        // 4 EMPTY
                        map.put(new Coordinate(i, j), new Empty());
                    }
                }
            }
        }
    }

    public void renderMap() {
        Map<Coordinate, Entity> map = simulation.getMapSimulation();
        for (int i = 0; i <= coordinateX; i++) {
            if (i == 0) {
                System.out.println("+ + + + + + + + + + ");
            }
            for (int j = 0; j <= coordinateY; j++) {
                if (j == 0) {
                    System.out.print("+");
                } else if (j == coordinateY) {
                    System.out.println("+");
                } else {
                    Coordinate coordinate = new Coordinate(i, j);
                    System.out.print(" " + map.get(coordinate) + " ");
                }
            }
            if (i == coordinateX) {
                System.out.println("+ + + + + + + + + + ");
            }
        }

    }

}
