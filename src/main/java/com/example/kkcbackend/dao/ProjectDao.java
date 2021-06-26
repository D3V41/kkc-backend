package com.example.kkcbackend.dao;

import com.example.kkcbackend.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectDao extends JpaRepository<Project,Long> {
    @Query(value = "SELECT * FROM Projects p WHERE p.project_id = :projectId",nativeQuery = true)
    Project findByProjectId(Long projectId);
}
