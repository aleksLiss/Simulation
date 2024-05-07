package Simulation;

import Simulation.Entityis.BasicEntity.Entity;
import Simulation.Entityis.StaticEntytyisImpl.Empty;

import java.util.HashMap;
import java.util.Map;

public class Simulation implements Actions{
    private Map<Coordinate, Entity> mapSimulation;
    private int length;
    private int width;
    private int counter;
    //    private Actions actions;
    private StorageEntitiyesOnMap storage;

    public Simulation(int length, int width) {
        this.mapSimulation = new HashMap<>();
        this.counter = 0;
//        this.actions = new Actions(this, storage);
        this.length = length;
        this.width = width;
        this.storage = new StorageEntitiyesOnMap();
    }
    private void removeEntityFromMap(Coordinate coordinate) {
        mapSimulation.put(coordinate, new Empty());
    }
    public void renderMap() {
        System.out.println("================================");
        for (int i = 0; i <= length; i++) {
            for (int j = 0; j <= width; j++) {
                if (j == 0) {
                    System.out.print("+");
                }
                if (j == width) {
                    System.out.println("+");
                } else {
                    Entity staticE = storage.getStaticStorage().getOrDefault(new Coordinate(i, j), null);
                    Entity moveE = storage.getMoovableStorage().getOrDefault(new Coordinate(i, j), null);
                    if(staticE == null && moveE == null){
                        System.out.print(" E ");
                    }else{
                        if(staticE != null){
                            System.out.print(" " + staticE.getName() + " ");
                        }else{
                            System.out.print(" " + moveE.getName() + " ");
                        }
                    }
                }
            }
        }
        System.out.println("================================");
    }

    public StorageEntitiyesOnMap getStorage(){
        return storage;
    }

    @Override
    public void setSimulation() {
        storage.fillDefaultStatic();
        storage.fillDefaultMoovable();
    }

    @Override
    public void nextTurn() {

    }

    @Override
    public void startSimulation() {

    }

    @Override
    public void stopSimulation() {

    }
}
