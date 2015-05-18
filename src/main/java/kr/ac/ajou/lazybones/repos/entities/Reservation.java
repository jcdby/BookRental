package kr.ac.ajou.lazybones.repos.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Reservation {

	@Id
	private Long id;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="bid")
	private Book book;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="uid")
	private User user;
	
	@Column
	private Date period;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Date getPeriod() {
		return period;
	}

	public void setPeriod(Date period) {
		this.period = period;
	}
	
	
	
		
}
