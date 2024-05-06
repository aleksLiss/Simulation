package Simulation;

import Simulation.Entityis.BasicEntity.Entity;
import Simulation.Entityis.StaticEntytyisImpl.Empty;
import Simulation.Storage.GrassesAndHerbivoresAndPredatorsOnMap;
import Simulation.Storage.Switcher;

public class FindWayToGoal {
    private Simulation simulation;
    private GrassesAndHerbivoresAndPredatorsOnMap storage;
    public FindWayToGoal(Simulation simulation, GrassesAndHerbivoresAndPredatorsOnMap storage){
        this.simulation = simulation;
        this.storage = storage;
    }

    public void nextCoordinate(Switcher switcher){
        switch (switcher){
            case HERBIVORE:

                Coordinate start = storage.getEntityFromMap(Switcher.HERBIVORE);

                if(isValidPosition(start.getX() + 1, start.getY())){

                    Entity entity = simulation.getMapSimulation().get(new Coordinate(start.getX(), start.getY()));

                    simulation.getMapSimulation().put(new Coordinate(start.getX(), start.getY()), new Empty());

                    simulation.getMapSimulation().put(new Coordinate(start.getX() + 1, start.getY()), entity);

                    storage.removeEntityFromMap(Switcher.HERBIVORE, entity);

                    storage.addEntityToStorage(Switcher.HERBIVORE,start.getX() + 1, start.getY(), entity);

                };

                break;
            case PREDATOR:
                break;
        }
    }

    private boolean isValidPosition(int x, int y){
        Entity entity = simulation.getMapSimulation().get(new Coordinate(x, y));
        return entity.getName() == 'E' || entity.getName() == 'G';
    }
    private void showStartAndFinishPosition(Coordinate start, Coordinate finish){
        int resultX = start.getX() + 1;
        int resultY = start.getY();

        System.out.printf("start: x=%d; y=%d\n", start.getX(), start.getY());
        System.out.printf("finish: x=%d; y=%d\n", finish.getX(), finish.getY());
        System.out.printf("next: x= %d; y= %d", resultX, resultY);
    }
}
