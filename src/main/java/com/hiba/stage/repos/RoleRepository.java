package com.hiba.stage.repos;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hiba.stage.entities.Role;

public interface RoleRepository  extends JpaRepository<Role, Long> {
	
	Role findByRole(String role);
	Optional<Role> findById(Long id);
	
}

