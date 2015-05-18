package kr.ac.ajou.lazybones.EntityManager;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.ajou.lazybones.repos.BookRepository;
import kr.ac.ajou.lazybones.repos.entities.Book;

@Service
public class BookEntityManagerImpl implements BookEntityManager {

	@Autowired
	private BookRepository brpo;
	
	@Override
	public Book insert(String title, String desc, String noisbn) {
		// TODO Auto-generated method stub
		Book boo = brpo.save(new Book(title, desc, noisbn));
		return boo;
	}

	@Override
	public Book findOneBook(long id) {
		// TODO Auto-generated method stub
		return brpo.findOne(id);
	}

	@Override
	public List<Book> findAllBooks() {
		// TODO Auto-generated method stub
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

	
}
