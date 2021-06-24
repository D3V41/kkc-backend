package com.example.kkcbackend.security.controller;

import com.example.kkcbackend.model.User;
import com.example.kkcbackend.payload.request.LoginRequest;
import com.example.kkcbackend.payload.responce.JwtResponce;
import com.example.kkcbackend.security.jwt.JwtUtils;
import com.example.kkcbackend.security.model.AdminDetails;
import com.example.kkcbackend.security.model.WorkerDetails;
import com.example.kkcbackend.security.service.MyUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest l){
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(l.getUsername(),l.getPassword()));


        SecurityContextHolder.getContext().setAuthentication(authentication);

        String jwt = jwtUtils.generateAdminJwtToken(authentication);


        User u = myUserDetailsService.findByUsername(l.getUsername());

        if(u.getEditAccess()){
            AdminDetails adminDetails = (AdminDetails) authentication.getPrincipal();

            List<String> roles = adminDetails.getAuthorities().stream()
                    .map(GrantedAuthority::getAuthority)
                    .collect(Collectors.toList());

            return ResponseEntity.ok(new JwtResponce(jwt,
                    adminDetails.getUsername(),
                    adminDetails.getPassword(),
                    adminDetails.getProjectId(),
                    adminDetails.getClusterName(),
                    roles));
        }
        else {
            WorkerDetails workerDetails = (WorkerDetails) authentication.getPrincipal();

            List<String> roles = workerDetails.getAuthorities().stream()
                    .map(GrantedAuthority::getAuthority)
                    .collect(Collectors.toList());

            return ResponseEntity.ok(new JwtResponce(jwt,
                    workerDetails.getUsername(),
                    workerDetails.getPassword(),
                    workerDetails.getProjectId(),
                    workerDetails.getClusterName(),
                    roles));
        }

    }

    @PostMapping("/signup")
    public ResponseEntity<?> registerAdmin(@NonNull @Valid @RequestBody User u){
        if(myUserDetailsService.checkUserExists(u.getUserName()).isPresent()){
            return ResponseEntity.badRequest()
                    .body("Error : Username is already taken");
        }

        User user = new User(u.getId(),u.getUserName(),u.getClusterName(),u.getEditAccess()
                ,u.getProjectId(),passwordEncoder.encode(u.getPassword()));

        myUserDetailsService.insertUser(user);

        return ResponseEntity.ok("User Registered!!!");
    }
}

