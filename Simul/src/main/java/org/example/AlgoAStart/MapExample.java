package org.example.AlgoAStart;

import org.example.AlgoAStart.Entitys.BaseEntity;
import org.example.AlgoAStart.Entitys.Cell;
import org.example.AlgoAStart.Entitys.MoovAbleEntity.Herbivore;
import org.example.AlgoAStart.Entitys.MoovAbleEntity.Predator;
import org.example.AlgoAStart.Entitys.StaticEntity.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

public class MapExample {
    private HashMap<Integer, Cell> cellHashMap;
    private final int LINE;
    private Map<Integer, Grass> herbIndexes;
    private Map<Integer, Herbivore> herbivoresIndexes;
    private Map<Integer, Predator> predatorsIndexes;

    public MapExample() {
        this.cellHashMap = new HashMap<>();
        this.herbIndexes = new HashMap<>();
        this.herbivoresIndexes = new HashMap<>();
        this.predatorsIndexes = new HashMap<>();
        this.LINE = 29;
    }

    public static void main(String[] args) {
        MapExample mapExample = new MapExample();
        mapExample.setUp();
        mapExample.renderCellMap();
    }


    public void setUp() {
        this.setEmptyCellAndBorder();
        this.setGrass();
        this.setRocks();
        this.setTrees();
        this.setHerbivore();
        this.setPredators();
    }

    private void setRocks() {
        IntStream.range(0, 980).forEach(i -> {
            if (i % 53 == 0) {
                if (!(cellHashMap.get(i).getEntity().getName().equals("BORDER"))) {
                    cellHashMap.get(i).setEntity(new Rock());
                }
            }
        });
    }

    ;

    private void setTrees() {
        IntStream.range(0, 980).forEach(i -> {
            if (i % 71 == 0) {
                if (!(cellHashMap.get(i).getEntity().getName().equals("BORDER"))) {
                    cellHashMap.get(i).setEntity(new Tree());
                }
            }
        });
    }

    private void setGrass() {
        IntStream.range(0, 980).forEach(i -> {
            if (i % 35 == 0) {
                if (!(cellHashMap.get(i).getEntity().getName().equals("BORDER"))) {
                    Grass grass = new Grass();
                    cellHashMap.get(i).setEntity(grass);
                    herbIndexes.put(i, grass);
                }
            }
        });
    }

    private void setHerbivore() {
        Herbivore hv1 = new Herbivore();
        Herbivore hv2 = new Herbivore();
        Herbivore hv3 = new Herbivore();

        cellHashMap.get(370).setEntity(hv1);
        cellHashMap.get(670).setEntity(hv2);
        cellHashMap.get(950).setEntity(hv3);

        herbivoresIndexes.put(370, hv1);
        herbivoresIndexes.put(670, hv2);
        herbivoresIndexes.put(950, hv3);
    };


    private void setPredators() {
        Predator pr1 = new Predator();
        Predator pr2 = new Predator();
        Predator pr3 = new Predator();

        cellHashMap.get(197).setEntity(pr1);
        cellHashMap.get(250).setEntity(pr2);
        cellHashMap.get(937).setEntity(pr3);

        predatorsIndexes.put(197, pr1);
        predatorsIndexes.put(250, pr2);
        predatorsIndexes.put(937, pr3);
    };


    private void setEmptyCellAndBorder() {
        //Fil the map
        IntStream.range(0, 980).forEach(i -> cellHashMap.put(i, new Cell(new EmptyEntity(i), i)));
        // Set border
        IntStream.range(0, 28).forEach(i -> cellHashMap.get(i).setEntity(new BorderEntity()));
        IntStream.range(952, 979).forEach(i -> cellHashMap.get(i).setEntity(new BorderEntity()));
        IntStream.range(0, 980).forEach(i -> {
            if (i % 28 == 0) {
                cellHashMap.get(i).setEntity(new BorderEntity());
            }
        });
        IntStream.range(0, 980).forEach(i -> {
            if ((i - 27) % 28 == 0) {
                cellHashMap.get(i).setEntity(new BorderEntity());
            }
        });
    }

    private void renderCellMap() {
        int counter = 1;
        for (Map.Entry entry : cellHashMap.entrySet()) {
            Cell cell = (Cell) entry.getValue();
            if (cell.getEntity().getTemplate() == null) {
                System.out.print("\t" + cell.getEntity().getTemplate());
            } else {
                System.out.print("\t" + cell.getEntity().getTemplate() + "\t");
            }
            counter++;
            if (counter % LINE == 0) {
                System.out.println();
                counter = 1;
            }
        }
        System.out.println();
    }

    public Cell[] getNeighbors(int point) {
        Cell[] arr = new Cell[8];
        arr[0] = cellHashMap.get((point - LINE));
        arr[1] = cellHashMap.get(point - 1);
        arr[2] = cellHashMap.get((point + LINE - 2));
        arr[3] = cellHashMap.get((point + LINE - 1));
        arr[4] = cellHashMap.get((point + LINE));
        arr[5] = cellHashMap.get(point + 1);
        arr[6] = cellHashMap.get((point - LINE + 2));
        arr[7] = cellHashMap.get((point - LINE + 1));
        return arr;
    }

    public Map<Integer, Grass> getHerbIndexes() {
        return herbIndexes;
    }

    public Map<Integer, Herbivore> getHerbivoresIndexes() {
        return herbivoresIndexes;
    }

    public int getLINE() {
        return LINE;
    }
}
