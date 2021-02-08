package com.example.supbarter.dao.daoInterface;

import com.example.supbarter.entity.Object;

import javax.ejb.Local;
import java.util.List;

@Local
public interface IObjectDao {
	List<Object> getAll();
	Object findById(Long id);
	void create(Object object);
	void update(Long id, Object incoming);
	void remove(Long id);
}
