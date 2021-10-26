package com.admin.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.admin.model.in.UserIn;
import com.admin.model.out.UserOut;
import com.admin.service.UserService;


@CrossOrigin
@RestController
public class LoginController {
	
	@Autowired
	private UserService userService;

	@PostMapping("/login")
	public UserOut login(@RequestBody UserIn in) {

		UserOut out = userService.login(in);		
		return out;

	}


}
