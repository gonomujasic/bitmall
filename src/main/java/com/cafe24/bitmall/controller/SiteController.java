package com.cafe24.bitmall.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/site")
public class SiteController {

	@RequestMapping("/company")
	public String company() {
		return "site/company";
	}

	@RequestMapping("/policy")
	public String policy() {
		return "site/policy";
	}

	@RequestMapping("/useinfo")
	public String useinfo() {
		return "site/useinfo";
	}
	
}
