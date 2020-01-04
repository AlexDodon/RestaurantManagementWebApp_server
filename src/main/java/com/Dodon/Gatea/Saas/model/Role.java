package com.Dodon.Gatea.Saas.model;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.*;

@Entity
public class Role implements Serializable{
  
    /**
	 * 
	 */
	private static final long serialVersionUID = 662058130131660279L;

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
 
    private String name;
    @ManyToMany(mappedBy = "roles")
    private Collection<User> users;
 
    @ManyToMany
    @JoinTable(
        name = "roles_privileges", 
        joinColumns = @JoinColumn(
          name = "role_id", referencedColumnName = "id"), 
        inverseJoinColumns = @JoinColumn(
          name = "privilege_id", referencedColumnName = "id"))
    private Collection<Privilege> privileges;   
}