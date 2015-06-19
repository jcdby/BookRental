package kr.ac.ajou.lazybones.entitymanager;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import kr.ac.ajou.lazybones.repos.ReservationRepository;
import kr.ac.ajou.lazybones.repos.entities.Book;
import kr.ac.ajou.lazybones.repos.entities.Reservation;
import kr.ac.ajou.lazybones.repos.entities.User;

@Repository
public class ReservationEntityManagerImpl implements ReservationEntityManager {

	@Autowired
	private ReservationRepository repos;

	@PersistenceContext
	private EntityManager em;

	@Override
	public Reservation findOneReservation(long id) {
		return repos.findOne(id);
	}

	@Override
	public List<Reservation> findAllReservations() {
		return repos.findAll();
	}

	@Override
	public int update(Reservation resv) {
		if (repos.findOne(resv.getId()) != null) {
			repos.save(resv);
			return 1;
		}
		return 0;
	}

	@Override
	public int delete(Reservation resv) {
		if (repos.findOne(resv.getId()) != null) {
			repos.delete(resv);
			
			return 1;
		}
		return 0;
	}

	@Override
	public Reservation insert(Reservation resv) {

		return repos.save(resv);
	}

	@Override
	@Transactional
	public List<Reservation> findReservationsByUid(String uid) {
		User user = em.getReference(User.class, uid);
		return repos.findReservationsByUser(user);
	}

	@Override
	@Transactional
	public List<Reservation> findReservationsByBid(Long bid) {
		Book book = em.getReference(Book.class, bid);
		return repos.findReservationsByBook(book);
	}

	
	@Override
	@Transactional
	public Reservation insert(String uid, Long bid, Date from, Date to) {
		Reservation resv = new Reservation();
		Book book = em.getReference(Book.class, bid);
		User user = em.getReference(User.class, uid);

		resv.setBook(book);
		resv.setUser(user);
		resv.setFrom(from);
		resv.setTo(to);

		return repos.save(resv);

	}

	@Override
	@Transactional
	public int deleteByReservationId(Long id) {
		if (repos.findOne(id) != null) {
			repos.delete(em.getReference(Reservation.class, id));
			
			//repos.delete(id);
			System.out.println("Erased!");
			return 1;
		} else{
			System.out.println("Failed!");
			return 0;

		}

	}

}
