package com.example.springboot.app.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name= "employees")
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(name="surname")
	private String surname;
	
	@Column(name="fristname")
	private String fristname;


	@ManyToMany
	@JoinTable(
			name = "languages_like",
			joinColumns = @JoinColumn(name = "employee_id"),
			inverseJoinColumns = @JoinColumn(name = "language_id"))
	private List<Language> likedLanguages;

	@OneToOne
	@JoinColumn(name = "country_id")
	private Country country;


	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getFristname() {
		return fristname;
	}

	public void setFristname(String fristname) {
		this.fristname = fristname;
	}


	public List<Language> getLikedLanguages() {
		return likedLanguages;
	}

	public void setLikedLanguages(List<Language> likedLanguages) {
		this.likedLanguages = likedLanguages;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}
}//class
