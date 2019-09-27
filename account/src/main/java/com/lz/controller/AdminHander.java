package com.lz.controller;

import com.lz.entity.Account;
import com.lz.repository.AdminRepository;
import com.lz.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/account")
public class AdminHander {
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private AdminRepository adminRepository;

	@GetMapping("/login/{username}/{password}/{type}")
	public Account login(@PathVariable("username") String username,
						 @PathVariable("password") String password,
						 @PathVariable("type") String type){
		Account account = null;
		switch (type){
			case "user":
				account = (Account) userRepository.login(username,password);
				break;
			case "admin":
				account = adminRepository.login(username,password);
				break;
		}
		return account;

	}

}
