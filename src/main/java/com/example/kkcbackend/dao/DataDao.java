package com.example.kkcbackend.dao;

import com.example.kkcbackend.model.Data;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DataDao extends JpaRepository<Data,Long> {
    @Query(value = "SELECT d FROM Data d JOIN Unit u ON d.unit.unitId = u.unitId " +
            "WHERE u.ulb.ulbName = :ulbname")
    List<Data> findByUlbname(String ulbname);

    @Query(value = "SELECT * FROM Data d WHERE d.id = :id",nativeQuery = true)
    List<Data> findByDataId(Long id);

    @Query(value = "SELECT d.timestamp, u.clusterName, u.ward, u.roadName, u.unitId, d.prime_Mode_ON_TIME, " +
            "d.prime_Mode_OFF_TIME, d.kwh, d.current_R_Phase, d.current_Y_Phase, d.current_B_Phase, " +
            "d.eventType " +
            "FROM Data d JOIN Unit u ON d.unit.unitId = u.unitId " +
            "WHERE u.ulb.ulbName = :ulbname AND u.phase = :phase")
    List<Object[]> getStatusData(int phase,String ulbname);

    @Query(value = "SELECT d.timestamp, u.clusterName, u.ward, u.roadName, u.unitId, d.prime_Mode_ON_TIME, " +
            "d.prime_Mode_OFF_TIME, d.kwh, d.current_R_Phase, d.current_Y_Phase, d.current_B_Phase, " +
            "d.eventType " +
            "FROM Data d JOIN Unit u ON d.unit.unitId = u.unitId " +
            "WHERE u.ulb.ulbName = :ulbname")
    List<Object[]> getStatusDataAllPhase(String ulbname);
}
