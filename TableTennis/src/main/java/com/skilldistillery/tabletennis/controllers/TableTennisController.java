package com.skilldistillery.tabletennis.controllers;

import java.beans.PropertyEditorSupport;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.skilldistillery.tabletennis.data.TableTennisDAO;
import com.skilldistillery.tabletennis.entities.Game;
import com.skilldistillery.tabletennis.entities.SkillLevel;
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
	public String home(Model model, HttpSession session) {
		if(session.getAttribute("loginUser") != null) {
			List<User> userList = dao.findAll();
		model.addAttribute("users", userList);
		return "home";
		}
		else {return "redirect:landing.do";}
		
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
	@RequestMapping(path = "viewYourProfile.do")
	public String showYourProfile(Model model, HttpSession session) {
		List<SkillLevel> skillLevelList = dao.getSkillLevelList();
		model.addAttribute("user", session.getAttribute("loginUser"));
		model.addAttribute("skillLevels", skillLevelList);
		return "viewYourProfile";
	}

	@RequestMapping(path = "createGame.do", method = RequestMethod.POST)
	public String createGame(Model model, HttpSession session, Game game, int oppId) {
		User challenger = (User) session.getAttribute("loginUser");
		User challengedUser = dao.findById(oppId);
		Game g = dao.createGame(challengedUser, challenger, game);
//		session.setAttribute("loginUser", loggedInUser);
		model.addAttribute("game", g);
		return "updateGame";
	}

	@RequestMapping(path = "createGame.do", method = RequestMethod.GET)
	public String showCreateGameForm(Model model, int id, HttpSession session) {
		if(session.getAttribute("loginUser") != null) {
		model.addAttribute("opponent", dao.findById(id));
		return "createGame";
		}
		else {return "redirect:landing.do";}
	}
	
	@RequestMapping(path = "logout.do")
	public String logout(HttpSession session, Model model) {
		session.removeAttribute("loginUser");
		return "redirect:landing.do";
	}

	@InitBinder
	public void initBinder(WebDataBinder webDataBinder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		dateFormat.setLenient(true);
		webDataBinder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
		webDataBinder.registerCustomEditor(LocalDate.class, new PropertyEditorSupport() {
			@Override
			public void setAsText(String text) throws IllegalArgumentException {
				setValue(LocalDate.parse(text, DateTimeFormatter.ofPattern("yyyy-MM-dd")));
			}

			@Override
			public String getAsText() throws IllegalArgumentException {
				return DateTimeFormatter.ofPattern("yyyy-MM-dd").format((LocalDate) getValue());
			}
		});
		webDataBinder.registerCustomEditor(LocalTime.class, new PropertyEditorSupport() {
			@Override
			public void setAsText(String text) throws IllegalArgumentException {
				setValue(LocalTime.parse(text, DateTimeFormatter.ofPattern("HH:mm")));
			}

			@Override
			public String getAsText() throws IllegalArgumentException {
				return DateTimeFormatter.ofPattern("HH:mm").format((LocalTime) getValue());
			}
		});
		webDataBinder.registerCustomEditor(LocalDateTime.class, new PropertyEditorSupport() {
			@Override
			public void setAsText(String text) throws IllegalArgumentException {
				setValue(LocalDateTime.parse(text, DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm")));
			}

			@Override
			public String getAsText() throws IllegalArgumentException {
				return DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm").format((LocalDateTime) getValue());
			}
		});
	}

}