package com.pet.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.pet.model.admin.Admin;
import com.pet.model.admin.AdminService;

@Controller
public class AdminController {
	@Autowired(required = false)
	private AdminService adminService;
	
	@RequestMapping(value="/admin/test", method=RequestMethod.GET)
	public ModelAndView loginCheck(Admin admin) {
		Admin result=adminService.loginCheck(admin);
		System.out.println("결과 id : "+result.getId());
		return null;
	}
	
}
