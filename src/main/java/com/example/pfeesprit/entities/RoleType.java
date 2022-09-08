package com.example.pfeesprit.entities;

public enum RoleType  {
	Admin,PO,USER;
	public String getAuthority() {
		return name();
	}
}
