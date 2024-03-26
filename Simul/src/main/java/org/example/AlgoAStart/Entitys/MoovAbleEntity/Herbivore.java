package org.example.AlgoAStart.Entitys.MoovAbleEntity;

import org.example.AlgoAStart.Entitys.Cell;
import org.example.AlgoAStart.Entitys.StaticEntity.Grass;
import org.example.AlgoAStart.MapExample;

import java.util.Map;

public class Herbivore extends Creature {
    private int speed;
    private int hp;
    private int countSteps;
    private String template;
    private String name;
    private MapExample map;


    public Herbivore() {
        this.speed = 1;
        this.countSteps = 10;
        this.hp = 100;
        this.template = "\uD83E\uDD8E";
        this.name = "HV";
    }

    @Override
    public void makeMove() {

        Map<Integer, Grass> herbOnMap = map.getHerbIndexes();
        Map<Integer, Herbivore> herbivoreOnMap = map.getHerbivoresIndexes();

        for (Map.Entry herbivore: herbivoreOnMap.entrySet()){
            for (Map.Entry herb: herbOnMap.entrySet()){

                int pointH = (int) herb.getKey();
                Cell[] arr = map.getNeighbors((int) herbivore.getKey());

                int [] resultLength = new int[8];

                for (Cell cell: arr){
                    int index = 0;
                    if(cell.getEntity().getName().equals("H")){
                        cell.setEntity(this);
                        this.hp = 100;
                        this.countSteps = 10;
                    }else {
                        int finishX = map.getLINE() - (pointH % map.getLINE());
                        int finishY = pointH / map.getLINE();
                        int finishResult = finishX + finishY;
                        resultLength[index] = finishResult;
                    }
                }
                int min = 100;
                for (int result: resultLength){
                    if(result < min){
                        min = result;
                    }
                }

            }
        }




        countSteps--;
        // Если количество шагов становится равным 5, за каждый последующий шаг минусуем 20 хп
        // Если съели траву, возвращаем в исходное значение количество шагов и хп
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    @Override
    public String getTemplate() {
        return template;
    }

    public void setTemplate(String template) {
        this.template = template;
    }

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
