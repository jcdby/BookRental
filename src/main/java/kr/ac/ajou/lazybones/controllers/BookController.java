package kr.ac.ajou.lazybones.controllers;

import java.util.ArrayList;
import java.util.List;

import kr.ac.ajou.lazybones.repos.entities.Book;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class BookController {

	@RequestMapping(value = "/Book", method = RequestMethod.GET)
	public String getBookList(Model model) {

		return "bookList";
	}

	@RequestMapping(value = "/Book/Register", method = RequestMethod.GET)
	public String registerBook(Model model) {
		return "bookForm";
	}

	@RequestMapping(value = "/Book/Modify/{ID}", method = RequestMethod.GET)
	public String modifyBook(@PathVariable("ID") int id, Model model) {
		
		//Not implemented yet.
		return "bookForm";
	}

}
