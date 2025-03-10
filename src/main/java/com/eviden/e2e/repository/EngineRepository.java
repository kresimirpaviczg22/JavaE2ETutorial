package com.eviden.e2e.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.eviden.e2e.model.Engine;

public interface EngineRepository extends JpaRepository<Engine, Long>{
	
    @Query("select e from Engine e where e.id = :id")
    List<Engine> selectById(@Param("id") Long id);

}
