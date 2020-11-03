package com.skilldistillery.tabletennis.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.skilldistillery.tabletennis.data.TableTennisDAO;
import com.skilldistillery.tabletennis.entities.User;

@Controller
public class TableTennisController {

	@Autowired
	private TableTennisDAO dao;

	@RequestMapping(path = { "/", "landing.do" })
	public String landing(Model model) {
		List<User> userList = dao.findAll();
		model.addAttribute("users", userList);
		return "landing";
	}

	@RequestMapping(path = "login.do", method = RequestMethod.POST)
	public String doLogin(Model model, @ModelAttribute("user") @Valid User user, Errors errors, HttpSession session) {
		User loggedInUser = dao.getUserByEmail(user.getEmail());
		if (loggedInUser == null) {
			errors.rejectValue("email", "error.email", "Invalid email or password");
		} else {
			// TODO: Else if the user is not valid (isValidUser), use the Errors object to
			// reject
			// the password with the message "Incorrect password"
			boolean isValidUser = dao.isValidUser(loggedInUser.getEmail(), loggedInUser.getPassword());
			if (!isValidUser) {
				errors.rejectValue("password", "error.password", "Incorrect password");
			}
		}
		if (errors.getErrorCount() != 0) {
			return "login";
		}
		session.setAttribute("loginUser", loggedInUser);
		List<User> userList = dao.findAll();
		model.addAttribute("users", userList);
		return "home";
	}

	@RequestMapping(path = "login.do", method = RequestMethod.GET)
	public String showLogin(Model model) {
		model.addAttribute("user", new User());
		return "login";
	}

	@RequestMapping(path = "home.do")
	public String home(Model model) {
		List<User> userList = dao.findAll();
		model.addAttribute("users", userList);
		return "home";
	}

	@RequestMapping(path = "deleteProfile.do")
	public String deleted() {
		return "deleteProfile";
	}

	@RequestMapping(path = "showCreateProfileForm.do")
	public String showCreateProfileForm() {
		return "createProfile";
	}

	@RequestMapping(path = "createProfile.do")
	public String createUserProfile(User user, Model model) {
		User newUser = dao.createUser(user);
		model.addAttribute("user", newUser);
		return "viewYourProfile";

	}
	@RequestMapping(path = "viewOtherProfile.do")
	public String showOtherProfile(int id, Model model) {
		User user = dao.findById(id);
		model.addAttribute("user", user);
		return "viewOtherProfile";
	}
	@RequestMapping(path = "createGame.do")
	public String createGame(int id, Model model) {
		User user = dao.findById(id);
		model.addAttribute("user", user);
		return "viewOtherProfile";
	}
}