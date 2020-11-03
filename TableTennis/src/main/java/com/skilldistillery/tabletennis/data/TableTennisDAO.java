package com.skilldistillery.tabletennis.data;

import java.util.List;

import com.skilldistillery.tabletennis.entities.Game;
import com.skilldistillery.tabletennis.entities.User;

public interface TableTennisDAO {

	User findById(int id);
	List<User> findAll();
	User createUser(User user);
	boolean isEmailUnique(String email);
	User getUserByEmail(String email);
	boolean isValidUser(String email, String password);
	Game createGame(User challengedUser, User challenger, Game game);
	
}
