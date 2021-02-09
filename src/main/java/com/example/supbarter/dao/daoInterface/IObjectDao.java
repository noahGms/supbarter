package com.example.supbarter.dao.daoInterface;

import com.example.supbarter.entity.Object;

import javax.ejb.Local;
import java.util.List;

@Local
public interface IObjectDao {
	Long count();
	Long countUserObjects(Long id);
	List<Object> getAll();
	List<Object> getAllWithPage(Integer page);
	List<Object> getWithLimit(Integer limit);
	List<Object> search(String text);
	List<Object> getByUserId(Long id);
	List<Object> getByUserIdWithPage(Long id, Integer page);
	Object findById(Long id);
	void create(Object object);
	void update(Long id, Object incoming);
	void remove(Long id);
}
