package com.prototype.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class UserActivityKey implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Column(name = "id_user")
	Long idUser;

	@Column(name = "id_activity")
	private Long idActivity;

	public UserActivityKey(Long idUser, Long idActivity) {
		this.idUser = idUser;
		this.idActivity = idActivity;
	}

	public UserActivityKey() {
	}

	public Long getIdUser() {
		return idUser;
	}

	public void setIdUser(Long idUser) {
		this.idUser = idUser;
	}

	public Long getIdActivity() {
		return idActivity;
	}

	public void setIdActivity(Long idActivity) {
		this.idActivity = idActivity;
	}

}
