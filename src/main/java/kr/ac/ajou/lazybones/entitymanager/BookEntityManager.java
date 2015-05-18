package kr.ac.ajou.lazybones.entitymanager;

import java.util.List;

import kr.ac.ajou.lazybones.repos.entities.Book;

public interface BookEntityManager {
	
	Book findOneBook(long id);
	List<Book> findAllBooks();
	Book findOneBookByTitle(String title);
	int update(Book b);
	int delete(Book b);
	Book insert(String title, String desc, String noisbn);
	
}
