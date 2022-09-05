package com.example.pfeesprit.controllers;

import java.util.List;

import com.example.pfeesprit.entities.Role;
import com.example.pfeesprit.services.IRoleservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.fasterxml.jackson.annotation.JsonBackReference;



@RestController
public class RoleController {

	@Autowired
	IRoleservice iroleservice;

	@JsonBackReference("")
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/Role/findall")
	public List<Role> getAllUsers() {
		return iroleservice.getAllRoles();
	}

	@GetMapping("/Role/rolebyid/{idRole}")
	public Role getUserById(@PathVariable("idRole") int idRole) throws Exception {
		return iroleservice.findRoleById(idRole);
	}

	@PostMapping("/Role/createRole")
	@ResponseBody
	public Role createUser(@RequestBody Role user) throws Exception {
		return iroleservice.createRole(user);
	}

	@PutMapping("/Role/updateRole")
	@ResponseBody
	public Role updateUser(@RequestBody Role role) throws Exception {
		return iroleservice.updateRole(role);
	}

	@DeleteMapping("/Role/deleteRoleById/{roleId}")
	public void deleteRoleById(@PathVariable("roleId") int roleId) throws Exception {
		iroleservice.deleteRoleById(roleId);
	}
}