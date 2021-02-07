package com.example.supbarter.dao;

import com.example.supbarter.entities.User;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Stateless
public class UserDao implements IUserDao {
	@PersistenceContext
	EntityManager em;

	@Override
	public List<User> getAll() {
		return em.createQuery("SELECT u from User u").getResultList();
	}

	@Override
	public User findById(Long id) {
		return em.find(User.class, id);
	}

	@Override
	public User findByField(String[] field) {
		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<User> criteria = builder.createQuery(User.class);
		Root<User> root = criteria.from(User.class);
		criteria.where(
				builder.equal(root.get(field[0]), field[1])
		);
		TypedQuery<User> typed = em.createQuery(criteria);
		try {
			return typed.getSingleResult();
		} catch (final NoResultException nre) {
			return null;
		}
	}

	@Override
	public void create(User user) {
		em.persist(user);
	}
}
