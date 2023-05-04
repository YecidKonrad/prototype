package com.prototype.dto;

import java.io.Serializable;


public class StatePhaseDto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long idStatePhase;
	private String state;
		
	public StatePhaseDto(Long idStatePhase, String state) {
		this.idStatePhase = idStatePhase;
		this.state = state;
	}


	public StatePhaseDto(Long idStatePhase) {
		this.idStatePhase = idStatePhase;
	}

	public StatePhaseDto() {
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
