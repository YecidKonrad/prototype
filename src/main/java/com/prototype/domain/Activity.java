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

@Entity
@Table(name="Activities")
public class Activity implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false, updatable = false)
	private Long idActivity;
	private String tittle;
	private String description;
	private Date startDuration;
	private Date endDuration;
	private Date createdDate;
	private int priority;
	@ManyToOne
	@JoinColumn(name = "id_state_activity", nullable = false, foreignKey = @ForeignKey(name = "fk_activity_state_activity"))
	private StateActivity stateActivity;
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "created_by", nullable = false, foreignKey = @ForeignKey(name = "fk_activity_user"))
	private User createdBy;

	@OneToMany(mappedBy = "user")
	@JsonIgnore
	private Set<ActivityUser> usuarios;
	
	@OneToMany(mappedBy = "phase")
	@JsonIgnore
	private Set<ActivityPhase> phases;	
	
	public Activity(Long idActivity) {
		this.idActivity = idActivity;
	}
	
	

	public Activity() {
	}



	public Long getIdActivity() {
		return idActivity;
	}
	public void setIdActivity(Long idActivity) {
		this.idActivity = idActivity;
	}
	public String getTittle() {
		return tittle;
	}
	public void setTittle(String tittle) {
		this.tittle = tittle;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
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
	public int getPriority() {
		return priority;
	}
	public void setPriority(int priority) {
		this.priority = priority;
	}
	public StateActivity getStateActivity() {
		return stateActivity;
	}
	public void setStateActivity(StateActivity stateActivity) {
		this.stateActivity = stateActivity;
	}
	public User getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(User createdBy) {
		this.createdBy = createdBy;
	}

	public Set<ActivityUser> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(Set<ActivityUser> usuarios) {
		this.usuarios = usuarios;
	}




	
	
	
	
}
