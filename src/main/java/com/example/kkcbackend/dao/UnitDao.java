package com.example.kkcbackend.dao;

import com.example.kkcbackend.model.Project;
import com.example.kkcbackend.model.Unit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UnitDao extends JpaRepository<Unit,Long> {
    @Query(value = "SELECT * FROM Units u WHERE u.imei = :imei",nativeQuery = true)
    Optional<Unit> findByUnitImei(Long imei);

    @Query(value = "SELECT * FROM Units u WHERE u.imei = :imei OR u.unit_id = :unitId",nativeQuery = true)
    Optional<Unit> checkByImeiOrUnitId(Long imei,int unitId);
}
