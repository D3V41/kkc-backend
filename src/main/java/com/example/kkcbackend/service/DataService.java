package com.example.kkcbackend.service;

import com.example.kkcbackend.dao.DataDao;
import com.example.kkcbackend.model.Data;
import com.example.kkcbackend.payload.responce.StatusResponce;
import com.example.kkcbackend.payload.responce.UnitListResponce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class DataService {
    @Autowired
    DataDao dataDao;

    public Boolean insertData(Data d){
        dataDao.save(d);
        return true;
    }

    public List<Data> getDatalistByUlbname(String ulbname){
        return dataDao.findByUlbname(ulbname);
    }

    public Boolean getDataById(Long id){
        List<Data> data = dataDao.findByDataId(id);
        return !data.isEmpty();
    }

    public List<StatusResponce> getStatusData(int phase,String ulbname){
        List<Object[]> list = dataDao.getStatusData(phase,ulbname);
        return extractStatus(list);
    }

    public List<StatusResponce> getStatusDataAllPhase(String ulbname){
        List<Object[]> list = dataDao.getStatusDataAllPhase(ulbname);
        return extractStatus(list);
    }

    public float getTotalcurrent(float r,float y, float b){
        return (r+y+b)/3;
    }

    public List<StatusResponce> extractStatus(List<Object[]> list){
        List<StatusResponce> list2 = new ArrayList<>();
        for (Object[] obj : list){
            StatusResponce statusResponce = new StatusResponce();
            statusResponce.setTimestamp((Date) obj[0]);
            statusResponce.setZone((String) obj[1]);
            statusResponce.setWard((int) obj[2]);
            statusResponce.setRoadName((String) obj[3]);
            statusResponce.setUnitId((int) obj[4]);
            float iTotal = getTotalcurrent((float)obj[8],(float)obj[9],(float)obj[10]);
            if(iTotal==0){
                statusResponce.setStatus(false);
            }
            else {
                statusResponce.setStatus(true);
            }
            statusResponce.setOnTime((String) obj[5]);
            statusResponce.setOffTime((String) obj[6]);
            statusResponce.setKwh((float) obj[7]);
            statusResponce.setiTotal(iTotal);
            statusResponce.setKwTotal(0.0F);
            statusResponce.setEventType((String) obj[11]);
            statusResponce.setTotalloadwattage(0.0F);
            list2.add(statusResponce);
        }
        return list2;
    }
}
