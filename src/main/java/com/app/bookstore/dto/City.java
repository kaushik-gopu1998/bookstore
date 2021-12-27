package com.app.bookstore.dto;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
@Entity
public class City implements Serializable {

	private static final long serialVersionUID = -6745075374351071622L;

	@Id
	private Integer cityId;
	
	private String name;
	
	@ManyToOne
	@JoinColumn(name = "state_id")
	private State State;

	@OneToMany
	private Set<Users> user;
	
	public City() {
		super();
	}

	public City(Integer cityId, String name, State state, Set<Users> user) {
		super();
		this.cityId = cityId;
		this.name = name;
		State = state;
		this.user = user;
	}

	public Integer getCityId() {
		return cityId;
	}

	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public State getState() {
		return State;
	}

	public void setState(State state) {
		State = state;
	}

	public Set<Users> getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user.add(user);
	}
		
}
