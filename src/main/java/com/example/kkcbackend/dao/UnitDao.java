package com.example.kkcbackend.dao;

import com.example.kkcbackend.model.Project;
import com.example.kkcbackend.model.Ulb;
import com.example.kkcbackend.model.Unit;
import com.example.kkcbackend.payload.responce.UnitListResponce;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public interface UnitDao extends JpaRepository<Unit,Long> {
    @Query(value = "SELECT * FROM Units u WHERE u.imei = :imei",nativeQuery = true)
    Optional<Unit> findByUnitImei(Long imei);

    @Query(value = "SELECT * FROM Units u WHERE u.imei = :imei OR u.unit_id = :unitId",nativeQuery = true)
    List<Unit> checkByImeiOrUnitId(Long imei,int unitId);

    @Modifying
    @Query(value = "UPDATE Unit u SET u.clusterName = :clusterName, u.commandMode = :commandMode," +
            " u.imei = :imei, u.latitude = :latitude, u.ledRating = :ledRating, u.longitude = :longitude," +
            " u.meterNo = :meterNo, u.mobile = :mobile, u.noOfFixture = :noOfFixture," +
            " u.phase = :phase, u.roadName = :roadName, u.totalLoad = :totalLoad," +
            " u.typeOfLoad = :typeOfLoad, u.ulb = :ulb, u.ward = :ward WHERE u.unitId = :unitId")
    void updateUnit(@Param("imei") Long imei,@Param("unitId") int unitId,@Param("ulb") Ulb ulb,
                        @Param("meterNo") String meterNo,@Param("clusterName")String clusterName,
                        @Param("roadName")String roadName, @Param("ledRating") float ledRating,
                        @Param("totalLoad")float totalLoad, @Param("noOfFixture") int noOfFixture,
                        @Param("typeOfLoad")String typeOfLoad, @Param("mobile") Long mobile,
                        @Param("phase") int phase, @Param("latitude") float latitude,
                        @Param("longitude") float longitude, @Param("commandMode") String commandMode,
                    @Param("ward")int ward);

    @Query(value = "SELECT * FROM Units u WHERE u.unit_id = :unitId",nativeQuery = true)
    Optional<Unit> findByUnitId(int unitId);

    @Query(value = "SELECT * FROM Units u WHERE u.id = :id",nativeQuery = true)
    Optional<Unit> findById(Long id);

    @Query(value = "SELECT unit.unitId, ulb.clusterName, unit.phase, unit.roadName, ulb.ulbName " +
            "FROM Unit unit " +
            "JOIN Ulb as ulb " +
            "ON unit.ulb.ulbId = ulb.ulbId")
    List<Object[]> getUnitList();

    @Query(value = "SELECT u.unitId, u.roadName, u.latitude, u.longitude " +
            "FROM Unit u " +
            "WHERE u.phase = :phase AND u.ulb.ulbName = :ulbname")
    List<Object[]> getMapviewList(int phase,String ulbname);

    @Query(value = "SELECT u.unitId, u.roadName, u.latitude, u.longitude " +
            "FROM Unit u " +
            "WHERE u.ulb.ulbName = :ulbname")
    List<Object[]> getMapviewListAllPhase(String ulbname);
}
