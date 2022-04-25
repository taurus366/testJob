package com.example.testjob.model.entity;

import javax.persistence.Column;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import javax.persistence.Entity;
import java.time.Instant;

@Entity
@Table(name = "users")
public class UserEntity extends BaseEntity {

    private String username;

    private Boolean agree = false;

    @OneToOne
    private SectorEntity sector;

    @OneToOne
    private UnderSectorOneEntity underSectorOne;

    @OneToOne
    private UnderSectorTwoEntity underSectorTwo;

    @OneToOne
    private UnderSectorThreeEntity underSectorThree;

    private Instant modified;

    public UserEntity() {
    }

    public String getUsername() {
        return username;
    }

    public UserEntity setUsername(String username) {
        this.username = username;
        return this;
    }

    public Boolean getAgree() {
        return agree;
    }

    public UserEntity setAgree(Boolean agree) {
        this.agree = agree;
        return this;
    }

    public SectorEntity getSector() {
        return sector;
    }

    public UserEntity setSector(SectorEntity sectorId) {
        this.sector = sectorId;
        return this;
    }

    public UnderSectorOneEntity getUnderSectorOne() {
        return underSectorOne;
    }

    public UserEntity setUnderSectorOne(UnderSectorOneEntity underSectorOne) {
        this.underSectorOne = underSectorOne;
        return this;
    }

    public UnderSectorTwoEntity getUnderSectorTwo() {
        return underSectorTwo;
    }

    public UserEntity setUnderSectorTwo(UnderSectorTwoEntity underSectorTwo) {
        this.underSectorTwo = underSectorTwo;
        return this;
    }

    public UnderSectorThreeEntity getUnderSectorThree() {
        return underSectorThree;
    }

    public UserEntity setUnderSectorThree(UnderSectorThreeEntity underSectorThree) {
        this.underSectorThree = underSectorThree;
        return this;
    }

    public Instant getModified() {
        return modified;
    }

    public UserEntity setModified(Instant modified) {
        this.modified = modified;
        return this;
    }
}
