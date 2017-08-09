package org.com.cay.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.com.cay.custom.function.SortIntMethod;
import org.com.cay.custom.function.SortStringMethod;
import org.com.cay.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class IndexController {

	@RequestMapping("/index")
	public ModelAndView index(){
		ModelAndView mv = new ModelAndView("index");
		mv.addObject("name", "Cay");
		mv.addObject("users", prepareUsers());
		mv.addObject("flag", true);
		
		mv.addObject("desc", "<font color='red'>我是红色的！</font>");
		
		Map<String, Object> maps = new HashMap<String, Object>();
		maps.put("project", "Java");
		maps.put("hobby", "Swimming");
		maps.put("name", "张三");
		mv.addObject("maps", maps);
		
		mv.addObject("sort_int", new SortIntMethod());
		mv.addObject("sort_string", new SortStringMethod());
		
		return mv;
	}
	
	private List<User> prepareUsers(){
		List<User> users = new ArrayList<User>();
		
		for(int i = 0;i < 5;i++){
			User user = new User();
			user.setId(i + 1);
			
			user.setName("用户" + i);
			user.setBirthday(new Date());
			
			users.add(user);
		}
		
		return users;
		
	}
}
