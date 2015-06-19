package kr.ac.ajou.lazybones.entitymanager;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import kr.ac.ajou.lazybones.repos.BookRepository;
import kr.ac.ajou.lazybones.repos.entities.Book;

@Repository
public class BookEntityManagerImpl implements BookEntityManager {

	@Autowired
	private BookRepository brpo;
	
	@Override
	public Book insert(String title, String desc, String noisbn) {
		Book boo = brpo.save(new Book(title, desc, noisbn));
		return boo;
	}

	@Override
	@Transactional
	public Book findOneBook(long id) {
		return brpo.findByIdentifier(id);

	}

	@Override
	public List<Book> findAllBooks() {
		return brpo.findAll();
	}

	@Override
	public int update(Book b) {
		if(brpo.findOne(b.getIdentifier()) != null){
			brpo.save(b);
			
			return 1;
		} 
		return 0;
	}

	@Override
	public int delete(Book b) {
		if(brpo.findOne(b.getIdentifier()) != null){
			brpo.delete(b);
			return 1;
		} 
		return 0;	
	
	}
	
	@Override
	@Transactional
	public Book findOneBookByTitle(String title){
		return brpo.findByTitle(title);
	}
	
	@Override
	public List<Book> findSimilarBooksByTitle(String title) {
		return brpo.findSimilarBooksByTitle(title);
	}
}
