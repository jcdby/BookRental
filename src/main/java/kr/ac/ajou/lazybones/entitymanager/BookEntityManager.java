package kr.ac.ajou.lazybones.entitymanager;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import kr.ac.ajou.lazybones.repos.entities.Book;

public interface BookEntityManager {
	
	Book findOneBook(long id);
	List<Book> findAllBooks();
	int update(Book b);
	int delete(Book b);
	Book insert(String title, String desc, String noisbn);
	Book findOneBookByTitle(String title);
	List<Book> findSimilarBooksByTitle(String title);
	
}
