package org.example.AlgoAStart.Entitys.StaticEntity;

import org.example.AlgoAStart.Entitys.BaseEntity;

public class BorderEntity extends BaseEntity {
    private String name;
    private String template;
    public BorderEntity() {
        this.name = "BORDER";
        this.template = null;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getTemplate() {
        return template;
    }

    public void setTemplate(String template) {
        this.template = template;
    }
}
