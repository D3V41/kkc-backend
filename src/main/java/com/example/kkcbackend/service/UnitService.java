package com.example.kkcbackend.service;

import com.example.kkcbackend.dao.UnitDao;
import com.example.kkcbackend.model.Unit;
import com.example.kkcbackend.payload.responce.MapviewResponce;
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

    public Boolean checkByImeiOrUnitId(Long imei,int unitId){
        List<Unit> units = unitDao.checkByImeiOrUnitId(imei,unitId);
        return !units.isEmpty();

    }

    public Boolean updateUnit(Unit u){
        unitDao.updateUnit(u.getImei(),u.getUnitId(),u.getUlb(),u.getMeterNo(),
                u.getClusterName(),u.getRoadName(),u.getLedRating(),u.getTotalLoad(),
                u.getNoOfFixture(),u.getTypeOfLoad(),u.getMobile(),u.getPhase(),u.getLatitude(),
                u.getLongitude(),u.getCommandMode(),u.getWard());
        return true;
    }

    public List<UnitListResponce> getUnitList(){
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
        return list2;
    }

    public List<MapviewResponce> getMapviewList(int phase,String ulbname){
        List<Object[]> list = unitDao.getMapviewList(phase,ulbname);
        return extractMapData(list);
    }

    public List<MapviewResponce> getMapviewListAllPhase(String ulbname){
        List<Object[]> list = unitDao.getMapviewListAllPhase(ulbname);
        return extractMapData(list);
    }

    public List<MapviewResponce> extractMapData(List<Object[]> list){
        List<MapviewResponce> list2 = new ArrayList<>();
        for (Object[] obj : list){
            MapviewResponce mapviewResponce = new MapviewResponce();
            mapviewResponce.setUnitId((Integer) obj[0]);
            mapviewResponce.setRoadName((String) obj[1]);
            mapviewResponce.setLatitude((Float) obj[2]);
            mapviewResponce.setLongitude((Float) obj[3]);
            list2.add(mapviewResponce);
        }
        return list2;
    }
}
