package org.example.AlgoAStart.Entitys.MoovAbleEntity;

public class Predator extends Creature {
    private int speed;
    private int hp;
    private String template;
    private String name;
    public Predator() {
        this.speed = 2;
        this.hp = 100;
        this.template = "\uD83D\uDC0A";
        this.name = "PR";
    }

    @Override
    public void makeMove() {

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
