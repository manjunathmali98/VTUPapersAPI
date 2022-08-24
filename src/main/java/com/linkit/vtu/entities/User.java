package com.linkit.vtu.entities;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class User {
	
	@Id
	private String email;
	
	private String password;
	
	private String apiToken;
	
	private String gitToken;

	public User() {
		super();
		// TODO Auto-generated constructor stub
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
		this.password = password;
	}

	public String getApiToken() {
		return apiToken;
	}

	public void setApiToken(String apiToken) {
		this.apiToken = apiToken;
	}

	public String getGitToken() {
		return gitToken;
	}

	public void setGitToken(String gitToken) {
		this.gitToken = gitToken;
	}

	public User(String email, String password, String apiToken, String gitToken) {
		super();
		this.email = email;
		this.password = password;
		this.apiToken = apiToken;
		this.gitToken = gitToken;
	}
	
	
	
}
