/*
 * Controller for handling books
 */

package kr.ac.ajou.lazybones.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import kr.ac.ajou.lazybones.entitymanager.BookEntityManagerImpl;
import kr.ac.ajou.lazybones.entitymanager.ReservationEntityManagerImpl;
import kr.ac.ajou.lazybones.repos.entities.Book;
import kr.ac.ajou.lazybones.repos.entities.Reservation;

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
	private ReservationEntityManagerImpl resvImpl;

	@Autowired
	public BookController(BookEntityManagerImpl bemImpl) {
		super();
		this.bemImpl = bemImpl;
	}

	/*
	 * Show Book List Page.
	 */
	@RequestMapping(value = "/Book", method = RequestMethod.GET)
	public String getBookList(Model model) {
		List<Book> AllBooks = bemImpl.findAllBooks();
		model.addAttribute("books", AllBooks);
		return "bookList";
	}

	/*
	 * Show Book Register Page.
	 */
	@RequestMapping(value = "/Book/Register", method = RequestMethod.GET)
	public String registerBook(Model model) {
		return "bookForm";
	}

	/*
	 * Submit Book Registration Form.
	 */
	@RequestMapping(value = "/Book/Register", method = RequestMethod.POST)
	public String registerBook(
			@RequestParam(required = true) String title,
			@RequestParam(required = true) String description,
			@RequestParam(value = "isbn", required = false) String ISBN,
			Model model) {
		
		bemImpl.insert(title, description, ISBN);
				
		return "redirect:/Book";
	}

	/*
	 * Show Book Detail Page (According to Each ID)
	 */
	@RequestMapping(value = "/Book/Detail/{ID}", method = RequestMethod.GET)
	public String getBookDetail(@PathVariable("ID") Long bid, HttpServletRequest request, Model model) {
		Book oneBook = bemImpl.findOneBook(bid);
		
		// No Such ID --> return to /Book
		if(oneBook==null){
			return "redirect:/Book";
		}
		
		// Add Models for Reservation Info + Book Detail Info
		List<Reservation> reservations = resvImpl.findReservationsByBid(bid);
		model.addAttribute("reservations", reservations);
		model.addAttribute("requestedBook", oneBook);
		
		return "bookDetail";
	}
	/*
	 * Search Book by Title 
	 */
	@RequestMapping(value = "/Book/Search", method = RequestMethod.GET)
	public String searchAndShowSimilarBooks(@RequestParam(value="title") String title, Model model)
	{
		List<Book> similarBooks = bemImpl.findSimilarBooksByTitle(title.toUpperCase());
		model.addAttribute("books", similarBooks);
		return "bookList";
	}

}
