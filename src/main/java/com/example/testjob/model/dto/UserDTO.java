package com.example.testjob.model.dto;

public class UserDTO {

    private String username;
    private String sector;
    private String underSectorOne;
    private String underSectorTwo;
    private String underSectorThree;
    private boolean isAgree;

    public UserDTO() {
    }

    public String getUsername() {
        return username;
    }

    public UserDTO setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getSector() {
        return sector;
    }

    public UserDTO setSector(String sector) {
        this.sector = sector;
        return this;
    }

    public String getUnderSectorOne() {
        return underSectorOne;
    }

    public UserDTO setUnderSectorOne(String underSectorOne) {
        this.underSectorOne = underSectorOne;
        return this;
    }

    public String getUnderSectorTwo() {
        return underSectorTwo;
    }

    public UserDTO setUnderSectorTwo(String underSectorTwo) {
        this.underSectorTwo = underSectorTwo;
        return this;
    }

    public String getUnderSectorThree() {
        return underSectorThree;
    }

    public UserDTO setUnderSectorThree(String underSectorThree) {
        this.underSectorThree = underSectorThree;
        return this;
    }

    public boolean isAgree() {
        return isAgree;
    }

    public UserDTO setAgree(boolean agree) {
        isAgree = agree;
        return this;
    }
}
