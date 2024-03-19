package org.example.AlgoAStart;

import java.util.*;
import java.util.stream.IntStream;

public class MatrixA {
    private Map<Field, Double> openMap;
    private List<Field> closeArr;
    private Field[][] map;
    public static final int LINES = 7;
    public static final int COLUM = 7;
    public static final int BORDER_LINES = LINES + 2;
    public static final int BORDER_COLUMNS = COLUM + 2;
    public static final int START_X = 1;
    public static final int START_Y = 1;
    public static final int FINISH_X = 6;
    public static final int FINISH_Y = 6;

    public MatrixA() {
        this.openMap = new HashMap<>();
        this.closeArr = new ArrayList<>();
        this.map = new Field[BORDER_LINES][BORDER_COLUMNS];
    }

    public static void main(String[] args) {
        MatrixA matrixA = new MatrixA();

        matrixA.setMap();
        matrixA.renderMap();

        Field field = matrixA.getNextStep(matrixA.getStartPoint());
        matrixA.setNameOfField(field);
        matrixA.setFieldFromCloseArr(0);
        matrixA.renderMap();

        Field field1 = matrixA.getNextStep(field);
        matrixA.setNameOfField(field1);
        matrixA.setFieldFromCloseArr(1);
        matrixA.renderMap();

        Field field2 = matrixA.getNextStep(field1);
        matrixA.setNameOfField(field2);
        matrixA.setFieldFromCloseArr(2);
        matrixA.renderMap();

        Field field3 = matrixA.getNextStep(field2);
        matrixA.setNameOfField(field3);
        matrixA.setFieldFromCloseArr(3);
        matrixA.renderMap();

        Field field4 = matrixA.getNextStep(field3);
        matrixA.setNameOfField(field4);
        matrixA.setFieldFromCloseArr(4);
        matrixA.renderMap();

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
        setFinishPoint(FINISH_X, FINISH_Y);
    }
    private void renderMap() {
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

    private void setFinishPoint(int x, int y) {
        map[x][y].setName("\uD83C\uDF3F");
    }

    private Field getFinishPoint() {
        return map[FINISH_X][FINISH_Y];
    }

    private void setNameOfField(Field field) {
        field.setName("\uD83E\uDD8E");
    }

    private void setFieldFromCloseArr(int i){
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
        IntStream.range(0, arr.length - 1).forEach(i -> {
            if (arr[i] != null && !closeArr.contains(arr[i])) {
                result.add(arr[i]);
            }
        });
        return result;
    }

    private Field getNextStep(Field startPoint) {

        closeArr.add(startPoint); // 1.

        List<Field> neighbors = getNeighbors(startPoint); // 2

        int finishX = getFinishPoint().getX();
        int finishY = getFinishPoint().getY();

        for (Field field : neighbors) {
            int counterX = finishX - field.getX();
            int counterY = finishY - field.getY();
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
        for (Map.Entry entry : openMap.entrySet()) {
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