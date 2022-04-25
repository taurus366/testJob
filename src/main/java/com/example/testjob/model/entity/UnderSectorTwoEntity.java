package com.example.testjob.model.entity;



import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@NamedEntityGraph(
        name = "sector_three",
        attributeNodes = {
                @NamedAttributeNode("underSectorThreeEntities")
        }
)

@Entity
@Table(name = "under_sectors_two")
public class UnderSectorTwoEntity extends BaseEntity{

    private String name;

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private List<UnderSectorThreeEntity> underSectorThreeEntities = new ArrayList<>();

    public UnderSectorTwoEntity() {
    }

    public String getName() {
        return name;
    }

    public UnderSectorTwoEntity setName(String name) {
        this.name = name;
        return this;
    }

    public List<UnderSectorThreeEntity> getUnderSectorThreeEntities() {
        return underSectorThreeEntities;
    }

    public UnderSectorTwoEntity setUnderSectorThreeEntities(List<UnderSectorThreeEntity> underSectorThreeEntities) {
        this.underSectorThreeEntities = underSectorThreeEntities;
        return this;
    }
}
