package com.app.bookstore.dto;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Category implements Serializable {

	private static final long serialVersionUID = -3333773630498951676L;

	@Id
	private Integer categoryId;
	
	private String name;
	
	
	public Category() {
		super();
	}
    
	public Category(String name) {
		super();
		
		this.name = name;
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	@Override
	public String toString() {
		return "Category [ name=" + name + "]";
	}

}
