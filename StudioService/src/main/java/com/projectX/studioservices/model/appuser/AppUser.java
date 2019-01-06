package com.projectX.studioservices.model.appuser;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.Column;

@Entity(name = "AppUser")
@Table(name = "AppUser")
public class AppUser {
		
	@Id
	@GeneratedValue
	private Integer id;
	
	@Column(name = "username", unique = true)
    private String username;
	
	@Column(name = "password")
    private String password;
	
	@Column(name = "email", unique = true)
	private String email;
	
	@Column(name = "role")
    private String role;
    
	public AppUser() {

	}

	public AppUser(Integer id, String username, String password, String email, String role) {
    		this.id = id;
    		this.username = username;
    		this.password = password;
    		this.email = email;
    		this.role = role;
    	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		this.password = encoder.encode(password);
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "AppUser [id=" + id + ", username=" + username + ", email=" + email + ", role=" + role + "]";
	}
	
	
}