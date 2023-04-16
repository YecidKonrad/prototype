package com.prototype.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class StatePhase implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false, updatable = false)
	private Long idStatePhase;
	private String state;
	
	
	public StatePhase(Long idStatePhase, String state) {
		this.idStatePhase = idStatePhase;
		this.state = state;
	}


	public StatePhase(Long idStatePhase) {
		this.idStatePhase = idStatePhase;
	}

	public StatePhase() {
	}


	public Long getIdStatePhase() {
		return idStatePhase;
	}


	public void setIdStatePhase(Long idStatePhase) {
		this.idStatePhase = idStatePhase;
	}


	public String getState() {
		return state;
	}


	public void setState(String state) {
		this.state = state;
	}
	
	
	

}
