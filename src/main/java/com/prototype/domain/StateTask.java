package com.prototype.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class StateTask implements Serializable{

	private static final long serialVersionUID = 1L;
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(nullable = false, updatable = false)
		private Long idStateTask;
		private String state;
		
		public StateTask(Long idStateTask, String state) {
			this.idStateTask = idStateTask;
			this.state = state;
		}

		public StateTask() {
		}
		
		public StateTask(Long idStateTask) {
			this.idStateTask = idStateTask;
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
