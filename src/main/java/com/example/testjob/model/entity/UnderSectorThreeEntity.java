package com.example.testjob.model.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "under_sectors_three")
public class UnderSectorThreeEntity extends BaseEntity{

    private String name;

    public UnderSectorThreeEntity() {
    }

    public String getName() {
        return name;
    }

    public UnderSectorThreeEntity setName(String name) {
        this.name = name;
        return this;
    }
}
