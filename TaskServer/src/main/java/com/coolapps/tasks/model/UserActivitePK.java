package com.coolapps.tasks.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the user_activites database table.
 * 
 */
@Embeddable
public class UserActivitePK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="user_id", insertable=false, updatable=false)
	private double userId;

	@Column(name="activity_id")
	private double activityId;

	public UserActivitePK() {
	}
	public double getUserId() {
		return this.userId;
	}
	public void setUserId(double userId) {
		this.userId = userId;
	}
	public double getActivityId() {
		return this.activityId;
	}
	public void setActivityId(double activityId) {
		this.activityId = activityId;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof UserActivitePK)) {
			return false;
		}
		UserActivitePK castOther = (UserActivitePK)other;
		return 
			(this.userId == castOther.userId)
			&& (this.activityId == castOther.activityId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) (java.lang.Double.doubleToLongBits(this.userId) ^ (java.lang.Double.doubleToLongBits(this.userId) >>> 32)));
		hash = hash * prime + ((int) (java.lang.Double.doubleToLongBits(this.activityId) ^ (java.lang.Double.doubleToLongBits(this.activityId) >>> 32)));
		
		return hash;
	}
}