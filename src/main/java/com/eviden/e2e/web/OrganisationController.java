package com.eviden.e2e.web;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eviden.e2e.model.Organisation;
import com.eviden.e2e.service.OrganisationService;
import com.eviden.e2e.util.JsonMap;

@RestController
@RequestMapping("/api/organisations")
public class OrganisationController {
	
	@Autowired
	OrganisationService organisationService;
	
	@GetMapping
	JsonMap getOrganisations() {
		return JsonMap.map().set("organisations", toDto(organisationService.findAll()));
	}
	
	@DeleteMapping("/{id}")
	boolean deleteOrganisation (@PathVariable("id") Long Id){
		organisationService.delete(Id);
		return true;
	}
	
	@PatchMapping("/{id}")
	boolean updateOrganisation (@PathVariable("id") Long Id, @RequestBody String name) {
		organisationService.update(Id, name);
		return true;
	}
	
	private List<Organisation> toDto(List<Organisation> organisations) {
		organisations.forEach(this::toDto);
		return organisations;
	}

	private Organisation toDto(Organisation organisation) {
		return organisation;
	}
}
