package com.example.testjob.model.service;

import java.util.ArrayList;
import java.util.List;

public class JsonSectorServiceModel {

    private String name;
    private List<JsonSectorServiceModel> children = new ArrayList<>();

    public JsonSectorServiceModel() {
    }

    public String getName() {
        return name;
    }

    public JsonSectorServiceModel setName(String name) {
        this.name = name;
        return this;
    }

    public List<JsonSectorServiceModel> getChildren() {
        return children;
    }

    public JsonSectorServiceModel setChildren(List<JsonSectorServiceModel> children) {
        this.children = children;
        return this;
    }
}
