package com.pet.model.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {
	@Autowired(required = false)
	private AdminDAO adminDAO;
	
	public Admin loginCheck(Admin admin) {
		return adminDAO.loginCheck(admin);
	}
}
