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
@Table(name="phase_user")
public class PhaseUser implements Serializable{
	
	@EmbeddedId
    UserPhaseKey userPhaseKey =  new UserPhaseKey();
	

	@ManyToOne
	@MapsId("idPhase")
	@JoinColumn(name = "id_phase", nullable = false, foreignKey = @ForeignKey(name = "fk_phase_user_phase"))
	public Phase phase;
	
	@ManyToOne
	@MapsId("idUser")
	@JoinColumn(name = "id_user", nullable = false, foreignKey = @ForeignKey(name = "fk_phase_user_user"))
	public User user;
	
	public PhaseUser(Phase phase, User user) {
		this.phase = phase;
		this.user = user;
	}
	
	public PhaseUser() {
	}



	public Phase getPhase() {
		return phase;
	}

	public void setPhase(Phase phase) {
		this.phase = phase;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public UserPhaseKey getUserPhaseKey() {
		return userPhaseKey;
	}

	public void setUserPhaseKey(UserPhaseKey userPhaseKey) {
		this.userPhaseKey = userPhaseKey;
	}

	
	
}
