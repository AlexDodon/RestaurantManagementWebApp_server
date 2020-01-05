package com.Dodon.Gatea.Saas.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

@Entity
@Table(name = "users")
//@DiscriminatorColumn(name="REF_TYPE")
@EntityListeners(AuditingEntityListener.class)
public class User implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -1032502090400525780L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column
	@NotEmpty
    private String username;
	@Column
    @NotEmpty
    private String password;
	@Column
	@NotBlank
	private String firstName;
	@Column
	@NotBlank
	private String lastName;
	
	 @ManyToMany
	    @JoinTable( 
	        name = "users_roles", 
	        joinColumns = @JoinColumn(
	          name = "user_id", referencedColumnName = "id"), 
	        inverseJoinColumns = @JoinColumn(
	          name = "role_id", referencedColumnName = "id")
	        ) 
	private Collection<Role> roles;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
	public Collection<Role> getRoles() {
		return roles;
	}
	public void setRoles(Collection<Role> roles) {
		this.roles = roles;
	}
	

}
