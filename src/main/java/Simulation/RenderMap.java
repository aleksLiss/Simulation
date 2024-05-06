package Simulation;

import Simulation.Entityis.BasicEntity.Entity;

import java.util.Map;

public class RenderMap {

    public static void render(Simulation simulation){
        Map<Coordinate, Entity> map = simulation.getMapSimulation();
        int coordinateX = simulation.getLength();
        int coordinateY = simulation.getWidth();
        System.out.println();
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
                    System.out.print(" " + map.get(coordinate).getName() + " ");
                }
            }
            if (i == coordinateX) {
                System.out.println("+ + + + + + + + + + ");
            }
        }
    }
}
