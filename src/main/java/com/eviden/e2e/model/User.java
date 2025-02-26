package com.eviden.e2e.model;

import com.eviden.e2e.converter.repository.BooleanToYesNoConverter;

import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "users")
public class User {

	@Id
	@GeneratedValue
	private Long id;
	
	@NotNull
	private String username;
	
	private String email;
	
	@Column(name = "active")
	@Convert(converter = BooleanToYesNoConverter.class)
	private boolean active;
	
	@ManyToOne
	@JoinColumn(name = "organisation_id")
	private Organisation organisation;

	public User() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean getActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}
	
    public void setOrganisation(Organisation organisation) {
		this.organisation = organisation;
	}
	
	@Override
	public String toString() {
		return "User {" +
				"id=" + id + '\'' +
				", username=" + username + '\'' +
				", email=" + email + '\'' +
				", active=" + active + '\'' +
				"}";
	}
	
}
