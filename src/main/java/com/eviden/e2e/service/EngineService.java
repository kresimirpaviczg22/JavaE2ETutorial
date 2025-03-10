package com.eviden.e2e.service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eviden.e2e.model.Engine;
import com.eviden.e2e.repository.EngineRepository;

@Service
public class EngineService {
	
	@Autowired
	EngineRepository engineRepository;
	
    public Engine get(Long id) throws NoSuchElementException {
        return engineRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }
    
    public Engine create(Engine data) {
        return engineRepository.save(new Engine(data));
    }
    
    public Engine update(Long id, Engine data) throws NoSuchElementException {
    	Engine engine = get(id).updateFrom(data);
        return engineRepository.save(engine);
    }

    public void deleteById(Long id) {   	
    	engineRepository.deleteById(id);
    }
    
    public List<Engine> findAll() {
        return engineRepository.findAll();
    }

}
