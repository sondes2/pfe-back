package com.example.pfeesprit.repositories;

import com.example.pfeesprit.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;



public interface IRoleRepository extends JpaRepository<Role, Integer> {
	//public Role findRoleByroleType(String user) throws Exception;
	public Role findRoleByidRole(int RoleId) throws Exception;

}
