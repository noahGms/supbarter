package com.example.supbarter.entities;

import at.favre.lib.crypto.bcrypt.BCrypt;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(uniqueConstraints=@UniqueConstraint(columnNames="email"))
public class User implements Serializable {
	@Id
	@GeneratedValue
	private Long id;

	@Column(unique = true)
	private String email;

	@Column
	private String username;

	@Column
	private String firstname;

	@Column
	private String lastname;

	@Column
	private String password;

	@Column
	private Integer zipcode;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = BCrypt.withDefaults().hashToString(12, password.toCharArray());
	}

	public boolean checkPassword(String password) {
		return BCrypt.verifyer().verify(password.toCharArray(), this.getPassword()).verified;
	}

	public Integer getZipcode() {
		return zipcode;
	}

	public void setZipcode(Integer zipcode) {
		this.zipcode = zipcode;
	}
}
