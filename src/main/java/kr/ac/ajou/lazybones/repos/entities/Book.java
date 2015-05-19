package kr.ac.ajou.lazybones.repos.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Book {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private Long identifier;
	
	@Column(name="title")
	private String title;
	
	@Column(name="description")	
	private String description;
	
	@Column(name="isbn")
	private String NoISBN;
	
	
	public Book(String title, String description, String noISBN) {
		super();
		this.title = title;
		this.description = description;
		this.NoISBN =noISBN;
	}
	
		public Book() {
		super();
		// TODO Auto-generated constructor stub
	}
		
	public String getNoISBN() {
			return NoISBN;
		}

		public void setNoISBN(String noISBN) {
			NoISBN = noISBN;
		}



	//Reservations for book will be fetched when they needed. 
	@OneToMany(mappedBy = "book", fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	private List<Reservation> reservations;


	public Long getIdentifier() {
		return identifier;
	}


	public void setIdentifier(Long identifier) {
		this.identifier = identifier;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public List<Reservation> getReservations() {
		return reservations;
	}


	public void setReservations(List<Reservation> reservations) {
		this.reservations = reservations;
	}	
	
	
	

}
