package com.hunter.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hunter.utils.ViewName;

@Controller
@RequestMapping("/Admin")
public class AdminController {

	@GetMapping("/Dashboard")
	public String getAdminDashboard() {
		return ViewName.ADMIN_DASHBOARD_PAGE;
	}

}
