package com.eviden.e2e.web;

import java.util.List;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.web.bind.annotation.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.eviden.e2e.model.Engine;
import com.eviden.e2e.service.EngineService;
import com.eviden.e2e.util.JsonMap;

@RestController
@RequestMapping("/api/engines")
public class EngineController {
	
    private static final Logger logger = LoggerFactory.getLogger(EngineController.class);
	
    private final EngineService engineService;

    public EngineController(EngineService engineService) {
        this.engineService = engineService; 
    }
    
    @GetMapping
    JsonMap getEngines() {
        return JsonMap.map()
                .set("content", toDto(engineService.findAll()));
    }
    
    @PostMapping
    Engine createEngine(@RequestBody Engine data) {
        logger.info("Creating a new engine: {}", data);
        return toDto(engineService.create(data));
    }
    
    @GetMapping("/{id}")
    Engine getEngine(@PathVariable("id") Long id) throws NotFoundException {
    	Engine engine = engineService.get(id);
        logger.info("Fetched engine ID: {} - {}", id, (engine != null ? "SUCCESS" : "NOT FOUND"));
        return toDto(engine);
    }
    
    @DeleteMapping("/{id}")
    void deleteEngine(@PathVariable("id") Long id) throws NotFoundException {
    	engineService.deleteById(id); 
        logger.info("Deleted engine ID: {}", id);
    }

	private List<Engine> toDto(List<Engine> engines) {
    	engines.forEach(this::toDto);
        return engines;
	}
	
    private Engine toDto(Engine engine) {  
        return engine;
    }
    
    @GetMapping("/cache-stats")
    JsonMap getCacheStats() {
        long hitCount = engineService.getHitCount();
        long missCount = engineService.getMissCount();
        logger.info("Cache Stats - Hits: {}, Misses: {}", hitCount, missCount);

        return JsonMap.map()
                .set("hitCount", hitCount)
                .set("missCount", missCount);
    }
}
