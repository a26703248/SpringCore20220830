package spring.core.session03.mvc.service;

import java.util.List;

import spring.core.session03.mvc.model.User;

public interface UserService {	
	public void append(User user);
	public List<User> queryAll();
}

