package com.prototype.domain;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

@Entity
@Table(name="activity_user")
public class ActivityUser implements Serializable{
	

	private static final long serialVersionUID = 1L;

	@EmbeddedId
    UserActivityKey idUserActivityKey = new UserActivityKey();

	@ManyToOne
	@MapsId("idActivity")
	@JoinColumn(name = "id_activity", nullable = false, foreignKey = @ForeignKey(name = "fk_activity_user_activity"))
	private Activity activity;
	
	@ManyToOne
	@MapsId("idUser")
	@JoinColumn(name = "id_user", nullable = false, foreignKey = @ForeignKey(name = "fk_activity_user_user"))
	private User user;

	public ActivityUser(Activity activity, User user) {
		this.activity = activity;
		this.user = user;
	}

	public ActivityUser() {
	}

	public UserActivityKey getIdUserActivityKey() {
		return idUserActivityKey;
	}

	public void setIdUserActivityKey(UserActivityKey idUserActivityKey) {
		this.idUserActivityKey = idUserActivityKey;
	}

	public Activity getActivity() {
		return activity;
	}

	public void setActivity(Activity activity) {
		this.activity = activity;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	
	
}
