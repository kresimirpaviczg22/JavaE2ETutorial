package com.eviden.e2e.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "cars")
public class Car {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@NotNull
	private String vin;
	
	private String make;
	
	private String model;
	
	private int manufacturingYear = 0;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "engine_id", referencedColumnName = "id")
	private Engine engine;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getVin() {
		return vin;
	}
	public void setVin(String vin) {
		this.vin = vin;
	}
	
	public String getMake() {
		return make;
	}
	public void setMake(String make) {
		this.make = make;
	}
	
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	
	public int getManufacturingYear() {
		return manufacturingYear;
	}
	public void setManufacturingYear(int manufacturingYear) {
		this.manufacturingYear = manufacturingYear;
	}
	
	public Engine getEngine() {
		return engine;
	}
	public void setEngine(Engine engine) {
		this.engine = engine;
	}
	
	@Override
	public String toString() {
		return "Car {" +
				"id=" + id + '\'' +
				", vin=" + vin + '\'' +
				", model=" + make + " " + model + " " + manufacturingYear + '\'' +
				", engine=" + engine + '\'' +
				"}";
	}
	public Car updateFrom(Car other) {
        if (other.getVin() != null) setVin(other.getVin());
        if (other.getMake() != null) setMake(other.getMake());
        if (other.getModel() != null) setModel(other.getModel());
        if (other.getManufacturingYear() != 0) setManufacturingYear(other.getManufacturingYear());
        if (other.getEngine() != null) setEngine(other.getEngine());
        
        return this;
	}
	
	public Car() { //empty constructor
		
	}
	 
	public Car(Car data) { //remap constructor
		this.id = data.getId();
		this.vin = data.getVin();
		this.make = data.getMake();
		this.model = data.getModel();
		this.manufacturingYear = data.getManufacturingYear();
		
		this.engine = data.getEngine();
	}
	
}
