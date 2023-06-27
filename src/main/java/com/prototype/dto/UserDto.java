package com.prototype.dto;

import java.io.Serializable;

public class UserDto implements Serializable{
	  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    private Long idUser;
	private String userId;
	    private String firstName;
	    private String lastName;
	    private String username;
	    private String email;
	    private String institution;
	    private boolean isActive;   
	    	
		
		public UserDto(Long idUser, String userId, String firstName, String lastName, String username, String email,
				String institution, boolean isActive) {
			this.idUser = idUser;
			this.userId = userId;
			this.firstName = firstName;
			this.lastName = lastName;
			this.username = username;
			this.email = email;
			this.institution = institution;
			this.isActive = isActive;
		}

		public UserDto() {

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
		public boolean isActive() {
			return isActive;
		}
		public void setActive(boolean isActive) {
			this.isActive = isActive;
		}

		public Long getIdUser() {
			return idUser;
		}

		public void setIdUser(Long idUser) {
			this.idUser = idUser;
		}
		
		// Método para obtener el nombre completo
	    public String getFullName() {
	        // Verificar que los atributos no estén vacíos
	        if (firstName.isEmpty() || lastName.isEmpty()) {
	            return "Faltan datos";
	        }
	        
	        // Concatenar el nombre completo con espacios
	        return firstName + " " + lastName;
	    }
	    
	    
}
