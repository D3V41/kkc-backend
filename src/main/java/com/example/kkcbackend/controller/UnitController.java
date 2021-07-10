package com.example.kkcbackend.controller;

import com.example.kkcbackend.model.Ulb;
import com.example.kkcbackend.model.Unit;
import com.example.kkcbackend.payload.request.UnitRequest;
import com.example.kkcbackend.payload.responce.MapviewResponce;
import com.example.kkcbackend.payload.responce.StatusResponce;
import com.example.kkcbackend.payload.responce.StringResponce;
import com.example.kkcbackend.payload.responce.UnitListResponce;
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
        String responce;
        if(ulb != null ){
            Unit unit1 = new Unit(u.getImei(),u.getUnitId(),ulb,u.getMeterNo(),u.getClusterName(),
                    u.getRoadName(),u.getLedRating(),u.getTotalLoad(),u.getNoOfFixture(),u.getTypeOfLoad(),
                    u.getMobile(),u.getPhase(),u.getLatitude(),u.getLongitude(),u.getCommandMode(),u.getWard());
            if(!unitService.checkByImeiOrUnitId(u.getImei(),u.getUnitId())){
                unitService.insertUnit(unit1);
                responce = "Unit Added";
                return new ResponseEntity<StringResponce>(new StringResponce(responce), HttpStatus.OK);
            }
            else {
                responce = "Unit exists";
                return new ResponseEntity<StringResponce >(new StringResponce(responce), HttpStatus.UNAUTHORIZED);
            }

        }
        else {
            responce = "Ulb not exists";
            return new ResponseEntity<StringResponce >(new StringResponce(responce), HttpStatus.UNAUTHORIZED);
        }
    }

    @GetMapping(path = "{unitId}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> getUnit(@PathVariable("unitId") int unitId){
       Unit u = unitService.findByUnitId(unitId);
       if(u != null){
          return new ResponseEntity<Unit>(u,HttpStatus.OK);
       }
       else {
           return new ResponseEntity<StringResponce>(new StringResponce("Invalid unit id"),HttpStatus.UNAUTHORIZED);
       }

    }

    @GetMapping(path = "unitlist")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<List<UnitListResponce>> getUnitList(){
        List<UnitListResponce> list = unitService.getUnitList();
        if(list != null){
            return new ResponseEntity<List<UnitListResponce>>(list,HttpStatus.OK);
        }
        else {
            return new ResponseEntity<List<UnitListResponce>>((List<UnitListResponce>) null,HttpStatus.UNAUTHORIZED);
        }

    }

    @PutMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> updateUnit(@Valid @NotNull @RequestBody UnitRequest u){
        Ulb ulb = ulbService.findByUlbName(u.getUlbName());
        Unit unit = unitService.findByUnitId(u.getUnitId());
        String responce;
        if(ulb != null ){
            if(unit != null){
                Unit unit1 = new Unit(u.getImei(),u.getUnitId(),ulb,u.getMeterNo(),u.getClusterName(),
                        u.getRoadName(),u.getLedRating(),u.getTotalLoad(),u.getNoOfFixture(),u.getTypeOfLoad(),
                        u.getMobile(),u.getPhase(),u.getLatitude(),u.getLongitude(),u.getCommandMode(),u.getWard());
                unitService.updateUnit(unit1);
                responce = "Unit Updated";
                return new ResponseEntity<StringResponce>(new StringResponce(responce), HttpStatus.OK);
            }
            else {
                responce = "Unit not exists";
                return new ResponseEntity<StringResponce>(new StringResponce(responce), HttpStatus.UNAUTHORIZED);
            }

        }
        else {
            responce = "Ulb not exists";
            return new ResponseEntity<StringResponce>(new StringResponce(responce), HttpStatus.UNAUTHORIZED);
        }
    }

    @GetMapping(path = "mapview/{phase}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<? extends Object> getData(@PathVariable("phase") int phase){
        List<MapviewResponce> list = unitService.getMapviewList(phase);
        if(!list.isEmpty()){
            return new ResponseEntity<List<MapviewResponce>>(list,HttpStatus.OK);
        }
        else {
            return new ResponseEntity<StringResponce>(new StringResponce("No data"),HttpStatus.UNAUTHORIZED);
        }

    }

}
