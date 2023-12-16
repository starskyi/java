package com.star.domain;

public class User {
	private String username;
	private String password;
	private Integer manager;
	
	public User(){
		
	}
	
	public User(String username, String password, Integer manager){
		this.username = username;
		this.password = password;
		this.manager = manager;
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
		this.password = password;
	}

	public int getManager() {
		return manager;
	}

	public void setManager(int manager) {
		this.manager = manager;
	}

	@Override
	public String toString() {
		return "User [manager=" + manager + ", password=" + password
				+ ", username=" + username + "]";
	}
	
	

}
