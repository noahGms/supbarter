package com.example.supbarter.dao.daoInterface;

import com.example.supbarter.entity.User;

import javax.ejb.Local;
import java.util.List;

@Local
public interface IUserDao {
	List<User> getAll();
	User findById(Long id);
	User findByField(String[] field);
	void create(User user);
	void update(Long id, User incoming);
}
