package com.eviden.e2e.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;

import com.eviden.e2e.model.Contract;
import com.eviden.e2e.model.Organisation;
import com.eviden.e2e.repository.OrganisationRepository;

import jakarta.transaction.Transactional;

@Service
public class OrganisationService {

	@Autowired
	OrganisationRepository organisationRepository;

    public List<Organisation> findAll() {
        return organisationRepository.findAll();
    }
	
    public Organisation get(Long id) throws NotFoundException {
        return organisationRepository.findById(id).orElseThrow(NotFoundException::new);
    }
    
    @Transactional
    public void delete(Long id) {
        organisationRepository.deleteById(id);
    }
    
    @Transactional
    public void update(Long id, String name) {
    	organisationRepository.updateNameById(name, id);
    }
}
