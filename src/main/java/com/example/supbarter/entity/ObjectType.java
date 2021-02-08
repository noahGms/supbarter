package com.example.supbarter.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class ObjectType implements Serializable {
	@Id
	@GeneratedValue
	private Long id;

	@Column
	private String name;

	@OneToMany( targetEntity=Object.class, mappedBy="type")
	private List<Object> objects = new ArrayList<>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
