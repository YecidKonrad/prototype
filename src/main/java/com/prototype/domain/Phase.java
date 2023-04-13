package com.prototype.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="Phases")
public class Phase implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false, updatable = false)
	private Long idPhase;
	private String phase;
	private Date startDuration;
	private Date endDuration;
	private Date createdDate;
	private String description;
	private int ordering;
	
	@ManyToOne
	@JoinColumn(name = "id_state_phase", nullable = false, foreignKey = @ForeignKey(name = "fk_phase_state_phase"))
	private StatePhase statePhase;
	
	@ManyToOne
	@JsonManagedReference
	@JoinColumn(name = "created_by", nullable = false, foreignKey = @ForeignKey(name = "fk_phase_user"))
	private User createdBy;
	
	@OneToMany(mappedBy = "user")
	@JsonIgnore
	private Set<PhaseUser> usuarios;	
	
	public Phase(Long idPhase, String phase, Date startDuration, Date endDuration, Date createdDate, String description,
			int ordering, StatePhase statePhase, User createdBy) {
		this.idPhase = idPhase;
		this.phase = phase;
		this.startDuration = startDuration;
		this.endDuration = endDuration;
		this.createdDate = createdDate;
		this.description = description;
		this.ordering = ordering;
		this.statePhase = statePhase;
		this.createdBy = createdBy;
	}



	public Phase() {
	}



	public Phase(Long idPhase) {
		this.idPhase = idPhase;
	}



	public Long getIdPhase() {
		return idPhase;
	}
	public void setIdPhase(Long idPhase) {
		this.idPhase = idPhase;
	}
	public String getPhase() {
		return phase;
	}
	public void setPhase(String phase) {
		this.phase = phase;
	}
	
	public Date getStartDuration() {
		return startDuration;
	}
	public void setStartDuration(Date startDuration) {
		this.startDuration = startDuration;
	}
	public Date getEndDuration() {
		return endDuration;
	}
	public void setEndDuration(Date endDuration) {
		this.endDuration = endDuration;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getOrdering() {
		return ordering;
	}
	public void setOrdering(int order) {
		this.ordering = order;
	}
	public StatePhase getStatePhase() {
		return statePhase;
	}
	public void setStatePhase(StatePhase statePhase) {
		this.statePhase = statePhase;
	}



	public User getCreatedBy() {
		return createdBy;
	}



	public void setCreatedBy(User createdBy) {
		this.createdBy = createdBy;
	}

	public Set<PhaseUser> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(Set<PhaseUser> usuarios) {
		this.usuarios = usuarios;
	}



	
	
}
