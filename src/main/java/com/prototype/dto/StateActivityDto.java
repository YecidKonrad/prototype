package com.prototype.dto;

public class StateActivityDto {
	private Long idStateActivity;
	private String state;
	
	public StateActivityDto() {
	}

	public StateActivityDto(Long idStateActivity, String state) {
		this.idStateActivity = idStateActivity;
		this.state = state;
	}

	public Long getIdStateActivity() {
		return idStateActivity;
	}

	public void setIdStateActivity(Long idStateActivity) {
		this.idStateActivity = idStateActivity;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	
	
}
