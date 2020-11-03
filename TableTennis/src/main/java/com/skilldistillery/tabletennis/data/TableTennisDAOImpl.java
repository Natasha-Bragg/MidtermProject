package com.skilldistillery.tabletennis.data;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.skilldistillery.tabletennis.entities.User;

@Transactional
@Service
public class TableTennisDAOImpl implements TableTennisDAO {
	
	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("TableTennisProject");

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
	
	@Override
	public User createUser(User user) {
		em = emf.createEntityManager();

	    em.getTransaction().begin();
	    em.persist(user);
	    em.flush();
	    em.getTransaction().commit();
		em.close();
		return user;
	}

	@Override
	public User login(User user) {
		// TODO Auto-generated method stub
		return user;
	}

}
