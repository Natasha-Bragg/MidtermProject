package com.skilldistillery.tabletennis.data;

import java.util.List;

import javax.persistence.EntityManager;
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

	public boolean isEmailUnique(String email) {
		String jpql = "SELECT u.email FROM User u WHERE email = :x";
		List<String> emailString = em.createQuery(jpql, String.class).setParameter("x", email).getResultList();

		if (0 != emailString.size()) {
			return false;
		}

		return true;
	}

	@Override
	public User getUserByEmail(String email) {
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
		User user = getUserByEmail(email);
		if (user == null) {
			return false;
		}
		if (user.getPassword().equals(password)) {
			return true;
		}
		return false;
	}

	@Override
	public List<SkillLevel> getSkillLevelList() {
		String q = "SELECT s FROM SkillLevel s";
		List<SkillLevel> skillLevels = em.createQuery(q, SkillLevel.class).getResultList();
		return skillLevels;
	}

	@Override
	public boolean isUserDisabled(User user) {
		User userToUpdate = em.find(User.class, user.getId());
		userToUpdate.setEnabled(false);
		if(userToUpdate.getEnabled() == false) {
			return true;
		}
		else {return false;}
	}

	@Override
	public User createUser(User user, Address address, int skillLevelId) {
		if (isEmailUnique(user.getEmail())) {
			user.setSkillLevel(em.find(SkillLevel.class, skillLevelId));
			em.persist(address);
			user.setAddress(em.find(Address.class, address.getId()));
			em.persist(user);
			em.flush();
			return user;
		}
		return null;
	}
	
	@Override
	public User updateUser(User user) {
		User updateUser = em.find(User.class, user.getId());
		Address address = em.find(Address.class, user.getAddress().getId());
		address.setCity(user.getAddress().getCity());
		address.setStreet(user.getAddress().getStreet());
		address.setState(user.getAddress().getState());
		updateUser.setEmail(user.getEmail());
		updateUser.setPassword(user.getPassword());
		updateUser.setFirstName(user.getFirstName());
		updateUser.setLastName(user.getLastName());
		updateUser.setHost(user.getHost());
		updateUser.setTravel(user.getTravel());
		updateUser.setAddress(address);
		updateUser.setSkillLevel(em.find(SkillLevel.class, user.getSkillLevel().getId()));
		return updateUser;
	}

	@Override
	public Game createGame(User challengedUser, User challenger, Game game, Address address) {
	System.out.println("************In DAO create game");
	System.out.println(address);
		em.persist(address);
		game.setAddress(address);
		System.out.println("************In DAO game address");
	System.out.println(game.getAddress());
		game.setPlayerOne(challengedUser);
		game.setPlayerTwo(challenger);
		em.persist(game);
		
		em.flush();

		return game;
	}
	
	@Override
	public Game updateGame(Game game) {
		Game gameToUpdate = em.find(Game.class, game.getId());
//		User winningUser = em.find(User.class, game.getWinner().getId());
		gameToUpdate.setResult(game.getResult());
//		gameToUpdate.setWinner(winningUser);
		return gameToUpdate;
	}
	
	@Override
	public boolean isGameDisabled(Game game) {
		Game gameToUpdate = em.find(Game.class, game.getId());
		gameToUpdate.setEnabled(false);
		if(gameToUpdate.getEnabled() == false) {
			return true;
		}
		else {return true;}
	}

}
