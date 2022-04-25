package com.example.testjob.repository;

import com.example.testjob.model.entity.UnderSectorTwoEntity;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UnderSectorTwoRepository extends JpaRepository<UnderSectorTwoEntity, Long> {

    @EntityGraph("sector_three")
    @Query("SELECT s from UnderSectorTwoEntity s where s.id=:id")
    Optional<UnderSectorTwoEntity> findByIdGraph(@Param("id") Long id);
}
