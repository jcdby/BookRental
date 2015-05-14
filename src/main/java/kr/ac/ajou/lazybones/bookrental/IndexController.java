package kr.ac.ajou.lazybones.bookrental;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping(value="/")
public class IndexController {

	@RequestMapping(method=RequestMethod.GET)
	public String index() {
		return "index"; // this will be mapped to index.jsp
	}
}

