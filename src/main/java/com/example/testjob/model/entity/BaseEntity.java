package com.example.testjob.model.entity;



import javax.persistence.*;
import java.time.Instant;

@MappedSuperclass
public abstract class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Instant created;


    public Long getId() {
        return id;
    }

    public BaseEntity setId(Long id) {
        this.id = id;
        return this;
    }

    public Instant getCreated() {
        return created;
    }

    public BaseEntity setCreated(Instant created) {
        this.created = created;
        return this;
    }

    @PrePersist
    public void beforeCreate() {
        this.setCreated(Instant.now());
        System.out.println("PRE PERSIST CREATED A RECORD ______________________________________________________________________");
    }
}
