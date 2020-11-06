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
import com.skilldistillery.tabletennis.entities.Address;
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
			errors.rejectValue("email", "error.email", "No account found. Please create a profile.");
		} else if (loggedInUser.getEnabled() == false) {
			errors.rejectValue("enabled", "error.enabled", "Account disabled");
		}
		else {
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
		if (session.getAttribute("loginUser") != null) {
			List<User> userList = dao.findAll();
			model.addAttribute("users", userList);
			return "home";
		} else {
			return "redirect:landing.do";
		}

	}

	@RequestMapping(path = "showCreateProfileForm.do")
	public String showCreateProfileForm(Model model) {
		List<SkillLevel> skillLevels = dao.getSkillLevelList();
		model.addAttribute("skillLevels", skillLevels);
		return "createProfile";
	}

	@RequestMapping(path = "createProfile.do")
	public String createUserProfile(User user, Model model, Address address, int skillLevelId) {
		address.setId(0);
		User newUser = dao.createUser(user, address, skillLevelId);
		model.addAttribute("user", newUser);
		return "login";

	}

	@RequestMapping(path = "viewOtherProfile.do")
	public String showOtherProfile(int id, Model model, HttpSession session) {
		if (session.getAttribute("loginUser") != null) {
			User user = dao.findById(id);
			model.addAttribute("user", user);
			return "viewOtherProfile";
		}
		return "redirect:landing";
	}

	@RequestMapping(path = "viewYourProfile.do")
	public String showYourProfile(Model model, HttpSession session) {
		if (session.getAttribute("loginUser") != null) {
			List<SkillLevel> skillLevelList = dao.getSkillLevelList();
			model.addAttribute("user", session.getAttribute("loginUser"));
			model.addAttribute("skillLevels", skillLevelList);
			return "viewYourProfile";
		}
		return "redirect:landing";
	}
	
	@RequestMapping(path = "showUpdateProfile.do")
	public String showUpdateProfile(Model model, HttpSession session) {
		List<SkillLevel> skillLevels = dao.getSkillLevelList();
		model.addAttribute("user", session.getAttribute("loginUser"));
		model.addAttribute("skillLevels", skillLevels);
		return "updateProfile";
	}
	
	@RequestMapping(path = "updateProfile.do", params="update")
	public String updateProfile(Model model, HttpSession session, User user) {
		User u = dao.updateUser(user);
		
		session.setAttribute("loginUser", u);
		model.addAttribute("user", u);
		return "redirect:viewYourProfile.do";
	}
	
	@RequestMapping(path = "deleteProfile.do")
	public String deleteUser(HttpSession session, User user) {
		if (session.getAttribute("loginUser") != null) {
			User u = (User) session.getAttribute("loginUser");
			Boolean isUserDeleted = dao.isUserDisabled(u);
			if (isUserDeleted == true) {
				return "deleteProfile";
			} else {
				return "showYourProfile";
			}
		}
		return "redirect:landing";
	}

	@RequestMapping(path = "createGame.do", method = RequestMethod.POST)
	public String createGame(Model model, HttpSession session, Game game, int oppId, Address address) {
		if (session.getAttribute("loginUser") != null) {
		User challenger = (User) session.getAttribute("loginUser");
		User challengedUser = dao.findById(oppId);
		Game g = dao.createGame(challengedUser, challenger, game, address);
		model.addAttribute("game", g);
		return "updateGame";
		}
		return "redirect:landing";
	}

	@RequestMapping(path = "createGame.do", method = RequestMethod.GET)
	public String showCreateGameForm(Model model, int id, HttpSession session, Game game) {
		if (session.getAttribute("loginUser") != null) {
			model.addAttribute("opponent", dao.findById(id));
			model.addAttribute("game", game);
			return "createGame";
		} else {
			return "redirect:landing.do";
		}
	}

	@RequestMapping(path = "updateGame.do")
	public String updateProfile(Model model, HttpSession session, Game game) {
		if(session.getAttribute("loginUser") != null) {
		Game g = dao.updateGame(game);
		model.addAttribute("user", session.getAttribute("loginUser"));
		return "redirect:home.do";
		}
		return null;
	}
	
	@RequestMapping(path = "deleteGame.do")
	public String deleteGame(Game game, HttpSession session) {
		if (session.getAttribute("loginUser") != null) {
			Boolean isGameDeleted = dao.isGameDisabled(game);
			if (isGameDeleted == true) {
				return "deleteGame";
			} else {
				return "updateGame";
			}
		}
		return "redirect:landing";
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