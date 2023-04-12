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
	
	/*@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false, updatable = false)
	private Long idPhaseUser;*/
	@EmbeddedId
    UserPhaseKey idUserPhaseKey;

	@ManyToOne
	@MapsId("idPhase")
	@JoinColumn(name = "id_phase", nullable = false, foreignKey = @ForeignKey(name = "fk_phase_user_phase"))
	private Phase phase;
	
	@ManyToOne
	@MapsId("idUser")
	@JoinColumn(name = "id_user", nullable = false, foreignKey = @ForeignKey(name = "fk_phase_user_user"))
	private User user;
	
	public PhaseUser(Phase phase, User user) {
		this.phase = phase;
		this.user = user;
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

	public UserPhaseKey getIdUserPhaseKey() {
		return idUserPhaseKey;
	}

	public void setIdUserPhaseKey(UserPhaseKey idUserPhaseKey) {
		this.idUserPhaseKey = idUserPhaseKey;
	}
	
	
}
