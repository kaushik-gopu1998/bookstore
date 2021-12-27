package com.app.bookstore.dto;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
@Entity
public class Reviews implements Serializable {
	
	private static final long serialVersionUID = -6533741197758647205L;

	@Id
	private Integer reviewId;
	
	private String description;
	
	@ManyToOne
	@JoinColumn(name = "added_by")
	private Users addedBy;
	
	@ManyToOne
	@JoinColumn(name = "product_id")
	private Products productId;
	
	private Integer rating;
	
	private Date addedDate;

	public Reviews() {
		super();
	}

	public Reviews(Integer reviewId, String description, Users addedBy, Products productId, Integer rating,
			Date addedDate) {
		super();
		this.reviewId = reviewId;
		this.description = description;
		this.addedBy = addedBy;
		this.productId = productId;
		this.rating = rating;
		this.addedDate = addedDate;
	}

	public Integer getReviewId() {
		return reviewId;
	}

	public void setReviewId(Integer reviewId) {
		this.reviewId = reviewId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Users getAddedBy() {
		return addedBy;
	}

	public void setAddedBy(Users addedBy) {
		this.addedBy = addedBy;
	}

	public Products getProductId() {
		return productId;
	}

	public void setProductId(Products productId) {
		this.productId = productId;
	}

	public Integer getRating() {
		return rating;
	}

	public void setRating(Integer rating) {
		this.rating = rating;
	}

	public Date getAddedDate() {
		return addedDate;
	}

	public void setAddedDate(Date addedDate) {
		this.addedDate = addedDate;
	}

	@Override
	public String toString() {
		return "Reviews [reviewId=" + reviewId + ", description=" + description + ", addedBy=" + addedBy
				+ ", productId=" + productId + ", rating=" + rating + ", addedDate=" + addedDate + "]";
	}
	
	
	
	
	

}
