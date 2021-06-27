package com.example.kkcbackend.controller;

import com.example.kkcbackend.model.Project;
import com.example.kkcbackend.model.Ulb;
import com.example.kkcbackend.payload.request.UlbRequest;
import com.example.kkcbackend.service.ProjectService;
import com.example.kkcbackend.service.UlbService;
import com.sun.istack.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/ulb")
@CrossOrigin(origins = "*",maxAge = 3600)
public class UldController {
    @Autowired
    UlbService ulbService;
    @Autowired
    ProjectService projectService;

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> addUlb(@Valid @NotNull @RequestBody UlbRequest u){
        Project p = projectService.findByProjectId(u.getProjectId());
        Ulb u1 = ulbService.findByUlbName(u.getUlbName());
        if(p != null){
            Ulb ulb = new Ulb(u.getUlbId(),u.getUlbName(),u.getClusterName(),p);
            if(u1 == null){
                ulbService.insertUlb(ulb);
                return new ResponseEntity<String>("Ulb Added",HttpStatus.OK);
            }
            else {
                return new ResponseEntity<String >("Ulb exists", HttpStatus.UNAUTHORIZED);
            }
        }
        else {
            return new ResponseEntity<String >("Project not exists", HttpStatus.UNAUTHORIZED);
        }
    }
}
