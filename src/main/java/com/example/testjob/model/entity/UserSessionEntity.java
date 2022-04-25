package com.example.testjob.model.entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "users_session")
public class UserSessionEntity extends BaseEntity{

    @Column(nullable = false)
    private String token;

    @OneToOne
    private UserEntity user;

    public UserSessionEntity() {
    }

    public String getToken() {
        return token;
    }

    public UserSessionEntity setToken(String token) {
        this.token = token;
        return this;
    }

    public UserEntity getUser() {
        return user;
    }

    public UserSessionEntity setUser(UserEntity user) {
        this.user = user;
        return this;
    }
}
