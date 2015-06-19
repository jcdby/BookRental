package kr.ac.ajou.lazybones.entitymanager;

import java.util.Date;
import java.util.List;

import kr.ac.ajou.lazybones.repos.entities.Reservation;

public interface ReservationEntityManager {
	Reservation findOneReservation(long id);

	List<Reservation> findAllReservations();

	int update(Reservation resv);

	int delete(Reservation resv);
	int deleteByReservationId(Long id);

	Reservation insert(Reservation resv);
	Reservation insert(String uid, Long bid, Date from, Date to);


	List<Reservation> findReservationsByUid(String uid);

	List<Reservation> findReservationsByBid(Long bid);

}
