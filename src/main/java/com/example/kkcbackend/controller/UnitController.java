package com.example.kkcbackend.controller;

import com.example.kkcbackend.model.Ulb;
import com.example.kkcbackend.model.Unit;
import com.example.kkcbackend.payload.request.UnitRequest;
import com.example.kkcbackend.service.UlbService;
import com.example.kkcbackend.service.UnitService;
import com.sun.istack.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/unit")
@CrossOrigin(origins = "*",maxAge = 3600)
public class UnitController {
    @Autowired
    UnitService unitService;
    @Autowired
    UlbService ulbService;

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> addUnit(@Valid @NotNull @RequestBody UnitRequest u){
        Ulb ulb = ulbService.findByUlbName(u.getUlbName());
        Unit unit = unitService.checkByImeiOrUnitId(u.getImei(),u.getUnitId());

        if(ulb != null ){
            Unit unit1 = new Unit(u.getImei(),u.getUnitId(),ulb,u.getMeterNo(),u.getClusterName(),
                    u.getRoadName(),u.getLedRating(),u.getTotalLoad(),u.getNoOfFixture(),u.getTypeOfLoad(),
                    u.getMobile(),u.getPhase(),u.getLatitude(),u.getLongitude(),u.getCommandMode());
            if(unit == null){
                unitService.insertUnit(unit1);
                return new ResponseEntity<String>("Unit Added", HttpStatus.OK);
            }
            else {
                return new ResponseEntity<String >("Unit exists", HttpStatus.UNAUTHORIZED);
            }

        }
        else {
            return new ResponseEntity<String >("Ulb not exists", HttpStatus.UNAUTHORIZED);
        }
    }

}
