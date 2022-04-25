package com.example.testjob.model.binding;

import com.example.testjob.model.validator.*;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class UserRegisterEditBindingModel {

    @NotEmpty
    @NotNull
    @NotBlank
    private String username;

    @SectorExists()
    private Long sectorId;

    @UnderSectorOneExists()
    private Long underSectorOneId;

    @UnderSectorTwoExists()
    private Long underSectorTwoId;

    @UnderSectorThreeExists()
    private Long underSectorThreeId;

//    @IfIsTrue()
    @JsonProperty()
    private boolean isAgree;

    public UserRegisterEditBindingModel() {
    }

    public String getUsername() {
        return username;
    }

    public UserRegisterEditBindingModel setUsername(String username) {
        this.username = username;
        return this;
    }

    public Long getSectorId() {
        return sectorId;
    }

    public UserRegisterEditBindingModel setSectorId(Long sectorId) {
        this.sectorId = sectorId;
        return this;
    }

    public Long getUnderSectorOneId() {
        return underSectorOneId;
    }

    public UserRegisterEditBindingModel setUnderSectorOneId(Long underSectorOneId) {
        this.underSectorOneId = underSectorOneId;
        return this;
    }

    public Long getUnderSectorTwoId() {
        return underSectorTwoId;
    }

    public UserRegisterEditBindingModel setUnderSectorTwoId(Long underSectorTwoId) {
        this.underSectorTwoId = underSectorTwoId;
        return this;
    }

    public Long getUnderSectorThreeId() {
        return underSectorThreeId;
    }

    public UserRegisterEditBindingModel setUnderSectorThreeId(Long underSectorThreeId) {
        this.underSectorThreeId = underSectorThreeId;
        return this;
    }

    public boolean IsAgree() {
        return isAgree;
    }

    public UserRegisterEditBindingModel setAgree(boolean agree) {
        isAgree = agree;
        return this;
    }


}
