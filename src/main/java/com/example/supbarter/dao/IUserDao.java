package com.example.supbarter.dao;

import com.example.supbarter.entities.User;

import javax.ejb.Local;
import java.util.List;

@Local
public interface IUserDao {
	List<User> getAll();
	User findById(Long id);
	User findByField(String[] field);
	void create(User user);
}
