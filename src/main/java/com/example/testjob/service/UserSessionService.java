package com.example.testjob.service;

import com.example.testjob.model.entity.UserEntity;
import com.example.testjob.model.entity.UserSessionEntity;

public interface UserSessionService {


    UserEntity checkIfTokenExistsAndUser(String token);
}
