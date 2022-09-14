package spring.core.session03.mvc.repository;

import java.util.List;

import spring.core.session03.mvc.model.User;

public interface UserDao {
	public void add(User user);
	public List<User> findAll();
}
