package org.example.AlgoAStart.Entitys.StaticEntity;

import org.example.AlgoAStart.Entitys.BaseEntity;

public class Rock extends BaseEntity {
    private String template;
    private String name;
    public Rock() {
        this.template = "\uD83E\uDEA8";
        this.name = "ROCK";
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
