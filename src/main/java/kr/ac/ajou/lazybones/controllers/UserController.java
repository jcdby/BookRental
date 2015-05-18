package kr.ac.ajou.lazybones.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import kr.ac.ajou.lazybones.repos.UserRepository;
import kr.ac.ajou.lazybones.repos.entities.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {

	private UserRepository userRepository;

	@Autowired
	public UserController(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	// Show Register page.
	@RequestMapping(value = "/Register", method = RequestMethod.GET)
	public String showRegistrationForm() {
		return "register";
	}

	// Process Registration
	@RequestMapping(value = "/Register", method = RequestMethod.POST)
	// public String processRegistration(@Valid User user, Errors errors) {
	public String processRegistration(@RequestParam(value = "id") String id,
			@RequestParam(value = "name") String name,
			@RequestParam(value = "password") String pwd) {
		try {
			// Save
			User user = new User(id, name, pwd);
			
			if(userRepository.findById(id) != null) {
				System.err.println("Fail to register: same ID already exists");
				return "redirect:/Register";
			}
			userRepository.save(user);
			System.out.println("Sucess to register: " + id + ", " + name + ", "
					+ pwd);
			// If registration succeed, go to login page.
			return "redirect:/Login";
		} catch (Exception e) {
			System.err.println("Fail to register");
			return "redirect:/Register";
		}
	}
	
	// Process Unregistration
		@RequestMapping(value = "/Unregister", method = RequestMethod.POST)
		// public String processUnrregistration(@Valid User user, Errors errors) {
		public String processUnrregistration(@RequestParam(value = "id") String id,
				@RequestParam(value = "name") String name,
				@RequestParam(value = "password") String pwd) {
			try {
				// Save
				User user = new User(id, name, pwd);
				userRepository.delete(user);
				System.out.println("Sucess to unregister: " + id + ", " + name + ", "
						+ pwd);
			} catch (Exception e) {
				System.err.println("Fail to unregister");
			}
			return "index";
		}

	// Show Login page.
	@RequestMapping(value = "/Login", method = RequestMethod.GET)
	public String login() {
		return "login";
	}

	// Process Login 
	@RequestMapping(value = "/Login", method = RequestMethod.POST)
	public String processLogin(@RequestParam(value = "id") String id, @RequestParam(value = "password") String pwd, HttpServletRequest request) {
		try {
			User user = new User();
			user = userRepository.findById(id);
			
			// If user does not exist
			if(user == null) {
				System.out.println("Login failed: " + id + ", " + pwd + "- User doesn't exists");
				request.getSession().removeAttribute("logininfo");
				return "redirect:/Login";
			}
			
			// if pwd is correct
			if(pwd.equals(user.getPwd())) {
				System.out.println("pwd correct");
				request.getSession().setAttribute("logininfo", true);
				return "redirect:/";
			}
			
			// if pwd is not correct
			System.out.println("pwd not correct");
			request.getSession().removeAttribute("logininfo");
			return "redirect:/Login";
		} catch (Exception e) {
			e.printStackTrace();
			return "redirect:/Login";
		}
	}

	// Login check
	@RequestMapping(value = "/Logincheck")
	public void loginCheck(HttpServletRequest request) {
		// making session
		request.getSession().setAttribute("logininfo", true);
	}

	// Logout Process
	@RequestMapping(value = "/Logout", method = RequestMethod.POST)
	public Boolean logout(HttpServletRequest request) {
		try {
			// if(login condition is failed) {
			// request.getSession().setAttribute("logininfo", false);
			// return false;
			// }
		} catch (Exception e) {
			e.printStackTrace();
		}
		// deleting session
		request.getSession().removeAttribute("logininfo");
		return true;
	}
}