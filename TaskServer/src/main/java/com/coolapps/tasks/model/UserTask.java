package com.coolapps.tasks.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the user_tasks database table.
 * 
 */
@Entity
@Table(name="user_tasks")
@NamedQuery(name="UserTask.findAll", query="SELECT u FROM UserTask u")
public class UserTask implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private UserTaskPK id;

	//bi-directional many-to-one association to Task
	@ManyToOne
	@JoinColumn(name="task_id")
	private Task task;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;

	public UserTask() {
	}

	public UserTaskPK getId() {
		return this.id;
	}

	public void setId(UserTaskPK id) {
		this.id = id;
	}

	public Task getTask() {
		return this.task;
	}

	public void setTask(Task task) {
		this.task = task;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}