package com.prototype.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
@Embeddable
public class UserPhaseKey implements Serializable {
	

	private static final long serialVersionUID = 1L;

	@Column(name = "id_user")
    public Long idUser;

    @Column(name = "id_phase")
    public Long idPhase;
    
    

	public UserPhaseKey() {
	}

	public UserPhaseKey(Long idUser, Long idPhase) {
		this.idUser = idUser;
		this.idPhase = idPhase;
	}



	public Long getIdUser() {
		return idUser;
	}

	public void setIdUser(Long idUser) {
		this.idUser = idUser;
	}

	public Long getIdPhase() {
		return idPhase;
	}

	public void setIdPhase(Long idPhase) {
		this.idPhase = idPhase;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idPhase == null) ? 0 : idPhase.hashCode());
		result = prime * result + ((idUser == null) ? 0 : idUser.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		UserPhaseKey other = (UserPhaseKey) obj;
		if (idPhase == null) {
			if (other.idPhase != null) {
				return false;
			}
		} else if (!idPhase.equals(other.idPhase)) {
			return false;
		}
		if (idUser == null) {
			if (other.idUser != null) {
				return false;
			}
		} else if (!idUser.equals(other.idUser)) {
			return false;
		}
		return true;
	}

	
    
    
}
