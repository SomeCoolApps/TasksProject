package com.data.module.model;

public class User {
	private int id;
	private String name;
 // user from jpa
	
	public User() {
		super();
	}
	public User(int id, String name) {
		this.id = id;
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	

}
