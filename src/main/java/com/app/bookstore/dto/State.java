package com.app.bookstore.dto;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
@Entity
public class State  implements Serializable{
	

	private static final long serialVersionUID = -5448784626162554156L;

	@Id
	private Integer stateId;
	
	private String name;
	
	@OneToMany
	private Set<City> cities;
	
    @ManyToOne
    @JoinColumn(name="country_id", nullable=false)
	private Country country;

	public State() {
		super();
	}

	public State(int stateId, String name, Set<City> cities, Country country) {
		super();
		this.stateId = stateId;
		this.name = name;
		this.cities = cities;
		this.country = country;
	}

	public int getStateId() {
		return stateId;
	}

	public void setStateId(int stateId) {
		this.stateId = stateId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	public Set<City> getCities() {
		return cities;
	}

	public void setCities(City cities) {
		this.cities.add(cities);
	}
	    
}
