package com.hiba.stage.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hiba.stage.entities.Role;
import com.hiba.stage.repos.RoleRepository;


@Service
public class RoleServiceImp implements RoleService {
	@Autowired
	RoleRepository roleRepository;

	@Override
	public List<Role> getAllRoles() {
	return roleRepository.findAll();
	}


	
	
	

}
