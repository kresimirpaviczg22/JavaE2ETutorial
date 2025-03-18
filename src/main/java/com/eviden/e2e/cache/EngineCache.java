package com.eviden.e2e.cache;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.eviden.e2e.model.Engine;
import com.eviden.e2e.web.EngineController;

public class EngineCache {
	

    private static final Logger logger = LoggerFactory.getLogger(EngineController.class);

    private static volatile EngineCache instance;
    
    private final Map<Long, Engine> cache = new HashMap<>();

    private EngineCache() { // Empty constructor
    	
    }

    public static EngineCache getInstance() {
        if (instance == null) {
            synchronized (EngineCache.class) { // Thread safety
                if (instance == null) {
                    instance = new EngineCache();
                }
            }
        }
        return instance;
    }

    public Engine get(Long id) {
    	logger.info("Getting {} from cache...", id);
        return cache.get(id);
    }

    public void put(Long id, Engine engine) {
    	logger.info("Putting {} in cache...", id);
        cache.put(id, engine);
    }

    public void remove(Long id) {
    	logger.info("Removing {} from cache...", id);
        cache.remove(id);
    }

    public void clear() {
        cache.clear();
    }
}
