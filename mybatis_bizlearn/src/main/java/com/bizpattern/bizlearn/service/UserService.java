package com.bizpattern.bizlearn.service;

import java.util.List;

import com.bizpattern.bizlearn.model.User;

public interface UserService {

	public User getUser(Long id);

	public List<User> getAllUsers();
	
	public void addUser(User user);

}
