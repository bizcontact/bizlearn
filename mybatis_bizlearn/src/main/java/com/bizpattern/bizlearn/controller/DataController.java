package com.bizpattern.bizlearn.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.bizpattern.bizlearn.model.User;
import com.bizpattern.bizlearn.service.UserService;

@Controller
public class DataController {

	@Autowired
	UserService userService;

	@GetMapping("getAllUsers")
	public ModelAndView getAllUsers() {
		List<User> users = userService.getAllUsers();
		return new ModelAndView("allUsers", "users", users);
	}

	@GetMapping("addUser")
	public ModelAndView showForm() {
		return new ModelAndView("addUserForm", "user", new User());
	}

	@PostMapping("addUser")
	public String addUser(@RequestParam("name") String name, @RequestParam("address") String address) {
		User user = new User();
		user.setName(name);
		user.setAddress(address);
		userService.addUser(user);
		return "redirect:getAllUsers";
	}

}
