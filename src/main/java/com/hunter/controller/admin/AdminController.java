package com.hunter.controller.admin;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.hunter.utils.ViewName;

@Controller
public class AdminController {

	@GetMapping("/Admin/Dashboard")
	public String getAdminDashboard() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (!(authentication instanceof AnonymousAuthenticationToken)) {
			System.out.println(authentication);
			System.out.println("?");
		    Object currentUserName = authentication.getPrincipal();
		    System.out.println(currentUserName.toString());
		}
		return ViewName.ADMIN_DASHBOARD_PAGE;
	}

}
