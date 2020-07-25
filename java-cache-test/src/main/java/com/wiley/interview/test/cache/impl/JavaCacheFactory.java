package com.wiley.interview.test.cache.impl;

import com.wiley.interview.test.cache.model.FileCache;
import com.wiley.interview.test.cache.model.InMemmoryCache;
import com.wiley.interview.test.cache.util.Constants;

public class JavaCacheFactory {
	
	private static JavaCache cache;
	
    private JavaCacheFactory(){}

    private static void createInstance(String level, String strategy, int memSize){
        if(Constants.FILE_CACHE.equals(level)){
            cache = new FileCache(memSize,strategy);
        }else {
            cache = new InMemmoryCache(memSize,strategy);
        }
    }

    public static JavaCache getInstance(String level, String strategy, int memSize){
        if (cache==null) {
            createInstance(level, strategy, memSize);
        }
        return cache;
    }

}
