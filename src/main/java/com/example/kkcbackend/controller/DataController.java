package com.example.kkcbackend.controller;

import com.example.kkcbackend.model.Data;
import com.example.kkcbackend.model.Ulb;
import com.example.kkcbackend.model.Unit;
import com.example.kkcbackend.payload.request.DataRequest;
import com.example.kkcbackend.payload.request.UnitRequest;
import com.example.kkcbackend.payload.responce.StatusResponce;
import com.example.kkcbackend.payload.responce.StringResponce;
import com.example.kkcbackend.payload.responce.UnitListResponce;
import com.example.kkcbackend.service.DataService;
import com.example.kkcbackend.service.UlbService;
import com.example.kkcbackend.service.UnitService;
import com.sun.istack.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/data")
@CrossOrigin(origins = "*",maxAge = 3600)
public class DataController {
    @Autowired
    DataService dataService;
    @Autowired
    UlbService ulbService;
    @Autowired
    UnitService unitService;

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> addData(@Valid @NotNull @RequestBody DataRequest d){
        Boolean data = dataService.getDataById(d.getId());
        Unit unit = unitService.findByUnitId(d.getUnitId());
        Data data1 = new Data(d.getId(),d.getEventType(),unit,d.getMinute(),d.getHour(),d.getDay(),d.getMonth(),
                d.getYear(),d.getTimestamp(),d.getVoltage_R_Phase(),d.getVoltage_Y_Phase(),
                d.getVoltage_B_Phase(),d.getCurrent_R_Phase(),d.getCurrent_Y_Phase(),d.getCurrent_B_Phase(),
                d.getPowerFactor_R_Phase(),d.getPowerFactor_Y_Phase(),d.getPowerFactor_B_Phase(),d.getKwh(),
                d.getKvah(),d.getVoltage_THD_R_Phase_Percentage(),d.getVoltage_THD_Y_Phase_Percentage(),
                d.getVoltage_THD_B_Phase_Percentage(),d.getCurrent_THD_R_Phase_Percentage(),
                d.getCurrent_THD_Y_Phase_Percentage(),d.getCurrent_THD_B_Phase_Percentage(),
                d.getR_Light_Failure(),d.getY_Light_Failure(),d.getPowerFailHRs(),d.getFaultByte(),
                d.getPrime_Mode_ON_TIME(),d.getPrime_Mode_OFF_TIME(),d.getDimmed_ON_TIME(),
                d.getDimmed_OFF_TIME(),d.getLongitude_AXIS(),d.getLatitude_AXIS(),d.getrYB_Image(),
                d.getS1S2BoostOutputImage(),d.getAuxInputImage(),d.getEarthCurrent(),
                d.getlEDDaywiseGlowingHours(),d.getlEDDaywiseNonGlowingHours(),d.getbLight_failure(),
                d.getCreatedOn(),d.getRawString());
        String responce;
        if(!data){
                dataService.insertData(data1);
                responce = "Data Added";
                return new ResponseEntity<StringResponce>(new StringResponce(responce), HttpStatus.OK);
            }
            else {
                responce = "Data exists";
                return new ResponseEntity<StringResponce >(new StringResponce(responce), HttpStatus.UNAUTHORIZED);
            }
    }

    @GetMapping(path = "{ulbname}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> getData(@PathVariable("ulbname")String ulbname){
        List<Data> data = dataService.getDatalistByUlbname(ulbname);
        Ulb ulb = ulbService.findByUlbName(ulbname);
        if(!data.isEmpty()){
            return new ResponseEntity<List<Data>>(data,HttpStatus.OK);
        }
        else {
            if(ulb != null) {
                return new ResponseEntity<StringResponce>(new StringResponce("There is no data in that ulb"), HttpStatus.UNAUTHORIZED);
            }
            else {
                return new ResponseEntity<StringResponce>(new StringResponce("Invalid Ulb Name"), HttpStatus.UNAUTHORIZED);
            }
        }

    }

    @GetMapping(path = "status/{phase}/{ulbname}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<? extends Object> getData(@PathVariable("phase") int phase, @PathVariable("ulbname")String ulbname){
        List<StatusResponce> list = dataService.getStatusData(phase,ulbname);
        if(!list.isEmpty()){
            return new ResponseEntity<List<StatusResponce>>(list,HttpStatus.OK);
        }
        else {
            return new ResponseEntity<StringResponce>(new StringResponce("No data"),HttpStatus.UNAUTHORIZED);
        }

    }
}
