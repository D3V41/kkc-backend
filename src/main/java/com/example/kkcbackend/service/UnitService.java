package com.example.kkcbackend.service;

import com.example.kkcbackend.dao.UnitDao;
import com.example.kkcbackend.model.Unit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UnitService {
    @Autowired
    UnitDao unitDao;

    public Boolean insertUnit(Unit unit){
        unitDao.save(unit);
        return true;
    }

    public Unit findByUnitImei(Long imei){
        return unitDao.findByUnitImei(imei).orElse(null);
    }

    public Unit checkByImeiOrUnitId(Long imei,int unitId){
        return unitDao.checkByImeiOrUnitId(imei,unitId).orElse(null);
    }
}
