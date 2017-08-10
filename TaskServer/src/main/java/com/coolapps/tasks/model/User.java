package com.coolapps.tasks.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the user database table.
 * 
 */
@Entity
@NamedQuery(name="User.findAll", query="SELECT u FROM User u")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String name;

	//bi-directional many-to-one association to UserActivite
	@OneToMany(mappedBy="user")
	private List<UserActivites> userActivites;

	//bi-directional many-to-one association to UserTask
	@OneToMany(mappedBy="user")
	private List<UserTask> userTasks;

	public User() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<UserActivites> getUserActivites() {
		return this.userActivites;
	}

	public void setUserActivites(List<UserActivites> userActivites) {
		this.userActivites = userActivites;
	}

	public UserActivites addUserActivite(UserActivites userActivite) {
		getUserActivites().add(userActivite);
		userActivite.setUser(this);

		return userActivite;
	}

	public UserActivites removeUserActivite(UserActivites userActivite) {
		getUserActivites().remove(userActivite);
		userActivite.setUser(null);

		return userActivite;
	}

	public List<UserTask> getUserTasks() {
		return this.userTasks;
	}

	public void setUserTasks(List<UserTask> userTasks) {
		this.userTasks = userTasks;
	}

	public UserTask addUserTask(UserTask userTask) {
		getUserTasks().add(userTask);
		userTask.setUser(this);

		return userTask;
	}

	public UserTask removeUserTask(UserTask userTask) {
		getUserTasks().remove(userTask);
		userTask.setUser(null);

		return userTask;
	}

}