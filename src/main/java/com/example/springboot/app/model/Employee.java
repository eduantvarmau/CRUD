package com.example.springboot.app.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name= "employees")
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@Column(name="surname")
	private String surname;
	
	@Column(name="fristname")
	private String firstname;



	@ManyToMany(cascade = CascadeType.PERSIST)
	@JoinTable(
			name = "languages_like",
			joinColumns = @JoinColumn(name = "employee_id"),
			inverseJoinColumns = @JoinColumn(name = "language_id"))
	private List<Language> likedLanguages;

	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "country_id")
	private Country country;


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
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
