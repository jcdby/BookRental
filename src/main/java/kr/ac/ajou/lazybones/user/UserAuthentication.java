package kr.ac.ajou.lazybones.user;


import kr.ac.ajou.lazybones.config.RootConfig;
import kr.ac.ajou.lazybones.data.User;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserAuthentication {

	@RequestMapping(value="/Login", method=RequestMethod.GET)
	public String login() {
			return "login";
	}
	
	// nothing implemented yet
	@RequestMapping(value="/Login", method=RequestMethod.POST)
	public boolean login(User user) {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(RootConfig.class);

		//if(user exists)
			// ((ConfigurableApplicationContext)ctx).close();
			// return true;
		// close the context
		((ConfigurableApplicationContext)ctx).close();
		return false;
	}

	@RequestMapping(value="/Register", method=RequestMethod.GET)
	public String register() {
			return "register";
	}
	
	// nothing implemented yet
	@RequestMapping(value="/Register", method=RequestMethod.POST)
	public boolean register(User user) {
		return false;
	}
	
		
	/* Using like this:
	UserManagerImpl cm =  ctx.getBean(UserManagerImpl.class);
	
	User teemu = cm.insert("teemu", "Teemu", "1234567");
		
	teemu.setEmail("[private]");
	cm.update(teemu);
	
	cm.delete(teemu);
	
	*/
}
