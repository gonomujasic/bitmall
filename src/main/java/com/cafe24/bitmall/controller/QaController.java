package com.cafe24.bitmall.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class QaController {

	@RequestMapping("/qa")
	public String qa() {
		return "qa/qa";
	}

	@RequestMapping("/qa_new")
	public String qaNew() {
		return "qa/qa_new";
	}

	@RequestMapping("/qa_modify")
	public String qaModify() {
		return "qa/qa_modify";
	}

	@RequestMapping("/qa_read")
	public String qaRead() {
		return "qa/qa_read";
	}

	@RequestMapping("/qa_reply")
	public String qaReply() {
		return "qa/qa_reply";
	}
}
