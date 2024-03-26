package org.example.AlgoAStart.Entitys.StaticEntity;

import org.example.AlgoAStart.Entitys.BaseEntity;

public class Grass extends BaseEntity {
    private String template;
    private String name;
    public Grass() {
        this.template = "\uD83C\uDF3F";
        this.name = "GRASS";
    }
    public String getTemplate() {
        return template;
    }
    public void setTemplate(String template) {
        this.template = template;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
