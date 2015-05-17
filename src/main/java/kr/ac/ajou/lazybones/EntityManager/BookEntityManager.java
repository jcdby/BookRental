package kr.ac.ajou.lazybones.EntityManager;

import java.util.List;

import kr.ac.ajou.lazybones.repos.entities.Book;

public interface BookEntityManager {
	
	Book insert(String title, String desc);
	Book findone(long id);
	List<Book> findAllBooks();
	
}
