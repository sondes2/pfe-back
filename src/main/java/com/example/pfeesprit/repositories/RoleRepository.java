package com.example.pfeesprit.repositories;

import java.util.List;

import com.example.pfeesprit.entities.Role;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface RoleRepository extends CrudRepository<Role, Integer> {
	
	@Query(value = "SELECT role_type FROM `role`", nativeQuery = true)
	public List<String> getRoleType();
}
