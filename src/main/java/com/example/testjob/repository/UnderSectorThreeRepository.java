package com.example.testjob.repository;

import com.example.testjob.model.entity.UnderSectorThreeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UnderSectorThreeRepository extends JpaRepository<UnderSectorThreeEntity, Long> {
}
