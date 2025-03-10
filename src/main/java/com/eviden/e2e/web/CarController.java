package com.eviden.e2e.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eviden.e2e.model.Car;
import com.eviden.e2e.service.CarService;
import com.eviden.e2e.util.JsonMap;


@RestController
@RequestMapping("/api/cars")
public class CarController {
	
    @Autowired
    CarService carService;
    
    @GetMapping
    JsonMap getCars() {
        return JsonMap.map()
                .set("content", toDto(carService.findAll()));
    }
    
    @PostMapping
    Car createCars(@RequestBody Car data) {
        System.out.println("--- created car? ---");
        return toDto(carService.create(data));
    }
    
    @GetMapping("/{id}")
    Car getCar(@PathVariable("id") Long id) throws NotFoundException {
    	Car car = carService.get(id);
        return toDto(car);
    }
    
    @DeleteMapping("/{id}")
    void deleteCar(@PathVariable("id") Long id) throws NotFoundException {
    	carService.deleteById(id); 
    }

	private List<Car> toDto(List<Car> cars) {
    	cars.forEach(this::toDto);
        return cars;
	}
	
    private Car toDto(Car car) {  
        return car;
    }

}
