package com.example.testjob.service.Impl;

import com.example.testjob.model.entity.UserEntity;
import com.example.testjob.model.entity.UserSessionEntity;
import com.example.testjob.repository.UserSessionRepository;
import com.example.testjob.service.UserSessionService;
import org.springframework.stereotype.Service;

@Service
public class UserSessionServiceImpl implements UserSessionService {

    private final UserSessionRepository userSessionRepository;

    public UserSessionServiceImpl(UserSessionRepository userSessionRepository) {
        this.userSessionRepository = userSessionRepository;
    }

    @Override
    public UserEntity checkIfTokenExistsAndUser(String token) {
        UserSessionEntity byToken = this.userSessionRepository
                .findByToken(token);

        return byToken.getUser();
    }
}
