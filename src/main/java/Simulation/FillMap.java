package Simulation;

import Simulation.Entityis.BasicEntity.Entity;
import Simulation.Entityis.MoovableEntytyis.Herbivore;
import Simulation.Entityis.MoovableEntytyis.Predator;
import Simulation.Entityis.StaticEntytyisImpl.Empty;
import Simulation.Entityis.StaticEntytyisImpl.Grass;
import Simulation.Storage.GrassesAndHerbivoresAndPredatorsOnMap;
import Simulation.Storage.Switcher;


import java.util.Map;

public class FillMap {
    private Simulation simulation;
    private GrassesAndHerbivoresAndPredatorsOnMap storage;
    private int coordinateX;
    private int coordinateY;

    public FillMap(Simulation simulation, int coordinateX, int coordinateY, GrassesAndHerbivoresAndPredatorsOnMap storage) {
        this.simulation = simulation;
        this.coordinateX = coordinateX;
        this.coordinateY = coordinateY;
        this.storage = storage;
    }

    public void fill() {
        Map<Coordinate, Entity> map = simulation.getMapSimulation();
        for (int i = 0; i <= coordinateX; i++) {
            for (int j = 0; j <= coordinateY; j++) {
                // 1 Grass
                if (i == j) {
                    Grass grass = new Grass();
                    storage.addEntityToStorage(Switcher.GRASS, i, j, grass);
                    map.put(new Coordinate(i, j), grass);
                } else {
                    if (i == 3 && j == 5) {
                        // 2 HERBIVORE
                        Herbivore herbivore = new Herbivore();
                        storage.addEntityToStorage(Switcher.HERBIVORE, i, j, herbivore);
                        map.put(new Coordinate(i, j), herbivore);
                    } else if (i == 7 && j == 5) {
                        // 3 PREDATOR
                        Predator predator = new Predator();
                        storage.addEntityToStorage(Switcher.PREDATOR, i, j, predator);
                        map.put(new Coordinate(i, j), predator);
                    } else {
                        // 4 EMPTY
                        map.put(new Coordinate(i, j), new Empty());
                    }
                }
            }
        }
    }
}