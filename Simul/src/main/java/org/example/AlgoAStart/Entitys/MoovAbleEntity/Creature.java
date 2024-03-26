package org.example.AlgoAStart.Entitys.MoovAbleEntity;

import org.example.AlgoAStart.Entitys.BaseEntity;

public abstract class Creature extends BaseEntity {
    private int speed;
    private int hp;
    protected abstract void makeMove();
}
