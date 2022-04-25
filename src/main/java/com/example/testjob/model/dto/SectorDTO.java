package com.example.testjob.model.dto;

import java.util.ArrayList;
import java.util.List;

public class SectorDTO {

    private Long id;
    private String name;
    private List<SectorDTO> children = new ArrayList<>();

    public SectorDTO() {
    }

    public Long getId() {
        return id;
    }

    public SectorDTO setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public SectorDTO setName(String name) {
        this.name = name;
        return this;
    }

    public List<SectorDTO> getChildren() {
        return children;
    }

    public SectorDTO setChildren(List<SectorDTO> children) {
        this.children = children;
        return this;
    }
}
