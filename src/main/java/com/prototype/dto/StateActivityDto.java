package com.prototype.dto;

public class StateActivityDto {
	private Long idStatePhase;
	private String state;
	
	public StateActivityDto() {
	}

	public StateActivityDto(Long idStatePhase, String state) {
		this.idStatePhase = idStatePhase;
		this.state = state;
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
