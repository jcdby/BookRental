package kr.ac.ajou.lazybones.repos.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

@Entity
public class User {

	//@GeneratedValue(strategy = GenerationType.AUTO)
	//private Long identifier;

	// @NotNull
	// @Size(min = 1, max = 16)
	@Id
	@Column
	private String id;

	// @NotNull
	// @Size(min = 2, max = 60)
	@Column
	private String name;

	// @NotNull
	// @Size(min = 5, max = 25)
	private String pwd;

	@OneToMany(mappedBy = "user", fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	private List<Reservation> reservations;

	public User() {
	}

	public User(String id, String name, String pwd) {
		this.id = id;
		this.name = name;
		this.pwd = pwd;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	@Override
	public boolean equals(Object that) {
		return EqualsBuilder.reflectionEquals(this, that, "id", "name", "pwd");
	}

	@Override
	public int hashCode() {
		return HashCodeBuilder.reflectionHashCode(this, "id", "name", "pwd");
	}
}