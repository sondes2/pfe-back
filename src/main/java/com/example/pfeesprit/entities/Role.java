package com.example.pfeesprit.entities;


import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name= "Role")
public class Role implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int idRole;
	private String description;
	@Enumerated(EnumType.STRING)
	private RoleType roleType;
	@OneToMany(cascade= CascadeType.DETACH, mappedBy="role", fetch= FetchType.EAGER)
	public Set<User> user;
	
	public Role() {
		super();

		// TODO Auto-generated constructor stub
	}

	public Role(int idRole, String description, RoleType roleType, Set<User> user) {
		super();
		this.idRole = idRole;
		this.description = description;
		this.roleType = roleType;
		this.user = user;
	}

	public int getIdRole() {
		return idRole;
	}

	public void setIdRole(int idRole) {
		this.idRole = idRole;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public RoleType getRoleType() {
		return roleType;
	}

	public void setRoleType(RoleType roleType) {
		this.roleType = roleType;
	}

	public Set<User> getUser() {
		return user;
	}

	public void setUser(Set<User> user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Role [idRole=" + idRole + ", description=" + description + ", roleType=" + roleType + ", user=" + user
				+ "]";
	}
	
	
	
	
}
