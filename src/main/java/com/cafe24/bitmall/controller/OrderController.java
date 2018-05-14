package com.cafe24.bitmall.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cafe24.bitmall.service.OrderService;
import com.cafe24.bitmall.vo.CartVo;

@Controller
@RequestMapping("/order")
public class OrderController {

	@Autowired
	OrderService oService;
	
	
	@RequestMapping(value= {"/",""})
	public String order() {
		
		
		
		return "order/order";
	}

	@RequestMapping("/order_pay")
	public String order_pay() {
		return "order/order_pay";
	}

	@RequestMapping("/order_ok")
	public String orderOk() {
		return "order/order_ok";
	}

	@RequestMapping("/InsertIntoCart")
	public String insertIntoCart(
			@ModelAttribute CartVo vo
			) {
		//유저 추가 해야함.
		//어드민 계정으로 일단 설정
		vo.setUserNo(2L);
		System.out.println(vo);
		oService.insertIntoCart(vo);
			
		return "redirect:/order/cart";
	}
	
	@RequestMapping("/cart")
	public String cart(Model model) {
		//유저 추가 해야함
		//일단 관리자 
		Long userNo = 2L;
		List<CartVo> cartList = oService.getCartList(userNo);
		
		model.addAttribute("cartList",cartList);
		return "order/cart";
		
	}
				
}
