package com.prototype.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

@Entity
@Table(name="activity_phase")
public class ActivityPhase implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	ActivityPhaseKey idActivityPhaseKey = new ActivityPhaseKey();
	
	@ManyToOne
	@MapsId("idActivity")
	@JoinColumn(name = "id_activity", nullable = false, foreignKey = @ForeignKey(name = "fk_activity_phase_activity"))
	private Activity activity;
	
	@ManyToOne
	@MapsId("idPhase")
	@JoinColumn(name = "id_phase", nullable = false, foreignKey = @ForeignKey(name = "fk_activity_phase_phase"))
	private Phase phase;

	public ActivityPhase(Activity activity, Phase phase) {
		this.activity = activity;
		this.phase = phase;
	}

	public ActivityPhase() {
	}

	public ActivityPhaseKey getIdActivityPhaseKey() {
		return idActivityPhaseKey;
	}

	public void setIdActivityPhaseKey(ActivityPhaseKey idActivityPhaseKey) {
		this.idActivityPhaseKey = idActivityPhaseKey;
	}

	public Activity getActivity() {
		return activity;
	}

	public void setActivity(Activity activity) {
		this.activity = activity;
	}

	public Phase getPhase() {
		return phase;
	}

	public void setPhase(Phase phase) {
		this.phase = phase;
	}
	
	


}
