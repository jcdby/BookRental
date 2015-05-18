package kr.ac.ajou.lazybones.restcontrollers;

import java.util.ArrayList;
import java.util.List;

import kr.ac.ajou.lazybones.repos.entities.Book;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookRESTController {

	@RequestMapping(value = "/Book/All", method = RequestMethod.GET, produces = "application/json")
	public List<Book> getAllBooks() {
		return new ArrayList<Book>();
	}

}
