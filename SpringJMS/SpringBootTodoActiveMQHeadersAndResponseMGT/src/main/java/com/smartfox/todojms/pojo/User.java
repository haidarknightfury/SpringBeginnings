package com.smartfox.todojms.pojo;

import java.io.Serializable;

public class User implements Serializable {

	private static final long serialVersionUID = 1L;
	private  String username;
	private  String userId;
	
	public User() {}

	public User(String username, String userId) {
		super();
		this.username = username;
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public String getUserId() {
		return userId;
	}

	@Override
	public String toString() {
		return "User [username=" + username + ", userId=" + userId + "]";
	}

}
