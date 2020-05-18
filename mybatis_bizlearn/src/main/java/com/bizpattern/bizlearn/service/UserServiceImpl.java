package com.bizpattern.bizlearn.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bizpattern.bizlearn.model.User;
import com.bizpattern.bizlearn.model.mapper.UserMapper;

@Service
public class UserServiceImpl implements UserService {

	private final UserMapper userMapper;

	public UserServiceImpl(UserMapper userMapper) {
		this.userMapper = userMapper;
	}

	public User getUser(Long id) {
		return this.userMapper.getUser(id);
	}

	public List<User> getAllUsers() {
		return this.userMapper.getAllUsers();
	}

	public void addUser(User user) {
		this.userMapper.addUser(user);
	}

}
