package com.cafe24.bitmall.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FaqController {

	@RequestMapping("/faq")
	public String faq() {
		return "faq/faq";
	}
	
	@RequestMapping("/faq_read")
	public String faqRead() {
		return "faq/faq_read";
	}
}
