package kr.ac.ajou.lazybones.repos;

import java.util.List;

import kr.ac.ajou.lazybones.repos.entities.Book;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {

	public Page<Book> findAll(Pageable arg0);

	public long count();

	public void delete(Long arg0);

	public void delete(Book arg0);

	public void delete(Iterable<? extends Book> arg0);

	public void deleteAll();

	public boolean exists(Long arg0);

	public Book findOne(Long arg0);
	
	public Book findByTitle(String title);

	public <S extends Book> S save(S arg0);

	public List<Book> findAll();

	public List<Book> findAll(Sort arg0);

	public List<Book> findAll(Iterable<Long> arg0);

	public <S extends Book> List<S> save(Iterable<S> arg0);
	
	

}
