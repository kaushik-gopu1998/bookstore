package com.app.bookstore.dto;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
@Entity
public class Country implements Serializable {
 
	private static final long serialVersionUID = 5069153074670432580L;

	@Id
	private Integer countryId;
	
	private String name;
	
	private int countryCode ;
	
	@OneToMany
	private Set<State> states;
		
	public Country() {
		super();
	}
	
	public Country(int countryId, String name, int countryCode, Set<State> states) {
		super();
		this.countryId = countryId;
		this.name = name;
		this.countryCode = countryCode;
		this.states = states;
	}



	public Set<State> getStates() {
		return states;
	}



	public void setStates(State states) {
		this.states.add(states);
	}



	public int getCountryId() {
		return countryId;
	}

	public void setCountryId(int countryId) {
		this.countryId = countryId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(int countryCode) {
		this.countryCode = countryCode;
	}
	
	
}
