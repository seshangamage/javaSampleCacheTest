package com.wiley.interview.test.cache.web.view;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.wiley.interview.test.cache.impl.JavaCache;
import com.wiley.interview.test.cache.impl.JavaCacheFactory;
import com.wiley.interview.test.cache.model.Student;

@Controller
@SessionAttributes("name")
public class PageViewController {

    @Value("${cache.level}")
    private String level;
    @Value("${cache.strategy}")
    private String strategy;
    @Value("${cache.maxsize}")
    private int maxsize;
	
    @RequestMapping(value="/main", method = RequestMethod.GET)
    public String showTodos(ModelMap model){
    	
        return "main";
    }

}
