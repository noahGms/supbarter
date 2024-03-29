package com.example.supbarter.dao.daoInterface;

import com.example.supbarter.entity.ObjectType;

import javax.ejb.Local;
import java.util.List;

@Local
public interface IObjectTypeDao {
	List<ObjectType> getAll();
	ObjectType findById(Long id);
	void create(ObjectType objectType);
	void remove(Long id);
	void update(Long id, ObjectType incoming);
}
