package com.wiley.interview.test.cache.web.view;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.wiley.interview.test.cache.impl.JavaCache;
import com.wiley.interview.test.cache.impl.JavaCacheFactory;
import com.wiley.interview.test.cache.model.Student;

@Controller
@SessionAttributes("name")
public class PageViewController {
	
	private JavaCache javaCache;

	@RequestMapping(value = "/main", method = RequestMethod.GET)
	public String getMainView(ModelMap model) {
		return "main";
	}

	@RequestMapping(value = "/config", method = RequestMethod.GET)
	public String getConfigView(ModelMap model) {
		return "config";
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String putStudentDataPage(ModelMap model) {
		return "put_data";
	}


	@PostMapping("/setup")
	public String setupCahce(@RequestParam("level") String level,@RequestParam("strategy") String strategy, @RequestParam("maxsize") int maxsize,
		ModelMap modelMap) {
		this.javaCache= JavaCacheFactory.getInstance(level,strategy,maxsize); 
		return "put_data"; // welcome is view name. It will call welcome.jsp
	}

	@PostMapping("/add")
	public String putStudentData(@RequestParam("name") String name,@RequestParam("id") String id, @RequestParam("age") int age,@RequestParam("address") String address,
		ModelMap modelMap) {
		Student student = new Student();
		student.setId(id);
		student.setName(name);
		student.setAge(age);
		student.setAddress(address);
		this.javaCache.put(id, student);
		modelMap.addAttribute("cache", this.javaCache);
		return "show_data"; // welcome is view name. It will call welcome.jsp
	}
}


