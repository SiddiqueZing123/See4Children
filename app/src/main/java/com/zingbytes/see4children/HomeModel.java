package com.zingbytes.see4children.activity.model;

/**
 * Created by Zingbyte-Ajay on 1/10/2018.
 */

public class HomeModel {
    String name,description;

    public HomeModel() {
    }

    public HomeModel(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "HomeModel{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
