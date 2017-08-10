package com.coolapps.tasks;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "User", catalog = "tasks" )

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
	@Id
	@Column(name="id")
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	@Column(name="name")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	

}
