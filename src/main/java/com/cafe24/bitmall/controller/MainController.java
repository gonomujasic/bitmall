	package com.cafe24.bitmall.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cafe24.bitmall.service.ProductService;
import com.cafe24.bitmall.vo.ProductVo;

@Controller
public class MainController {
	
	@Autowired
	ProductService pService;
	
	@RequestMapping(value= {"/", ""} )
	public String index(Model model) {
		
		List<ProductVo> pList = pService.getNewProductList();
		model.addAttribute("pList", pList);
		return "main/index";
	}
	
	
}
