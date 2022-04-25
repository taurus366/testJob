package com.example.testjob.model.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@NamedEntityGraph(
        name = "sector_one",
        attributeNodes = {
                @NamedAttributeNode("underSectorOneEntities")
        }
)




@Entity()
@Table(name = "sectors")
public class SectorEntity extends BaseEntity{

    private String name;

    @OneToMany(cascade = CascadeType.ALL)
    private List<UnderSectorOneEntity> underSectorOneEntities = new ArrayList<>();

    public SectorEntity() {
    }

    public String getName() {
        return name;
    }

    public SectorEntity setName(String name) {
        this.name = name;
        return this;
    }

    public List<UnderSectorOneEntity> getUnderSectorOneEntities() {
        return underSectorOneEntities;
    }

    public SectorEntity setUnderSectorOneEntities(List<UnderSectorOneEntity> underSectorOneEntities) {
        this.underSectorOneEntities = underSectorOneEntities;
        return this;
    }
}
