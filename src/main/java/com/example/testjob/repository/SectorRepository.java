package com.example.testjob.repository;

import com.example.testjob.model.entity.SectorEntity;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SectorRepository extends JpaRepository<SectorEntity , Long> {

//    RETURN SECTOR
    Optional<SectorEntity> findById(Long id);

//    If I don't want to use fetch:EAGER , I can use this.
    @EntityGraph(value = "sector_one")
    @Query("SELECT s FROM SectorEntity s where s.id = :id")
    Optional<SectorEntity> findByIdGraph(@Param("id") Long id);
}
