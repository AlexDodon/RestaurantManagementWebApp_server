package com.Dodon.Gatea.Saas.model;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.*;

@Entity
public class Privilege implements Serializable{
  
    /**
	 * 
	 */
	private static final long serialVersionUID = 3700249073751055608L;

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
 
    private String name;
 
    @ManyToMany(mappedBy = "privileges")
    private Collection<Role> roles;
}