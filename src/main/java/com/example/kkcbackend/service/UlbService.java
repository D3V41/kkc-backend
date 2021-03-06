package com.example.kkcbackend.service;

import com.example.kkcbackend.dao.ProjectDao;
import com.example.kkcbackend.dao.UlbDao;
import com.example.kkcbackend.model.Project;
import com.example.kkcbackend.model.Ulb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UlbService {
    @Autowired
    UlbDao ulbDao;

    public Ulb findByUlbId(Long ulbId){
        return ulbDao.findByUlbId(ulbId).orElse(null);
    }

    public Boolean insertUlb(Ulb ulb){
         ulbDao.save(ulb);
         return true;
    }

    public Ulb findByUlbName(String name){
        return ulbDao.findByUlbName(name).orElse(null);
    }

    public List<String> getUlbNames(){
        return ulbDao.getUlbnames();
    }

    public List<String> getUlbnameByCluster(String clusterName){
        return ulbDao.getUlbnameByCluster(clusterName);
    }
}
