package com.projectX.AuthService.model;

import java.util.Date;

public class User {
	private Integer id;
	
	private String name;
	
	private Date registerDate;
	

	public User(Integer id, String name, Date birthDate) {
		super();
		this.id = id;
		this.name = name;
		this.registerDate = birthDate;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getBirthDate() {
		return registerDate;
	}

	public void setBirthDate(Date birthDate) {
		this.registerDate = birthDate;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", birthDate=" + registerDate + "]";
	}

	
}
