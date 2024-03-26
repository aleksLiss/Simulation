package org.example.AlgoAStart.Entitys.StaticEntity;

import org.example.AlgoAStart.Entitys.BaseEntity;

public class EmptyEntity extends BaseEntity {
    private String template;
    private String name;
    public EmptyEntity(int index) {
        this.name = "EMPTY";
        this.template = String.format("%d",index);
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
}
