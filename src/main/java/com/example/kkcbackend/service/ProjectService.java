package com.example.kkcbackend.service;

import com.example.kkcbackend.dao.ProjectDao;
import com.example.kkcbackend.model.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectService {
    @Autowired
    ProjectDao projectDao;

    public Project findByProjectId(Long projectId){
        return projectDao.findByProjectId(projectId);
    }
}
