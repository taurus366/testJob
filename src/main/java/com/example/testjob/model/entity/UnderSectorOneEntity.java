package com.example.testjob.model.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@NamedEntityGraph(
        name = "sector_two",
        attributeNodes = {
                @NamedAttributeNode("underSectorTwoEntities")
        }
)



@Entity
@Table(name = "under_sectors_one")
public class UnderSectorOneEntity extends BaseEntity{

    private String name;

    @OneToMany(cascade = CascadeType.ALL)
    private List<UnderSectorTwoEntity> underSectorTwoEntities= new ArrayList<>();

    public UnderSectorOneEntity() {
    }

    public String getName() {
        return name;
    }

    public UnderSectorOneEntity setName(String name) {
        this.name = name;
        return this;
    }

    public List<UnderSectorTwoEntity> getUnderSectorTwoEntities() {
        return underSectorTwoEntities;
    }

    public UnderSectorOneEntity setUnderSectorTwoEntities(List<UnderSectorTwoEntity> underSectorTwoEntities) {
        this.underSectorTwoEntities = underSectorTwoEntities;
        return this;
    }
}
