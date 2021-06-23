package com.example.kkcbackend.dao;

import com.example.kkcbackend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserDao extends JpaRepository<User,Long> {
    @Query(value = "SELECT * FROM Users u WHERE u.user_name = :userName",nativeQuery = true)
    Optional<User> findByUsername(String userName);

    @Query(value = "SELECT * FROM Users u WHERE u.user_name = :userName",nativeQuery = true)
    Optional<User> checkUserExists(String userName);

}
