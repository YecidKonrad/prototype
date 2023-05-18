package com.prototype.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class IdentificationTypes implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false, updatable = false)
	private Long idIdentificationType;
	private String identification;
	private String name;
	@ManyToOne()
	@JoinColumn(name = "id_country", nullable = false, foreignKey = @ForeignKey(name = "fk_identification_country"))
	@JsonIgnore
	private Countries country;
	

	public IdentificationTypes() {
		super();
	}

	public IdentificationTypes(Long idIdentificationType, String identification, String name) {
		super();
		this.idIdentificationType = idIdentificationType;
		this.identification = identification;
		this.name = name;
	}
	

	public IdentificationTypes(Long idIdentificationType) {
		super();
		this.idIdentificationType = idIdentificationType;
	}


	public Long getIdIdentificationType() {
		return idIdentificationType;
	}

	public void setIdIdentificationType(Long idIdentificationType) {
		this.idIdentificationType = idIdentificationType;
	}

	public String getIdentification() {
		return identification;
	}

	public void setIdentification(String identification) {
		this.identification = identification;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
