package com.eviden.e2e.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.web.bind.annotation.*;

import com.eviden.e2e.model.Engine;
import com.eviden.e2e.service.EngineService;
import com.eviden.e2e.util.JsonMap;

@RestController
@RequestMapping("/api/engines")
public class EngineController {
	
    @Autowired
    EngineService engineService;
    
    @GetMapping
    JsonMap getEngines() {
        return JsonMap.map()
                .set("content", toDto(engineService.findAll()));
    }
    
    @PostMapping
    Engine createEngine(@RequestBody Engine data) {
    	System.out.println("--- added engine? " + data + "---");
        return toDto(engineService.create(data));
    }
    
    @GetMapping("/{id}")
    Engine getEngine(@PathVariable("id") Long id) throws NotFoundException {
    	Engine engine = engineService.get(id);
        return toDto(engine);
    }
    
    @DeleteMapping("/{id}")
    void deleteEngine(@PathVariable("id") Long id) throws NotFoundException {
    	engineService.deleteById(id); 
    }

	private List<Engine> toDto(List<Engine> engines) {
    	engines.forEach(this::toDto);
        return engines;
	}
	
    private Engine toDto(Engine engine) {  
        return engine;
    }
}
