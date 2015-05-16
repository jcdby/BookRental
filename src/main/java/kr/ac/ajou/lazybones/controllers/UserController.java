package kr.ac.ajou.lazybones.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import kr.ac.ajou.lazybones.repos.UserRepository;
import kr.ac.ajou.lazybones.repos.entities.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserController {

	@RequestMapping(value = "/User/Register", method = RequestMethod.GET)
	public String showRegistrationForm() {
		return "register";
	}

	@RequestMapping(value = "/User/Register", method = RequestMethod.POST)
	public String processRegistration(@Valid User user, Errors errors) {
		if (errors.hasErrors()) {
			return "register";
		}

		return "redirect:/User/" + user.getId();
	}

	@RequestMapping(value = "/User/{id}", method = RequestMethod.GET)
	public String showSpitterProfile(@PathVariable String id, Model model) {

		return "profile";
	}
	
	
	@RequestMapping(value="/Login", method=RequestMethod.GET)
	public String login() {
			return "login";
	}

	@RequestMapping(value="/Login", method=RequestMethod.POST)
	public Boolean login(HttpServletRequest request) {
		try {
			// if(login condition is failed) {
			// request.getSession().setAttribute("logininfo", false);
			// return false;
			// }
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.getSession().setAttribute("logininfo", true);
		return true;
	}

	@RequestMapping(value = "/Logincheck")
	public void loginCheck(HttpServletRequest request) {
		request.getSession().setAttribute("logininfo", true);
	}
}