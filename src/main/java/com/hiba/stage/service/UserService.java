package com.hiba.stage.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.hiba.stage.entities.User;



public interface UserService {
	User saveUser(User u);
	User updateStage(User u);
	void deleteUser(User u);
	 void deleteUserById(Long id);
	 User getUsere(Long id);
	List<User> getAllUsers();
	Page<User> getAllUsersParPage(int page, int size);
	User updateUser(User user);
	User getUser(Long id);
}
