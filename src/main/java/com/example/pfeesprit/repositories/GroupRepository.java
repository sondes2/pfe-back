package com.example.pfeesprit.repositories;

import com.example.pfeesprit.entities.Groupe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupRepository extends JpaRepository<Groupe, Long> {

}
