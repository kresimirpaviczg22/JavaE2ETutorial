package com.eviden.e2e.service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eviden.e2e.model.Car;
import com.eviden.e2e.model.Engine;
import com.eviden.e2e.repository.CarRepository;
import com.eviden.e2e.repository.EngineRepository;

@Service
public class CarService {
	
	@Autowired
	CarRepository carRepository;
	
	@Autowired
	EngineRepository engineRepository;
	
    public Car get(Long id) throws NoSuchElementException {
        return carRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }
    
    public Car create(Car data) {
        if (data.getEngine() != null && data.getEngine().getId() != null) {
            Engine managedEngine = engineRepository.findById(data.getEngine().getId())
                    .orElseThrow(() -> new RuntimeException("Engine not found!"));
            data.setEngine(managedEngine);
        }
        return carRepository.save(data);
    }
    
    public Car update(Long id, Car data) throws NoSuchElementException {
        Car car = get(id).updateFrom(data);
        return carRepository.save(car);
    }

    public void deleteById(Long id) {   	
    	carRepository.deleteById(id);
    }
    
    public List<Car> findAll() {
        return carRepository.findAll();
    }
}
