package com.lz.repository;

import org.apache.catalina.User;

public interface UserRepository {
	public User login(String username, String password);

}
