package com.cafe24.bitmall.controller;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.cafe24.bitmall.service.FIleUploadService;
import com.cafe24.bitmall.service.OptService;
import com.cafe24.bitmall.service.ProductService;
import com.cafe24.bitmall.vo.OptVo;
import com.cafe24.bitmall.vo.OptsVo;
import com.cafe24.bitmall.vo.ProductVo;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	ProductService pService;
	
	@Autowired
	OptService optService;
	
	@Autowired
	FIleUploadService fService;
	
	@RequestMapping("/login")
	public String login() {
		return "admin/login";
	}

	@RequestMapping("/jumun")
	public String jumun() {
		return "admin/jumun";
	}

	@RequestMapping("/jumun_info")
	public String jumunInfo() {
		return "admin/jumun_info";
	}

	@RequestMapping("/member")
	public String member() {
		return "admin/member";
	}

	@RequestMapping("/faq")
	public String faq() {
		return "admin/faq";
	}

	@RequestMapping("/faq_new")
	public String faqNew() {
		return "admin/faq_new";
	}

	@RequestMapping("/faq_edit")
	public String faqEdit() {
		return "admin/faq_edit";
	}

	@RequestMapping("/opt")
	public String opt(Model model) {
		
		Map<String, Object> map = optService.getOptList();
		model.addAttribute("map", map);
		return "admin/opt";
	}

	@RequestMapping(value="/opt_new", method=RequestMethod.GET)
	public String optNew() {
		return "admin/opt_new";
	}
	
	@RequestMapping(value="/opt_new", method=RequestMethod.POST)
	public String optNew(@ModelAttribute OptVo optVo) {
		
		boolean result = optService.insertOpt(optVo);
		
		return "redirect:/admin/opt";
	}
	
	@RequestMapping(value="/opt_edit", method=RequestMethod.GET)
	public String optEdit(@RequestParam Long no, Model model) {
		
		OptVo optVo = optService.getOpt(no);
		model.addAttribute("vo", optVo);
		return "admin/opt_edit";
	}
	
	@RequestMapping(value="/opt_edit", method=RequestMethod.POST)
	public String optEdit(@ModelAttribute OptVo optVo) {
		
		boolean result = optService.editOpt(optVo);
		
		return "redirect:/admin/opt";
	}

	@RequestMapping(value="/opt_delete")
	public String optDelete(@RequestParam Long no) {
		
		boolean result = optService.deleteOpt(no);
		
		return "redirect:/admin/opt";
	}
	
	@RequestMapping(value="/opts_new", method=RequestMethod.GET)
	public String optsNew(@RequestParam Long no, Model model) {
		model.addAttribute("no",no);
		return "admin/opts_new";
	}
	
	@RequestMapping(value="/opts_new", method=RequestMethod.POST)
	public String optsNew(@ModelAttribute OptsVo optsVo, Model model) {
		//어케 보낼지 생각해야 함.
		boolean result = optService.insertOpts(optsVo);
		
		return "redirect:/admin/opts?no="+optsVo.getOptNo();
	}

	@RequestMapping(value="/opts_edit", method=RequestMethod.GET)
	public String optsEdit(@ModelAttribute OptsVo vo, Model model) {
		
		OptsVo optsVo = optService.getOpts(vo.getNo());
		optsVo.setOptNo(vo.getOptNo());
		model.addAttribute("vo", optsVo);
		return "admin/opts_edit";
	}
	
	@RequestMapping(value="/opts_edit", method=RequestMethod.POST)
	public String optsEdit(@ModelAttribute OptsVo optsVo) {
		
		boolean result = optService.editOpts(optsVo);
		
		return "redirect:/admin/opts?no="+optsVo.getOptNo();
	}

	@RequestMapping(value="/opts_delete")
	public String optsDelete(@ModelAttribute OptsVo optsVo) {
		
		boolean result = optService.deleteOpts(optsVo.getNo());
		
		return "redirect:/admin/opts?no="+optsVo.getOptNo();
	}

	@RequestMapping("/opts")
	public String opts(
			@RequestParam Long no,
			Model model) {
		
		OptVo vo = optService.getOptsList(no);
		model.addAttribute("vo", vo);
		
		return "admin/opts";
	}

	@RequestMapping("/product")
	public String product(
			@RequestParam(value="keyword", required=false, defaultValue="") String keyword,
			@RequestParam(value="currentPage", required=false, defaultValue="1") int currentPage,
			@RequestParam(value="product_status", required=false, defaultValue="0") int productStatus,
			@RequestParam(value="icon", required=false, defaultValue="0") int icon,
			@RequestParam(value="category", required=false, defaultValue="0") int category,
			@RequestParam(value="productNN", required=false, defaultValue="0") int productNN,
			Model model) {
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("keyword", keyword);
		map.put("currentPage", currentPage);
		map.put("product_status", productStatus);
		map.put("icon", icon);
		map.put("category", category);
		map.put("productNN", productNN);
		
		Map<String, Object> pageMap = pService.getProductList(map);
 		model.addAttribute("map", pageMap);
 		System.out.println(map.toString());
		return "admin/product";
	}

	@RequestMapping(value="/product_new", method=RequestMethod.GET)
	public String productNew(Model model) {
		
		ProductVo productVo = pService.loadNewProduct();
		model.addAttribute("productVo", productVo);
		//model.addAttribute("productVo", new ProductVo());
		return "admin/product_new";
	}

	@RequestMapping(value="/product_new", method=RequestMethod.POST)
	public String productNew(
			@ModelAttribute @Valid ProductVo productVo, 
			BindingResult bindingResult,
			Model model
			) {
		System.out.println("너 맞지?"+productVo);
		
		if(bindingResult.hasErrors()) {
			productVo = pService.getCListAndOpt(productVo);
			model.addAttribute("productVo", productVo);
			
			return "/admin/product_new";
		}
		
		productVo = pService.makeNewProduct(productVo);
		System.out.println(productVo);
		fService.restore(productVo);
		
		return "redirect:/admin/product";
	}
	

	@RequestMapping("/product_edit")
	public String productEdit() {
		return "admin/product_edit";
	}

}
