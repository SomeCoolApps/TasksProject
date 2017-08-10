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
@NamedQuery(name="UserActivite.findAll", query="SELECT u FROM UserActivite u")
public class UserActivite implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private UserActivitePK id;

	private String activity;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="activity_date")
	private Date activityDate;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;

	public UserActivite() {
	}

	public UserActivitePK getId() {
		return this.id;
	}

	public void setId(UserActivitePK id) {
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