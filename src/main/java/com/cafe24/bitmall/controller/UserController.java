package com.cafe24.bitmall.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {

	@RequestMapping("/member_login")
	public String loginForm() {
		return "user/member_login";
	}

/*	@RequestMapping("/member_logout")
	public String loginout() {
		return "main/index";
	}*/
	
	@RequestMapping("/member_agree")
	public String memberAgree() {
		return "user/member_agree";
	}

	@RequestMapping("/member_join")
	public String memberJoin() {
		return "user/member_join";
	}

	@RequestMapping("/member_joinend")
	public String memberJoinEnd() {
		return "user/member_joinend";
	}

	@RequestMapping("/member_modify")
	public String memberModify() {
		return "user/member_modify";
	}

	@RequestMapping("/member_modifying")
	public String memberModifying() {
		return "user/member_amodifying";
	}

	@RequestMapping("/cart")
	public String cart() {
		return "user/cart";
	}
	
	@RequestMapping("/jumun")
	public String jumun() {
		return "user/jumun";
	}

	@RequestMapping("/jumun_info")
	public String jumunInfo() {
		return "user/jumun_info";
	}
}
