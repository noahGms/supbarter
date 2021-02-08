package com.example.supbarter.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Object implements Serializable {
	@Id
	@GeneratedValue
	private Long id;

	@Column
	private String title;

	@Column
	private String description;

	@Column
	private Double price;

	@Column
	private String picture;

	@ManyToOne @JoinColumn(name="typeId", nullable=true)
	private ObjectType type;

	@ManyToOne @JoinColumn(name="userId", nullable=false)
	private User user;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public ObjectType getType() {
		return type;
	}

	public void setType(ObjectType type) {
		this.type = type;
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

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picturePath) {
		this.picture = picturePath;
	}
}
