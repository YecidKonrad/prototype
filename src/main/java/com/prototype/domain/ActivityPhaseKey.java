package com.prototype.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class ActivityPhaseKey implements Serializable {
	

	private static final long serialVersionUID = 1L;

	@Column(name = "id_activity")
	Long idActivity;

	@Column(name = "id_phase")
	private Long idPhase;

	public ActivityPhaseKey(Long idActivity, Long idPhase) {
		this.idActivity = idActivity;
		this.idPhase = idPhase;
	}

	public ActivityPhaseKey() {
	}

	public Long getIdActivity() {
		return idActivity;
	}

	public void setIdActivity(Long idActivity) {
		this.idActivity = idActivity;
	}

	public Long getIdPhase() {
		return idPhase;
	}

	public void setIdPhase(Long idPhase) {
		this.idPhase = idPhase;
	}

	
}
