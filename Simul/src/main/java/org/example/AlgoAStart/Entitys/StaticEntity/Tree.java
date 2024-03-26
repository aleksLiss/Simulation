package org.example.AlgoAStart.Entitys.StaticEntity;

import org.example.AlgoAStart.Entitys.BaseEntity;

public class Tree extends BaseEntity {
    private String template;
    private String name;
    public Tree() {
        this.template = "\uD83C\uDF32";
        this.name = "TREE";
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
