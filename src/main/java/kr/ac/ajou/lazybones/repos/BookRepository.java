package kr.ac.ajou.lazybones.repos;

import java.util.List;

import kr.ac.ajou.lazybones.repos.entities.Book;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BookRepository extends JpaRepository<Book, Long> {

	@Override
	public Page<Book> findAll(Pageable arg0);

	@Override
	public long count();

	@Override
	public void delete(Long arg0);

	@Override
	public void delete(Book arg0);

	@Override
	public void delete(Iterable<? extends Book> arg0);

	@Override
	public void deleteAll();

	@Override
	public boolean exists(Long arg0);
	
	public Book findByIdentifier(Long arg0);
	
	public Book findByTitle(String title);

	@Override
	public <S extends Book> S save(S arg0);

	@Override
	public List<Book> findAll();

	@Override
	public List<Book> findAll(Sort arg0);

	@Override
	public List<Book> findAll(Iterable<Long> arg0);

	@Query("select b from Book b where upper(b.title) like %?1%")
	public List<Book> findSimilarBooksByTitle(String upperCaseTitle);

	@Override
	public <S extends Book> List<S> save(Iterable<S> arg0);

}
