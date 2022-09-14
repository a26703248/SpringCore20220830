package spring.core.session03.mvc.repository;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import org.springframework.stereotype.Repository;

import spring.core.session03.mvc.model.User;

@Repository
public class UserDaoImpl implements UserDao{

	// CopyOnWriteArrayList 可安全的執行多執行續
	private List<User> users = new CopyOnWriteArrayList<User>();
	
	@Override
	public void add(User user) {
		System.out.println("repository - add user:" + user);
		users.add(user);
	}

	@Override
	public List<User> findAll() {
		System.out.println("repository - findAll");
		return users;
	}

}
