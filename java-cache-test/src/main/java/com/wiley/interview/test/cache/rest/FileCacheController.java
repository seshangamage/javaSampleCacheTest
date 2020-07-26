package com.wiley.interview.test.cache.rest;

import org.springframework.beans.factory.annotation.Value;

public class FileCacheController {

	@Value("${cache.level}")
	private String level;
	@Value("${cache.strategy}")
	private String strategy;
	@Value("${cache.maxsize}")
	private int maxsize;
	
	
}
