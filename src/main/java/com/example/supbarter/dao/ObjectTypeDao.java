package com.example.supbarter.dao;

import com.example.supbarter.dao.interfaces.IObjectTypeDao;
import com.example.supbarter.entities.ObjectType;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class ObjectTypeDao implements IObjectTypeDao {
	@PersistenceContext
	EntityManager em;

	@Override
	public List<ObjectType> getAll() {
		return em.createQuery("SELECT u from ObjectType u").getResultList();
	}

	@Override
	public ObjectType findById(Long id) {
		return em.find(ObjectType.class, id);
	}

	@Override
	public void create(ObjectType objectType) {
		em.persist(objectType);
	}

	@Override
	public void remove(Long id) {
		ObjectType objectType = em.find(ObjectType.class , id);
		em.remove(objectType);
	}

	@Override
	public void update(Long id, ObjectType incoming) {
		ObjectType objectType = this.findById(id);
		objectType.setName(incoming.getName());
		em.merge(objectType);
	}
}
