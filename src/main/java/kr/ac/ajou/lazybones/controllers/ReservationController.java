/*
 * Controller for handling Reservations
 */
package kr.ac.ajou.lazybones.controllers;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import kr.ac.ajou.lazybones.entitymanager.ReservationEntityManagerImpl;
import kr.ac.ajou.lazybones.entitymanager.UserEntityManagerImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ReservationController {

	@Autowired
	private ReservationEntityManagerImpl resvEntityManagerImpl;
	@Autowired
	private UserEntityManagerImpl userManagerImpl;
	
	/*
	 * Show My Reservation List.
	 */
	@RequestMapping(value = "/Reservation", method = RequestMethod.GET)
	public String reservations(HttpServletRequest request, Model model) {

		String uid = (String) request.getSession().getAttribute("userid");
		
		model.addAttribute("reservations",
				resvEntityManagerImpl.findReservationsByUid(uid));

		return "reservationList";
	}

	/*
	 * Make a Reservation (according to each ID)
	 */
	@RequestMapping(value = "/Book/Reserve/{id}", method = RequestMethod.POST)
	public String reserveBook(
			@PathVariable("id") Long bookId,
			@RequestParam(value = "date-from", required = true) @DateTimeFormat(iso=DateTimeFormat.ISO.DATE) Date from,
			@RequestParam(value = "date-to", required = true) @DateTimeFormat(iso=DateTimeFormat.ISO.DATE) Date to,
			HttpServletRequest request, Model model) {

		// Get User ID from session
		String uid = (String) request.getSession().getAttribute("userid");

		// Insert Reservation
		resvEntityManagerImpl.insert(uid, bookId, from, to);

		return "redirect:/Book/Detail/" + bookId;
	}
	
	/*
	 * Cancle a Reservation (according to each ID)
	 */
	@RequestMapping(value = "/Reservation/Cancel/{id}", method = RequestMethod.GET)
	public String cancelBookReservation(
			@PathVariable("id") Long reservationId,
			HttpServletRequest request, Model model) {

		// Delete Reservation
		resvEntityManagerImpl.deleteByReservationId(reservationId);

		return "redirect:/Reservation";
	}
}
