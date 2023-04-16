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

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class User implements Serializable {	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user",nullable = false, updatable = false)
    private Long idUser;
    private String userId;
    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private String email;
    private String institution;
    private String profileImageUrl;
    private Date lastLoginDate;
    private Date lastLoginDateDisplay;
    private Date joinDate;
    private String role; //ROLE_USER{ read, edit }, ROLE_ADMIN {delete}
    private String[] authorities;
    private boolean isActive;
    private boolean isNotLocked;
    @ManyToOne
    @JoinColumn(name = "id_identification_type", nullable = false, foreignKey = @ForeignKey(name = "fk_user_identification_type"))
    private IdentificationTypes identificationType;
    
    @OneToMany(mappedBy = "phase")
    @JsonIgnore
    private Set<PhaseUser> phases;
    
    @OneToMany(mappedBy = "activity")
    @JsonIgnore
    private Set<ActivityUser> activities;
    
    public User(){}

   
    public User(Long id, String userId, String firstName, String lastName, String username, String password,
			String email, String institution, String profileImageUrl, Date lastLoginDate, Date lastLoginDateDisplay,
			Date joinDate, String role, String[] authorities, boolean isActive, boolean isNotLocked,
			IdentificationTypes identificationType) {
		super();
		this.idUser = id;
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.password = password;
		this.email = email;
		this.institution = institution;
		this.profileImageUrl = profileImageUrl;
		this.lastLoginDate = lastLoginDate;
		this.lastLoginDateDisplay = lastLoginDateDisplay;
		this.joinDate = joinDate;
		this.role = role;
		this.authorities = authorities;
		this.isActive = isActive;
		this.isNotLocked = isNotLocked;
		this.identificationType = identificationType; 
	}


	public User(Long id) {
		this.idUser = id;
	}


	public Long getId() {
		return idUser;
	}


	public void setId(Long id) {
		this.idUser = id;
	}


	public String getUserId() {
		return userId;
	}


	public void setUserId(String userId) {
		this.userId = userId;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getInstitution() {
		return institution;
	}


	public void setInstitution(String institution) {
		this.institution = institution;
	}


	public String getProfileImageUrl() {
		return profileImageUrl;
	}


	public void setProfileImageUrl(String profileImageUrl) {
		this.profileImageUrl = profileImageUrl;
	}


	public Date getLastLoginDate() {
		return lastLoginDate;
	}


	public void setLastLoginDate(Date lastLoginDate) {
		this.lastLoginDate = lastLoginDate;
	}


	public Date getLastLoginDateDisplay() {
		return lastLoginDateDisplay;
	}


	public void setLastLoginDateDisplay(Date lastLoginDateDisplay) {
		this.lastLoginDateDisplay = lastLoginDateDisplay;
	}


	public Date getJoinDate() {
		return joinDate;
	}


	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}


	public String getRole() {
		return role;
	}


	public void setRole(String role) {
		this.role = role;
	}


	public String[] getAuthorities() {
		return authorities;
	}


	public void setAuthorities(String[] authorities) {
		this.authorities = authorities;
	}


	public boolean isActive() {
		return isActive;
	}


	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}


	public boolean isNotLocked() {
		return isNotLocked;
	}


	public void setNotLocked(boolean isNotLocked) {
		this.isNotLocked = isNotLocked;
	}


	public IdentificationTypes getIdentificationType() {
		return identificationType;
	}


	public void setIdentificationType(IdentificationTypes identificationType) {
		this.identificationType = identificationType;
	}


	public Long getIdUser() {
		return idUser;
	}


	public void setIdUser(Long idUser) {
		this.idUser = idUser;
	}


	public Set<PhaseUser> getPhases() {
		return phases;
	}


	public void setPhases(Set<PhaseUser> phases) {
		this.phases = phases;
	}

}
