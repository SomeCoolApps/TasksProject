package com.coolapps.tasks.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the task database table.
 * 
 */
@Entity
@NamedQuery(name="Task.findAll", query="SELECT t FROM Task t")
public class Task implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private double id;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="create_date")
	private Date createDate;

	private String description;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="due_date")
	private Date dueDate;

	private String name;

	private double parent;

	private String priority;

	private String status;

	//bi-directional many-to-one association to UserTask
	@OneToMany(mappedBy="task")
	private List<UserTask> userTasks;

	public Task() {
	}

	public double getId() {
		return this.id;
	}

	public void setId(double id) {
		this.id = id;
	}

	public Date getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getDueDate() {
		return this.dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getParent() {
		return this.parent;
	}

	public void setParent(double parent) {
		this.parent = parent;
	}

	public String getPriority() {
		return this.priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<UserTask> getUserTasks() {
		return this.userTasks;
	}

	public void setUserTasks(List<UserTask> userTasks) {
		this.userTasks = userTasks;
	}

	public UserTask addUserTask(UserTask userTask) {
		getUserTasks().add(userTask);
		userTask.setTask(this);

		return userTask;
	}

	public UserTask removeUserTask(UserTask userTask) {
		getUserTasks().remove(userTask);
		userTask.setTask(null);

		return userTask;
	}

}