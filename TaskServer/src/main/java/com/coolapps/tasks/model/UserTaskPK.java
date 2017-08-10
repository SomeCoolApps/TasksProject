package com.coolapps.tasks.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the user_tasks database table.
 * 
 */
@Embeddable
public class UserTaskPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="user_id", insertable=false, updatable=false)
	private double userId;

	@Column(name="task_id", insertable=false, updatable=false)
	private double taskId;

	public UserTaskPK() {
	}
	public double getUserId() {
		return this.userId;
	}
	public void setUserId(double userId) {
		this.userId = userId;
	}
	public double getTaskId() {
		return this.taskId;
	}
	public void setTaskId(double taskId) {
		this.taskId = taskId;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof UserTaskPK)) {
			return false;
		}
		UserTaskPK castOther = (UserTaskPK)other;
		return 
			(this.userId == castOther.userId)
			&& (this.taskId == castOther.taskId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) (java.lang.Double.doubleToLongBits(this.userId) ^ (java.lang.Double.doubleToLongBits(this.userId) >>> 32)));
		hash = hash * prime + ((int) (java.lang.Double.doubleToLongBits(this.taskId) ^ (java.lang.Double.doubleToLongBits(this.taskId) >>> 32)));
		
		return hash;
	}
}