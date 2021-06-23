package com.example.kkcbackend.security.service;

import com.example.kkcbackend.dao.UserDao;
import com.example.kkcbackend.model.User;
import com.example.kkcbackend.security.model.AdminDetails;
import com.example.kkcbackend.security.model.WorkerDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class MyUserDetailsService implements UserDetailsService {
    @Autowired
    UserDao userDao;

    @Transactional
    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
            User user = userDao.findByUsername(userName).orElseThrow(() -> new UsernameNotFoundException("User not found with name : " + userName));
            if (user.getEditAccess()) {
                return AdminDetails.build(user);
            } else {
                return WorkerDetails.build(user);
            }

    }

    public Optional<User> checkUserExists(String userName){
        return userDao.checkUserExists(userName);
    }

    public void insertUser(User user) {
        userDao.save(user);
    }

    public User findByUsername(String userName){
        return userDao.findByUsername(userName).orElse(null);
    }


}
