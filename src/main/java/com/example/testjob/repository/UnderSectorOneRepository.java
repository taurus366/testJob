package com.example.testjob.repository;

import com.example.testjob.model.entity.SectorEntity;
import com.example.testjob.model.entity.UnderSectorOneEntity;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UnderSectorOneRepository extends JpaRepository<UnderSectorOneEntity, Long> {

    @EntityGraph(value = "sector_two")
    @Query("SELECT s FROM UnderSectorOneEntity s where s.id = :id")
    Optional<UnderSectorOneEntity> findByIdGraph(@Param("id") Long id);
}
