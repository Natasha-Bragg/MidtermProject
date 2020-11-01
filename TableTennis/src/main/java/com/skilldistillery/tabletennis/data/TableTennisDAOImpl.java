package com.skilldistillery.tabletennis.data;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.skilldistillery.tabletennis.entities.User;

@Transactional
@Service
public class TableTennisDAOImpl implements TableTennisDAO {

	@PersistenceContext
	private EntityManager em;

	@Override
	public User findById(int id) {
		return em.find(User.class, id);
	}

	@Override
	public List<User> findAll() {
String q = "SELECT u FROM User u";
List<User> userList = em.createQuery(q, User.class)
						.getResultList();
		return userList;
	}

}
