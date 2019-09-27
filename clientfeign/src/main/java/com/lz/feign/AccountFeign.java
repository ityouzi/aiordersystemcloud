package com.lz.feign;

import com.lz.entity.Account;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "account")
public interface AccountFeign {

	@GetMapping("/account/login/{username}/{password}/{type}")
	public Account login(@PathVariable("username") String username,
						 @PathVariable("password") String passwrod,
						 @PathVariable("type") String type);
}
