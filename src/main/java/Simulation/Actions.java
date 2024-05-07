package Simulation;

import Simulation.Entityis.MoovableEntytyis.Creature;
import Simulation.Entityis.MoovableEntytyis.Herbivore;
import Simulation.Entityis.MoovableEntytyis.Predator;

import java.util.Map;

public interface Actions {
    public void setSimulation();
    public void nextTurn();
    public void startSimulation();
    public void stopSimulation();

}
