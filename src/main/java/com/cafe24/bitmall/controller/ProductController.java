package com.cafe24.bitmall.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cafe24.bitmall.service.ProductService;
import com.cafe24.bitmall.vo.ProductVo;

@Controller
@RequestMapping("/product")
public class ProductController {

	@Autowired
	ProductService pService;
	
	@RequestMapping(value= { "/", "" })
	public String product() {
		return "product/product";
	}

	@RequestMapping("/product_detail")
	public String productDetail(
			@RequestParam("no") Long no, 
			Model model) {
		ProductVo vo = pService.getProductDetail(no);
		System.out.println(vo);
		model.addAttribute("vo",vo);
		return "product/product_detail";
	}

	@RequestMapping("/product_search")
	public String productSearch() {
		return "product/product_search";
	}
}
