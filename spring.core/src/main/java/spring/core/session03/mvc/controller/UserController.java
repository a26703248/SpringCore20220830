package spring.core.session03.mvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import spring.core.session03.mvc.model.User;
import spring.core.session03.mvc.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	public void insert(User user) {
		System.out.println("Controller - insert user:" + user);
		userService.append(user); // 透過 userService 新增 user
	}
	
	public List<User> selectAll() {
		System.out.println("Controller - selectAll");
		return userService.queryAll(); // 透過 userService 查詢所有 user 
	}
	
}
