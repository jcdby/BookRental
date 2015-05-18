package kr.ac.ajou.lazybones.repos;

import java.util.List;

import kr.ac.ajou.lazybones.repos.entities.Reservation;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {

	public Page<Reservation> findAll(Pageable arg0);

	public long count();

	public void delete(Long arg0);

	public void delete(Reservation arg0);

	public void delete(Iterable<? extends Reservation> arg0);

	public void deleteAll();

	public boolean exists(Long arg0);

	public Reservation findOne(Long arg0);

	public <S extends Reservation> S save(S arg0);

	public List<Reservation> findAll();

	public List<Reservation> findAll(Sort arg0);

	public List<Reservation> findAll(Iterable<Long> arg0);

	public <S extends Reservation> List<S> save(Iterable<S> arg0);

}
