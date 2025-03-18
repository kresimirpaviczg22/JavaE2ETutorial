package com.eviden.e2e.service;

import java.util.List;
import java.util.NoSuchElementException;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.eviden.e2e.cache.EngineCache;
import com.eviden.e2e.model.Engine;
import com.eviden.e2e.repository.EngineRepository;

@Service
public class EngineService {
	
    private static final Logger logger = LoggerFactory.getLogger(EngineService.class);
	
	private final EngineRepository engineRepository;
	private final EngineCache engineCache;
	private long hitCount = 0L;
	private long missCount = 0L;
	
    public EngineService(EngineRepository engineRepository) {
        this.engineRepository = engineRepository;
        this.engineCache = EngineCache.getInstance(); // Singleton instance
    }
	
    public Engine get(Long id) throws NoSuchElementException {
        Engine engine = engineCache.get(id);
        if (engine != null) {
        	hitCount++;
            logger.info("Cache HIT for engine ID: {} (Hit Count: {}, Miss Count: {})", id, hitCount, missCount);
            return engine;
        }
        
        engine = engineRepository.findById(id).orElseThrow(NoSuchElementException::new);
        missCount++;
        logger.info("Cache MISS for engine ID: {} (Hit Count: {}, Miss Count: {})", id, hitCount, missCount);
        
        engineCache.put(engine.getId(), engine);
        
        return engine;
    }
    
    public Engine create(Engine data) {
    	Engine newEngine = new Engine(data);
        engineCache.put(newEngine.getId(), newEngine); // Add to cache
        logger.info("Created engine ID: {} and added to cache", newEngine.getId());
        return engineRepository.save(newEngine);
    }
    
    public Engine update(Long id, Engine data) throws NoSuchElementException {
    	Engine engine = get(id).updateFrom(data);
        return engineRepository.save(engine);
    }

    public void deleteById(Long id) {   	
    	engineRepository.deleteById(id);
        engineCache.remove(id); // Remove from cache
        logger.info("Removed engine ID: {} from cache", id);
    }
    
    public List<Engine> findAll() {
        return engineRepository.findAll();
    }
    
    public void logCacheStatistics() {
        logger.info("Cache Statistics - Hit Count: {}, Miss Count: {}", hitCount, missCount);
    }

	public long getHitCount() {
		// TODO Auto-generated method stub
		return hitCount;
	}

	public long getMissCount() {
		// TODO Auto-generated method stub
		return missCount;
	}

}
