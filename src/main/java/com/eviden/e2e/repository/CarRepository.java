package com.eviden.e2e.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.eviden.e2e.model.Car;

public interface CarRepository extends JpaRepository<Car, Long>{
	
    @Query("select c from Car c where c.id = :id")
    List<Car> selectById(@Param("id") Long id);
    
}
