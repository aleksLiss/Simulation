package Simulation;

import Simulation.Entityis.BasicEntity.Entity;
import Simulation.Entityis.MoovableEntytyis.Herbivore;
import Simulation.Entityis.MoovableEntytyis.Predator;
import Simulation.Entityis.StaticEntytyisImpl.Empty;
import Simulation.Entityis.StaticEntytyisImpl.Grass;
import Simulation.Storage.GrassesAndHerbivoresAndPredatorsOnMap;

import java.util.HashMap;
import java.util.Map;

public class Simulation {
    private Map<Coordinate, Entity> mapSimulation;
    private int length;
    private int width;
    private int counter;
//    private Actions actions;
    private GrassesAndHerbivoresAndPredatorsOnMap storage;
    public Simulation(int length, int width, GrassesAndHerbivoresAndPredatorsOnMap storage) {
        this.mapSimulation = new HashMap<>();
        this.counter = 0;
//        this.actions = new Actions(this, storage);
        this.length = length;
        this.width = width;
        this.storage = storage;
    }

    public Map<Coordinate, Entity> getMapSimulation(){
        return mapSimulation;
    }

    public int getLength() {
        return length;
    }

    public int getWidth() {
        return width;
    }

    private void removeEntityFromMap(Coordinate coordinate){
        mapSimulation.put(coordinate, new Empty());
    }

    public void updateMap(){
        updateGrasses();
        updateHerbivores();
        updatePredators();
    }

    private void updatePredators(){
        Map<Coordinate, Predator> predatorMap = storage.getPredators();
        for(Map.Entry entry: predatorMap.entrySet()){
            Coordinate coordinate = (Coordinate) entry.getKey();
            mapSimulation.put(coordinate, (Predator) entry.getValue());
        }
    }


    private void updateHerbivores(){
        Map<Coordinate, Herbivore> herbivoreMap = storage.getHerbivores();
        for(Map.Entry entry: herbivoreMap.entrySet()){
            Coordinate coordinate = (Coordinate) entry.getKey();
            mapSimulation.put(coordinate, (Herbivore) entry.getValue());
        }
    }

    private void updateGrasses(){
        Map<Coordinate, Grass> grassMap = storage.getGrasses();
        for(Map.Entry entry: grassMap.entrySet()){
            Coordinate coordinate = (Coordinate) entry.getKey();
            mapSimulation.put(coordinate, (Grass)entry.getValue());
        }
    }


    public void renderMap(){

        for (int i = 0; i <= length; i++) {

            for (int j = 0; j <= width; j++) {

                if(i == 0 || i == length){
                    System.out.print(" + ");
                }else {
                    if (j == 0) {
                        System.out.print("+");
                    }
                    if(j == width){
                        System.out.println("+");
                    }
                    else {
                        Coordinate coordinate = new Coordinate(i, j);
                        System.out.print(" " + mapSimulation.get(coordinate).getName() + " ");
                    }
                }
            }
            System.out.println();
        }
        System.out.println("\n");
    }

    public GrassesAndHerbivoresAndPredatorsOnMap getStorage(){
        return storage;
    }
}
