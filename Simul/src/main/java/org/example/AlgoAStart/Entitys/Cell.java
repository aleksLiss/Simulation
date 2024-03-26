package org.example.AlgoAStart.Entitys;

public class Cell {
    private BaseEntity entity;
    private int coordinate;

    public Cell(BaseEntity entity) {
        this.entity = entity;
    }
    public Cell(BaseEntity entity, int coordinate) {
        this.entity = entity;
        this.coordinate = coordinate;
    }

    public BaseEntity getEntity() {
        return entity;
    }

    public void setEntity(BaseEntity entity) {
        this.entity = entity;
    }

    public int getCoordinate() {
        return coordinate;
    }

    public void setCoordinate(int coordinate) {
        this.coordinate = coordinate;
    }
}
