package com.eviden.e2e.model;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;


@Entity
@Table(name = "organisation")
public class Organisation {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@NotNull
	private String name;
	
	private String address;
	
	private String city;

	private String state;
	
	private String country;

	@NotNull
	private LocalDate foundedDate;
	
	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name = "organisation_id")
	private List<User> users;

	public Organisation() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public LocalDate getFoundedDate() {
		return foundedDate;
	}

	public void setFoundedDate(LocalDate foundedDate) {
		this.foundedDate = foundedDate;
	}
	
	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	@Override
	public String toString() {
		return "Organisation {" +
				"id=" + id +
				", name=" + name + '\'' +
				", address=" + address + '\'' +
				", city=" + city + '\'' +
				", state=" + state + '\'' +
				", country=" + country + '\'' +
				", foundedDate=" + foundedDate + '\'' +
				", users=" + users + '\'' +
				"}";
	}
		
}
