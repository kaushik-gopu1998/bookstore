package com.app.bookstore.dto;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
@Entity
public class City implements Serializable {

	private static final long serialVersionUID = -6745075374351071622L;

	@Id
	private Integer cityId;
	
	private String name;
	
	@OneToMany(mappedBy="city")
	private Set<UserAddress> userAddress;
	
	
	
	
	
	public City() {
		super();
	}

	public City(Integer cityId, String name) {
		super();
		this.cityId = cityId;
		this.name = name;
		
		
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

	

	
}
