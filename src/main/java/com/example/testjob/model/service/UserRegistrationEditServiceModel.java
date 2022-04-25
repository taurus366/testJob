package com.example.testjob.model.service;

public class UserRegistrationEditServiceModel {


    private String username;

    private Long sectorId;

    private Long underSectorOneId;

    private Long underSectorTwoId;


    private Long underSectorThreeId;

    private boolean isAgree;

    public UserRegistrationEditServiceModel() {
    }

    public String getUsername() {
        return username;
    }

    public UserRegistrationEditServiceModel setUsername(String username) {
        this.username = username;
        return this;
    }

    public Long getSectorId() {
        return sectorId;
    }

    public UserRegistrationEditServiceModel setSectorId(Long sectorId) {
        this.sectorId = sectorId;
        return this;
    }

    public Long getUnderSectorOneId() {
        return underSectorOneId;
    }

    public UserRegistrationEditServiceModel setUnderSectorOneId(Long underSectorOneId) {
        this.underSectorOneId = underSectorOneId;
        return this;
    }

    public Long getUnderSectorTwoId() {
        return underSectorTwoId;
    }

    public UserRegistrationEditServiceModel setUnderSectorTwoId(Long underSectorTwoId) {
        this.underSectorTwoId = underSectorTwoId;
        return this;
    }

    public Long getUnderSectorThreeId() {
        return underSectorThreeId;
    }

    public UserRegistrationEditServiceModel setUnderSectorThreeId(Long underSectorThreeId) {
        this.underSectorThreeId = underSectorThreeId;
        return this;
    }

    public boolean isAgree() {
        return isAgree;
    }

    public UserRegistrationEditServiceModel setAgree(boolean agree) {
        isAgree = agree;
        return this;
    }
}

