package com.skilldistillery.tabletennis.data;

import java.util.List;

import com.skilldistillery.tabletennis.entities.User;

public interface TableTennisDAO {

	User findById(int id);
	List<User> findAll();

}
