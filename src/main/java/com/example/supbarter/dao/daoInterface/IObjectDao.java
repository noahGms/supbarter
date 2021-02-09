package com.example.supbarter.dao.daoInterface;

import com.example.supbarter.entity.Object;

import javax.ejb.Local;
import java.util.List;

@Local
public interface IObjectDao {
	Long count();
	List<Object> getAll();
	List<Object> getAllWithPage(Integer page);
	List<Object> getWithLimit(Integer limit);
	List<Object> search(String text);
	List<Object> getByUserId(Long id);
	Object findById(Long id);
	void create(Object object);
	void update(Long id, Object incoming);
	void remove(Long id);
}
