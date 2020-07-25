package com.wiley.interview.test.cache;

import org.junit.jupiter.api.Test;

import com.wiley.interview.test.cache.impl.JavaCache;
import com.wiley.interview.test.cache.impl.JavaCacheFactory;
import com.wiley.interview.test.cache.model.Student;

public class InMemmoryCacheTest {

	
	@Test
	public void addValuesToCacheLFU() {
        JavaCache cache = JavaCacheFactory.getInstance("memory","LFU", 3);
        Student s = new Student();
        s.setAddress("Colombo");
        s.setName("SHeshan");
        s.setId("123456");
        s.setAge(34);
        Student s1 = new Student();
        s1.setAddress("Colombo");
        s1.setName("SHeshan");
        s1.setId("123456");
        s1.setAge(34);
        Student s2 = new Student();
        s2.setAddress("Colombo");
        s2.setName("SHeshan");
        s2.setId("123456");
        s2.setAge(34);
        Student s3 = new Student();
        s3.setAddress("Colombo");
        s3.setName("SHeshan");
        s3.setId("123456");
        s3.setAge(34);
        Student s4 = new Student();
        s4.setAddress("Colombo");
        s4.setName("SHeshan");
        s4.setId("123456");
        s4.setAge(34);
        cache.put("123456", s );
        cache.put("123457", s1 );
        cache.put("123458", s2 );
        cache.put("123459", s3 );
        cache.put("123460", s4 );
        Student s10 = (Student) cache.get("123456");
        System.out.println( s10.getAddress());
        cache.viewCache();
	}
	
	
	@Test
	public void addValuesToCacheLRU() {
        JavaCache cache = JavaCacheFactory.getInstance("memory","LRU", 3);
        Student s = new Student();
        s.setAddress("Colombo");
        s.setName("SHeshan");
        s.setId("123456");
        s.setAge(34);
        Student s1 = new Student();
        s1.setAddress("Colombo");
        s1.setName("SHeshan");
        s1.setId("123456");
        s1.setAge(34);
        Student s2 = new Student();
        s2.setAddress("Colombo");
        s2.setName("SHeshan");
        s2.setId("123456");
        s2.setAge(34);
        Student s3 = new Student();
        s3.setAddress("Colombo");
        s3.setName("SHeshan");
        s3.setId("123456");
        s3.setAge(34);
        Student s4 = new Student();
        s4.setAddress("Colombo");
        s4.setName("SHeshan");
        s4.setId("123456");
        s4.setAge(34);
        cache.put("123456", s );
        cache.put("123457", s1 );
        cache.put("123458", s2 );
        cache.put("123459", s3 );
        cache.put("123460", s4 );
        Student s10 = (Student) cache.get("123456");
        System.out.println(s10.getAddress());
        cache.viewCache();
	}

}
