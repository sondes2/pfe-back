package com.example.pfeesprit.services;

import java.util.ArrayList;
import java.util.List;

import com.example.pfeesprit.entities.Role;
import com.example.pfeesprit.repositories.IRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class RoleService implements IRoleservice {

	@Autowired
	IRoleRepository roleRepository;


	@Override
	public List<Role> getAllRoles() {
		return roleRepository.findAll() != null ? roleRepository.findAll(): new ArrayList<Role>();
	}

	@Override
	public Role createRole(Role entity) throws Exception {
		return roleRepository.save(entity);
	}

	@Override
	public Role updateRole(Role entity) throws Exception {
		if (entity != null && entity.getIdRole() != 0)
			return roleRepository.save(entity);
		else {
			throw new Exception("No the role record exist"); 
		}
	}

	@Override
	public Role findRoleByroleType(String role) throws Exception {
		return roleRepository.findRoleByroleType(role);
	}


	@Override
	public Role findRoleById(int id) throws Exception {
		return roleRepository.findRoleByidRole(id);
	}
	
	@Override
	public void deleteRoleById(int roleId) throws Exception {
		roleRepository.deleteById(roleId);
	}
	
}
