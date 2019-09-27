package com.lz.feign;

import com.lz.entity.User;
import com.lz.entity.UserVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(value = "user")
public interface UserFeign {
	@GetMapping("/user/findAll/{page}/{limit}")
	public UserVo findAll(@PathVariable("page") int page, @PathVariable("limit") int limit);

	@PostMapping("/user/save")
	public void save(@RequestBody User user);

	@DeleteMapping("/user/deleteById/{id}")
	public void deleteById(@PathVariable("id") long id);

}
