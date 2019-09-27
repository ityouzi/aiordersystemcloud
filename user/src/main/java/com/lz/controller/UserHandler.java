package com.lz.controller;

import com.lz.entity.User;
import com.lz.entity.UserVo;
import com.lz.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/user")
public class UserHandler {

	@Autowired
	private UserRepository userRepository;

	@GetMapping("/findAll/{page}/{limit}")
	public UserVo findAll(@PathVariable("page") int page,
						  @PathVariable("limit") int limit){
		UserVo userVo = new UserVo();
		userVo.setCode(0);
		userVo.setMsg("");
		userVo.setCount(userRepository.count());
		userVo.setData(userRepository.findAll((page-1)*limit,limit));
		return userVo;
	}

	@PostMapping("/save")
	public void save(@RequestBody User user){
		user.setRegisterdate(new Date());
		userRepository.save(user);
	}

	@DeleteMapping("/deleteById/{id}")
	public void deleteById(@PathVariable("id") long id){
		userRepository.deleteById(id);
	}


}
