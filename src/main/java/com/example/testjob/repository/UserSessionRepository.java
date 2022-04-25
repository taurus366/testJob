package com.example.testjob.repository;

import com.example.testjob.model.entity.UserSessionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserSessionRepository extends JpaRepository<UserSessionEntity,Long> {

    UserSessionEntity findByToken(String token);
}
