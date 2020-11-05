package com.skilldistillery.tabletennis.data;

import java.util.List;

import com.skilldistillery.tabletennis.entities.Address;
import com.skilldistillery.tabletennis.entities.Game;
import com.skilldistillery.tabletennis.entities.SkillLevel;
import com.skilldistillery.tabletennis.entities.User;

public interface TableTennisDAO {

	User findById(int id);
	List<User> findAll();
	User createUser(User user, Address address, int skillLevelId);
	User updateUser(User user, Address address, int skillLevelId);
	boolean isEmailUnique(String email);
	User getUserByEmail(String email);
	boolean isValidUser(String email, String password);
	Game createGame(User challengedUser, User challenger, Game game, Address address);
	List<SkillLevel> getSkillLevelList();
	boolean isGameDisabled(Game game);
	boolean isUserDisabled(User user);
	
}
