package com.eviden.e2e.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.eviden.e2e.model.User;

public interface UserRepository extends JpaRepository<User, Long>{

    @Query("select u from User u where u.id = :id")
    List<User> selectById(@Param("id") Long id);
    
}
