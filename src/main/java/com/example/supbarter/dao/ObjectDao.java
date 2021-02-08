package com.example.supbarter.dao;

import com.example.supbarter.dao.daoInterface.IObjectDao;
import com.example.supbarter.entity.Object;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class ObjectDao implements IObjectDao {
	@PersistenceContext
	EntityManager em;

	@Override
	public Long count() {
		return (Long) em.createQuery("SELECT count(*) FROM Object ").getSingleResult();
	}

	@Override
	public List<Object> getAll() {
		return em.createQuery("SELECT o from Object o").getResultList();
	}

	@Override
	public List<Object> getWithLimit(Integer limit) {
		return em.createQuery("SELECT o from Object o order by id desc").setMaxResults(limit).getResultList();
	}

	@Override
	public List<Object> getByUserId(Long id) {
		return em.createQuery("SELECT o from Object o WHERE o.user = " + id).getResultList();
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

	@Override
	public List<Object> search(String text) {
		String query = "SELECT o from Object o JOIN o.type t WHERE title LIKE '%" + text + "%' OR description LIKE '%" + text + "%' OR t.name LIKE '%" + text + "%'";
		return em.createQuery(query).getResultList();
	}
}
