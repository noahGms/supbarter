package com.example.supbarter.dao;

import com.example.supbarter.dao.interfaces.IObjectDao;
import com.example.supbarter.entities.Object;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class ObjectDao implements IObjectDao {
	@PersistenceContext
	EntityManager em;

	@Override
	public List<Object> getAll() {
		return em.createQuery("SELECT o from Object o").getResultList();
	}

	@Override
	public Object findById(Long id) {
		return em.find(Object.class, id);
	}

	@Override
	public void create(Object object) {
		em.persist(object);
	}

	@Override
	public void update(Long id, Object incoming) {
		Object object = this.findById(id);
		object.setTitle(incoming.getTitle());
		object.setDescription(incoming.getDescription());
		object.setPrice(incoming.getPrice());
		object.setPicture(incoming.getPicture());
		object.setType(incoming.getType());
		em.merge(object);
	}

	@Override
	public void remove(Long id) {
		Object object = this.findById(id);
		em.remove(object);
	}
}
