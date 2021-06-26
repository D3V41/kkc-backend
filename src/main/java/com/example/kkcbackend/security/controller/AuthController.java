package com.example.kkcbackend.security.controller;

import com.example.kkcbackend.model.Project;
import com.example.kkcbackend.model.User;
import com.example.kkcbackend.payload.request.LoginRequest;
import com.example.kkcbackend.payload.request.SignUpRequest;
import com.example.kkcbackend.payload.responce.JwtResponce;
import com.example.kkcbackend.security.jwt.JwtUtils;
import com.example.kkcbackend.security.model.AdminDetails;
import com.example.kkcbackend.security.model.WorkerDetails;
import com.example.kkcbackend.security.service.MyUserDetailsService;
import com.example.kkcbackend.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin(origins = "*",maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    MyUserDetailsService myUserDetailsService;
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    JwtUtils jwtUtils;
    @Autowired
    ProjectService projectService;

    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest l){
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(l.getUsername(),l.getPassword()));


        SecurityContextHolder.getContext().setAuthentication(authentication);



        User u = myUserDetailsService.findUser(l.getUsername(),l.getClusterName(),l.getProjectId());

        if(u != null) {
            if (u.getEditAccess()) {
                String jwt = jwtUtils.generateAdminJwtToken(authentication);

                AdminDetails adminDetails = (AdminDetails) authentication.getPrincipal();

                List<String> roles = adminDetails.getAuthorities().stream()
                        .map(GrantedAuthority::getAuthority)
                        .collect(Collectors.toList());

                return ResponseEntity.ok(new JwtResponce(jwt,
                        adminDetails.getUsername(),
                        adminDetails.getProjectId(),
                        adminDetails.getClusterName(),
                        roles));
            } else if (!u.getEditAccess()) {
                String jwt = jwtUtils.generateWorkerJwtToken(authentication);

                WorkerDetails workerDetails = (WorkerDetails) authentication.getPrincipal();

                List<String> roles = workerDetails.getAuthorities().stream()
                        .map(GrantedAuthority::getAuthority)
                        .collect(Collectors.toList());

                return ResponseEntity.ok(new JwtResponce(jwt,
                        workerDetails.getUsername(),
                        workerDetails.getProjectId(),
                        workerDetails.getClusterName(),
                        roles));
            }
        }

        return new ResponseEntity<String>("Cluster name or project id is wrong",HttpStatus.UNAUTHORIZED);
    }

    @PostMapping("/signup")
    public ResponseEntity<?> registerAdmin(@NonNull @Valid @RequestBody SignUpRequest l){
        if(myUserDetailsService.checkUserExists(l.getUsername()).isPresent()){
            return ResponseEntity.badRequest()
                    .body("Error : Username is already taken");
        }

        Project project = projectService.findByProjectId(l.getProjectId());
        if(project == null){
            return new ResponseEntity<String>("Project not exists",HttpStatus.UNAUTHORIZED);
        }
        User user = new User(l.getUsername(),l.getClusterName(),l.getEditAccess(),
                passwordEncoder.encode(l.getPassword()),project);

        myUserDetailsService.insertUser(user);

        return ResponseEntity.ok("User Registered!!!");
    }
}

