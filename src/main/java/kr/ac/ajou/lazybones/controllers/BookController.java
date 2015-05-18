package kr.ac.ajou.lazybones.controllers;

import java.util.List;

import kr.ac.ajou.lazybones.entitymanager.BookEntityManagerImpl;
import kr.ac.ajou.lazybones.repos.entities.Book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BookController {

	
	private BookEntityManagerImpl bemImpl;

	@Autowired
	public BookController(BookEntityManagerImpl bemImpl) {
		super();
		this.bemImpl = bemImpl;
	}

	@RequestMapping(value = "/Book", method = RequestMethod.GET)
	public String getBookList(Model model) {
		List<Book> AllBooks = bemImpl.findAllBooks();
		model.addAttribute("books", AllBooks);
		return "bookList";
	}

	@RequestMapping(value = "/Book/Register", method = RequestMethod.GET)
	public String registerBook(Model model) {
		return "bookForm";
	}

	@RequestMapping(value = "/Book/Register", method = RequestMethod.POST)
	public String registerBook(
			@RequestParam(required = true) String title,
			@RequestParam(required = true) String description,
			@RequestParam(value = "isbn", required = false) String ISBN,
			Model model) {
		
		bemImpl.insert(title, description, ISBN);
				
		return "redirect:/Book";
	}

	@RequestMapping(value = "/Book/Modify/{ID}", method = RequestMethod.GET)
	public String modifyBook(@PathVariable("ID") int id, Model model) {

		// Not implemented yet.
		return "bookForm";
	}

	@RequestMapping(value = "/Book/Detail/{ID}", method = RequestMethod.GET)
	public String getBookDetail(@PathVariable("ID") int id, Model model) {
		Book oneBook = bemImpl.findOneBook(id);
		model.addAttribute("requestedBook", oneBook);
		return "bookDetail";
	}
	
	@RequestMapping(value = "/Book/Search", method = RequestMethod.GET)
	public String searchBookbyItsName(@RequestParam(value="title") String title, Model model)
	{
		Book oneBook = bemImpl.findOneBookByTitle(title);
		model.addAttribute("requestedBook", oneBook);
		return "bookDetail";
	}

	
}
