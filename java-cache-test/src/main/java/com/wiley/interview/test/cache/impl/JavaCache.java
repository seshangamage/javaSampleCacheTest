package com.wiley.interview.test.cache.impl;

public interface JavaCache {
	
    void put(String key, Object value);
    Object get(String key);
    void viewCache();
    void clearCache();

}
