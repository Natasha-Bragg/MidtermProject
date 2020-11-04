package com.skilldistillery.tabletennis.data;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.skilldistillery.tabletennis.entities.Address;
import com.skilldistillery.tabletennis.entities.Game;
import com.skilldistillery.tabletennis.entities.SkillLevel;
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
		List<User> userList = em.createQuery(q, User.class).getResultList();
		return userList;
	}

	@Override
	public User createUser(User user) {
		if (isEmailUnique(user.getEmail())) {
			em = emf.createEntityManager();

			em.getTransaction().begin();
			em.persist(user);
			em.flush();
			em.getTransaction().commit();
			em.close();
			return user;
		}
		return null;
	}

	@Override
	public boolean isEmailUnique(String email) {
		em = emf.createEntityManager();
		String jpql = "SELECT u.email FROM User u WHERE email = :x";
		List<String> emailString = em.createQuery(jpql, String.class).setParameter("x", email).getResultList();

		if (0 != emailString.size()) {
			return false;
		}

		return true;
	}

	@Override
	public User getUserByEmail(String email) {
		em = emf.createEntityManager();
		String jpql = "SELECT u FROM User u WHERE email = :x";
		List<User> users = em.createQuery(jpql, User.class).setParameter("x", email).getResultList();

		if (users.size() != 0) {
			return users.get(0);
		} else {
			return null;
		}
	}

	@Override
	public boolean isValidUser(String email, String password) {
//		em = emf.createEntityManager();
//		String jpql = "SELECT u FROM User u WHERE id = ?";
//		User user = em.createQuery(jpql, User.class).setParameter("id", u.getId()).getSingleResult();
//
//		if (user == null) {
//			return false;
//		}
//		
//		else 
//
//		return true;

		User user = getUserByEmail(email);
		if (getUserByEmail(email) == null) {
			return false;
		}
		if (user.getPassword().equals(password)) {
			return true;
		}
		return false;
	}

	@Override
	public Game createGame(User challengedUser, User challenger, Game game) {
		em = emf.createEntityManager();
		Game g = new Game();
		Address a = new Address();
		em.getTransaction().begin();

		g.setPlayerOne(challengedUser);
		g.setPlayerTwo(challenger);
		g.setDateTime(game.getDateTime());
		g.setVenue(game.getVenue());
		a.setStreet(game.getAddress().getStreet());
		a.setCity(game.getAddress().getCity());
		a.setState(game.getAddress().getState());
		g.setAddress(a);

		em.persist(g);
		em.persist(a);
		em.flush();
		em.getTransaction().commit();
		em.close();

		return g;
	}

	@Override
	public List<SkillLevel> getSkillLevelList() {
		em = emf.createEntityManager();
		String q = "SELECT s FROM SkillLevel s";
		List<SkillLevel> skillLevels = em.createQuery(q, SkillLevel.class)
										.getResultList();
		return skillLevels;
	}

}
