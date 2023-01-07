package com.hiba.stage.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.hiba.stage.entities.User;
import com.hiba.stage.repos.UserRepository;
@Service
public class UserServiceImp implements UserService {

	@Autowired
	UserRepository userRepository;

	@Override
	public User saveUser(User u) {
		
		return userRepository.save(u);
	}

	@Override
	public User updateStage(User u) {
		return userRepository.save(u);
	}

	@Override
	public void deleteUser(User u) {
		userRepository.delete(u);
		
	}

	@Override
	public void deleteUserById(Long id) {
		userRepository.deleteById(id);
		
	}

	@Override
	public User getUsere(Long id) {
		return userRepository.getById(id);
	}

	@Override
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}



	@Override
	public Page<User> getAllUsersParPage(int page, int size) {
		return userRepository.findAll(PageRequest.of(page, size));
	}

	@Override
	public User updateUser(User user) {
		return userRepository.save(user);
		
	}

	@Override
	public User getUser(Long id) {
		return userRepository.getById(id);
	}

}
