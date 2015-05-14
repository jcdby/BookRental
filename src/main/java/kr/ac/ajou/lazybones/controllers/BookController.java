package kr.ac.ajou.lazybones.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Controller
public class BookController {
	
	public class Book{
		
		
	}
	
	@RequestMapping(value="/Book/All", method= RequestMethod.GET, produces ="application/json")
	public List<Book> getAllBooks(){
		return new ArrayList<Book>();
	}
	
	@RequestMapping(value="/test", method=RequestMethod.GET)
	public String aaa(){
		return "index";
	}
	

}
