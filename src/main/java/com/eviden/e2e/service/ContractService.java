package com.eviden.e2e.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;

import com.eviden.e2e.model.Contract;
import com.eviden.e2e.repository.ContractRepository;

@Service
public class ContractService {

	@Autowired
	ContractRepository contractRepository;
   
    public Contract get(Long id) throws NotFoundException {
        return contractRepository.findById(id).orElseThrow(NotFoundException::new);
    }
    
    public Contract create(Contract data) {
        return contractRepository.save(new Contract(data));
    }

    public Contract update(Long id, Contract data) throws NotFoundException {
        return get(id).updateFrom(data);
    }
    
    public void deleteById(Long id) {   	
    	contractRepository.deleteById(id);
    }
    
    public List<Contract> findAll() {
        return contractRepository.findAll();
    }
}
