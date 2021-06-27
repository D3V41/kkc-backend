package com.example.kkcbackend.dao;

import com.example.kkcbackend.model.Project;
import com.example.kkcbackend.model.Ulb;
import com.example.kkcbackend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UlbDao extends JpaRepository<Ulb,Long> {
    @Query(value = "SELECT * FROM Ulbs u WHERE u.ulb_id = :ulbId",nativeQuery = true)
    Optional<Ulb> findByUlbId(Long ulbId);

    @Query(value = "SELECT * FROM Ulbs u WHERE u.ulb_name = :ulbName",nativeQuery = true)
    Optional<Ulb> findByUlbName(String ulbName);
}
