package com.example.kkcbackend.service;

import com.example.kkcbackend.dao.UnitDao;
import com.example.kkcbackend.model.Unit;
import com.example.kkcbackend.payload.responce.UnitListResponce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

    public Unit findByUnitId(int unitId){
        return unitDao.findByUnitId(unitId).orElse(null);
    }

    public Unit findById(Long id){
        return unitDao.findById(id).orElse(null);
    }

    public Unit checkByImeiOrUnitId(Long imei,int unitId){
        return unitDao.checkByImeiOrUnitId(imei,unitId).orElse(null);
    }

    public Boolean updateUnit(Unit u){
        unitDao.updateUnit(u.getImei(),u.getUnitId(),u.getUlb(),u.getMeterNo(),
                u.getClusterName(),u.getRoadName(),u.getLedRating(),u.getTotalLoad(),
                u.getNoOfFixture(),u.getTypeOfLoad(),u.getMobile(),u.getPhase(),u.getLatitude(),
                u.getLongitude(),u.getCommandMode());
        return true;
    }

    public List<Object[]> getUnitList(){
        List<Object[]> list = unitDao.getUnitList();
        List<UnitListResponce> list2 = new ArrayList<>();
        for (Object[] obj : list){
            UnitListResponce unitListResponce = new UnitListResponce();
            unitListResponce.setUnitId((int)obj[0]);
            unitListResponce.setClusterName((String) obj[1]);
            unitListResponce.setPhase((int)obj[2]);
            unitListResponce.setRoadName((String) obj[3]);
            unitListResponce.setUlbName((String) obj[4]);
            list2.add(unitListResponce);
        }
        return unitDao.getUnitList();
    }
}
