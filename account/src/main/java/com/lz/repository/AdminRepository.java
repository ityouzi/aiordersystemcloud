package com.lz.repository;

import com.lz.entity.Admin;

public interface AdminRepository {
	public Admin login(String username, String password);
}
