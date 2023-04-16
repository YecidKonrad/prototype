package com.prototype.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class StateActivity implements Serializable{

	private static final long serialVersionUID = 1L;
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(nullable = false, updatable = false)
		private Long idStateActivity;
		private String state;
		
		public StateActivity(Long idStateActivity, String state) {
			this.idStateActivity = idStateActivity;
			this.state = state;
		}
				
		public StateActivity() {
		}



		public StateActivity(Long idStateActivity) {
			this.idStateActivity = idStateActivity;
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
