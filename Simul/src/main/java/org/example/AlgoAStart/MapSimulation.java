package org.example.AlgoAStart;

import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class MapSimulation {
    private Map<Field, Double> openMap;
    private List<Field> closeArr;
    private Field[][] map;
    private List<Field> herbList;
    public static final int LINES = 12;
    public static final int COLUM = 12;
    public static final int BORDER_LINES = LINES + 2;
    public static final int BORDER_COLUMNS = COLUM + 2;
    public static final int START_X = 1;
    public static final int START_Y = 7;
    public MapSimulation() {
        this.openMap = new HashMap<>();
        this.closeArr = new ArrayList<>();
        this.map = new Field[BORDER_LINES][BORDER_COLUMNS];
        this.herbList = new ArrayList<>();
    }
    public static void main(String[] args) {
        MapSimulation matrixA = new MapSimulation();

        matrixA.setMap();
        matrixA.renderMap();

        int counterStep = 0;
        for (Field herb : matrixA.herbList) {
            matrixA.closeArr.clear();
            Field field = matrixA.getNextStep(matrixA.getStartPoint(), herb);
            while (true) {
                try {
                    TimeUnit.MILLISECONDS.sleep(2000);
                    matrixA.setNameOfField(field);
                    matrixA.setFieldFromCloseArr(counterStep);
                    matrixA.renderMap();
                    counterStep++;
                    field = matrixA.getNextStep(field, herb);
                } catch (InterruptedException ex) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }
    private void setHerbList() {
        herbList.add(map[4][5]);
        herbList.add(map[6][8]);
        herbList.add(map[7][8]);
        herbList.add(map[2][3]);
    }
    private void setMap() {
        for (int i = 1; i < LINES + 1; i++) {
            for (int j = 1; j < COLUM + 1; j++) {
                Field field = new Field(String.format("%d%d", i, j));
                field.setX(i);
                field.setY(j);
                map[i][j] = field;
            }
        }
        setStartPoint(START_X, START_Y);
        setRock(map[4][4]);

        setTree(map[5][2]);
        setTree(map[5][3]);
        setTree(map[7][3]);
        setTree(map[7][2]);
        setTree(map[7][1]);

        setHerbList();

        for (Field field : herbList) {
            setFinishPoint(field);
        }
    }

    private void renderMap() {
        HashMap<Integer, Field> mapEx = new HashMap<>();

        IntStream.range(0, 50).forEach(i -> mapEx.put(i, new Field(String.valueOf(i))));


        for (int i = 0; i < BORDER_LINES; i++) {
            for (int j = 0; j < BORDER_COLUMNS; j++) {
                Field field = map[i][j];
                if (field != null) {
                    System.out.print("\t" + field.getName() + "\t");
                } else {
                    System.out.print("\t" + field);
                }
            }
            System.out.println();
        }
        System.out.println("=======================================");
    }

    private void setStartPoint(int x, int y) {
        map[x][y].setName("\uD83E\uDD8E");
    }

    private Field getStartPoint() {
        return map[START_X][START_Y];
    }

    private void setFinishPoint(Field field) {
        field.setName("\uD83C\uDF3F");
    }

    private void setNameOfField(Field field) {
        field.setName("\uD83E\uDD8E");
    }

    private void setRock(Field field) {
        field.setName("\uD83E\uDEA8");
    }

    private void setTree(Field field) {
        field.setName("\uD83C\uDF32");
    }

    private void setFieldFromCloseArr(int i) {
        closeArr.get(i).setName(String.format("%d%d", closeArr.get(i).getX(), closeArr.get(i).getX()));
    }

    private List<Field> getNeighbors(Field field) {
        int x = field.getX();
        int y = field.getY();
        Field[] arr = {
                map[x - 1][y],
                map[x - 1][y - 1],
                map[x][y - 1],
                map[x + 1][y - 1],
                map[x + 1][y],
                map[x + 1][y + 1],
                map[x][y + 1],
                map[x - 1][y + 1]
        };
        List<Field> result = new ArrayList<>();

        IntStream.range(0, arr.length).forEach(i -> {
            //&&
            if (arr[i] != null
                    && !arr[i].getName().equals("\uD83E\uDEA8")
                    && !arr[i].getName().equals("\uD83C\uDF32") && (!closeArr.contains(arr[i]))) {
                result.add(arr[i]);
            }
        });
        return result;
    }

    private Field getNextStep(Field startPoint, Field finishPoint) {

        closeArr.add(startPoint); // 1.

        List<Field> neighbors = getNeighbors(startPoint); // 2

        for (Field field : neighbors) {
            int counterX = finishPoint.getX() - field.getX();
            int counterY = finishPoint.getY() - field.getY();
            if (counterY < 0) {
                counterY *= -1;
            }
            if (counterX < 0) {
                counterX *= -1;
            }
            double result;
            if (field.getX() == field.getY()) {
                result = counterX + counterY + 1.4;
            } else {
                result = counterX + counterY + 1;
            }
            openMap.put(field, result);
        }
        double min = 100.0;
        Field result = null;
        for (java.util.Map.Entry entry : openMap.entrySet()) {
            Field field = (Field) entry.getKey();
//            System.out.println(field.getName() + " = " + entry.getValue());
            if(field.getName().equals("\uD83C\uDF3F")){
                result = field;
                break;
            }
            if ((double) entry.getValue() < min) {
                min = (double) entry.getValue();
                result = (Field) entry.getKey();
            }
        }
        openMap.clear();
        return result;
    }

;
}


class Field {
    private String name;
    private int x;
    private int y;

    public Field(String name) {
        this.name = name;
    }

    public Field(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}