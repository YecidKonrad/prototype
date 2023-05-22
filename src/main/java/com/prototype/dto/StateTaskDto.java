package com.prototype.dto;

public class StateTaskDto {
	private Long idStateTask;
	private String state;
	
	public StateTaskDto() {
	}

	public StateTaskDto(Long idStateTask, String state) {
		this.idStateTask = idStateTask;
		this.state = state;
	}

	public Long getIdStateTask() {
		return idStateTask;
	}

	public void setIdStateTask(Long idStateTask) {
		this.idStateTask = idStateTask;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	
}
