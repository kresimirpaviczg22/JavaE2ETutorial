package com.eviden.e2e.model;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "engines")
public class Engine {
	
	public enum EngineType{
		PETROL(1), DIESEL(2), ELECTRIC(3);
		
		private int value;

		EngineType(int i) {
			// TODO Auto-generated constructor stub
			setValue(i);
		}

		public int getValue() {
			return value;
		}

		public void setValue(int value) {
			this.value = value;
		}
		
	}
	
	@Id
	@GeneratedValue
	private Long id;
	
	@NotNull
	private String manufacturer;
	
	private int volume;
	
	private String model;
	
	private int manufacturingYear;
	
	@Enumerated(EnumType.STRING)
	private EngineType engineType;

	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	public String getManufacturer() {
		return manufacturer;
	}
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public int getVolume() {
		return volume;
	}
	public void setVolume(int volume) {
		this.volume = volume;
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

	public EngineType getEngineType() {
		return engineType;
	}
	public void setEngineType(EngineType engineType) {
		this.engineType = engineType;
	}


	
	@Override
	public String toString() {
		return "Engine {" +
				"id=" + id + '\'' +
				", model=" + manufacturer + " " + model + " " + manufacturingYear + '\'' +
				", volume=" + volume + '\'' +
				", type=" + engineType +
				"}";
	}

	public Engine updateFrom(Engine other) {
	    if (other.getManufacturer() != null) setManufacturer(other.getManufacturer());
	    if (other.getVolume() != 0) setVolume(other.getVolume());
	    if (other.getModel() != null) setModel(other.getModel());
	    if (other.getManufacturingYear() != 0) setManufacturingYear(other.getManufacturingYear());
	    if (other.getEngineType() != null) setEngineType(other.getEngineType());

	    return this;
	}

	public Engine() {
	    // Empty constructor
	}

	public Engine(Engine data) {
	    this.id = data.getId();
	    this.manufacturer = data.getManufacturer();
	    this.volume = data.getVolume();
	    this.model = data.getModel();
	    this.manufacturingYear = data.getManufacturingYear();
	    this.engineType = data.getEngineType();
	}
	
}
