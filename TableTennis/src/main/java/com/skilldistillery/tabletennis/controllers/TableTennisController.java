package com.skilldistillery.tabletennis.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.skilldistillery.tabletennis.data.TableTennisDAO;
import com.skilldistillery.tabletennis.entities.User;

@Controller
public class TableTennisController {

	@Autowired
	private TableTennisDAO dao;

	@RequestMapping(path = {"/","landing.do"})
	public String landing(Model model) {
		List<User> userList = dao.findAll();
		model.addAttribute("users", userList);

		return "landing";
	}
	
	@RequestMapping(path="login.do")
	public String login() {
		return "login";
	}
}
