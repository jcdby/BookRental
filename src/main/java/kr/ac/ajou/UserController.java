package kr.ac.ajou;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import kr.ac.ajou.data.User;
import kr.ac.ajou.data.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserController {

private UserRepository userRepository;

	@Autowired
	public UserController(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String showRegistrationForm() {
		return "registerForm";
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String processRegistration(@Valid User user, Errors errors) {
		if (errors.hasErrors()) {
			return "registerForm";
		}

		userRepository.save(user);
		return "redirect:/user/" + user.getId();
	}

	@RequestMapping(value = "user/{id}", method = RequestMethod.GET)
	public String showSpitterProfile(@PathVariable String id, Model model) {
		User user = userRepository.findById(id);
		model.addAttribute(user);
		return "profile";
	}
	
	
	/**
	 * Simply selects the login view to render by returning its name.
	 */
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginPageLoad(Model model) {
		return "login";
	}

	/**
	 * Login
	 */
	@RequestMapping(value = "/login", method = RequestMethod.POST)
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

	/**
	 * Checking if already login succeed
	 */
	@RequestMapping(value = "/logincheck")
	public void loginCheck(HttpServletRequest request) {
		request.getSession().setAttribute("logininfo", true);
	}
}
