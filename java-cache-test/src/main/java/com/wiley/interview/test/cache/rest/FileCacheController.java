package com.wiley.interview.test.cache.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wiley.interview.test.cache.impl.JavaCache;
import com.wiley.interview.test.cache.impl.JavaCacheFactory;
import com.wiley.interview.test.cache.model.Student;

@Controller
@RequestMapping("/api/v1/infile")
public class FileCacheController {

	@Value("${cache.level}")
	private String level;
	@Value("${cache.strategy}")
	private String strategy;
	@Value("${cache.maxsize}")
	private int maxsize;
	
	private JavaCache cache;
	
	@PostMapping(path = "/add", consumes = "application/json", produces = "application/json")
	public HttpEntity<String> registerUser(@RequestBody Student student) {
		try {
		 cache = JavaCacheFactory.getInstance(level,strategy, maxsize);
		 cache.put(student.getId(), student);
		 return ResponseEntity.status(HttpStatus.OK).build();
		}
		catch(Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_GATEWAY).build();
		}
	}
	
	@GetMapping(path = "/getall", consumes = "application/json", produces = "application/json")
	public HttpEntity<String> getCacheData() {
		try {
		 return ResponseEntity.ok(cache.viewCache());
		}
		catch(Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_GATEWAY).build();
		}
	}
	
	@GetMapping(path = "/get", consumes = "application/json", produces = "application/json")
	public ResponseEntity<Object> getCacheDataforStudentId(@RequestParam String id) {
		try {
			Student s = (Student) cache.get(id);
		    ObjectMapper mapper = new ObjectMapper();
		    String jsonString = mapper.writeValueAsString(s);
		 return ResponseEntity.ok(jsonString);
		}
		catch(Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_GATEWAY).build();
		}
	}
	
	@GetMapping(path = "/clear", consumes = "application/json", produces = "application/json")
	public ResponseEntity<Object> clearCache() {
		try {
			cache.clearCache();
			return ResponseEntity.status(HttpStatus.OK).build();
		}
		catch(Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_GATEWAY).build();
		}
	}
	
}
