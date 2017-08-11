package com.coolapps.tasks.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the user_activites database table.
 * 
 */
@Entity
@Table(name="user_activites")
@NamedQuery(name="UserActivites.findAll", query="SELECT u FROM UserActivites u")
public class UserActivites implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private UserActivitesPK id;

	private String activity;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="activity_date")
	private Date activityDate;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="user_id" , insertable=false, updatable=false)
	private User user;

	public UserActivites() {
	}

	public UserActivitesPK getId() {
		return this.id;
	}

	public void setId(UserActivitesPK id) {
		this.id = id;
	}

	public String getActivity() {
		return this.activity;
	}

	public void setActivity(String activity) {
		this.activity = activity;
	}

	public Date getActivityDate() {
		return this.activityDate;
	}

	public void setActivityDate(Date activityDate) {
		this.activityDate = activityDate;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}