package com.wiley.interview.test.cache.model;

import java.util.Comparator;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.wiley.interview.test.cache.impl.JavaCache;
import com.wiley.interview.test.cache.util.Constants;

public class InMemmoryCache implements JavaCache{
	

    Logger log = LogManager.getLogger(InMemmoryCache.class);

    private static final ConcurrentHashMap<String, Node> cacheMap = new ConcurrentHashMap<>();
    private int MAX_SIZE;
    private String STRATEGY;

    public InMemmoryCache(int maxSize, String strategy) {
        this.MAX_SIZE = maxSize;
        this.STRATEGY = strategy;
    }

    @Override
    public void put(String key, Object value) {
        if (key != null && value != null) {
            while (cacheMap.size() >= MAX_SIZE) {
                evict();
            }
            cacheMap.put(key, new Node(value));
        }
    }

    @Override
    public Object get(String key) {
        if (cacheMap.containsKey(key)) {
            Node node = cacheMap.get(key);
            if (STRATEGY.equals(Constants.LRU)) {
                node.updateAccessedTime();
            } else {
                node.updateFrequency();
            }
            return node.getValue();
        } else {
            return null;
        }
    }

    private void evict() {
        if (STRATEGY.equals(Constants.LRU)) {
            String k = cacheMap.entrySet().stream().min(Comparator.comparing(stringNodeEntry -> stringNodeEntry.getValue().getUpdatedTime())).get().getKey();
            cacheMap.remove(k);
            cacheMap.values().forEach(node -> log.info(node));
        } else {
            String k = cacheMap.entrySet().stream().min(Comparator.comparing(stringNodeEntry -> stringNodeEntry.getValue().getFrequency())).get().getKey();
            cacheMap.remove(k);
            cacheMap.values().forEach(node -> log.info(node));
        }
    }

    @Override
    public String viewCache() {
    	return cacheMap.toString();
    }

	@Override
	public void clearCache() {
		// TODO Auto-generated method stub
		
	}


}
