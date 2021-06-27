package com.example.kkcbackend.dao;

import com.example.kkcbackend.model.Project;
import com.example.kkcbackend.model.Unit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UnitDao extends JpaRepository<Unit,Long> {
    @Query(value = "SELECT * FROM Units u WHERE u.id = :unitId",nativeQuery = true)
    Project findByUnitId(Long unitId);
}
